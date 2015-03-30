package Progress;

import java.util.Collection;
/**
 * Bar chart that displays the average scores of all tutorials an instructor 
 * has created.
 */
public abstract class OverviewTutorialGraph extends Graph{
	private Collection<TutorialData> tutorials;
	private Collection<Class> classes;
	
   /**
     * Gets the average score of a tutorial.
     * @param   t  tutorial to analyze
     * @return     average score of all students who have completed
     *             that tutorial
     */
   public abstract int getAverageScore(TutorialData t);

   /**
     * Displays the score on the graph.
     * @param   score   score to display
     * @param   title  title to display on the x-axis of the chart
     */
   public abstract void displayScore(int score, String title);
}
