package com.example.Practical_Guide_02.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Practical_Guide_02.Model.Student;
import com.example.Practical_Guide_02.Repo.StudentRepo;
import com.example.Practical_Guide_02.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Student updateStudent(long id, Student student) {
        Student existingStudent = studentRepo.findById(id).orElseThrow(() -> new RuntimeException());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearsOfEnrollment(student.getYearsOfEnrollment());

        return existingStudent;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepo.findById(id).orElseThrow(() -> new RuntimeException());
        studentRepo.deleteById(id);
    }

}
