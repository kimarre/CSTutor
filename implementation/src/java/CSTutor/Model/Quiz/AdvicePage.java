package CSTutor.Model.Quiz;

/**
 * This advicepage allows teachers to give feedback on tutorial pages to review
 * as well as the questions that got wrong.
 */
public abstract class AdvicePage
{
   /*
     Post:

        //The page must contains at least one character in the page
        exists(AdvicePage page; page.advice.length() > 0 && !isEmpty(page) && pageToReview != NULL);
        
    */

   abstract void setAdvice();
   //Advice to give
   String advice;
   //Refers to the page student need to review on
   Page pageToReview;
}
