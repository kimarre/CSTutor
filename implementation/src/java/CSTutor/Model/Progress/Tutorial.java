package CSTutor.Model.Progress;


/****
 * Class Tutorial is a data structure that represents a tutorial listed
 * under a class. Class Tutorial provides methods to get the name of
 * the tutorial.
 * @author Erica Solum (esolum@calpoly.edu)
 */
public class Tutorial
{
    /** Name of the tutorial */
    private String name;
    /** List of the names of the students who have access */
    private String[] students;
    /** List of the average quiz scores listed numerically by quiz ID*/
    private int[] averageQuizScores;
    /** 2-D array containing a student's name and their quiz scores */
    private int[][] quizScores;
    /** Number of quizzes attached to this tutorial */
    private int numQuizzes;
    
    public Tutorial(String name)
    {
        this.name = name;
        numQuizzes = 5;
        
        students = new String[] {"Maria Auxier", "Marian Bell", "Eugene Brown",
                "Jamie Bryant","Danielle Carter", "Vernon Chilton", "Mary Clark", 
                "Laurie Crawford", "Geoffrey Dunning", "Lester Flores", "Suzanne Gridley", 
                "Bruce Griffin", "Jennifer Headrick", "Kevin Hoover", "Constance Jackson",
                "Chris Kapp", "Leon Lewis", "Victor Massey", "Blanche Natal",
                "Dianne Ohara", "Charlotte Perry", "Eric Prince", "Frank Reed",
                "Nicole Rios", "David Rodriguez", "James Scott", "Robert Taylor",
                "Anna Turley", "James Welsh", "Marlene Williams"};
        
        
        
        
        quizScores = new int[students.length][numQuizzes];
        averageQuizScores = new int[numQuizzes];
        
        for(int row = 0; row < students.length; row++)
        {
            for(int col = 0; col < numQuizzes; col++)
            {   
                quizScores[row][col] = (int) (Math.random()*100);  
            }
        }
    }
    
    /**
     * Returns a string representation of a tutorial, also know as the name of
     * the tutorial.
     *                                                  <pre>
     pre:
       // String name must not be null.
       name != null && !name.isEmpty();
     *
     */
    public String toString()
    {
        return name;
    }
    
    /**
     * Returns if the names of the tutorials are the same.
     *                                                  <pre>
     pre:
       // String name must not be null.
       name != null && !name.isEmpty();
       // TutorialData tutorial must not be null.
       tutorial != null;
     *
     */
    public boolean equals(Tutorial tutorial)
    {
        if(tutorial.toString().equals(name))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Sets the list of students to the given array.
     * @param students  array containing the names of students
     */
    public void setStudents(String[] students)
    {
        this.students = students;
    }
    
    /**
     * Returns the list of students who have access to the tutorial.
     * @return  students  list of students' names
     */
    public String[] getStudents()
    {
        return students;
    }
    
    /**
     * Calculates and returns an array containing the average quiz scores
     * sorted numerically by quiz ID. 
     */
    public int[] getAverageQuizScores()
    {
        for(int col = 0; col<numQuizzes; col++)
        {
            int total = 0;
            for(int row = 0; row < students.length; row++)
            {
                total += quizScores[row][col];
            }
            averageQuizScores[col] = total/students.length;
        }
        
        
        return averageQuizScores;
    }
    
    /**
     * Returns the 2-D array with the students names and their quiz scores.
     * @return quizScores
     */
    public int[][] getQuizScores()
    {
        return quizScores;
    }

}