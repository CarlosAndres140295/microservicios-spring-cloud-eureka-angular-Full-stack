package com.andres.microserviceusuarios.controller;

import com.andres.microserviceusuarios.model.Student;
import com.andres.microserviceusuarios.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Student> data = service.findById(id);

        if (data.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(data.get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> save(@RequestBody Student student, @PathVariable Long id){
        Optional<Student> data = service.findById(id);

        if (data.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        loadData(data, student);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(data.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> save(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private void loadData(Optional<Student> data, Student student) {
        data.get().setFirstName(student.getFirstName());
        data.get().setLastName(student.getLastName());
        data.get().setEmail(student.getEmail());

    }
}
