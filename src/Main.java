import GA.GeneticAlgorithms.GeneticAlgorithm;
import GA.GeneticAlgorithms.Preset;
import GA.Utility.AveragingTool;

public class Main {
    public static void main (String[] args) {

        GeneticAlgorithm geneticAlgorithm = Preset.getGA("src/data/bays29.tsp");

        AveragingTool avg = new AveragingTool(geneticAlgorithm, 30);
        avg.run();
//        double result = geneticAlgorithm.run();
//        geneticAlgorithm.showGraphInWindow();
//        geneticAlgorithm.printProperties();
//        geneticAlgorithm.printResults();

    }
}