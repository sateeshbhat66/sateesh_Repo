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

    @Override
	public student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public student updateStudent(student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);	
	}

    

    



}
