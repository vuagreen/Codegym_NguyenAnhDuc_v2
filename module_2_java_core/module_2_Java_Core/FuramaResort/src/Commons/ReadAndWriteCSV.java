package Commons;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadAndWriteCSV {
    static final String NEW_LINE_SEPARATOR = "\n";
    public static void writeCSV(String fileName, String str) {
        FileWriter fileWriter =null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(str);
            fileWriter.append(NEW_LINE_SEPARATOR);

        } catch (Exception e) {
            System.out.println("Error in CSV "+fileName+" file Writer");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("Error when flush or close ");
            }
        }
    }

    public static String readCSV(String fileName) {
        StringBuilder s = new StringBuilder();
        try {
            File fileWriter = new File(fileName);
            if (fileWriter.createNewFile()) {
                System.out.println("File is created!");
            }
            Scanner myReader = new Scanner(fileWriter);
            while (myReader.hasNextLine()) {
                s.append(myReader.nextLine());
                s.append("\n");
            }
            myReader.close();
        } catch ( Exception e)  {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return s.toString();
    }
}
