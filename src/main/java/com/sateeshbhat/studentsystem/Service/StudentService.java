package com.sateeshbhat.studentsystem.Service;



import java.util.List;

import com.sateeshbhat.studentsystem.model.student;


public interface StudentService {
    public student saveStudent(student student1);
    public List<student> getAllStudents(); 

    student getStudentById(int id);
	
	student updateStudent(student student);
	
	void deleteStudentById(int id);

}
