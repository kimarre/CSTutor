package CSTutor.Model.Progress;

/****
 * Class QuizData is a stripped data representation of what a full quiz class would look like.
 * It is a pseudo-implementation used to show where quizzes would be used if the Quiz feature
 * was fully implemented. 
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class QuizData
{
    /** Displayable name of the quiz */
    private String name;
    /* Total number of questions in this quiz */
    private int numQuestions;
    /* Unique ID number of the quiz */ 
    private int quizID;
    /* Number of questions user answered correctly */
    private int score;

    
    public QuizData(String quizName, int qID, int numQ)
    {
        this.name = quizName;
        numQuestions = numQ;
        quizID = qID;
        score = -1;
        
    }
    
    /**
     * Returns the display name of the quiz.
     * @return name
     */
    public String getDisplayName()
    {
        return name;
    }
    
    /**
     * Returns the number of questions in the quiz.
     * @return numQuestions
     */
    public int getNumQuestions()
    {
        return numQuestions;
    }
    
    /**
     * Changes the display name of the quiz to the given String.
     * @param newName  new name for the quiz
     */
    public void changeName(String newName)
    {
        name = newName;
    }
    
    /**
     * Randomly generates a score (number of questions the user
     * answered correctly) for this quiz and returns that number.
     */
    public int getScore()
    {
        if(score == -1)
        {
            score = (int) (Math.random() * numQuestions) + 1;
        }
        return score;
    }
    
    
    

}
