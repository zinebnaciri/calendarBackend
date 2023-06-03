package com.example.demo.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.ExcelHelper;
import com.example.demo.models.Tutorial;
import com.example.demo.models.User;
import com.example.demo.repository.TutorialRepository;
import com.example.demo.repository.UserRepository;



@Service
public class ExcelService {
  @Autowired
  UserRepository repository;

  public void save(MultipartFile file) {
    try {
      List<User> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<User> tutorials = repository.findAll();

    ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
    return in;
  }

  public List<User> getAllTutorials() {
    return repository.findAll();
  }
}
