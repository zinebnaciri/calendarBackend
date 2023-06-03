package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserModuleAssignment;

@Repository
public interface UserModuleAssignmentRepository extends JpaRepository<UserModuleAssignment, Long> {
    UserModuleAssignment findByUserIdAndModuleId(Long userId, Long moduleId);
}
