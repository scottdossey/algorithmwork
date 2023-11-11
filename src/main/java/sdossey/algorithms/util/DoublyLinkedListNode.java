package sdossey.algorithms.util;

public class DoublyLinkedListNode<E>
{
    private E value;
    private DoublyLinkedListNode<E> next;
    private DoublyLinkedListNode<E> previous;  

    public DoublyLinkedListNode(DoublyLinkedListNode<E> previous,
                               DoublyLinkedListNode<E> next, 
                               E value)
    {        
        this.previous=previous;
        this.next=next;
        this.value=value;
    }  

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public DoublyLinkedListNode<E> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<E> next) {
        this.next = next;
    }

    public DoublyLinkedListNode<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListNode<E> previous) {
        this.previous = previous;
    }
}
