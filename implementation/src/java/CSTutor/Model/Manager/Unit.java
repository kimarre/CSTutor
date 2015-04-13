package Manager;
import java.util.*;

/**
 * Derived from section 2.2
 *
 * A Unit is a collection of tutorials, making one cohesive section about
 * a range of subjects. It has a name.
 */
public abstract class Unit {
   private List<Tutorial> tutorials;
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
