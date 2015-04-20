package CSTutor.Model.Manager;
import java.util.*;

/**
 * The Class object represents a class. This contains methods to add or
 * remove sections, units, and students. It also contains methods to rearrange
 * units, and to change the access level.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
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
   public void addSection(Section section){
	   sections.add(section);
   }

   /**
    * RemoveSection removes the given section from the class. RemoveSection
    * also removes all the students in that section from the class.
    */
   public void removeSection(Section section){
	   sections.remove(section);
   }

   /**
    * RemoteTutorial removes the specified tutorial from the collection of
    * tutorials without a unit.
    */
   public void removeUnit(Unit unit){
	   units.remove(unit);
   }

   /**
    * AddTutorial adds the specified tutorial to the collection of tutorials
    * without a unit.
    */
   public void addUnit(Unit unit){
	   units.add(unit);
   }

   /**
    * RemoveStudent removes the specified student from the class and any
    * sections they are in.
    */
   public void removeStudent(User student){
	   students.remove(student);
   	System.out.println("In CSTutor.Model.Class.removeStudent()");
   }

   /**
    * AddStudent adds the student to the class. THey are not a part of
    * any section, initially.
    */
   public void addStudent(User student){
	   students.add(student);
   	System.out.println("In CSTutor.Model.Class.addStudent()");
   }

   /**
    * ChangeAccessLevel changes the class' access level to the new specified
    * level.
    */
   public void changeAccessLevel(ClassAccessLevel newAccess){
	   access = newAccess;
   	System.out.println("In CSTutor.Model.Class.changeAccessLevel()");
   }

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
