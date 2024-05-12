package com.sateeshbhat.studentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sateeshbhat.studentsystem.model.student;

public interface StudentRepository extends JpaRepository<student,Integer> {

}
