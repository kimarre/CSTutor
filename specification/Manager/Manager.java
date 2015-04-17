package Manager;
import java.util.List;

/**
 * The Manager object is based on section 2.2 of the requirements. 
 * 
 * The manager contains a collection of classes. The selectedClass is the
 * currently selected class, and the selectedSection is the currently selected
 * section within that class.
 */
public abstract class Manager {
   List<Class> data;
   Class selectedClass;
   Section selectedSection;
   Unit selectedUnit;
   Tutorial selectedTutorial;
   Page selectedPage;

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
   abstract void selectSection(Section select);
   /**
    * SelectClass sets the selectedClass to the given class, if it exists.
    * <pre>
      pre:
       data.contains(select);
      post:
       selectedClass'.equals(select);
    */ 
   abstract void selectClass(Class select);
   /**
    * SelectUnit sets the selectedUnit to the given unit, if it is within the selected class or section.
    * <pre>
      pre:
       selectedClass !=null && ((selectedSection == null && selectedClass.units.contains(select)) || 
       (selectedSection != null && (selectedSection.units.contains(select) || selectedSection.parent.units.contains(select))));
      post:
       selectedUnit'.equals(select);
    */ 
   abstract void selectUnit(Unit select);
   /**
    * SelectTutorial sets the selectedTutorial to the given tutorial, if it is withing the selected unit.
    * <pre>
      pre:
       selectedUnit != null && selectedUnit.tutorials.contains(select);
      post:
       selectedTutorial'.equals(select);
    */ 
   abstract void selectTutorial(Tutorial select);
   /**
    * SelectPage sets the selectedPage to the given page, if it is within the selectedTutorial.
    * <pre>
      pre:
       selectedTutorial != null && selectedTutorial.pages.contains(select);
      post:
       selectedPage'.equals(select);
    */ 
   abstract void selectPage(Page select);

   /**
    * CreateClass adds the given class to data.
    * <pre>
      pre:
       !data.contains(classs);
      post:
       data'.contains(classs);
    */
   abstract void createClass(Class classs);

   /**
    * CreateSection adds the given section to the currently selected class.
    * <pre>
      pre:
       selectedClass != null && !selectedClass.sections.contains(section);
      post:
       selectedClass'.sections.contains(section);
    */
   abstract void createSection(Section section);
   /**
    * CreateUnit adds the given section to the currently selected class.
    * <pre>
      pre:
       selectedClass != null && ((selectedSection == null && !selectedClass.units.contains(unit)) ||
       (selectedSection != null && !selectedSection.units.contains(unit) && !selectedSection.parent.units.contains(unit)))
      post:
       selectedClass'.units.contains(unit) || selectedSection' != null && selectedSection'.units.contains(unit);
    */
   abstract void createUnit(Unit unit);
   /**
    * CreateTutorial adds the given tutorial to the currently selected unit.
    * <pre>
      pre:
       selectedUnit != null && !selectedUnit.tutorials.contains(tutorial);
      post:
       selectedUnit'.tutorials.contains(tutorial);
    */
   abstract void createTutorial(Tutorial tutorial);
   /**
    * CreatePage adds the given page to the currently selected tutorial.
    * <pre>
      pre:
       selectedTutorial != null && !selectedTutorial.pages.contains(page);
      post:
       selectedTutorial'.pages.contains(page);
    */
   abstract void createPage(Page page);

   /**
    * DeleteUnitTutorialOrPage removes the selected object.
    * <pre>
     pre:
      selectedClass != null && selectedUnit != null;
     post: 
      //the deepest non-null object got deleted. If spest has an xor, the ors should really be xors.
      selectedTutorial' != null && selectedPage != null && selectedPage' == null && !selectedTutorial'.pages.contains(selectedPage) ||
      selectedPage == null && selectedUnit' != null && selectedTutorial != null && selectedTutorial' == null && !selectedUnit'.tutorials.contains(selectedTutorial) ||
      selectedSection' != null && selectedTutorial == null && selectedUnit != null && selectedUnit' == null && !selectedSection'.units.contains(selectedUnit) ||
      selectedClass' != null && selectedTutorial == null && selectedUnit != null && selectedUnit' == null && !selectedClass'.units.contains(selectedUnit);
    */
   abstract void deleteUnitTutorialOrPage();

   /**
    * DeleteClassOrSection removes the currently selected section or class.
    * <pre>
     pre:
     selectedClass != null;
     post:
     selectedClass' != null && selectedSection != null && selectedSection' == null && selectedClass'.sections.contains(selectedSection) ||
     selectedClass != null && selectedClass' == null && !data'.contains(selectedClass);
    */
   abstract void deleteClassOrSection();

   /**
    * MovePage moves the selected page into the given tutorial, if it exists.
    * <pre>
     pre:
      selectedPage != null;
     post:
      newTutorial'.pages.contains(selectedPage);
    */
   abstract void movePage(Tutorial newTutorial);
   /**
    * MoveTutorial moves the given tutorial into the given unit.
    * <pre>
     pre:
      selectedTutorial != null;
     post:
      newUnit'.tutorials.contains(selectedTutorial);
    */
   abstract void moveTutorial(Unit newUnit);
}
