package com.emis.schoolProject.repositories;

import com.emis.schoolProject.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from school s left join school_teachers st on st.school_id=s.id where st.teacher_id is null;")
    void deleteSchool();

    @Query(nativeQuery = true, value = "select * from school s join address a on s.address_id=a.id where a.region=:region")
    List<School> getSchoolByRegion(@Param("region") String region);
}
