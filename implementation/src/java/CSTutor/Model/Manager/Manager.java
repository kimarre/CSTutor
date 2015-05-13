package CSTutor.Model.Manager;
import java.util.*;

/****
 * The Manager contains all the information for the manager view. It contains
 * all Classes, as well as what is currently selected. 
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class Manager {
	/* A list of all classes */
   public List<Class> data;
	/* The selected class */
   public Class selectedClass;
	/* The selected section */
   public Section selectedSection;
	/* The selected unit */
   public Unit selectedUnit;
	/* The selected tutorial */
   public Tutorial selectedTutorial;
	/* The selected page */
   public Page selectedPage;
   /**
    * Creates a manager model. Should only be one per site.
    */
   public Manager() {
      data = new ArrayList<Class>();
   }

   /**
    * SelectSection sets the selectedSection to the given section, if it
    * is within the selectedClass. <pre>
      pre:
       // The selected section is within the selectedClass
       selectedClass != null &&
       selectedClass.sections.contains(select);
      post:
       selectedSection'.equals(select);
    */
   public void selectSection(Section select) {
   	System.out.println("Selecting " + select);
	   if (select == null) {
	   	System.out.println("Warning: nothing selected");
		   selectedSection = null;
		   selectedClass = null;
	   }
	   else {
		   selectedSection = select;
		   selectClass(select.parent);
	   }
   }
   /**
    * SelectClass sets the selectedClass to the given class, if it exists.
    * <pre>
      pre:
      
       select != null && data.contains(select);
      post:
       selectedClass'.equals(select);
    */ 
   public void selectClass(Class select) {
   	System.out.println("Selecting " + select);
	   selectedClass = select;
   }
   /**
    * SelectUnit sets the selectedUnit to the given unit, if it is within the selected class or section.
    * <pre>
      pre:
       selectedClass !=null && ((selectedSection == null && selectedClass.units.contains(select)) || 
       (selectedSection != null && (selectedSection.units.contains(select) || selectedSection.parent.units.contains(select))));
      post:
       selectedUnit'.equals(select);
    */ 
   public void selectUnit(Unit select){
   	System.out.println("Selecting " + select);
	   if (select == null) {
	   	System.out.println("Warning: nothing selected");
		   selectedUnit = null;
		   selectedSection = null;
		   selectedClass = null;
	   }
	   else {
		   selectedUnit = select;
		   selectSection(select.parent);
	   }
   }
   /**
    * SelectTutorial sets the selectedTutorial to the given tutorial, if it is withing the selected unit.
    * <pre>
      pre:
       selectedUnit != null && selectedUnit.tutorials.contains(select);
      post:
       selectedTutorial'.equals(select);
    */ 
   public void selectTutorial(Tutorial select){
   	System.out.println("Selecting " + select);
	   if (select == null) {
	   	System.out.println("Warning: nothing selected");
		   selectedTutorial = null;
		   selectedUnit = null;
		   selectedSection = null;
		   selectedClass = null;
	   }
	   else {
		   selectedTutorial = select;
		   selectUnit(select.parent);
	   }
   }
   /**
    * SelectPage sets the selectedPage to the given page, if it is within the selectedTutorial.
    * <pre>
      pre:
       selectedTutorial != null && selectedTutorial.pages.contains(select);
      post:
       selectedPage'.equals(select);
    */ 
   public void selectPage(Page select){
	   if (select == null) {
	   	System.out.println("Warning: nothing selected");
		   selectedPage = null;
		   selectedTutorial = null;
		   selectedUnit = null;
		   selectedSection = null;
		   selectedClass = null;
	   }
	   else {
		   selectedPage = select;
		   selectTutorial(select.parent);
	   }
   }

   /**
    * CreateClass adds the given class to data.
    * <pre>
      pre:
       !data.contains(classs);
      post:
       data'.contains(classs);
    */
   public void createClass(Class classs){
	   data.add(classs);
  	 	System.out.println("In CSTutor.Model.Manager.createClass()");
  	}

   /**
    * CreateSection adds the given section to the currently selected class.
    * <pre>
      pre:
       selectedClass != null && !selectedClass.sections.contains(section);
      post:
       selectedClass'.sections.contains(section);
    */
   public void createSection(Section section){
	   if (selectedClass != null) {
		   selectedClass.sections.add(section);
	   }
   }
   /**
    * CreateUnit adds the given section to the currently selected class.
    * <pre>
      pre:
       selectedClass != null && ((selectedSection == null && !selectedClass.units.contains(unit)) ||
       (selectedSection != null && !selectedSection.units.contains(unit) && !selectedSection.parent.units.contains(unit)))
      post:
       selectedClass'.units.contains(unit) || selectedSection' != null && selectedSection'.units.contains(unit);
    */
   public void createUnit(Unit unit){
	   if (selectedSection != null) {
		   selectedSection.units.add(unit);
	   }
   }
   /**
    * CreateTutorial adds the given tutorial to the currently selected unit.
    * <pre>
      pre:
       selectedUnit != null && !selectedUnit.tutorials.contains(tutorial);
      post:
       selectedUnit'.tutorials.contains(tutorial);
    */
    public void createTutorial(Tutorial tutorial){
    	if (selectedUnit != null) {
 		   selectedUnit.tutorials.add(tutorial);
 	   }
    }
   /**
    * CreatePage adds the given page to the currently selected tutorial.
    * <pre>
      pre:
       selectedTutorial != null && !selectedTutorial.pages.contains(page);
      post:
       selectedTutorial'.pages.contains(page);
    */
    public void createPage(Page page){
       if (selectedTutorial != null) {
 		   selectedTutorial.pages.add(page);
 	   }
    }

    /**
     * Deletes the given class 
     * <pre>
      pre:
       selectedClass != null && data.contains(selectedClass);
      post:
       selectedClass' == null && !data'.contains(selectedClass);
     */
    public void deleteClass() {
    	data.remove(selectedClass);
   	 System.out.println("In CSTutor.Model.Manager.deleteClass()");
    }

    /**
     * Deletes the given section 
     * <pre>
      pre:
       selectedSection != null && selectedClass != null && selectedClass.sections.contains(selectedSection);
      post:
       selectedSection' == null && !selectedClass'.sections.contains(selectedSection);
     */
    public void deleteSection() {
    	if(selectedClass != null) {
    		selectedClass.sections.remove(selectedSection);
    	}
   	 System.out.println("In CSTutor.Model.Manager.deleteSection()");
    }

    /**
     * Deletes the given unit 
     * <pre>
      pre:
       selectedSection != null && selectedUnit != null && selectedSections.units.contains(selectedUnit);
      post:
       selectedUnit' == null && !selectedSection'.units.contains(selectedUnit);
     */
    public void deleteUnit() {
    	if(selectedSection != null) {
    		selectedSection.units.remove(selectedUnit);
    	}
   	 System.out.println("In CSTutor.Model.Manager.deleteUnit()");
    }

    /**
     * Deletes the given tutorial 
     * <pre>
      pre:
       selectedTutorial != null && selectedUnit != null && selectedUnit.tutorials.contains(selectedTutorial);
      post:
       selectedTutorial' == null && !selectedUnit'.sections.contains(selectedTutorial);
     */
    public void deleteTutorial() {
    	if(selectedUnit != null) {
    		selectedUnit.tutorials.remove(selectedUnit);
    	}
   	 System.out.println("In CSTutor.Model.Manager.deleteTutorial()");
    }

    /**
     * Deletes the given page 
     */
    public void deletePage(Page page) {
    	if(selectedTutorial != null) {
    		selectedTutorial.pages.remove(selectedPage);
    	}
   	 System.out.println("In CSTutor.Model.Manager.deletePage()");
    }


   /**
    * MovePage moves the selected page into the given tutorial, if it exists.
    * <pre>
     pre:
      selectedPage != null;
     post:
      newTutorial'.pages.contains(selectedPage);
    */
    public void movePage(Tutorial newTutorial){}
   /**
    * MoveTutorial moves the given tutorial into the given unit.
    * <pre>
     pre:
      selectedTutorial != null;
     post:
      newUnit'.tutorials.contains(selectedTutorial);
    */
    public void moveTutorial(Unit newUnit){}
}
