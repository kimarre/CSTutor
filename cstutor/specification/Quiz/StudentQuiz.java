package Quiz;

import java.util.Collection;

/**
 * A studentQuiz is a sample quiz taken by the student. It has a set of pages  
 * of questions to be answered by the student. Once the student finishes the
 * set of questions, isSubmited become true indicating the student has finished
 * the quiz
 */
public abstract class StudentQuiz {

    /**
     *
     */
    abstract void turninQuiz();

    //students go to first page of tutorial only if the student got a score lower than 60 
    abstract void goToFirstPage();
    

    //students go the page to review some material if the score is between 60 and 80
    abstract void goToSpecifiedPage(int number);
    //consist of a set of pages of questions
    Collection<Page> quizquestions;
    //checks to see whether the quiz has been submited
    boolean isSubmited;
    int score;
}
