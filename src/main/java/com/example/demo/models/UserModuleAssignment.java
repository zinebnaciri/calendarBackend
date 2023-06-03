package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "user_module_assignment")
public class UserModuleAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    
    
    public UserModuleAssignment() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public Long getModuleId() {
		return moduleId;
	}



	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}



	@Column(name = "module_id")
    private Long moduleId;

 

    public UserModuleAssignment(Long userId, Long moduleId) {
        this.userId = userId;
        this.moduleId = moduleId;
    }
}

