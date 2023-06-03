package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.CreateExamRequest;
import com.example.demo.models.Exam;
import com.example.demo.services.ExamService;

@RestController
@RequestMapping("api/exams")
public class ExamController {

	private final ExamService examService;

	@Autowired
	public ExamController(ExamService examService) {
		this.examService = examService;
	}
	@GetMapping("/{userId}")
    public ResponseEntity<List<Exam>> getExamsByUserId(@PathVariable Long userId) {
        List<Exam> exams = examService.findExamsByUserId(userId);
        return ResponseEntity.ok(exams);
    }

	@GetMapping("/assigned-user/{userId}")
    public List<Exam> getExamsByAssignedUser(@PathVariable Long userId) {
        return examService.getExamsByAssignedUser(userId);
    }

	@PostMapping("/save")
	public Exam save(@RequestBody Exam p) {
		return examService.save(p);
	}

	@GetMapping("/all")
	public List<Exam> findAll() {
		return examService.findAll();
	}

	@GetMapping("/id/{id}")
	public Exam findById(@PathVariable int id) {
		return examService.findById(id);
	}

	@PutMapping("/update")
	public Exam update(@RequestBody Exam p) {
		return examService.update(p);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		examService.delete(id);
	}

	@PostMapping("/create")
	public ResponseEntity<Exam> createExam(@RequestBody CreateExamRequest request) {
		Exam exam = examService.createExam(request.getNom(), request.getDuree(), request.getDateTime(),
				request.getModuleId(), request.getSalleId());

		return ResponseEntity.ok(exam);
	}

}
