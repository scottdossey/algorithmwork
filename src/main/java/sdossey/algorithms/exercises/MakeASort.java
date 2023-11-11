package sdossey.algorithms.exercises;

import javax.swing.JFrame;

import sdossey.algorithms.datasets.RandomData;
import sdossey.algorithms.util.InstrumentedList;
import sdossey.algorithms.util.IntArrayVisualizer;

public class MakeASort
{
    public static final void main(String[] args)
    {
        double delay = .1; //Second delay between visualization step.
        IntArrayVisualizer visualizer = 
            new IntArrayVisualizer(RandomData.randomIntList(1, 51, 30), delay);

        JFrame frame = new JFrame("Sorting Visualization App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(visualizer);        
        frame.setResizable(true);
        frame.setSize(800,600);
        frame.setVisible(true);

        sort(visualizer.getInstrumentedList());        
    }    

    static final void sort(InstrumentedList<Integer> list)
    {

        //We are only allowed to use the following methods:
        //
        //Integer list.get(index) -- returns what is at an index.
        //
        //int list.compare(indexA, indexB); 
        //     returns negative number is a<b, 0 if a.equals(b), and 
        //             positive number if a>b
        //
        //int list.exchange(indexA, indexB);
        //      exchange the element at indexA with the element at indexB        
    }
}
