import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUpload {
    String fileName;
    String path;

    public FileUpload(String fileName) {
        this.fileName = fileName;
        this.path = Paths.get("").toAbsolutePath().toString() + "\\files\\";
    }

    void dataUpload() {
        String file = this.path + this.fileName;

        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new FileReader(new File(file)));
//        scanner.useDelimiter(" ");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
            System.out.print(list);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
//        return list.toArray(new String[list.size()]);
    }


}
