package sdossey.algorithms.exercises;

import sdossey.algorithms.datasets.Words;

public class SortedArraySearch 
{
    public static boolean contains(String[] data, String searchString)
    {
		//Reimplement this method to be faster. 
		//It is okay to create other methods that are called,
		//and it is okay to use methods of String (such as equals)
		for(String value:data)
		{
		    if(searchString.equals(value))
		    {
		        return true;
		    }
		}
		return false;
    }

    public static final void main(String[] args)
    {
        String[] data = Words.ENGLISH;   
        String[] checkData = Words.SPANISH;
        
        int counter=0;

        long start = System.currentTimeMillis();
        for( String value : checkData )
        {
            if(contains(data, value))
            {                
                counter += 1;
            }
        }        
        long end = System.currentTimeMillis();        
        System.out.println("There are "+counter+" words shared between our Spanish and English dictionary.");
        System.out.println("It took "+(end-start)+ " milliseconds to do this calculation.");
    }
}
