package Progress;

import java.util.Collection;

/**
 * Bar chart that displays the quiz scores of the tutorials the
 * student has completed.
 */ 
public abstract class StudentGraph extends Graph{
    private Collection<Student> students;
    private Collection<Integer> scores;
    private Collection<Class> classes;
    
    /**
     * Adds a class category onto the chart so that multiple quiz scores
     * can be displayed for one class.
     * @param   classTitle   title to be displayed on the x-axis
     */
    public abstract void addClassCategory(String classTitle);
    
}
