package sdossey.algorithms.datasets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomData 
{
    private static final Random RNG = new Random();

    public static List<Integer> randomIntList(int min, int max, int size)    
    {
        ArrayList<Integer> returnList = new ArrayList<>(size);
        for(int i=0; i<size; ++i)
        {
            returnList.add(RNG.nextInt(max-min)+min);
        }
        return returnList;
    }
}
