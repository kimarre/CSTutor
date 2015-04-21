package CSTutor.Model.Manager;
import java.util.List;

/**
 * Class Tutorial represents a tutorial track. It contains multiple pages.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public abstract class Tutorial {
	/* All tutorial pages in this track*/
   private List<Page> pages;
   /* The name of the tutorial track*/
   private String name;
   /**
    * AddPage adds the given page to the collection
    */
   abstract void addPage(Page page);

   /**
    * RemovePage removes the page from the collection, if it exists.
    */
   abstract void removePage(Page page);

   /**
    * MoveUp moves the page up one space if possible
    */
   abstract void moveUp(Page page);

   /**
    * MoveDown moves the page down one space if possible
    */
   abstract void moveDown(Page page);

}
