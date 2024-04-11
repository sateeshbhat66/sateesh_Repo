package com.sateeshbhat.studentsystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sateeshbhat.studentsystem.model.student;
import com.sateeshbhat.studentsystem.repository.StudentRepository;

@Service
public class studentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public student saveStudent(student student1) {

        return studentRepository.save(student1);
    }

    @Override
    public List<student> getAllStudents() {
        
        return studentRepository.findAll();
    }

    

    



}
