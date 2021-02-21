package com.emis.schoolProject.controller;

import com.emis.schoolProject.model.Teacher;
import com.emis.schoolProject.services.SchoolService;
import com.emis.schoolProject.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class mainController {
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private TeacherService teacherService;


    @GetMapping("/teachers/{pageNum}/{pageSize}")
    public ResponseEntity<?> getTeachers(@PathVariable int pageNum, @PathVariable int pageSize) {
        return new ResponseEntity<>(teacherService.getTeachers(pageNum, pageSize), HttpStatus.OK);
    }

    @GetMapping("/schools/{region}")
    public ResponseEntity<?> getSchools(@PathVariable String region) {
        return new ResponseEntity<>(schoolService.getSchoolsByRegion(region), HttpStatus.OK);
    }


    @GetMapping("/teachers/updateSubject/{schoolId}/{subject}")
    public ResponseEntity<?> updateSubject(@PathVariable int schoolId, @PathVariable String subject) {
        teacherService.updateTeachersSubject(schoolId, subject);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping("/schools/deleteSchool")
    public ResponseEntity<?> deleteSchool() {
        schoolService.deleteSchool();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/teachers/saveTeacher")
    public ResponseEntity<?> saveTeacher(@RequestBody Teacher teacher) {
        return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.OK);
    }


}
