package CSTutor.Model.Manager;
import java.util.Collection;

/**
 * Class Section is a subsection of a class. It can have a specific professor, but otherwise
 * is similar to a class.
 * 
 * @author Simon Vurens
 */
public abstract class Section {
	/* The name of the section */
	private String name;
	/* The enrolled students in the section. A subset of students enrolled in the class*/
   private Collection<User> students;
   /* The set of units within the section*/
   private Collection<Unit> units;
   /* the professor in charge of the section */
   private User professor;
   /* The class that this section is a part of */
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
    * ChangeProfessor changes the professor of the section to the specified professor
    */
   abstract void changeProfessor(User professor);
}
