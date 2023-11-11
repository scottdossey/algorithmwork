package sdossey.algorithms.exercises;

import sdossey.algorithms.util.AbstractSinglyLinkedList;
import sdossey.algorithms.util.SinglyLinkedListNode;

public class MakeLinkedListA<E> extends AbstractSinglyLinkedList<E>
{
    //Define a linked list
    //This linked list is gonna be of the form.
    // head -> [] -> [] -> []-> [] -> null
    SinglyLinkedListNode<E> head;    

    //Private constructor, we use factory method below to build.
    //This is for esoteric reasons having to do with how we are
    //testing stuff, we want to be able to build new ones easily.
    private MakeLinkedListA()
    {
        head = null;        
    }

    public static <E> AbstractSinglyLinkedList<E> factory(E type)
    {
        return new MakeLinkedListA<E>();
    }
   
    public class Cursor extends AbstractSinglyLinkedList<E>.Cursor
    {        
        //Storing the current location of the list is
        //tricky. In order to do certain operations we
        //need the previous node, so best to store the current
        //location as a previous node. If the current location
        //is the head of the list, that can be signalled by
        //setting previous = null.
        SinglyLinkedListNode<E> previous;        

        Cursor()
        {            
            //set the cursor to the very beginng of list (head).            
            previous = null;
        }

        //This is a helper function you should write
        //to the current node (like for a set or get)
        //given the value of previous. In most cases
        //this will be previous.next, but you have to handle
        //the case where previous == null, which means
        //we are before the head of list.
        @SuppressWarnings("unused") //Tjos just prevents a compiler error.
        private SinglyLinkedListNode<E> getCurrent()
        {      
            //COMPLETE ME!
            return null;
        }

        @Override
        public void advance() 
        {
            //COMPLETE ME!
        }

        @Override
        public E get() 
        {
            //COMPLETE ME!
            return null;      
        }

        @Override
        public E set(E value) 
        {
            //COMPLETE ME!
            return null;
        }

        @Override
        public void add(E newValue) 
        {
            //COMPLETE ME!    
        }

        @Override
        public E remove() 
        {
            //COMPLETE ME!
            return null;            
        }

        @Override
        public boolean hasNext() 
        {
            //COMPLETE ME!
            return false;    
        }
    }

    @Override
    public AbstractSinglyLinkedList<E>.Cursor getCursor() 
    {        
        return new Cursor();
    }    
}
