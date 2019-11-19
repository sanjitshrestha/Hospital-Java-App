package com.hospitalweb.controller;

import com.hospitalweb.domain.StaffInfo;
import com.hospitalweb.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    // Get All staff Info
    @GetMapping("/staffinfo")
    public List<StaffInfo> getAllStaffInfo() {
        return staffService.findAll();
    }

    // Create a new Staff
    @PostMapping("/newstaff")
    public StaffInfo createStaffInfo(@Valid @RequestBody StaffInfo staff) {
        return staffService.save(staff);
    }

    // Get a Single staff Info
    @GetMapping("/staffinfo/{id}")
    public Optional<StaffInfo> getStaffInfoById(@PathVariable(value = "id") Long id){
        return staffService.findById(id);
    }

    // Update a Staff Info
    @PutMapping("/staffupdate/{id}")
    public StaffInfo updateStaff1(@PathVariable(value = "id") Long id,
                                        @Valid @RequestBody StaffInfo staffDetails) throws Exception {

        StaffInfo staff = staffService.findById(id)
                .orElseThrow(() -> new Exception("Not valid account is found"));
        staff.setStaffName(staffDetails.getStaffName());
        staff.setAddress(staffDetails.getAddress());
        staff.setPhoneNumber(staffDetails.getPhoneNumber());
        staff.setStaffPost(staffDetails.getStaffPost());

        StaffInfo updateStaff = staffService.save(staff);

        return updateStaff;
    }

    // Delete a hospital
    @DeleteMapping("/staffdelete/{id}")
    public ResponseEntity<?> deleteStaffInfo(@PathVariable(value = "id") Long id) throws Exception {
        StaffInfo staff = staffService.findById(id)
                .orElseThrow(() -> new Exception("Error Deleting the staff"));

        staffService.delete(id);

        return ResponseEntity.ok().build();
    }

}
