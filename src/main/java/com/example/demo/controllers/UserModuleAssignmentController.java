package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.models.UserModuleAssignment;
import com.example.demo.services.UserModuleAssignmentService;

@RestController
@RequestMapping("/api/auth/users")
public class UserModuleAssignmentController {

    @Autowired
    private UserModuleAssignmentService userModuleAssignmentService;

    @PostMapping("/{userId}/modules/{moduleId}")
    public ResponseEntity<String> assignModuleToUser(@PathVariable("userId") Long userId, @PathVariable("moduleId") Long moduleId) {
        userModuleAssignmentService.assignModuleToUser(userId, moduleId);
        return ResponseEntity.ok("Module assigned successfully!");
    }

    @DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
    	userModuleAssignmentService.delete(id);
	}
    @GetMapping("/assignements")
    public ResponseEntity<List<UserModuleAssignment>> findAllUsers() {
		List<UserModuleAssignment> users = userModuleAssignmentService.findAll();
		return ResponseEntity.ok(users);
	}
}

