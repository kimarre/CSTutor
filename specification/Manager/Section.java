package Manager;
import java.util.Collection;

/**
 * Represents a section of a class. Each section contains some students from
 * the class. Each section also has a professor. Like classes, they may have
 * their own units and tutorials, but also have access to the overall class'
 * units and tutorials.
 *
 * Derived from section 2.2.
 */
public abstract class Section {
   private Collection<User> students;
   private Collection<Unit> units;
   private User professor;
   private Class parent;
    /** 
    * AddStudent adds the specified student to the section
    */
   abstract void addStudent(User student);

   /**
    * RemoveStudent removes the specified student from the section if
    * the student is in the section.
    */
   abstract void removeStudent(User student);

   /**
    * ChangeProfessor changes the professor of the section
    */
   abstract void changeProfessor(User professor);
}
