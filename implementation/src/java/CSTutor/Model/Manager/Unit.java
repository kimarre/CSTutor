package CSTutor.Model.Manager;
import java.util.*;

/**
 * Class Unit holds a collection of tutorial tracks.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public abstract class Unit {
	/* The tutorial tracks */
   private List<Tutorial> tutorials;
   /* The name of the unit*/
   private String name;

   /**
    * Rename changes the name of the unit.
    */ 
   abstract void rename(String newName);
   /**
    * AddTutorial adds the given tutorial to the unit.
    */ 
   abstract void addTutorial(Tutorial tutorial);
   /**
    * RemoveTutorial removes the tutorial from the unit, if it exists.
    */ 
   abstract void removeTutorial(Tutorial tutorial);
   /**
    * MoveTutorialUp moves the given tutorial up in the list
    */ 
   abstract void moveTutorialUp(Tutorial tutorial);
   /**
    * MoveTutorialDown moves the given tutorial down in the list
    */ 
   abstract void moveTutorialDown(Tutorial tutorial);
}
