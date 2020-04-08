import Linkern.AveragingTool;
import Linkern.Interpreter;
import Linkern.LinKernighan;
import Utils.FileInteract;

import java.io.File;
import java.util.Scanner;

public class LKRunM {

	public static void main(String[] args) {
    
		System.out.println("Starting...");
		
		File folder = new File("src/data/" + args[0]);
        File[] listOfFiles = folder.listFiles();

        File output = new File("src/output");
        output.mkdirs();

        for (int i = 0; i < listOfFiles.length; i++) {
        	String name = listOfFiles[i].getName();
        	if (listOfFiles[i].isFile() && name.substring(name.length() - 3).equalsIgnoreCase("tsp")) {
        		System.out.println("  [" + i + "] " + listOfFiles[i].getName());
            }
        }
        

        File outputType = new File("src/output/" + args[0]);
        outputType.mkdirs();
        
//        int idx;
//        do {
//	        System.out.print("Select the dataset to test: ");
//	        idx = scanner.nextInt();
//        } while(idx >= listOfFiles.length || idx < 0);

        for (int i = 0; i < listOfFiles.length; i++)
        {
            Interpreter in = new Interpreter(listOfFiles[i]);

            // Create the instance of the problem
            String name = listOfFiles[i].getName();
            if (listOfFiles[i].isFile() && name.substring(name.length() - 3).equalsIgnoreCase("tsp")) {
                LinKernighan lk = new LinKernighan(in.getCoordinates(), in.getIds());
                AveragingTool avg = new AveragingTool(lk, 30);
                double[] results = avg.run();
                FileInteract.appendToFile(results, outputType.toString() + "/lkspt.csv", listOfFiles[i].getName());
            }
        }
        
	}
}

