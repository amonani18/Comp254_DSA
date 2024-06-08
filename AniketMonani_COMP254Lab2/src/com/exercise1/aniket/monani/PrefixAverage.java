package com.exercise2.hardik.rana;

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
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class PrefixAverage {

    
	  /** Returns an array a such that, for all j, a[j] equals 
	   * the average of x[0], ..., x[j]. 
	   * A[j] = (X[0] + X[1] + � + X[j])/(j+1)
	   * 
	   * ******************************************************/
	  // inner loop size will be 1, 2, 3, ..., n  (based on j=0,1,2,...,n-1)
	  // we know that 1+2+3+...+ n-1+n = n(n+1)/2
	  // so, the running time os O(n^2)
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

	  /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
	  // the running time is O(n)
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
	// Method to generate an array of random doubles
	    public static double[] generateRandomArray(int size) {
	        Random rand = new Random();
	        double[] array = new double[size];
	        for (int i = 0; i < size; i++) {
	            array[i] = rand.nextDouble() * 1000; // random doubles between 0 and 1000
	        }
	        return array;
	    }
	    
		//name - Hardik Rana
		//student id - 301379703
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

      // Iterate over each series in the dataset
         for (int i = 0; i < dataset.getSeriesCount(); i++) {
             XYSeries series = dataset.getSeries(i);
             System.out.println("Series: " + series.getKey()); // Print the name of the series
             
             // Iterate over each data point in the series
             for (int j = 0; j < series.getItemCount(); j++) {
                 double x = series.getX(j).doubleValue(); // Get the X value of the data point
                 double y = series.getY(j).doubleValue(); // Get the Y value of the data point
                 System.out.println("Data point " + (j + 1) + ": X = " + x + ", Y = " + y);
             }
         }
         
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

         JFrame frame = new JFrame("Prefix Averages Comparison");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800, 600);

         ChartPanel chartPanel = new ChartPanel(chart);
         frame.getContentPane().add(chartPanel);
         frame.setVisible(true);
    }
    
}
