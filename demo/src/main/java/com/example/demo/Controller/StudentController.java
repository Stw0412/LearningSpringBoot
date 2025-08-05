package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.Services.StudentServices;
import com.example.demo.entities.Student;
//import com.example.demo.model.StudentModel;
import com.example.demo.repositories.StudentRepo;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	//private StudentServices student;
	private StudentRepo studentRepo;
	
	/*@GetMapping("/all")
	public List<StudentModel> getAllStudents() {
		return student.getAllStudents();
	}*/
	
	@GetMapping
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
	
	@PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }
	
	@PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student newStudent) {
        return studentRepo.findById(id).map(student -> {
            student.setName(newStudent.getName());
            student.setSurName(newStudent.getSurName());
            student.setAge(newStudent.getAge());
            return studentRepo.save(student);
        }).orElseThrow(() -> new RuntimeException("ไม่พบรหัสนักเรียน: " + id));
    }
	
	
	@DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (!studentRepo.existsById(id)) {
            throw new RuntimeException("ไม่พบรหัสนักเรียน: " + id);
        }
        studentRepo.deleteById(id);
        return "ลบนักเรียนรหัส " + id + " เรียบร้อยแล้ว";
    }
	
	
	
}
