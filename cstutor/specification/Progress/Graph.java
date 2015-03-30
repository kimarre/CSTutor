package Progress;

/**
 * This abstract class provides default implementations for most of the methods used for the graphs 
 * of students' progress and scores.
 * It takes care of creating, editing, and displaying any type of graph needed.  
 */
public abstract class Graph {
     
     String xAxisTitle;
     String yAxisTitle;

     /**
      * Sets the title of the x-axis that will be displayed on the graph.
      * @param title    represents the title of the axis 
      */
     public abstract void setXAxis(String title);

     /**
      * Sets the title of the y-axis that will be displayed on the graph.
      * @param title    represents the title of the axis
      */
     public abstract void setYAxis(String title);
	
}
