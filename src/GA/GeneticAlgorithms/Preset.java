package GA.GeneticAlgorithms;

import GA.GeneticObjects.Population;
import GA.IO.Import.DataSet;

import java.awt.*;
import java.util.Random;

import static GA.GeneticObjects.Population.fromDataSet;

public class Preset {

    private Preset() {}

    public static GeneticAlgorithm getDefaultGA () {

        Random random = new Random();
        long seed = random.nextLong();
        System.out.println("Seed: " + seed);
        Random r = new Random();
        r.setSeed(seed);

        // Parameters.
        int     popSize         = 500;      // Size of the population.
        int     maxGen          = 500;      // Number of generations to run.
        double  crossoverRate   = 0.8;     // Odds that crossover will occur.
        double  mutationRate    = 0.05;     // Odds that mutation will occur.

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();

        geneticAlgorithm.setPopulation(fromDataSet(popSize, DataSet.att48, r));
        //geneticAlgorithm.setPopulation(Population.getRandomPopulation(100, popSize, r));
        geneticAlgorithm.setMaxGen(maxGen);
        geneticAlgorithm.setK(3);
        geneticAlgorithm.setElitismValue(1);
        geneticAlgorithm.setCrossoverRate(crossoverRate);
        geneticAlgorithm.setMutationRate(mutationRate);
        geneticAlgorithm.setRandom(r);
        geneticAlgorithm.forceUniqueness(false);
        geneticAlgorithm.setLocalSearchRate(0.00);
        geneticAlgorithm.setCrossoverType(GeneticAlgorithm.CrossoverType.UNIFORM_ORDER);
        geneticAlgorithm.setMutationType(GeneticAlgorithm.MutationType.INSERTION);

        return geneticAlgorithm;
    }

    public static GeneticAlgorithm getGA (String dataPath) {

        Random random = new Random();
        long seed = random.nextLong();
//        System.out.println("Seed: " + seed);
        Random r = new Random();
        r.setSeed(seed);

        // Parameters.
        int     popSize         = 700;      // Size of the population.
        int     maxGen          = 10000;      // Number of generations to run.
        double  crossoverRate   = 0.95;     // Odds that crossover will occur.
        double  mutationRate    = 0.2;     // Odds that mutation will occur.

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        Population population = fromDataSet(popSize, dataPath, r);
        if (population == null)return null;
        geneticAlgorithm.setPopulation(population);
        //geneticAlgorithm.setPopulation(Population.getRandomPopulation(100, popSize, r));
        geneticAlgorithm.setMaxGen(maxGen);
        geneticAlgorithm.setK(3);
        geneticAlgorithm.setElitismValue(1);
        geneticAlgorithm.setCrossoverRate(crossoverRate);
        geneticAlgorithm.setMutationRate(mutationRate);
        geneticAlgorithm.setRandom(r);
        geneticAlgorithm.forceUniqueness(false);
        geneticAlgorithm.setLocalSearchRate(0.00);
        geneticAlgorithm.setCrossoverType(GeneticAlgorithm.CrossoverType.TWO_POINT);
        geneticAlgorithm.setMutationType(GeneticAlgorithm.MutationType.RECIPROCAL_EXCHANGE);

        return geneticAlgorithm;
    }

}
