package sdossey;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import sdossey.algorithms.exercises.MakeDoublyLinkedList;
import sdossey.algorithms.tests.TestDoublyLinkedList;

public class TestMakeDoublyLinkedList 
{
    @Test
    public void testDoublyLinkedList()
    {   
        TestDoublyLinkedList.testListClass( () -> MakeDoublyLinkedList.factory((Integer)0) );       
    }
    
    public static <E> List<E> nativeLinkedListFactory(E type)
    {
        return new LinkedList<E>();
    }

    @Test
    public void testNativeLinkedList()
    {           
        TestDoublyLinkedList.testListClass( () -> nativeLinkedListFactory((Integer)0) );       
    }
}
