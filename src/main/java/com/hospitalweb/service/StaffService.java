package com.hospitalweb.service;

import com.hospitalweb.domain.StaffInfo;
import com.hospitalweb.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repo;

    public List<StaffInfo> findAll(){
        return repo.findAll();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public Optional<StaffInfo> findById(Long id){
        return repo.findById(id);
    }

    public StaffInfo save(StaffInfo staff){
        return repo.save(staff);
    }
}
