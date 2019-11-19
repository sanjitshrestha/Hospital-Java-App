package com.hospitalweb.repository;

import com.hospitalweb.domain.StaffInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffInfo, Long>{
}
