package software.ulpgc.app.windows;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.arquitecture.model.Barchart;
import software.ulpgc.arquitecture.view.BarchartDisplay;

import javax.swing.*;
import java.awt.*;

public class JFreeBarchartDisplay extends JPanel implements BarchartDisplay {
    public JFreeBarchartDisplay(){
        setLayout(new BorderLayout());
    }

    @Override
    public void show(Barchart barchart) {
        removeAll();
        add(new ChartPanel(adapt(barchart)));
        revalidate();
    }

    private JFreeChart adapt(Barchart barchart) {
        return ChartFactory.createBarChart(
                barchart.title(),
                barchart.xAxis(),
                barchart.yAxis(),
                datasetOf(barchart)
        );
    }

    private CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for (String name : barchart.categories()) defaultCategoryDataset.addValue(barchart.get(name), "", name);
        return defaultCategoryDataset;
    }
}
