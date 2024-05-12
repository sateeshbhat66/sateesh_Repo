package com.sateeshbhat.studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.sateeshbhat.studentsystem.model.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sateeshbhat.studentsystem.Service.StudentService;



@RestController
public class studentController {

    @Autowired
    private StudentService studentService ;

    public studentController(StudentService studentService ){
        super();
        this.studentService=studentService;
    }



    

    @GetMapping("/students")
    public ModelAndView  getStudentDetails(Model model){
        List<student> students= studentService.getAllStudents();
        model.addAttribute("students", students);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("students.html");
        return modelAndView;

    }

    @GetMapping("/students/new")
    public ModelAndView createStudentForm(Model model){
        student student=new student();
        model.addAttribute("student", student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("CreateStudent.html");
        return modelAndView;
    }

    @PostMapping("/students")
    public ModelAndView  saveStudent(@ModelAttribute student student){
        studentService.saveStudent(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/students");
        return modelAndView;


    }

    @GetMapping("/students/edit/{id}")
	public ModelAndView editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit_student.html");
        return modelAndView;
	}

	@PostMapping("/students/{id}")
	public ModelAndView updateStudent(@PathVariable int id,
			@ModelAttribute("student") student student,
			Model model) {
		
		// get student from database by id
		student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/students");
        return modelAndView;		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public ModelAndView deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/students");
        return modelAndView;
	}


    






}
