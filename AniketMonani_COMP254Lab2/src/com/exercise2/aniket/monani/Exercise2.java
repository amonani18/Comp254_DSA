package com.exercise2.aniket.monani;

import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.LogarithmicAxis;
import javax.swing.*;

/*
 * Experimental Analysis of Algorithms
 *
 *Developed by Aniket Monani
 *
 *
 *Student ID: 301422485
 * This program performs an experimental analysis of two algorithms, prefixAverage1 and prefixAverage2,
 * for computing prefix averages of an array. The running times of both algorithms are measured and
 * visualized using a log-log chart.
 *
 * The implementation uses the JFreeChart library for creating the charts.
 * The performance is measured with varying input sizes and plotted to compare their complexities.
 */

/**
 * Class to compute prefix averages using two different algorithms and visualize their performance.
 */
public class Exercise2 {

    /**
     * Computes prefix averages using the first algorithm.
     * The time complexity is O(n^2).
     *
     * @param x the input array
     * @return the array of prefix averages
     */
	public static double[] prefixAverage1(double[] x) {
	    int n = x.length;
	    double[] a = new double[n];    // filled with zeros by default
	    for (int j=0; j < n; j++) {
	      double total = 0;            // begin computing x[0] + ... + x[j]
	      for (int i=0; i <= j; i++)
	        total += x[i];
	      a[j] = total / (j+1);        // record the average
	    }
	    return a;
	  }

    /**
     * Computes prefix averages using the second algorithm.
     * The time complexity is O(n).
     *
     * @param x the input array
     * @return the array of prefix averages
     */
	public static double[] prefixAverage2(double[] x) {
	    int n = x.length;
	    double[] a = new double[n];    // filled with zeros by default
	    double total = 0;              // compute prefix sum as x[0] + x[1] + ...
	    for (int j=0; j < n; j++) {
	      total += x[j];               // update prefix sum to include x[j]
	      a[j] = total / (j+1);        // compute average based on current sum
	    }
	    return a;
	  }

    /**
     * Generates an array of random doubles.
     *
     * @param size the size of the array
     * @return the array of random doubles
     */
	public static double[] generateRandomArray(int size) {
        Random rand = new Random();
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextDouble() * 1000; // random doubles between 0 and 1000
        }
        return array;
    }
	 //Student Name: Aniket Monani
    //Student ID: 301422485
	public static void main(String[] args) {
   	 int trials = 5;
        int n = 1000;

        XYSeries series1 = new XYSeries("prefixAverage1");
        XYSeries series2 = new XYSeries("prefixAverage2");

        int start = n;
        for (int t = 0; t < trials; t++) {
            double[] array = generateRandomArray(n);
            long startTime = System.currentTimeMillis();
            prefixAverage1(array);
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            series1.add(n, elapsed);
            n *= 2;
        }

        n = start;
        for (int t = 0; t < trials; t++) {
            double[] array = generateRandomArray(n);
            long startTime = System.currentTimeMillis();
            prefixAverage2(array);
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            series2.add(n, elapsed);
            n *= 2;
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        // Print data points for verification
        for (int i = 0; i < dataset.getSeriesCount(); i++) {
            XYSeries series = dataset.getSeries(i);
            System.out.println("Series: " + series.getKey());  // Print the name of the series
            for (int j = 0; j < series.getItemCount(); j++) {
                double x = series.getX(j).doubleValue(); // Get the X value of the data point
                double y = series.getY(j).doubleValue(); // Get the Y value of the data point
                System.out.println("Data point " + (j + 1) + ": X = " + x + ", Y = " + y);
            }
        }

        // Create the chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Prefix Averages Comparison",
                "Log(Input Size)",
                "Log(Time)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Customize the chart to use a logarithmic axis
        JFrame frame = new JFrame("Prefix Averages Comparison");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        ChartPanel chartPanel = new ChartPanel(chart);
        frame.getContentPane().add(chartPanel);
        frame.setVisible(true);
    }
}
