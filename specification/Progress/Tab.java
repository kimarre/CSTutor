package Progress;

import java.util.Collection;
/**
 * A sub-section of the left side bar that contains expandable lists.
 */  
public abstract class Tab
{
    private String title;
    private Collection<List> expandableLists;

    /**
      * Adds an expandable list to list collection, which is sorted
      * alphabetically.
      * @param   l  expandable list to be displayed
      *                                                         <pre>
       pre:
         // The List l must not be null.
         l != null;

       post:
         // List l is now in this.expandableLists.
         expandableLists'.contains(l);
      *
      */
    public abstract void addList(List l);

    /**
      * Gets the title of the tab as a String.
      */
    public String getName();


}
