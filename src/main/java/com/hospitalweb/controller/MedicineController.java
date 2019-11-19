package com.hospitalweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MedicineController {
    @RequestMapping("medicine")
    public String medicineHome(String myName, HttpSession session){
        System.out.println("hi"+myName);
        session.setAttribute("myName", myName);
        return "Medicine.html";
    }
}
