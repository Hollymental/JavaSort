package Filework;

import Classes.Bus;
import Classes.Student;
import Classes.User;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class FileDownload {
    private final String filePath;

    public FileDownload(String fileName) {
        this.filePath = Paths.get("").toAbsolutePath().toString() + "\\files\\" + fileName;
    }

    public void createUserFile(User[] users) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Users");

        for (int i = 0; i < users.length; i++) {
            Row row = sheet.createRow(i);

            Cell nameCell = row.createCell(0);
            nameCell.setCellValue(users[i].getName());

            Cell passwordCell = row.createCell(1);
            passwordCell.setCellValue(users[i].getPassword());

            Cell emailCell = row.createCell(2);
            emailCell.setCellValue(users[i].getEmail());
        }

        try (FileOutputStream fileOut = new FileOutputStream(this.filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void createBusFile(Bus[] buses) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Buses");

        for (int i = 0; i < buses.length; i++) {
            Row row = sheet.createRow(i);

            Cell numberCell = row.createCell(0);
            numberCell.setCellValue(buses[i].getNumber());

            Cell modelCell = row.createCell(1);
            modelCell.setCellValue(buses[i].getModel());

            Cell mileageCell = row.createCell(2);
            mileageCell.setCellValue(buses[i].getMileage());
        }

        try (FileOutputStream fileOut = new FileOutputStream(this.filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void createStudentFile(Student[] students) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Students");

        for (int i = 0; i < students.length; i++) {
            Row row = sheet.createRow(i);

            Cell groupNumberCell = row.createCell(0);
            groupNumberCell.setCellValue(students[i].getGroupNumber());

            Cell averageScoreCell = row.createCell(1);
            averageScoreCell.setCellValue(students[i].getAverageScore());

            Cell recordBookNumberCell = row.createCell(2);
            recordBookNumberCell.setCellValue(students[i].getRecordBookNumber());
        }

        try (FileOutputStream fileOut = new FileOutputStream(this.filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}