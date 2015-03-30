package Progress;

import java.util.Collection;

/**
 * Rectangular content section on the left side of the page that 
 * contains tabs with different view options and other information.
 */
public abstract class LeftSideBar {
    private Collection<Tab> tabs;

    /**
     * Adds a tab to the side bar.
      
      pre:
        // The input parameter newTab should not equal null.     
        newTab != null;
      
      post:
        // The new tab is in this.tabs.
         tabs'.contains(newTab);
     *
     */ 
    public abstract void addTab(Tab newTab);

    /**
     * Adds an expandable list to a certain tab that is already in the 
     * side bar.
     * @param   curTab  tab to add the list to
     * @param   l       expandable list to add the curTab
     *                                                        <pre>
       pre:
         //
         // The tab with the name tabTitle must be in this.tabs. The 
         // List l cannot be equal to null.
         // 
         exists(Tab curTab; 
             tabs.contains(curTab.getName().equals(tabTitle)))
         &&
         l != null; 
     *
     */   
    public abstract void addListToTab(String tabTitle, List l); 

}
