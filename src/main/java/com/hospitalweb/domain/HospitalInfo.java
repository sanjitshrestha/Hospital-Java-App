package com.hospitalweb.domain;

import javax.persistence.*;

@Entity
@Table(name = "hospital_info")
public class HospitalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "hospital_name")
    private String hospitalName;

    private String address;

    @Column(name = "phone_number")
    private long phoneNumber;

    private int estd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getEstd() {
        return estd;
    }

    public void setEstd(int estd) {
        this.estd = estd;
    }
}
