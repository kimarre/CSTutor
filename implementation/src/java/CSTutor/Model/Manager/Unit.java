package CSTutor.Model.Manager;
import java.util.*;

/**
 * Class Unit holds a collection of tutorial tracks.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class Unit {
	/* The tutorial tracks */
   public List<Tutorial> tutorials;
   /* The name of the unit*/
   public String name;
   
   public Section parent;

   public Unit(String name, Section parent) {
	   this.name = name;
	   this.parent = parent;
	   this.tutorials = new ArrayList<Tutorial>();
   }
   public String toString() {
	   return name;
   }
}
