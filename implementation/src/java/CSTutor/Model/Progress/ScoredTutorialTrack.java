package CSTutor.Model.Progress;

import CSTutor.Model.Tutorial.*;
import java.util.*;

/****
 * Class ScoredTutorialTrack provides code for a tutorial that has a quiz associated with it.
 * It uses the TutorialData object for tutorial data storage and the QuizData object for
 * quiz data storage.
 * @author Erica Solum (esolum@calpoly.edu)
 */
public class ScoredTutorialTrack
{
    /** Number of quizzes in this group of tutorials */
    int numQuizzes;
    /** Data type that holds a stripped version of a Tutorial */
    TutorialData data;
    /** Results of the optional quiz associated with this group of tutorials */
    ArrayList<QuizData> quizzes;
    /** List of students users who have access to this tutorial */
    String[] students;
    /** Quiz scores of students sorted alphabetically*/
    private int[][] quizScores;
    /** Boolean representing if the tutorial track has attached quizzes */
    boolean hasQuiz;
    /** List of the average quiz scores sorted numerically by quiz ID */
    private int[] averageQuizScores;
    
    public ScoredTutorialTrack(TutorialData d)
    {
        data = d;
        numQuizzes = 0;
        quizzes = new ArrayList<QuizData>();
        hasQuiz = false;
        
        students = new String[] {"Maria Auxier", "Marian Bell", "Eugene Brown",
                "Jamie Bryant","Danielle Carter", "Vernon Chilton", "Mary Clark", 
                "Laurie Crawford", "Geoffrey Dunning", "Lester Flores", "Suzanne Gridley", 
                "Bruce Griffin", "Jennifer Headrick", "Kevin Hoover", "Constance Jackson",
                "Chris Kapp", "Leon Lewis", "Victor Massey", "Blanche Natal",
                "Dianne Ohara", "Charlotte Perry", "Eric Prince", "Frank Reed",
                "Nicole Rios", "David Rodriguez", "James Scott", "Robert Taylor",
                "Anna Turley", "James Welsh", "Marlene Williams"};
    }
    
    /**
     * Assigns the given quiz data to this collection of tutorials.
     * @param quiz   data results of a quiz
     */
    public void placeQuizInTrack(QuizData quiz)
    {
        quizzes.add(quiz);
        hasQuiz = true;
        numQuizzes++;
        
        int[][] quizScoresTemp = new int[students.length][numQuizzes];
        averageQuizScores = new int[numQuizzes];
        
        for(int row = 0; row < students.length; row++)
        {
            
            quizScoresTemp[row][numQuizzes-1] = (int) (Math.random()*100);
        }
        
        if(numQuizzes > 1) 
        {
            for(int row = 0; row < students.length; row++)
            {
                for(int col = 0; col < (numQuizzes-1); col++)
                {
                    quizScoresTemp[row][col] = quizScores[row][col];
                }
            }
        }
        quizScores = quizScoresTemp;
    }
    
    /**
     * Returns if the tutorial has any quizzes associated with it or not.
     */
    public boolean hasQuizzes()
    {
        return hasQuiz;
    }
    
    /**
     * Returns the number of quizzes linked to this tutorial Track.
     * @return numQuizzes  number of quizzes in this tutorial track
     */
    public int getNumQuizzes()
    {
        return numQuizzes;
    }
    
    /**
     * Returns the tutorial's full title.
     */
    public String getDisplayName()
    {
        return data.getTitle();
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
    public boolean equals(ScoredTutorialTrack tutorial)
    {
        if(tutorial.data.toString().equals(data.getTitle()))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Calculates the average quiz scores and returns them.
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
     * Returns the quiz scores of each student.
     * @return quizScores   array holding the scores
     */
    public int[][] getQuizScores()
    {
        return quizScores;
    }
    
    /**
     * Returns the displayable name of the track.
     */
    public String toString()
    {
        return data.getTitle();
    }
    
    /**
     * Method that returns the displayable names of the students given
     * access to this tutorial track.
     * @return students   array of student users' names
     */
    public String[] getStudents()
    {
        return students;
    }
    
    /**
     * Returns the name of the nth quiz in the track.
     * @param place
     * @return 
     */
    public String getQuizName(int place)
    {
        if(place < quizzes.size())
        {
            return quizzes.get(place).getDisplayName();
        }
        return null;
    }
    

}
