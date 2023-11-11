package sdossey.algorithms.util;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class InstrumentedList<E extends Comparable<E>> extends AbstractList<E>
{
    interface Listener 
    {
        
        public void addNotify(int index);
        public void removeNotify(int index);
        public void changeNotify(int index);
        public void compareNotify(int aIndex, int bIndex);
        public void exchangeNotify(int aIndex, int bIndex);
    }

    ArrayList<E> myList;
    private List<Listener> listeners=
        new ArrayList<>();

    public void addListener(Listener toAdd)
    {
        listeners.add(toAdd);
    }

    public InstrumentedList()
    {
        myList = new ArrayList<E>();        
    }

    public InstrumentedList(Iterable<E> iterable)
    {        
        myList = new ArrayList<E>();
        
        for(E value:iterable)
        {
            myList.add(value);            
        }        
    }

    
    @Override
    public void add(int index, E element)
    {        
        myList.add(index, element);
        for(Listener listener : this.listeners)
        {
            listener.addNotify(index);
        }        
    }

    @Override
    public E remove(int index)
    {
        E value = myList.remove(index);
        for(Listener listener : this.listeners)
        {
            listener.removeNotify(index);
        }                
        return value;
    }


    @Override
    public E get(int index) 
    {
        return myList.get(index);
    }
    
    @Override
    public E set(int index, E value) 
    {
        E returnValue=myList.set(index, value);
        for(Listener listener : this.listeners)
        {
            listener.changeNotify(index);
        }                        
        return returnValue;
    }

    @Override
    public int size() 
    {
        return myList.size();
    }

    public int compare(int a, int b)
    {
        E aValue = myList.get(a);
        E bValue = myList.get(b);

        for(Listener listener : this.listeners)
        {
            listener.compareNotify(a, b);
        }                        
        return aValue.compareTo(bValue);
    }

    public void exchange(int a, int b)
    {
        
        E oldA = this.set(a, this.get(b));
        this.set(b, oldA);       
        for(Listener listener : this.listeners)
        {
            listener.exchangeNotify(a, b);
        }                                 
    }
}
