package CSTutor.Model.Manager;

/**
 * Class Page is a simple abstraction from the tutorial's page. May be removed.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class Page {
	/*The name of the page */
   public String name;
   /*The tutorial this page belongs to*/
   public Tutorial parent;
   public Page(String name, Tutorial parent) {
	   this.name = name;
	   this.parent = parent;
   }
   public String toString() {
	   return name;
   }
}
