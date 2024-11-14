package com.example.Practical_Guide_02.Service;

import java.util.List;

import com.example.Practical_Guide_02.Model.Student;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(long id);

    Student updateStudent(long id, Student student);

    void deleteStudent(long id);
}
