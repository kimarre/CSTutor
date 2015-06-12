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
   public List<CSTutor.Model.User.User> students;
   /* The set of units within the section*/
   public List<Unit> units;
   /* the professor in charge of the section */
   public CSTutor.Model.User.User professor;
   /* The class that this section is a part of */
   public Class parent;
   
   public Section(String name, List<CSTutor.Model.User.User> students, CSTutor.Model.User.User professor, Class parent) {
	   this.name = name;
	   this.students = students;
	   this.professor = professor;
	   this.parent = parent;
	   
	   this.units = new ArrayList<Unit>();
	   this.units.add(new Unit("Uncategorized", this));
   }

   public Section(String name, Class parent) {
      this.name = name;
      this.students = new ArrayList<CSTutor.Model.User.User>();
      this.professor = null;
      this.units = new ArrayList<Unit>();
	   this.units.add(new Unit("Uncategorized", this));
      this.parent = parent;
   }
   
   public String toString() {
	   return name;
   }
}
