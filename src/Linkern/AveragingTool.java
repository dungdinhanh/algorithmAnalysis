package Linkern;

import GA.GeneticAlgorithms.GeneticAlgorithm;

import java.util.ArrayList;

/**
 * Runs a Genetic Algorithm several times and graphs the average of the results.
 */
public class AveragingTool {

    private LinKernighan lk;
    private int numOfTimesToRun;
    private ArrayList<ArrayList<Double>> allValues;
    private ArrayList<String> legend = new ArrayList<>();

    public AveragingTool(LinKernighan lk, int numOfTimesToRun) {
        this.lk = lk;
        this.numOfTimesToRun = numOfTimesToRun;
        allValues = new ArrayList<>();
        legend = new ArrayList<>();
    }

    public double[] run () {
        ArrayList<Double> bestValuesAllGen = new ArrayList<>();
        ArrayList<Long> runningTime = new ArrayList<>();

        for (int i = 0; i < numOfTimesToRun; i++) {
            long start = System.currentTimeMillis();
            lk = new LinKernighan(lk.getCoordinates(), lk.getIds());
            lk.runAlgorithm();
            long runTime = System.currentTimeMillis() - start;
            bestValuesAllGen.add(lk.getDistance());
            runningTime.add(runTime);

        }


        double avgFinalSolution = mean(bestValuesAllGen);
        double avgRunTime = meanL(runningTime);
        double std = sd(bestValuesAllGen, avgFinalSolution);
        System.out.println("Average Final Solution: " + avgFinalSolution + " STD : " + std + " Running time : " + avgRunTime);
        double []results = {avgFinalSolution, std, avgRunTime};
        return results;
    }

    private int idx = 0;
    public void addItemToLegend (String item) {
        legend.set(idx, item + " - " + legend.get(idx++));
    }

    public void display () {
        if (legend.size() != allValues.size()) {
            System.out.println(allValues.size());
            System.out.println(legend.size());
            throw new IllegalStateException("Size of legend needs to be " +
                    "the same as the number of lines.");
        }
//        new WindowGraph(allValues, legend);
    }


    public static double sd (ArrayList<Double> table, double meanA)
    {
        // Step 1:
        double meanValue = meanA;
        double temp = 0;

        for (int i = 0; i < table.size(); i++)
        {
            double val = table.get(i);

            // Step 2:
            double squrDiffToMean = Math.pow(val - meanValue, 2);

            // Step 3:
            temp += squrDiffToMean;
        }

        // Step 4:
        double meanOfDiffs = (double) temp / (double) (table.size());

        // Step 5:
        return Math.sqrt(meanOfDiffs);
    }


    public static double sd (ArrayList<Double> table)
    {
        double meanA = mean(table);
        return AveragingTool.sd(table, meanA);

    }

    public static double mean(ArrayList<Double> table)
    {
        double sum = 0.0;
        double size = (double)table.size();
        for(int i = 0; i < size; i++)
        {
            sum += table.get(i);
        }
        return sum/size;
    }

    public static double meanL(ArrayList<Long> table)
    {
        double sum = 0.0;
        double size = (double)table.size();
        for(int i = 0; i < size; i++)
        {
            sum += (double)table.get(i);
        }
        return sum/size;
    }


}
