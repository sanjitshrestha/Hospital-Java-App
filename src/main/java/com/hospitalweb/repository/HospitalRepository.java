package com.hospitalweb.repository;

import com.hospitalweb.domain.HospitalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalInfo, Long>{
}
