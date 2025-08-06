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
import org.springframework.web.bind.annotation.RequestParam;
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
	// ค้นหาอายุระหว่าง xx และ yy
	@GetMapping("/ageBetween")
	public List<Student> getStudentsByAgeRange(
	        @RequestParam int min,
	        @RequestParam int max) {
	    return studentRepo.findByAgeBetween(min, max);
	}
	//ค้นหาด้วยชื่อได้ทุกอักษร
	@GetMapping("/searchByName")
	public List<Student> searchByName(@RequestParam String keyword) {
	    return studentRepo.findByNameContainingIgnoreCase(keyword);
	}
	//เรียงอายุมากไปน้อย และ น้อยไปมาก
	@GetMapping("/sortByAge")
	public List<Student> sortByAge(@RequestParam(defaultValue = "asc") String direction) {
	    if (direction.equalsIgnoreCase("desc")) {
	        return studentRepo.findAllByOrderByAgeDesc();
	    }
	    return studentRepo.findAllByOrderByAgeAsc();
	}
	
	
	@GetMapping("/search")
	public List<Student> searchStudents(
	    @RequestParam String name,
	    @RequestParam int minAge,
	    @RequestParam int maxAge,
	    @RequestParam(defaultValue = "age") String sortBy,
	    @RequestParam(defaultValue = "asc") String direction
	) {
	    // ค้นหาจาก repo
	    List<Student> result = studentRepo.findByNameContainingIgnoreCaseAndAgeBetween(name, minAge, maxAge);

	    // จัดเรียงภายในหน่วยความจำด้วยโค้ดที่อ่านง่ายขึ้น
	    result.sort((a, b) -> {
	        int comparisonResult = 0;

	        // เลือกการเรียงลำดับตาม "age" หรือ "id"
	        if (sortBy.equalsIgnoreCase("age")) {
	            comparisonResult = Integer.compare(a.getAge(), b.getAge());
	        } else if (sortBy.equalsIgnoreCase("id")) {
	            comparisonResult = Long.compare(a.getId(), b.getId());
	        }

	        // ถ้าต้องการเรียงจากมากไปน้อย ให้กลับค่าผลลัพธ์
	        if (direction.equalsIgnoreCase("desc")) {
	            comparisonResult = -comparisonResult;
	        }

	        return comparisonResult;
	    });

	    return result;
	}

}
