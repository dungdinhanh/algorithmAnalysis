import Linkern.AveragingTool;
import Linkern.Interpreter;
import Linkern.LinKernighan;
import Utils.FileInteract;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GetBest {

	public static void main(String[] args) {
    
		System.out.println("Starting...");
		
		File folder = new File("src/data/" + args[0]);
        File[] listOfFiles = folder.listFiles();

        ArrayList<String> dataName = new ArrayList<>();
        ArrayList<Integer> optimal = new ArrayList<>();

        File bestFile = new File("src/data/tsp/bestSolutions.txt");
        try{
            Scanner scanner = new Scanner(bestFile);
            while(scanner.hasNextLine())
            {
                String buffer = scanner.nextLine();
                StringTokenizer strTok = new StringTokenizer(buffer, " :\n");
                String name = strTok.nextToken();
                String value = strTok.nextToken();
                name = name + ".tsp";
                dataName.add(name);
                int ivalue = Integer.valueOf(value);
                optimal.add(ivalue);

            }
            scanner.close();
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

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
            String nameA = listOfFiles[i].getName();

            // Create the instance of the problem
            String name = listOfFiles[i].getName();
            if (listOfFiles[i].isFile() && name.substring(name.length() - 3).equalsIgnoreCase("tsp")) {

                int bestResult =0;
                    for (int j = 0; j < dataName.size(); j ++)
                    {
                        if(nameA.equals(dataName.get(j)))
                        {
                            bestResult = optimal.get(j);
                            break;
                        }
                    }

//                LinKernighan lk = new LinKernighan(in.getCoordinates(), in.getIds());
//                AveragingTool avg = new AveragingTool(lk, 30);
//                double[] results = avg.run();
                FileInteract.appendToFileB(bestResult, outputType.toString() + "/best.csv", listOfFiles[i].getName());
            }
        }
        
	}
}

