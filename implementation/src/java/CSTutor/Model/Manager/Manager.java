package CSTutor.Model.Manager;
import java.util.List;

/****
 * The Manager contains all the information for the manager view. It contains
 * all Classes, as well as what is currently selected. 
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class Manager {
	/* A list of all classes */
   List<Class> data;
	/* The selected class */
   Class selectedClass;
	/* The selected section */
   Section selectedSection;
	/* The selected unit */
   Unit selectedUnit;
	/* The selected tutorial */
   Tutorial selectedTutorial;
	/* The selected page */
   Page selectedPage;
   /**
    * Creates a manager model. Should only be one per site.
    */
   public Manager() {
   	
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
   public void selectSection(Section select) {}
   /**
    * SelectClass sets the selectedClass to the given class, if it exists.
    * <pre>
      pre:
       data.contains(select);
      post:
       selectedClass'.equals(select);
    */ 
   public void selectClass(Class select) {}
   /**
    * SelectUnit sets the selectedUnit to the given unit, if it is within the selected class or section.
    * <pre>
      pre:
       selectedClass !=null && ((selectedSection == null && selectedClass.units.contains(select)) || 
       (selectedSection != null && (selectedSection.units.contains(select) || selectedSection.parent.units.contains(select))));
      post:
       selectedUnit'.equals(select);
    */ 
   public void selectUnit(Unit select){}
   /**
    * SelectTutorial sets the selectedTutorial to the given tutorial, if it is withing the selected unit.
    * <pre>
      pre:
       selectedUnit != null && selectedUnit.tutorials.contains(select);
      post:
       selectedTutorial'.equals(select);
    */ 
   public void selectTutorial(Tutorial select){}
   /**
    * SelectPage sets the selectedPage to the given page, if it is within the selectedTutorial.
    * <pre>
      pre:
       selectedTutorial != null && selectedTutorial.pages.contains(select);
      post:
       selectedPage'.equals(select);
    */ 
   public void selectPage(Page select){}

   /**
    * CreateClass adds the given class to data.
    * <pre>
      pre:
       !data.contains(classs);
      post:
       data'.contains(classs);
    */
   public void createClass(Class classs){
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
   public void createSection(Section section){}
   /**
    * CreateUnit adds the given section to the currently selected class.
    * <pre>
      pre:
       selectedClass != null && ((selectedSection == null && !selectedClass.units.contains(unit)) ||
       (selectedSection != null && !selectedSection.units.contains(unit) && !selectedSection.parent.units.contains(unit)))
      post:
       selectedClass'.units.contains(unit) || selectedSection' != null && selectedSection'.units.contains(unit);
    */
   public void createUnit(Unit unit){}
   /**
    * CreateTutorial adds the given tutorial to the currently selected unit.
    * <pre>
      pre:
       selectedUnit != null && !selectedUnit.tutorials.contains(tutorial);
      post:
       selectedUnit'.tutorials.contains(tutorial);
    */
    public void createTutorial(Tutorial tutorial){}
   /**
    * CreatePage adds the given page to the currently selected tutorial.
    * <pre>
      pre:
       selectedTutorial != null && !selectedTutorial.pages.contains(page);
      post:
       selectedTutorial'.pages.contains(page);
    */
    public void createPage(Page page){}

    /**
     * Deletes the given class 
     */
    public void deleteClass(Class classs) {
   	 System.out.println("In CSTutor.Model.Manager.deleteClass()");
    }

    /**
     * Deletes the given section 
     */
    public void deleteSection(Section section) {
   	 System.out.println("In CSTutor.Model.Manager.deleteSection()");
    }

    /**
     * Deletes the given unit 
     */
    public void deleteUnit(Unit unit) {
   	 System.out.println("In CSTutor.Model.Manager.deleteUnit()");
    }

    /**
     * Deletes the given tutorial 
     */
    public void deleteTutorial(Tutorial tutorial) {
   	 System.out.println("In CSTutor.Model.Manager.deleteTutorial()");
    }

    /**
     * Deletes the given page 
     */
    public void deletePage(Page page) {
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
