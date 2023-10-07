/* public class Algorithim {
  public static int POP_SIZE;
  public Algorithim(int popSize) {
    POP_SIZE = popSize;
  }
  public Population evolvePopulation(Population pop) {
    Population evolvePop = mutatePopulation(crossoverPopulation(pop));
    return evolvePop;
  }
  public Population crossoverPopulation(Population pop) {
    Population mutatedPop = new Population(POP_SIZE).initPopulation();
    pop.sortChromosomesByFitness();
    Chromosome c1 = pop.getChromosomes()[0];
    Chromosome c2 = pop.getChromosomes()[1];
    for (int i = 0; i < POP_SIZE; i++) {
      for (int j = 0; j < c1.getGenes().length; j++) {
        int newGene;
        if (Math.random() > 0.5) {
          newGene = c1.getGenes()[j];
        } else {
          newGene = c2.getGenes()[j];
        }
        mutatedPop.getChromosomes()[i].setGene(j, newGene);
      }
    }
    return mutatedPop;
  }
  public Population mutatePopulation(Population pop) {
    // add radndom muattion
  }
}
*/