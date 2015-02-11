package learners.other;

import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Graphs extends ApplicationFrame {

    
    public Graphs(final String title,ArrayList<Object> o,int val) {

        super("Accuracy Meter");
    ArrayList<Object> obj;
    obj = o;
        
//        ArrayList<Double> alist = new ArrayList<>();
//        alist.add(1.0);
//        alist.add(5.0);
//        obj.add(alist);
//        
//         ArrayList<Double> blist = new ArrayList<>();
//        blist.add(1.3);
//        blist.add(9.0);
//        obj.add(blist);

//        ArrayList<Double> clist = new ArrayList<>();
//        clist.add(0,1.3);
//        clist.add(1,8.0);
//        obj.add(clist);
//        
//         ArrayList<Double> dlist = new ArrayList<>();
//        dlist.add(0,9.3);
//        dlist.add(1,2.0);
//        obj.add(dlist);
            
        final CategoryDataset dataset1 = createDataset1(obj);
        final JFreeChart chart = ChartFactory.createBarChart(
            "Accuracy Graph",        // chart title
            "Methods",               // domain axis label
            "Records",                  // range axis label
            dataset1,                 // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips?
            false                     // URL generator?  Not required...
        );

        chart.setBackgroundPaint(Color.white);
        
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(0xEE, 0xEE, 0xFF));
        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

        NumberAxis a = (NumberAxis) plot.getRangeAxis();
        a.setRange(0, val);
        //plot.setRangeAxis(WIDTH, null);
        
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
        
        
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private CategoryDataset createDataset1(ArrayList<Object> vals) {

      
        final String series1 = "Incorrectly Classified";
        final String series2 = "Correctly Classified";
        ArrayList<Double> a;
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        final String category2 = "Naive Bayes";
        final String category1 = "Neighborhood Rough Sets";
        final String category3 = "Fuzzy Sets";
//        final String category4 = "NRS&FS";
        
//        for(Object d : vals){
//            ArrayList<Double> a = (ArrayList<Double>) d;
//            a.get(0); // Negative
//            a.get(1); //Positive
//        }
        
        a  = (ArrayList<Double>)vals.get(0);   //Rough Sets
        dataset.addValue(a.get(0), series1, category1);
        dataset.addValue(a.get(1), series2, category1);
        
        a = (ArrayList<Double>)vals.get(1);                     //NRS
        dataset.addValue(a.get(0), series1, category2);
        dataset.addValue(a.get(1), series2, category2);
        
        a = (ArrayList<Double>)vals.get(2);                     //FS
        dataset.addValue(a.get(0), series1, category3);
        dataset.addValue(a.get(1), series2, category3);
        
//        a = (ArrayList<Double>)vals.get(3);                     //NRS&FS
//        dataset.addValue(a.get(0), series1, category4);
//        dataset.addValue(a.get(1), series2, category4);
        
        return dataset;

    }
 
    public static void main(final String[] args) {

        final Graphs demo = new Graphs("Accuracy Meter",null,0);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}