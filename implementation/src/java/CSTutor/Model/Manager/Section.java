package CSTutor.Model.Manager;
import java.util.*;

/**
 * Class Section is a subsection of a class. It can have a specific professor, but otherwise
 * is similar to a class.
 * 
 * @author Simon Vurens
 */
public class Section {
	/* The name of the section */
   public String name;
	/* The enrolled students in the section. A subset of students enrolled in the class*/
   public Collection<User> students;
   /* The set of units within the section*/
   public Collection<Unit> units;
   /* the professor in charge of the section */
   public User professor;
   /* The class that this section is a part of */
   public Class parent;
   
   public Section(String name, Collection<User> students, User professor, Class parent) {
	   this.name = name;
	   this.students = students;
	   this.professor = professor;
	   this.parent = parent;
	   
	   this.units = new HashSet<Unit>();
	   this.units.add(new Unit("Uncategorized", this));
   }
   public String toString() {
	   return name;
   }
}
