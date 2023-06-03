package com.example.demo.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Filiere;
import com.example.demo.models.Tutorial;
import com.example.demo.models.User;
import com.example.demo.repository.FiliereRepository;
import com.example.demo.repository.UserRepository;


public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Id", "matricule", "nom", "prenom","email","filiere"};
  static String SHEET = "Feuil1";

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static ByteArrayInputStream tutorialsToExcel(List<User> tutorials) {

    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
      Sheet sheet = workbook.createSheet(SHEET);

      // Header
      Row headerRow = sheet.createRow(0);

      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
      }

      int rowIdx = 1;
      for (User tutorial : tutorials) {
        Row row = sheet.createRow(rowIdx++);

        row.createCell(0).setCellValue(tutorial.getId());
        row.createCell(1).setCellValue(tutorial.getMatricule());
        row.createCell(2).setCellValue(tutorial.getNom());
        row.createCell(3).setCellValue(tutorial.getPrenom());
        row.createCell(4).setCellValue(tutorial.getTelephone());
        row.createCell(5).setCellValue(tutorial.getEmail());
        row.createCell(6).setCellValue(tutorial.getPassword());
        row.createCell(7).setCellValue(tutorial.getUsername());
        row.createCell(8).setCellValue("filiere");

      }

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
    	System.out.println(e.getMessage());
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }

  public static List<User> excelToTutorials(InputStream is) {
    try {
      Workbook workbook = new XSSFWorkbook(is);

      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      List<User> tutorials = new ArrayList<User>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        User tutorial = new User();
        

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {
          case 0:
            tutorial.setId((long) currentCell.getNumericCellValue());
            break;
          case 1:
            tutorial.setMatricule(currentCell.getStringCellValue());
            break;
          case 2:
            tutorial.setNom(currentCell.getStringCellValue());
            break;
          case 3:
              tutorial.setPrenom(currentCell.getStringCellValue());
              break;
          case 4:
              tutorial.setTelephone(currentCell.getStringCellValue());
              break;
          case 5:
              tutorial.setEmail(currentCell.getStringCellValue());
              break;
          case 6:
              tutorial.setPassword(currentCell.getStringCellValue());
          case 7:
              tutorial.setUsername(currentCell.getStringCellValue());
          case 8 : 
        	  tutorial.setFiliere(new Filiere(1,"test","test"));
              break;
          default:
            break;
          }

          cellIdx++;
        }

        tutorials.add(tutorial);
      }

      workbook.close();

      return tutorials;
    } catch (IOException e) {

      throw new RuntimeException(e.getMessage());

    }
  }
}
