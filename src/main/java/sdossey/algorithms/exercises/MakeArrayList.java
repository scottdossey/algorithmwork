/* 
 * Modify this so that you implement an ArrayList class that implements the 
 * full java.util.List interface.
 * 
 * This class will make use of java.util.AbstractList:
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/util/AbstractList.html
 * 
 * AbstractList does a lot of the work for you implementing the 
 * various methods of java.util.List. However, you still have to implement
 * "get(int), size(), set(int, E), add(int, E) and remove(int)" methods 
 * to maka a fully modifiable ArrayList.
 * 
 *  Complete the "Complete Me!" parts of the code. Be sure 
 *  to look at Javadoc descriptions of all the methods you need
 *  to implement to make sure you have implemented them fully
 *  and correctly.
 *  
 * There is JUnit test code in:
 *  src/test/java/TestMakeArrayList.java
 *  
 * This test code is unfortunately very hard to
 * follow as it is designed to test a LinkedList,
 * so you may want to write your own test cases
 * if you can't debug the code successfully using
 * the JUnit test.
 * 
 * Nevertheless, your code must PASS the JUnit
 * test to be considered complete. 
 */

package sdossey.algorithms.exercises;

import java.util.AbstractList;
import java.util.List;
//It is okay to add imports if necessary.

public class MakeArrayList<E> extends AbstractList<E> {
	
	//You shouldn't need to add any additional fields.
	int size; //Use this to track the number of items in the list.
	Object[] storage; //use this as the backing array.
	//We unfortunately have to use an array of 
    //objects because of limitations in Java's 
    //Generic system...
    //https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createArrays
	
	//This means we have to cast objects we get out of storage back to (E) type.
	// IE:  E value = (E)storage[5];
	//
	//Normally we avoid casts in Java at all costs, but in order to build
	//and ArrayList this is one rare case where it is unavoidable.

	
	//Constructor should not be modified.
    public MakeArrayList()    
    {
    	size=0;
    	storage=new Object[2]; //we'll start with an array of size 2.
    	//storage.length will always be bigger or the same size as size....
    	//as it should typically have unfilled space after size.
    }

    //This is used by the test case and shouldn't be modified;
    public static <E> List<E> factory(E type)
    {
        return new MakeArrayList<E>();
    }
    
    //Uncomment the following line only if you get a warning about an 
    //unchecked cast......feel free to add it to other methods that need it.
    //
	//@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		/* Complete Me! */
		/* Specification: */
		/* https://docs.oracle.com/javase/8/docs/api/java/util/List.html#get-int- */
		/* This will just return an item out of storage in 
		 * most cases, but you must throw the IndexOutOfBoundsException if a bad
		 * index is passed in.
		 * 
		 * You will have to cast the Object you grab from storage into an E.
		 */
		return null;
	}
    
	@Override
	public E set(int index, E value) {		
		/* Complete Me! */
		/* Specification: */
		/* https://docs.oracle.com/javase/8/docs/api/java/util/List.html#set-int-E- */
		/* This simply replaces an item in storage at index with value */
		/* YOu need to check and throw IndexOutOfBoundsException in case
		 * of a bad index just like with get.
		 */
		/* Be sure to return the old value previously at the index at the end of
		 * this method
		 */
		return null;
	}
	
	/* This is so trivial I'm giving it to you. 
	 * No code modification is allowed to this method, but make
	 * sure you update the size field when you add and remove
	 * items.
	 */
    @Override
    public int size() {        
        return size;
    }
    
    
    
    @Override
    public void add(int index, E element) {
    	/* Complete Me! */
    	/* Specification: */
    	/* https://docs.oracle.com/javase/8/docs/api/java/util/List.html#add-int-E- */
    	
    	/* This inserts item E into the list before index */
    	/* You will proceed as follows:
    	 *
    	 * 1. Check if the index is in range. NOTE that it the legal range is slightly
    	 *    different than for get() and set() because it is legal specify the 
    	 *    slot one past the end of the list in order to insert at the end of list.
    	 *    Throw an IndexOutOfBoundsException if the index is out of range.
    	 *    
    	 * 2. Ensure you have room in storage for the new element by comparing
    	 *    size and storage.length.  If you don't have enough space.....
    	 *    
    	 *       a) Allocate a new array of Objects that is twice the size of 
    	 *          storage.length.
    	 *       b) copy items 0-size into the new array of Objects.
    	 *       c) set storage = newStorage; 
    	 *    These steps will double the space available. We could choose 
    	 *    to not waste space like this, but we'd end up copying so much
    	 *    we'd harm the efficiency of the implementation.
    	 * 
    	 * 3. Shift all items located at or past index right 1 spot in the array.
    	 *    When you shift an item right, you need to not overwrite the 
    	 *    next item before it is shifted right, so you will have to
    	 *    proceed back to front for the shift.
    	 *     
    	 * 4. set the item at index to element.
    	 * 
    	 * Make sure you update size by 1 at some point.
    	 */
    }
 
    @Override
    public E remove(int index) {
    	/* Complete Me! */
    	/* Specification: */
    	/* https://docs.oracle.com/javase/8/docs/api/java/util/List.html#remove-int- */
    	
    	/* This removes item E in the list at index */
    	/* You will proceed as follows:
    	 *
    	 * 1. Check if the index is in range. Throw an
    	 *    IndexOutOfBoundsException if the index is out of range.
    	 * 
    	 * 2. Grab and store the old item at index.
    	 * 
    	 * 3. Shift all items past index left 1 spot in the array, replacing
    	 *    the item at index.
    	 *    
    	 * 4. Return the stored old item at index.
    	 * 
    	 * Make sure you update size by -1 at some point.
    	 * 
    	 * BONUS--as implemented this can be very wasteful because as the ArrayList
    	 *   shrinks we never shrink storage.  Add code that if 
    	 *   the storage.length becomes 4x "size" to reallocate and copy
    	 *   storage to a new storage half as big. 
    	 */
    	return null;
    }
}
