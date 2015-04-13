package Quiz;

import java.util.Collection;

/**
 * A page has a list of questions, the number of the questions, and the last 
 * page of questions will have hasSubmit to be true. This indicates that this
 * page has a submit button for people to turn in their quiz.
 */
public abstract class Page{
   
   /*
      pre:
        //There has to be at least more than one page for the Quiz 
        exists(Collection<Page> numPages; numPages.size() > 0)

            &&

        //There is at least one question per page of the quiz
        exists(int i; i>=0 && i < numPages.size();
              numPages.get(i).question.size() > 0);
    */
   abstract void addSubmitButton();
   //add new question to the page
   abstract void addQuestion();
   //consists of a set of questions
   Collection<Questions> question;
   //shows how many questions there are
   int amtQuestions;
   //a value that indicates whether the page has a submit button or not
   boolean hasSubmit;
     
}
