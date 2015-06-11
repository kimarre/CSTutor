package CSTutor.Model.Progress;

import java.util.ArrayList;

import CSTutor.Model.Manager.*;

/****
 * Class FullStudentTutorial provides a class that holds an instance of Tutorial from
 * the Manager package and keeps a list of TrackedPage's so that proper analysis
 * of a student's progress can be conducted.
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class FullStudentTutorial
{
    /** Tutorial data from the Manager feature */
    CSTutor.Model.Manager.Tutorial manTutorial;
    /** List of individual pages in the tutorial */
    ArrayList<TrackedPage> pages;
    /** Results of the optional quiz associated with this tutorial*/
    ArrayList<QuizData> quizzes;
    /** Number of quizzes in this tutorial */
    int numQuizzes;
    /** Variable for if the tutorial has at least one quiz */
    boolean hasQuiz;
    
    public FullStudentTutorial(CSTutor.Model.Manager.Tutorial tutorial)
    {
        manTutorial = tutorial;
        pages = new ArrayList<TrackedPage>();
        quizzes = new ArrayList<QuizData>();
        hasQuiz = false;
        numQuizzes = 0;
        generatePageData();  
    }
    
    /**
     * Generates page data to populate the tutorials until the database is
     * complete. Also randomly determines if this tutorial has quizzes.
     */
    private void generatePageData()
    {
        int randomNum = (int) (Math.random() * 5) + 1;
        for(int i=1; i< 6; i++)
        {
            Page tempPage = new Page(new String("Page " + i), manTutorial);
            boolean seen;
            
            if(i <= randomNum)
            {
                seen = true;
            }
            else
            {
                seen = false;
            }
            TrackedPage newTracked = new TrackedPage(tempPage, seen);
            pages.add(newTracked);
        }
        
        int quizDecider = (int) (Math.random() * 2);
        if(quizDecider != 0)
        {
            hasQuiz = true;
            numQuizzes = (int) (Math.random() * 5) + 1;
            
            for(int i=0; i < numQuizzes; i++)
            {
                QuizData tempQuiz = new QuizData(new String("Quiz " + (i+1)), i, (int) (Math.random() * 5) + 1);
                quizzes.add(tempQuiz);
            }
        }
    }
    
    /**
     * Returns the number of tracked pages in this tutorial.
     */
    public int getNumberOfPages()
    {
        return pages.size();
    }
    
    /**
     * Tabulates and returns the number of pages that have been seen by the user.
     */
    public int getNumberOfPagesSeen()
    {
        int tempInt = 0;
        for(TrackedPage tempPage: pages)
        {
            if(tempPage.beenSeen())
            {
                tempInt++;
            }
        }
        return tempInt;
    }
    
    /**
     * Returns the name of the tutorial.
     */
    public String getTutorialName()
    {
        return manTutorial.name;
    }
    
    /**
     * Returns the number of quizzes in the tutorial track.
     */
    public int getNumberOfQuizzes()
    {
        return numQuizzes;
    }
    
    /**
     * Returns if the tutorial has any quizzes associated with it or not.
     */
    public boolean hasQuizzes()
    {
        return hasQuiz;
    }
    
    /**
     * Returns the number of questions answered correctly for the quiz
     * with the given ID number.
     * @param quizID  quiz ID number
     */
    public int getScoreForQuiz(int quizID)
    {
        if(quizID < numQuizzes)
        {
            return quizzes.get(quizID).getScore();
        }
        else
        {
            System.out.println("Quiz ID is not a valid ID number");
            return -1;
        }
        
    }
    
    /**
     * Returns the number of questions in the quiz with the given ID.
     */
    public int getNumQuestionsInQuiz(int quizID)
    {
        if(quizID < numQuizzes)
        {
            return quizzes.get(quizID).getNumQuestions();
        }
        else
        {
            System.out.println("Quiz ID is not a valid ID number");
            return -1;
        }
    }
    
    /**
     * Returns the name of the quiz with the given ID.
     */
    public String getQuizName(int quizID)
    {
        if(quizID < numQuizzes)
        {
            return quizzes.get(quizID).getDisplayName();
        }
        else
        {
            System.out.println("Quiz ID is not a valid ID number");
            return null;
        }
    }

}
