package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Exam;
import com.example.demo.models.Filiere;
import com.example.demo.models.UserModuleAssignment;
import com.example.demo.repository.UserModuleAssignmentRepository;

@Service
public class UserModuleAssignmentService {

    @Autowired
    private UserModuleAssignmentRepository userModuleAssignmentRepository;

    public void assignModuleToUser(Long userId, Long moduleId) {
        UserModuleAssignment userModuleAssignment = new UserModuleAssignment(userId, moduleId);
        userModuleAssignmentRepository.save(userModuleAssignment);
    }

    public void unassignModuleFromUser(Long userId, Long moduleId) {
        UserModuleAssignment userModuleAssignment = userModuleAssignmentRepository.findByUserIdAndModuleId(userId, moduleId);
        if (userModuleAssignment != null) {
            userModuleAssignmentRepository.delete(userModuleAssignment);
        }
    }
	public List<UserModuleAssignment> findAll() {
		return userModuleAssignmentRepository.findAll();
	}
	public void delete(long id) {
		userModuleAssignmentRepository.deleteById(id);

	}
}

