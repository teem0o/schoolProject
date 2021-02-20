package com.emis.schoolProject.services;

import com.emis.schoolProject.model.School;
import com.emis.schoolProject.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;


    public void deleteSchool() {
        schoolRepository.deleteSchool();
    }

    public List<School> getSchoolsByRegion(String region) {
        return schoolRepository.getSchoolByRegion(region);
    }


}
