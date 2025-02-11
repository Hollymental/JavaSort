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
    String fileName;
    String path;

    public FileUpload(String fileName) {
        this.fileName = fileName;
        this.path = Paths.get("").toAbsolutePath().toString() + "\\files\\";
    }

    User[] usersUpload() {
        String filePath = this.path + this.fileName;
        User[] users = new User[5];
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            int rowCount = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator
                        = row.cellIterator();
                String[] userText = new String[3];
                int cellCount = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    userText[cellCount] = cell.getStringCellValue();
                    cellCount++;
                }
//                User user = new User.UserBuilder().name(userText[0]).password(userText[1]).email(userText[2]).build();
//                users[rowCount] = user;
//                rowCount++;
            }

            file.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
//        return new User[];
    }


}
