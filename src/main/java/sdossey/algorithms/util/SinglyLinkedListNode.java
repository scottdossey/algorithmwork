package sdossey.algorithms.util;

public class SinglyLinkedListNode<E> 
{
    public SinglyLinkedListNode(E value, SinglyLinkedListNode<E> next)
    {
        this.value = value;
        this.next = next;
    }

    //Not gonna use getters and setters deliberately, access directly.
    public E value;
    public SinglyLinkedListNode<E> next;    
}
