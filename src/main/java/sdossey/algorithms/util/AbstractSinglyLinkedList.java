package sdossey.algorithms.util;

public abstract class AbstractSinglyLinkedList<E>
{
    public static <E> AbstractSinglyLinkedList<E> factory(E type)
    {
        throw new UnsupportedOperationException("Need to override factory method of AbstractSinglyLinkedList");
    }
    
    public abstract class Cursor 
    {
        //Advance at cursor location.
        //You can advance 1 past the last item in the list
        //so you can add items at the end. 
        //but if you advancing after that should throw
        //a NoSuchElementException        
        public abstract void advance();

        //Get value at cursor location. If cursor is 
        //past end of list this will throw 
        //NoSuchElementException
        public abstract E get();
 
        //Set value (overwrite) at cursor
        //location. Return value is value
        //before set. If cursor is past 
        //end of list this will throw 
        //NoSuchElementException
        public abstract E set(E value);

        //Combination of get and advance.
        public E next()
        {
            E returnValue = this.get();
            this.advance();            
            return returnValue;
        }

        //Add (insert new value) at cursor location. 
        //current value at cursor position becomes 
        //next element.
        //       
        //cursor will point to newly added element
        //after update
        public abstract void add(E newValue);
        
        //Remove at cursor location.
        //returns item removed.
        //throw NoSuchElementException
        //if nothing to remove.        
        public abstract E remove();

        //Test to see if cursor is at end of list.
        public abstract boolean hasNext();
    }

    //Returns a cursor to the 0th
    //element of list.
    abstract public Cursor getCursor();
    
    public Cursor getCursor(int index)
    {
        Cursor cursor = getCursor();
        for(int i=0; i<index; ++i)
        {
            cursor.advance();
        }
        return cursor;
    }
    
    public int size()
    {
        //Will count the size of the list by default.
        //Can optionally track size an override.
        Cursor cursor = getCursor();

        int count = 0;
        while(cursor.hasNext())
        {
            cursor.advance();
            count += 1;
        }        
        return count;
    }
}
