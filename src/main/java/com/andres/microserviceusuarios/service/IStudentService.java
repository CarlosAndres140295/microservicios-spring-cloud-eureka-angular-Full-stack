package com.andres.microserviceusuarios.service;

import com.andres.microserviceusuarios.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    public List<Student> findAll();

    public Optional<Student> findById(Long id);

    public Student save(Student student);

    void deleteById(Long id);
}
