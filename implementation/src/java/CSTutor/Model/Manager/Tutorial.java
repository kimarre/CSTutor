package CSTutor.Model.Manager;
import java.util.*;

/**
 * Class Tutorial represents a tutorial track. It contains multiple pages.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class Tutorial {
	/* All tutorial pages in this track*/
   public List<Page> pages;
   /* The name of the tutorial track*/
   public String name;
   
   public Unit parent;
   
   public Tutorial(String name, Unit parent) {
	   this.name = name;
	   this.parent = parent;
	   this.pages = new ArrayList<Page>();
   }
   /**
    * MoveUp moves the page up one space if possible
    */
   void moveUp(Page page){}

   /**
    * MoveDown moves the page down one space if possible
    */
   void moveDown(Page page){}
   public String toString() {
	   return name;
   }
}
