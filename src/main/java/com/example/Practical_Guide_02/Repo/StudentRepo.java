package com.example.Practical_Guide_02.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Practical_Guide_02.Model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
