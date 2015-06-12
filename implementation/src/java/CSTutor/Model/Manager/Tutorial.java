package CSTutor.Model.Manager;
import java.util.*;

/**
 * Class Tutorial represents a tutorial track. It contains multiple pages.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class Tutorial {
   public String name;
   
   public Unit parent;
   
   public Tutorial(String name, Unit parent) {
	   this.name = name;
	   this.parent = parent;
   }
   public String toString() {
	   return name;
   }
}
