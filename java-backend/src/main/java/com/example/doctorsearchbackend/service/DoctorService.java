package main.java.com.example.doctorsearchbackend.service;

import com.example.doctorsearchbackend.model.Doctor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private List<Doctor> doctors;

    public DoctorService() {
        // Load data from JSON file
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Doctor>> typeReference = new TypeReference<>(){};
        InputStream inputStream = getClass().getResourceAsStream("/data.json");
        try {
            doctors = mapper.readValue(inputStream, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Doctor> getDoctorsByNameOrZipCode(String name, String zipCode) {
        return doctors.stream()
                .filter(doctor -> (name != null && doctor.getName().equalsIgnoreCase(name)) ||
                        (zipCode != null && doctor.getZipCode().equals(zipCode)))
                .collect(Collectors.toList());
    }
}
