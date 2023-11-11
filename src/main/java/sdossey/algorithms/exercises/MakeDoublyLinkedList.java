/* 
 * Copy this to src/main/java/jmasters/exercises and modify it so that you
 * implement a doubly linked list class that implements the full 
 * java.util.List interface.
 * 
 * This class will make use of java.util.AbstractSequentialList:
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/util/AbstractSequentialList.html
 * 
 * AbstractSequentialList does a lot of the work for you implementing the 
 * various methods of java.util.List. However, you still have to implement
 * a ListIterator (which we call Cursor and use an inner class)
 * and a size() method. We've already implemented the size method,
 * but you'll have to update the internally tracked size with each
 * operation.
 * 
 * To see the interface you need to implement for Cursor, look 
 * up the Javadoc for java.util.ListIterator. Complete the 
 * "Complete Me!" parts of the code.
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/util/ListIterator.html
 * 
 * There is JUnit test code in:
 *  src/main/test/java/jmasters/TestMakeDoublyLinkedList.java
 */
package sdossey.algorithms.exercises;

import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
//It is okay to add imports if necessary.

import sdossey.algorithms.util.DoublyLinkedListNode;

public class MakeDoublyLinkedList<E> extends AbstractSequentialList<E>
{
    DoublyLinkedListNode<E> head;
    DoublyLinkedListNode<E> tail;
    int size;

    public class Cursor<T> implements ListIterator<E>
    {
        int listIndex;
        DoublyLinkedListNode<E> previous;
        DoublyLinkedListNode<E> lastReturnedNode;

        Cursor()
        {
            listIndex = 0;
            previous = head;
            lastReturnedNode = null;
        }

        @Override
        public void add(E value) 
        {
            // COMPLETE ME!
        }

        @Override
        public boolean hasNext() 
        {
            // COMPLETE ME!
            return false;
        }

        @Override
        public boolean hasPrevious() 
        {
            // COMPLETE ME!
            return false;
        }

        @Override
        public E next() 
        {
            // COMPLETE ME!
            return null;
        }

        @Override
        public int nextIndex() 
        {
            // COMPLETE ME!
            return 0;
        }

        @Override
        public E previous() 
        {
            // COMPLETE ME!
            return null;
        }

        @Override
        public int previousIndex() 
        {
            // COMPLETE ME!
            return 0;
        }

        @Override
        public void remove() 
        {
            // COMPLETE ME!        
        }

        @Override
        public void set(E value) 
        {
            // COMPLETE ME!
        }
    }

    public MakeDoublyLinkedList()
    {
        //Head and tail are both sentinel values.
        head = new DoublyLinkedListNode<E>(null, null, null);
        tail = new DoublyLinkedListNode<E>(null, head, null);        
        head.setNext(tail);
        size = 0;
    }

    public static <E> List<E> factory(E type)
    {
        return new MakeDoublyLinkedList<E>();
    }

    @Override
    public ListIterator<E> listIterator(int offset) 
    {
        Cursor<E> cursor  = new Cursor<>();

        /* Note that is legal for the ListIterator to point just
         * past the last element, thus > comparison rather than
         * >= comparison.
         */
        if((offset < 0) || (offset > this.size()))
        {
            throw new IndexOutOfBoundsException();
        }
        if(offset > this.size())
        {
            throw new IndexOutOfBoundsException();
        }
        for(int i=0; i<offset; ++i)
        {
            cursor.next();
        }        
        return cursor;
    }

    @Override
    public int size() {        
        return size;
    }
    
}
