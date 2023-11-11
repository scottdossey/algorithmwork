package sdossey.algorithms.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TestDoublyLinkedList 
{
    public interface FactoryLambda
    {
        List<Integer> build();
    }

    FactoryLambda factory;
    
    public TestDoublyLinkedList(FactoryLambda factory) {
        this.factory = factory;
    }

    private List<Integer> construct()
    {
        return factory.build();
    }

    public static void testListClass(FactoryLambda factory)    
    {
        TestDoublyLinkedList tests = new TestDoublyLinkedList(factory);
        tests.sizeZeroTests();
        tests.sizeOneTests();
        tests.mainTests();
    }

    public void sizeZeroTests()
    {
        List<Integer> testList = construct();
        assertEquals(0, testList.size());
        ListIterator<Integer> cursor = testList.listIterator();
        internalSizeZeroTests(cursor);
    }

    private void internalSizeZeroTests(ListIterator<Integer> cursor)
    {
        assertFalse(cursor.hasNext());
        assertFalse(cursor.hasPrevious());
        assertEquals(0, cursor.nextIndex());
        assertEquals(-1, cursor.previousIndex());
        Class<? extends Throwable> e = NoSuchElementException.class;
        assertThrows(e, () -> {cursor.next();});
        assertThrows(e, () -> {cursor.previous();});

        e = IllegalStateException.class;
        assertThrows(e, () -> {cursor.set(5);});
        assertThrows(e, () -> {cursor.remove();});        
    }

    public void sizeOneTests()
    {
        List<Integer> testList = construct(); 
        ListIterator<Integer> cursor = testList.listIterator();
        cursor.add(32);
        assertEquals(1, testList.size());
        assertFalse(cursor.hasNext());
        assertTrue(cursor.hasPrevious());
        assertEquals(1, cursor.nextIndex());
        assertEquals(0, cursor.previousIndex());
        Class<? extends Throwable> e = NoSuchElementException.class;
        assertThrows(e, () -> {cursor.next();});
        e = IllegalStateException.class;
        assertThrows(e, () -> {cursor.set(5);});
        assertThrows(e, () -> {cursor.remove();});        

        //Okay, walk back.
        assertEquals(32, cursor.previous());
        assertEquals(1, testList.size());
        assertTrue(cursor.hasNext());
        assertFalse(cursor.hasPrevious());
        assertEquals(0, cursor.nextIndex());
        assertEquals(-1, cursor.previousIndex());
        cursor.set(5);//set from previous
        assertEquals(5, cursor.next());
        assertEquals(1, cursor.nextIndex());
        assertEquals(0, cursor.previousIndex());
        cursor.set(6); //set from next
        assertEquals(6, cursor.previous());
        cursor.set(7);
        cursor.set(8); //Verify you can set more than once.
        assertEquals(8, cursor.next());
        cursor.remove(); // remove after next.
        
        internalSizeZeroTests(cursor);
        assertEquals(0, testList.size());
        cursor.add(17);
        assertEquals(17, cursor.previous());
        cursor.remove(); // remove after previous.
        internalSizeZeroTests(cursor);
        assertEquals(0, testList.size());
    }

    public void mainTests()
    {
        List<Integer> testList = construct();
        ListIterator<Integer> cursor = testList.listIterator();
             
        //Test adding at base.
        for(Integer i = 0; i < 100; ++i)
        {
            cursor.add(i);
            assertTrue(cursor.hasPrevious());
            assertEquals(i+1, testList.size());
            assertEquals(i+1, cursor.nextIndex());
            assertEquals(i, cursor.previousIndex());
        }
                
        //Check list backwards.
        for(Integer j=99; j >=0; --j)
        {
            assertEquals(j+1, cursor.nextIndex());
            assertEquals(j, cursor.previousIndex());
            assertEquals(j!=99, cursor.hasNext());
            assertEquals(j, cursor.previous());
            assertEquals(j!=0, cursor.hasPrevious());
        }
        Class<? extends Throwable> e = NoSuchElementException.class;
        ListIterator<Integer> cursorTestA=cursor;
        
        assertThrows(e, () -> {cursorTestA.previous();});
                
        //Check list forwards.
        for(Integer i = 0; i < 100; ++i)
        {
            assertEquals(i, cursor.nextIndex());
            assertEquals(i-1, cursor.previousIndex());
            assertEquals(i!=0, cursor.hasPrevious());
            assertEquals(i, cursor.next());
            assertEquals(i!=99, cursor.hasNext());
        }
        ListIterator<Integer> cursorTestB=cursor;
        assertThrows(e, () -> {cursorTestB.next();});

        //Sanity check
        assertEquals(100, testList.size());

        //Now to test remove, 
        cursor = testList.listIterator(50);
        assertEquals(50, cursor.next());
        cursor.remove(); //Remove 50
        assertEquals(99, testList.size());
        assertEquals(50, cursor.nextIndex()); // Was 51 before removal
        assertEquals(49, cursor.previousIndex()); 
        e = IllegalStateException.class;
        ListIterator<Integer> cursorTestC=cursor;
        assertThrows(e, () -> {cursorTestC.set(5);});
        assertThrows(e, () -> {cursorTestC.remove();});        
        assertEquals(49, cursor.previous());
        cursor.remove(); //Remove 49 -- remove from previous 
        assertEquals(98, testList.size());
        assertEquals(49, cursor.nextIndex());
        assertEquals(48, cursor.previousIndex()); 
        
        //backup and walk forward over changes.
        assertEquals(48, cursor.previous());
        assertEquals(48, cursor.next());
        assertEquals(51, cursor.next());
        assertEquals(52, cursor.next());
        assertEquals(51, cursor.nextIndex());
        assertEquals(50, cursor.previousIndex()); 

        //walk backward over changes.
        assertEquals(52, cursor.previous());
        assertEquals(51, cursor.previous());
        assertEquals(48, cursor.previous());
        assertEquals(47, cursor.previous());
        assertEquals(47, cursor.nextIndex());
        assertEquals(46, cursor.previousIndex()); 

        assertEquals(47, cursor.next());
        assertEquals(48, cursor.next());
        cursor.add(49);
        assertEquals(99, testList.size());
        e = IllegalStateException.class;
        ListIterator<Integer> cursorTestD=cursor;
        assertThrows(e, () -> {cursorTestD.set(5);});
        assertThrows(e, () -> {cursorTestD.remove();});        
        cursor.add(50);
        assertEquals(100, testList.size());
        assertEquals(51, cursor.nextIndex());
        assertEquals(50, cursor.previousIndex()); 
        assertEquals(50, cursor.previous());
        assertEquals(49, cursor.previous());
        assertEquals(49, cursor.next());
        assertEquals(50, cursor.nextIndex());
        assertEquals(49, cursor.previousIndex()); 
        //OKAY time to test set.
        assertEquals(50, cursor.next());
        cursor.set(500);
        cursor.set(5000); //Dual test set.
        assertEquals(5000, cursor.previous());
        cursor.set(500);
        cursor.set(50);
        assertEquals(50, cursor.next());
        assertEquals(51, cursor.nextIndex());
        assertEquals(50, cursor.previousIndex()); 
        
        //Test bad indexes when getting ListITerator
        e = IndexOutOfBoundsException.class;        
        assertThrows(e, ()->{testList.listIterator(-1);});
        cursor = testList.listIterator(100); //Make sure this is valid;
        assertFalse(cursor.hasNext());
        assertThrows(e, ()->{testList.listIterator(101);});
         
        //Good enough for me.
        
    }
}
