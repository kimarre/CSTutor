package Quiz;

import java.util.Collection;

/**
 * A studentQuiz is a sample quiz taken by the student. It has a set of pages  
 * of questions to be answered by the student. Once the student finishes the
 * set of questions, isSubmited become true indicating the student has finished
 * the quiz
 */
abstract class studentQuiz {
    //consist of a set of pages of questions
    Collection<Page> quizquestions;
    //checks to see whether the quiz has been submited
    boolean isSubmited;
}
/**
 * A page has a list of questions, the number of the questions, and the last 
 * page of questions will have hasSubmit to be true. This indicates that this
 * page has a submit button for people to turn in their quiz.
 */
abstract class Page{
   //consists of a set of questions
   Collection<Questions> question;
   //shows how many questions there are
   int amtQuestions;
   //a value that indicates whether the page has a submit button or not
   boolean hasSubmit;
     
}

/**
 * A Question consist of a description of a question, number of question, and
 * a choice for the question.
 */
abstract class Questions{
   // Indicate what number the question is
   int questionNum;
   // Gives a description of what the questions request for
   Description question;
   // multiple choices for the question
   char answer[4];
}
/**
 * The description is meant for student to see what each question is about.
 */
abstract class Description
{
   String intro;
   String syntax;
}
/**
 * EditQuestion is a way for teachers to edit questions, with specific font and
 * size.
 */
abstract class EditQuestion{
   //The font for the question
   String fontStyle;
   //The font size for the question
   int fontSize;
   //What kind of question to be edited
   String question;
}
/**
 * This advicepage allows teachers to give feedback on tutorial pages to review
 * as well as the questions that got wrong.
 */
abstract class AdvicePage
{
   //Advice to give
   String advice;
   //Refers to the page student need to review on
   Page pageToReview;
}
