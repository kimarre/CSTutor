package Manager;
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
public abstract class Class {
   private List<Unit> units;
   private List<Section> sections;
   private List<User> students;
   private ClassAccessLevel access;
   /**
    * AddSection adds a given section to the class, if the section contains
    * students from the class.
    */
   abstract void addSection(Section section);

   /**
    * RemoveSection removes the given section from the class. RemoveSection
    * also removes all the students in that section from the class.
    */
   abstract void removeSection(Section section);

   /**
    * RemoteTutorial removes the specified tutorial from the collection of
    * tutorials without a unit.
    */
   abstract void removeTutorial(Tutorial tutorial);

   /**
    * AddTutorial adds the specified tutorial to the collection of tutorials
    * without a unit.
    */
   abstract void addTutorial(Tutorial tutorial);

   /**
    * RemoveStudent removes the specified student from the class and any
    * sections they are in.
    */
   abstract void removeStudent(User student);

   /**
    * AddStudent adds the student to the class. THey are not a part of
    * any section, intitially.
    */
   abstract void addStudent(User student);

   /**
    * ChangeAccessLevel changes the class' access level to the new specified
    * level.
    */
   abstract void changeAccessLevel(ClassAccessLevel newAccess);

   /**
    * MoveTutorialUp moves the tutorial up one space in the list.
    */ 
   abstract void moveTutorialUp(Tutorial tutorial);

   /**
    * MoveTutorialDown moves the tutorial down one space in the list.
    */ 
   abstract void moveTutorialDown(Tutorial tutorial);

   /**
    * MoveUnitUp moves the unit up one space in the list.
    */ 
   abstract void moveUnitUp(Unit unit);

   /**
    * MoveUnitDown moves the unit down one space in the list.
    */ 
   abstract void moveUnitDown(Unit unit);

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
