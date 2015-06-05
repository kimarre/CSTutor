package CSTutor.Model.Progress;

public class QuizData
{
    private String name;
    private int numQuestions;
    private int quizID;

    
    public QuizData(String quizName, int qID, int numQ)
    {
        this.name = quizName;
        numQuestions = numQ;
        quizID = qID;
        
        
    }
    
    public String getDisplayName()
    {
        return name;
    }
    
    public int getNumQuestions()
    {
        return numQuestions;
    }
    
    public void changeName(String newName)
    {
        name = newName;
    }
    
    
    
    
    

}
