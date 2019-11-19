package com.hospitalweb.service;

import com.hospitalweb.domain.HospitalInfo;
import com.hospitalweb.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository repo;

    public List<HospitalInfo> findAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Optional<HospitalInfo> findById(Long id) {
        return repo.findById(id);
    }

    public HospitalInfo save(HospitalInfo hospital) {
        return repo.save(hospital);
    }
}
