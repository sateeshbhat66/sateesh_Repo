package com.sateeshbhat.studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.sateeshbhat.studentsystem.model.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sateeshbhat.studentsystem.Service.StudentService;



@RestController
public class studentController {

    @Autowired
    private StudentService studentService ;


    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(@RequestBody student student1){
        studentService.saveStudent(student1);
        return ("new student added");
    }

    @PostMapping("/addstudent")
    public ModelAndView addstd(@ModelAttribute student student1){
        studentService.saveStudent(student1);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("/getAll")
    public List<student> getallStudentDetails(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getAllStudents")
    public ModelAndView  getStudentDetails(Model model){
        List<student> getAllStudents= studentService.getAllStudents();
        model.addAttribute("getAllStudents", getAllStudents);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("display.html");
        return modelAndView;

    }

    






}
