package main.java.com.example.doctorsearchbackend.controller;

import com.example.doctorsearchbackend.model.Doctor;
import com.example.doctorsearchbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DoctorGraphQLController {

    @Autowired
    private DoctorService doctorService;

    @QueryMapping
    public List<Doctor> searchDoctors(String name, String zipCode) {
        return doctorService.getDoctorsByNameOrZipCode(name, zipCode);
    }
}
