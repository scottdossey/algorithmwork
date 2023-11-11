package sdossey.algorithms.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringLoader<T> 
{
    public static String[] load(String filename)
    {
        List<String> wordList = new ArrayList<String>();

        Scanner scanner = 
            new Scanner(StringLoader.class.getClassLoader().getResourceAsStream(filename));       

        String value;
        
        while(scanner.hasNext())
        {
            value = scanner.next().trim();
            if ((value != null) && !value.equals(""))
            {
                wordList.add(value);
            }
        }
        scanner.close();

        String[] emptyArray=new String[0];
        String[] returnArray = wordList.toArray(emptyArray);
        Arrays.sort(returnArray); 
        return returnArray;
    }      
}
