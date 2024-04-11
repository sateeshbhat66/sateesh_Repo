package com.sateeshbhat.studentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sateeshbhat.studentsystem.model.student;
@Repository
public interface StudentRepository extends JpaRepository<student,Integer> {

}
