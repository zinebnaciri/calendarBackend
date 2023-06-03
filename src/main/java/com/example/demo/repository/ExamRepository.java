package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Exam;
import com.example.demo.models.Salle;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
	Exam findById(int id);

	boolean existsByDateTimeAndSalle(Date dateTime, Salle salle);
	 @Query("SELECT e FROM Exam e JOIN e.moduleEntity me JOIN UserModuleAssignment uma ON me.id = uma.moduleId WHERE uma.userId = :userId")
	    List<Exam> findExamsByAssignedUser(@Param("userId") Long userId);
	 @Query("SELECT exam FROM Exam exam JOIN exam.moduleEntity me JOIN ModuleEntity module_entity"
		 		+ " ON me.id = module_entity.id "
		 		+ " JOIN Filiere filiere ON module_entity.filiere = filiere.id "
			 		+ "JOIN User users ON users.filiere = filiere.id WHERE users.id = :userId")
	    List<Exam> findStudentExams(@Param("userId") Long userId);





}
