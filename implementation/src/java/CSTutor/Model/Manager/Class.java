package CSTutor.Model.Manager;
import java.util.Collection;
import java.util.List;

/**
 * The Class object represents a class. It is derived from section 2.2.
 * 
 * The units are collections of Tutorials. The tutorials are Tutorials that
 * are not a part of any Unit. The sections are the different sections of
 * the class. The students are all the Users who are in the class, and 
 * access is which users can view the class.
 */
public class Class {
   private List<Unit> units;
   private List<Section> sections;
   private List<User> students;
   private ClassAccessLevel access;
   public Class() {
   	
   }
   /**
    * AddSection adds a given section to the class, if the section contains
    * students from the class.
    */
   public void addSection(Section section){}

   /**
    * RemoveSection removes the given section from the class. RemoveSection
    * also removes all the students in that section from the class.
    */
   public void removeSection(Section section){}

   /**
    * RemoteTutorial removes the specified tutorial from the collection of
    * tutorials without a unit.
    */
   public void removeTutorial(Tutorial tutorial){}

   /**
    * AddTutorial adds the specified tutorial to the collection of tutorials
    * without a unit.
    */
   public void addTutorial(Tutorial tutorial){}

   /**
    * RemoveStudent removes the specified student from the class and any
    * sections they are in.
    */
   public void removeStudent(User student){
   	System.out.println("In CSTutor.Model.Class.removeStudent()");
   }

   /**
    * AddStudent adds the student to the class. THey are not a part of
    * any section, intitially.
    */
   public void addStudent(User student){
   	System.out.println("In CSTutor.Model.Class.addStudent()");
   }

   /**
    * ChangeAccessLevel changes the class' access level to the new specified
    * level.
    */
   public void changeAccessLevel(ClassAccessLevel newAccess){
   	System.out.println("In CSTutor.Model.Class.changeAccessLevel()");
   }

   /**
    * MoveTutorialUp moves the tutorial up one space in the list.
    */ 
   public void moveTutorialUp(Tutorial tutorial){}

   /**
    * MoveTutorialDown moves the tutorial down one space in the list.
    */ 
   public void moveTutorialDown(Tutorial tutorial){}

   /**
    * MoveUnitUp moves the unit up one space in the list.
    */ 
   public void moveUnitUp(Unit unit){}

   /**
    * MoveUnitDown moves the unit down one space in the list.
    */ 
   public void moveUnitDown(Unit unit){}

   /** 
    * ClassAccessLevel represents the possible access levels a class can have.
    *
    * Guest is the lowest level. Anyone can see a class with Guest access level.
    * Next is Student. Enrolled students, TAs, and professors can see this class.
    * Assistant allows TA's and professors to view the class.
    * Professor is only viewable to the professor.
    */
   enum ClassAccessLevel {
      Guest, Student, Assistant, Professor
   }
}
