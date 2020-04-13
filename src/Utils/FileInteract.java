package Utils;

import java.io.FileWriter;
import java.io.IOException;

public class FileInteract {

    public static void appendToFile(double []results, String outputFile, String fileName)
    {
        try{
            FileWriter csvWriter = new FileWriter(outputFile, true);
            String row = fileName+ ", " + results[0] + ", " + results[1] + ", " + results[2] + "\n";
            csvWriter.write(row);
            csvWriter.close();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void appendToFileB(int result, String outputFile, String fileName)
    {
        try{
            FileWriter csvWriter = new FileWriter(outputFile, true);
            String row = fileName+ ", " + result + "\n";
            csvWriter.write(row);
            csvWriter.close();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
