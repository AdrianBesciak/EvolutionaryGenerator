package map.element;

import map.MapDirection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Genome{
    public ArrayList<Integer> gens;
    private static final int genomeSize = 32;
    private static final int amountOfDistinctGens = 8;
    private static final Random random = new Random();

    public Genome()
    {
        gens = new ArrayList<Integer>();
        for (int i = 0; i < 8; i++)
            gens.add(i);
        for (int i = 8; i < genomeSize; i++)
        {
            int value = random.nextInt(amountOfDistinctGens);
            gens.add(value);
        }
        Collections.sort(gens);  
    }

    public Genome(Animal father, Animal mother)
    {
        int splitter1 = random.nextInt(genomeSize-1) + 1;
        int splitter2 = random.nextInt(genomeSize-1) + 1;
        while (splitter1 == splitter2)
            splitter2 = random.nextInt(genomeSize-1) + 1;
        if (splitter1 > splitter2)
        {
            int temp = splitter1;
            splitter1 = splitter2;
            splitter2 = temp;
        }

        gens = new ArrayList<Integer>();
        for (int i = 0; i < splitter1; i++)
            gens.add(father.genome.gens.get(i));
        for (int i = splitter1; i < splitter2; i++)
            gens.add(mother.genome.gens.get(i));
        for (int i = splitter2; i < genomeSize; i++)
            gens.add(father.genome.gens.get(i));
        verify();
    }

    protected void verify()
    {
        ArrayList<Integer> counter = new ArrayList<>(
                List.of(0, 0, 0, 0, 0, 0, 0, 0)
        );

        for (Integer gen : gens)
        {
            counter.set(gen, counter.get(gen)+1);
        }

        for (int i = 0; i < counter.size(); i++)
        {
            if (counter.get(i) == 0)
            {
                int j;
                do {
                    j = random.nextInt(genomeSize);
                }while (counter.get(gens.get(j)) <= 1);
                counter.set(gens.get(j), counter.get(gens.get(j)) - 1);
                gens.set(j, i);
            }
        }
        Collections.sort(gens);
    }

    public MapDirection getMove()
    {
        int move = gens.get(random.nextInt(genomeSize));
        MapDirection[] dir = MapDirection.values();
        return dir[move];
    }
}

