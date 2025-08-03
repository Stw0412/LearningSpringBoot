package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.StudentModel;

@Service
public class StudentServices {
	public List<StudentModel> getAllStudents() {
        List<StudentModel> students = new ArrayList<>();
        students.add(new StudentModel("STest01","SISI", 20));
        students.add(new StudentModel("STest02","SISI2", 21));
        students.add(new StudentModel("Stest03","SISI3", 19));
        return students;
    }
}
