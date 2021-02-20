package com.emis.schoolProject.repositories;

import com.emis.schoolProject.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Page<Teacher> findAll(Pageable pageable);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update teacher t inner join school_teachers st on st.teacher_id=t.id set t.subject=:subject where st.school_id=:schoolId")
    void updateTeachersSubject(@Param("schoolId") int schoolId, @Param("subject") String subject);


}
