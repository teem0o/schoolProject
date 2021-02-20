package com.emis.schoolProject.services;

import com.emis.schoolProject.model.Teacher;
import com.emis.schoolProject.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Page<Teacher> getTeachers(int pageNum, int pageSize) {
        return teacherRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    public void updateTeachersSubject(int schoolId, String subject) {
        teacherRepository.updateTeachersSubject(schoolId, subject);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
