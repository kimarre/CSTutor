package Quiz;

/**
 * A Question consist of a description of a question, number of question, and
 * a choice for the question.
 */
public abstract class Questions{
   // Indicate what number the question is
   int questionNum;
   /*
      post:
        //There exist at least one character for the question asked
        exists (Description question; question.length() > 0);
     */
   abstract void createDescription();
    
   // Gives a description of what the questions request for
   Description question;
   // multiple choices for the question
   char[] answer;
}
