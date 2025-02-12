import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUpload {
    private final String filePath;

    public FileUpload(String fileName) {
        this.filePath = Paths.get("").toAbsolutePath().toString() + "\\files\\" + fileName;
    }

    public User[] usersUpload(User[] users) {
        if (users.length < 0 || users.length > 7)
            return null;

//        User[] users = new User[size];
        DataValidation dataValidation = new DataValidation(User.class);
        try {
            FileInputStream file = new FileInputStream(new File(this.filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            int rowCount = 0;
            while (rowIterator.hasNext() && rowCount < users.length) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                String[] userText = getRowInfo(cellIterator);
                boolean isValid = dataValidation.validation(userText);
                if (isValid) {
                    User user = new User.UserBuilder()
                            .setName(userText[0])
                            .setPassword(userText[1])
                            .setEmail(userText[2])
                            .build();
                    users[rowCount] = user;
                } else {
                    System.out.println("Данные из файла не валидны");
                }
                rowCount++;
            }

            file.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }

    public Bus[] busesUpload(Bus[] buses) {
        if (buses.length < 0 || buses.length > 7)
            return null;
        DataValidation dataValidation = new DataValidation(Bus.class);
        try {
            FileInputStream file = new FileInputStream(new File(this.filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            int rowCount = 0;
            while (rowIterator.hasNext() && rowCount < buses.length) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                String[] busText = getRowInfo(cellIterator);
                boolean isValid = dataValidation.validation(busText);
                if (isValid) {
                    Bus bus = new Bus.BusBuilder()
                            .setNumber(busText[0])
                            .setModel(busText[1])
                            .setMileage((int) Double.parseDouble(busText[2])).
                            build();
                    buses[rowCount] = bus;
                } else {
                    System.out.println("Данные из файла не валидны");
                }

                rowCount++;
            }

            file.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return buses;
    }

    public Student[] studentsUpload(Student[] students) {

        if (students.length < 0 || students.length > 7)
            return null;
        DataValidation dataValidation = new DataValidation(Student.class);
//        Student[] students = new Student[size];
        try {
            FileInputStream file = new FileInputStream(new File(this.filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            int rowCount = 0;
            while (rowIterator.hasNext() && rowCount < students.length) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                String[] studentText = getRowInfo(cellIterator);

                boolean isValid = dataValidation.validation(studentText);
                if (isValid) {
                    Student student = new Student.StudentBuilder()
                            .setGroupNumber(studentText[0])
                            .setAverageScore(Double.parseDouble(studentText[1]))
                            .setRecordBookNumber((int) Double.parseDouble(studentText[2]))
                            .build();
                    students[rowCount] = student;
                } else {
                    System.out.println("Данные из файла не валидны");
                }
                rowCount++;
            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return students;
    }

    public String[] getRowInfo(Iterator<Cell> cellIterator) {
        String[] objectText = new String[3];
        int cellCount = 0;
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:

                    objectText[cellCount] = String.valueOf(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    objectText[cellCount] = cell.getStringCellValue();
                    break;
            }
            cellCount++;
        }
        return objectText;
    }


}
