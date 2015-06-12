package CSTutor.Model.Manager;
import java.util.*;

/****
 * The Class object represents a class. This contains methods to add or
 * remove sections, units, and students. It also contains methods to rearrange
 * units, and to change the access level.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class Class implements Cloneable{
	/* All sections contained by this class */
   public List<Section> sections;

	/* All students enrolled in this class */
   public List<CSTutor.Model.User.User> students;
   
	/* The minimum level of access required to view this class */
   public ClassAccessLevel access;
   
   public String name;
   /**
    * Creates a new class.
    */
   public Class(String name) {
	   this.name = name;
	   sections = new ArrayList<Section>();
	   students = new ArrayList<CSTutor.Model.User.User>();
	   access = ClassAccessLevel.Guest;
	   sections.add(new Section("All sections", new ArrayList<CSTutor.Model.User.User>(students), null, this));
   }

   /** 
    * ClassAccessLevel represents the possible access levels a class can have.
    *
    * Guest is the lowest level. Anyone can see a class with Guest access level.
    * Next is Student. Enrolled students, TAs, and professors can see this class.
    * Assistant allows TA's and professors to view the class.
    * Professor is only viewable to the professor.
    */
   public String toString() {
	   return name;
   }
   public enum ClassAccessLevel {
      Guest, Student, Professor;
   }
}
