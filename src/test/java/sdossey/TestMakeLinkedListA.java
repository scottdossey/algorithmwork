package sdossey;

import org.junit.jupiter.api.Test;


import sdossey.algorithms.exercises.MakeLinkedListA;
import sdossey.algorithms.tests.TestSinglyLinkedList;

public class TestMakeLinkedListA 
{
    @Test
    public void testListA()
    {   
        TestSinglyLinkedList.testListClass( () -> MakeLinkedListA.factory((Integer)0) );       
    }
 
}
