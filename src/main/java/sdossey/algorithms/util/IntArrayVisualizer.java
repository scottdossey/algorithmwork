package sdossey.algorithms.util;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.awt.Shape;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class IntArrayVisualizer extends JComponent implements Runnable, InstrumentedList.Listener {

    private static final long serialVersionUID = 5418640460332639983L;

    public static final Color DEFAULT_COLOR = Color.GRAY;
    public static final Color COMPARE_COLOR = Color.ORANGE;
    public static final Color EXCHANGE_COLOR = Color.RED;

    public static final double COMPARE_DELAY = .1;
    public static final double BAR_TO_GAP_RATIO = .666666;

    private long delayMillis;
    private InstrumentedList<Integer> numberList;
    private ArrayList<Color> colorList;

    public IntArrayVisualizer(Iterable<Integer> numberArray) {
        this(numberArray, .5);
    }

    public IntArrayVisualizer(Iterable<Integer> numberArray, double delay) {
        super();

        this.numberList = new InstrumentedList<Integer>(numberArray);
        this.colorList = new ArrayList<Color>();
        for (int i = 0; i < this.numberList.size(); ++i) {
            this.colorList.add(DEFAULT_COLOR);
        }

        this.delayMillis = (long) (delay * 1000);

        this.numberList.addListener(this);
        
    }

    public InstrumentedList<Integer> getInstrumentedList() {
        return numberList;
    }

    public void compareNotify(int a, int b) {
        Color aColor = colorList.set(a, COMPARE_COLOR);
        Color bColor = colorList.set(b, COMPARE_COLOR);

        this.forceUpdate();
        delay(delayMillis);

        colorList.set(a, aColor);
        colorList.set(b, bColor);
        this.forceUpdate();
    }

    public void run() {
        this.repaint();
    }

    public void forceUpdate() {
        try {
            SwingUtilities.invokeAndWait(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // Do nothing.
        }

    }

    public void exchangeNotify(int a, int b) {
        Color aColor = colorList.set(a, EXCHANGE_COLOR);
        Color bColor = colorList.set(b, EXCHANGE_COLOR);

        this.forceUpdate();
        delay(delayMillis);

        colorList.set(a, aColor);
        colorList.set(b, bColor);
        this.forceUpdate();
    }

    public void changeNotify(int index) {        
        this.forceUpdate();
    }

    public void addNotify(int index) {
        colorList.add(index, DEFAULT_COLOR);        
        this.forceUpdate();
    }

    public void removeNotify(int index) {
        colorList.remove(index);        
        this.forceUpdate();
    }

    private double getHorizontalBarWidth(Rectangle r) {        
        double width = r.getWidth();

        return (width - getMargin() * 2) / this.numberList.size();

    }

    private double getMax() {
        double maximum = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < numberList.size(); ++i) {
            if (numberList.get(i) > maximum) {
                maximum = this.numberList.get(i);
            }
        }
        return maximum;
    }

    private double getVerticalScaleFactor(Rectangle r) {
        double max = getMax();        
        double height = r.getHeight();
        return (height - getMargin() * 2) / max;
    }

    public double getMargin() {
        return 10.0;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        super.paintComponent(g);

        Rectangle r = this.getBounds();
        double horizontalBarWidth = getHorizontalBarWidth(r);
        double verticalScaleFactor = getVerticalScaleFactor(r); 

        double baseLineY = r.getHeight() - getMargin();
        double x = getMargin();

        double actualBarWidth = horizontalBarWidth * BAR_TO_GAP_RATIO;
        double halfGap = (horizontalBarWidth - actualBarWidth) / 2.0;        
        for (int i = 0; i < numberList.size(); ++i) {
            double height = (double)(numberList.get(i)*verticalScaleFactor);
            Shape shape = new Rectangle2D.Double(x + halfGap, baseLineY-height, actualBarWidth, height);
            g2d.setColor(colorList.get(i));
            g2d.fill(shape);
            g2d.setColor(Color.BLACK);
            g2d.draw(shape);
            x += horizontalBarWidth;
        }
    }    
}
