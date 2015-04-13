package CSTutor.Model.Tutorial.AuthorTutorial;

import CSTutor.Model.Tutorial.*;
import CSTutor.View.Tutorial.*;
import Tutorial.StudentTutorial.*;

/**
* An Author page is an individual topic page within a tutorial track. This is 
* the page that authors fill out their tutorial content on.
*/
public abstract class AuthorPage {
   Description description;
   CodeExample example;
   String tryItYourself;

   EditTextButtons toolbar;

   /*
      pre:                                                          <pre>
         //
         // The Description cannot be empty.
         //
         (description.intro.length() > 0) && (description.syntax.length() > 0);

      post:
         //
         // The edited page exists or has been added to the tutorial track.
         //
         authorPages'.contains(this);

   */
   abstract void save(StudentTutorial studentPages, AuthorTutorial authorPages);
   
   abstract void preview();

}
