package CSTutor.Model.Progress;


/****
 * Class TutorialData is a data structure that represents a tutorial listed
 * under a class. Class TutorialData provides methods to get the name of
 * the tutorial.
 * @author Erica Solum (esolum@calpoly.edu)
 */
public class TutorialData
{
    private String name;
    private boolean complete;
    private String[] students;
    private int[] averageQuizScores;
    private int[][] quizScores;
    private int numQuizzes;
    
    public TutorialData(String name)
    {
        this.name = name;
        complete = false;
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
    public boolean equals(TutorialData tutorial)
    {
        if(tutorial.toString().equals(name))
        {
            return true;
        }
        return false;
    }
    
    
    public void setStudents(String[] students)
    {
        this.students = students;
    }
    
    public String[] getStudents()
    {
        return students;
    }
    
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
    
    public int[][] getQuizScores()
    {
        return quizScores;
    }

}