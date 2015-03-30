package Manager;
import java.util.List;

/**
 * Derived from section 2.2
 *
 * A tutorial is a collection of information pages and quizzes. Multiple
 * pages make up a tutorial. A tutorial can be part of a larger unit.
 */
public abstract class Tutorial {
   private List<Page> pages;
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
