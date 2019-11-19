package com.hospitalweb.controller;

import com.hospitalweb.domain.HospitalInfo;
import com.hospitalweb.exception.HospitalInfoNotFoundException;
import com.hospitalweb.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    private HospitalService hospitalservice;

    @GetMapping("/")
    public String getHome() {
        return "hello";
        }


    // Get All Hospital Info
    @GetMapping("/hospitalinfo")
    public List<HospitalInfo> getAllHospitalInfo() {
        return hospitalservice.findAll();
    }

    // Create a new Hospital
    @PostMapping("/newhospital")
    public HospitalInfo createHospitalInfo(@Valid @RequestBody HospitalInfo hospital) {
        return hospitalservice.save(hospital);
    }

    // Get a Single Hospital Info
    @GetMapping("/hospitalinfo/{id}")
    public HospitalInfo getHospitalInfoById(@PathVariable(value = "id") Long id) throws HospitalInfoNotFoundException {
        return hospitalservice.findById(id)
                .orElseThrow(() -> new HospitalInfoNotFoundException(id));
    }

    // Update a Hospital Info
    @PutMapping("/update/{id}")
    public HospitalInfo updateHospital1(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody HospitalInfo hospitalDetails) throws HospitalInfoNotFoundException {

        HospitalInfo hospital = hospitalservice.findById(id)
                .orElseThrow(() -> new HospitalInfoNotFoundException(id));

        hospital.setHospitalName(hospitalDetails.getHospitalName());
        hospital.setAddress(hospitalDetails.getAddress());
        hospital.setPhoneNumber(hospitalDetails.getPhoneNumber());
        hospital.setEstd(hospitalDetails.getEstd());

        HospitalInfo updateHospital = hospitalservice.save(hospital);

        return updateHospital;
    }

    // Delete a hospital
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHospitalInfo(@PathVariable(value = "id") Long id) throws HospitalInfoNotFoundException {
        HospitalInfo hospital = hospitalservice.findById(id)
                .orElseThrow(() -> new HospitalInfoNotFoundException(id));

        hospitalservice.delete(id);

        return ResponseEntity.ok().build();
    }

}
