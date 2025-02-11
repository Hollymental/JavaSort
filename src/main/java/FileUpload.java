import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
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

    void dataUpload() {
        String filePath = this.path + this.fileName;
        ArrayList<String> list = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator
                        = row.cellIterator();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {

                        // Case 1
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(
                                    cell.getNumericCellValue()
                                            + "t");
                            break;

                        // Case 2
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(
                                    cell.getStringCellValue()
                                            + "t");
                            break;
                    }
                }

                System.out.println("");
            }

            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
//            System.out.println(ex.getMessage());
        }
//        return list.toArray(new String[list.size()]);
    }


}
