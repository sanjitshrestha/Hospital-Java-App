package com.hospitalweb.controller;

import com.hospitalweb.domain.HospitalInfo;
import com.hospitalweb.service.HospitalService;
import javafx.scene.paint.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private HospitalService service;

    @GetMapping("/home")
    public ModelAndView indexPage() {

        ModelAndView modelAndView = new ModelAndView();

        List<HospitalInfo> hospitalInfos = new ArrayList<>();
        hospitalInfos = service.findAll();
        int hospitalCount = hospitalInfos.size();
        modelAndView.addObject("hospitalCount", hospitalCount);


        modelAndView.setViewName("index");

        return modelAndView;
    }
}
