import GA.GeneticAlgorithms.GeneticAlgorithm;
import GA.GeneticAlgorithms.Preset;
import GA.Utility.AveragingTool;
import Utils.FileInteract;


import java.io.File;

public class Main {
    public static void main (String[] args) {

        System.out.println("Starting...");

        File folder = new File("src/data/" + args[0]);
        File[] listOfFiles = folder.listFiles();

        File output = new File("src/output");
        output.mkdirs();

//        for (int i = 0; i < listOfFiles.length; i++) {
//            String name = listOfFiles[i].getName();
//            if (listOfFiles[i].isFile() && name.substring(name.length() - 3).equalsIgnoreCase("tsp")) {
//                System.out.println("  [" + i + "] " + listOfFiles[i].getName());
//            }
//        }

        File outputType = new File("src/output/" + args[0]);
        outputType.mkdirs();


        for (int i = 0; i < listOfFiles.length; i++)
        {
            double []results = {0.0, 0.0, 0.0};
            String name = listOfFiles[i].getName();
            if (listOfFiles[i].isFile() && name.substring(name.length() - 3).equalsIgnoreCase("tsp")) {
                System.out.println("  [" + i + "] " + listOfFiles[i].getName());
                GeneticAlgorithm geneticAlgorithm = Preset.getGA(listOfFiles[i].toString());
                if(geneticAlgorithm != null){
                    AveragingTool avg = new AveragingTool(geneticAlgorithm, 30);
                    results = avg.run();
                }
                FileInteract.appendToFile(results, outputType.toString() + "/gatsp.csv", listOfFiles[i].getName());
            }
            //            FileInteract.appendToFile(results, "src/output/gatsp.csv", listOfFiles[i].getName());
        }
//        double result = geneticAlgorithm.run();
//        geneticAlgorithm.showGraphInWindow();
//        geneticAlgorithm.printProperties();
//        geneticAlgorithm.printResults();

    }
}