package CSTutor.Model.Progress;

import CSTutor.Model.Database.*;
import CSTutor.Model.Manager.Tutorial;

import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;


/****
 * Class InstructorModel is a model class for the Calendar Tool progress and
 * assessment feature. It contains methods for all of the operations defined
 * for Instructor users, including retrieving data from the database.
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 13Apr15
 */
public class InstructorModel
{
    private JList<Tutorial> tutorialList;
    private JList<Class> classList;
    private JList<Student> studentList;
    private DefaultListModel<Tutorial> tutorialsModel;
    private DefaultListModel<Student> studentModel;
    private ClassListModel<Class> fullClassesModel;
    private StudentListModel<Student> fullStudentsModel;
    private TutorialListModel<Tutorial> fullTutorialsModel;
    private ClassListModel<Class> searchClassesModel;
    private StudentListModel<Student> searchStudentsModel;
    private TutorialListModel<Tutorial> searchTutorialsModel;
    private Class currentClass;
    
    public InstructorModel()
    {
        retrieveClassesData();
        retrieveStudentData();
        retrieveTutorialData(); 
    }
    
    /**
     * Retrieves data about instructor's tutorials from the database. Puts
     * data into a JList for easy formatting later on. Currently sample 
     * data is filling the list for viewing purposes until further 
     * database implementation is done.
     */
    private void retrieveTutorialData()
    {
        System.out.println("In InstructorModel.retrieveTutorialData");
        
        ArrayList<CSTutor.Model.Manager.Class> managerClassList = (ArrayList<CSTutor.Model.Manager.Class>)TutorDB.getClasses();
        CSTutor.Model.Manager.Class class1 = managerClassList.get(0);
        
        ArrayList<CSTutor.Model.Manager.Section> sections = (ArrayList<CSTutor.Model.Manager.Section>)TutorDB.getSections(class1);
        CSTutor.Model.Manager.Section section1 = sections.get(0);
        
        ArrayList<CSTutor.Model.Manager.Unit> units = (ArrayList<CSTutor.Model.Manager.Unit>) TutorDB.getUnits(section1);
        CSTutor.Model.Manager.Unit unit1 = units.get(0);
        
        ArrayList<CSTutor.Model.Manager.Tutorial> tutorials = (ArrayList<CSTutor.Model.Manager.Tutorial>) TutorDB.getTutorials(unit1);
        
        
        /* Tutorials list */
        fullTutorialsModel
            = new TutorialListModel<Tutorial>(); /* List model for the JList */
        
        for(int i=0; i< tutorials.size(); i++)
        {
            fullTutorialsModel.addElement(tutorials.get(i));
        }
        
        /* Add sample elements to the list */
        /*fullTutorialsModel.addElement(new TutorialData("Hello World!"));
        fullTutorialsModel.addElement(new TutorialData("Intro. to C"));
        fullTutorialsModel.addElement(new TutorialData("Data Types"));
        fullTutorialsModel.addElement(new TutorialData("If Statements"));
        fullTutorialsModel.addElement(new TutorialData("Loops in C"));
        fullTutorialsModel.addElement(new TutorialData("Functions"));
        fullTutorialsModel.addElement(new TutorialData("The Stack"));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));*/
        tutorialList = new JList<Tutorial>(fullTutorialsModel);
        
        /* Tutorials list */
        //fullTutorialsModel
          //  = new TutorialListModel<TutorialData>(); /* List model for the JList */
        
        /* Add sample elements to the list */
        /*fullTutorialsModel.addElement(new TutorialData("Hello World!"));
        fullTutorialsModel.addElement(new TutorialData("Intro. to C"));
        fullTutorialsModel.addElement(new TutorialData("Data Types"));
        fullTutorialsModel.addElement(new TutorialData("If Statements"));
        fullTutorialsModel.addElement(new TutorialData("Loops in C"));
        fullTutorialsModel.addElement(new TutorialData("Functions"));
        fullTutorialsModel.addElement(new TutorialData("The Stack"));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        fullTutorialsModel.addElement(new TutorialData("     ..."));
        tutorialList = new JList<TutorialData>(fullTutorialsModel);*/
        
    }
    
    /**
     * Retrieves list of students enrolled in any of this instructor's tutorials 
     * from the database. Puts data into a JList for easy formatting
     * later on. Currently sample data is filling the list for viewing
     * purposes until further database implementation is done.
     */
    private void retrieveStudentData()
    {
        //System.out.println("In InstructorModel.retrieveStudentData");
        
        /*
         * List model for the JList.
         */
        fullStudentsModel
            = new StudentListModel<Student>(); 
        
        ArrayList<Class> enrolledClasses = new ArrayList<Class>();
        enrolledClasses.add(new Class("CPE 225"));
        enrolledClasses.add(new Class("CPE 357"));
        
        ArrayList<Class> enrolledClasses2 = new ArrayList<Class>();
        enrolledClasses2.add(new Class("CPE 101"));
        enrolledClasses2.add(new Class("CPE 102"));
        
        ArrayList<Class> enrolledClasses3 = new ArrayList<Class>();
        enrolledClasses3.add(new Class("CPE 305"));
        enrolledClasses3.add(new Class("CPE 308"));
        
        ArrayList<Class> enrolledClasses4 = new ArrayList<Class>();
        enrolledClasses4.add(new Class("CPE 300"));
        enrolledClasses4.add(new Class("CPE 349"));
        
        ArrayList<Class> enrolledClasses5 = new ArrayList<Class>();
        enrolledClasses5.add(new Class("CPE 378"));
        enrolledClasses5.add(new Class("CPE 453"));
        
        /*
         * Add sample elements to the list.
         */
        fullStudentsModel.addElement(new Student("Maria Auxier", enrolledClasses));
        fullStudentsModel.addElement(new Student("Marian Bell", enrolledClasses2));
        fullStudentsModel.addElement(new Student("Eugene Brown", enrolledClasses3));
        fullStudentsModel.addElement(new Student("Jamie Bryant", enrolledClasses4));
        fullStudentsModel.addElement(new Student("Danielle Carter", enrolledClasses5));
        fullStudentsModel.addElement(new Student("Vernon Chilton", enrolledClasses));
        
        fullStudentsModel.addElement(new Student("Mary Clark", enrolledClasses2));
        fullStudentsModel.addElement(new Student("Laurie Crawford", enrolledClasses3));
        fullStudentsModel.addElement(new Student("Geoffrey Dunning", enrolledClasses4));
        fullStudentsModel.addElement(new Student("Lester Flores", enrolledClasses5));
        fullStudentsModel.addElement(new Student("Suzanne Gridley", enrolledClasses));
        fullStudentsModel.addElement(new Student("Bruce Griffin", enrolledClasses2));
        
        fullStudentsModel.addElement(new Student("Jennifer Headrick", enrolledClasses3));
        fullStudentsModel.addElement(new Student("Kevin Hoover", enrolledClasses4));
        fullStudentsModel.addElement(new Student("Constance Jackson", enrolledClasses5));
        fullStudentsModel.addElement(new Student("Chris Kapp", enrolledClasses));
        fullStudentsModel.addElement(new Student("Leon Lewis", enrolledClasses2));
        fullStudentsModel.addElement(new Student("Victor Massey", enrolledClasses3));
        
        fullStudentsModel.addElement(new Student("Blanche Natal", enrolledClasses4));
        fullStudentsModel.addElement(new Student("Dianne Ohara", enrolledClasses5));
        fullStudentsModel.addElement(new Student("Charlotte Perry", enrolledClasses));
        fullStudentsModel.addElement(new Student("Eric Prince", enrolledClasses2));
        fullStudentsModel.addElement(new Student("Frank Reed", enrolledClasses3));
        fullStudentsModel.addElement(new Student("Nicole Rios", enrolledClasses4));
        
        fullStudentsModel.addElement(new Student("David Rodriguez", enrolledClasses5));
        fullStudentsModel.addElement(new Student("James Scott", enrolledClasses));
        fullStudentsModel.addElement(new Student("Robert Taylor", enrolledClasses2));
        fullStudentsModel.addElement(new Student("Anna Turley", enrolledClasses3));
        fullStudentsModel.addElement(new Student("James Welsh", enrolledClasses4));
        fullStudentsModel.addElement(new Student("Marlene Williams", enrolledClasses5));
        studentList = new JList<Student>(fullStudentsModel);  
        
    }
    
    /**
     * Retrieves list of instructor's classes from the database. Puts 
     * data into a JList for easy formatting later on. Currently sample 
     * data is filling the list for viewing purposes until further
     *  database implementation is done.
     */
    private void retrieveClassesData()
    {
        //System.out.println("In InstructorModel.retrieveClassesData");
        
        
        
        
        List<String> dbClasses = TutorDB.getClassNames();
        fullClassesModel = new ClassListModel<Class>();
        
        for(int i=0; i<dbClasses.size(); i++)
        {
            fullClassesModel.addElement(new Class(dbClasses.get(i).toString()));
        }
        
        classList = new JList<Class>(fullClassesModel);
    }
    
    /**
     * Returns the JList filled with student data.
     *                                                 <pre>
     pre:
       // The JList studentList must not be null.
       studentList != null;
     *                                                  </pre>
     */
    public JList<Student> getStudentList()
    {
        return studentList;     
    }
    
    /**
     * Returns the JList filled with tutorial data.
     *                                                 <pre>
     pre:
       // The JList tutorialList must not be null.
       tutorialList != null;
     *                                                  </pre>
     */
    public JList<Tutorial> getTutorialList()
    {
        return tutorialList;
    }
    
    /**
     * Returns the JList filled with class data.
     *                                                 <pre>
     pre:
       // The JList classList must not be null.
       classList != null;
     *                                                  </pre>
     */
    public JList<Class> getClassList()
    {
        return classList;
    }
    
    /**
     * Returns a list of classes that match the search string.
     *                                                 <pre>
     pre:
       // fullClassesModel must be initialized.
       fullClassesModel != null;
     *                                                  </pre>
     */
    public JList<Class> searchForClass(String searchString)
    {
        ArrayList<Class> simClasses = fullClassesModel.getSimilarClasses(new Class(searchString));
        searchClassesModel = new ClassListModel<Class>();
        
        for(Class cl: simClasses)
        {
            searchClassesModel.addElement(cl);
        }
        return new JList<Class>(searchClassesModel); 
    }
    
    /**
     * Returns a list of students that match the search string.
     *                                                 <pre>
     pre:
       // fullStudentsModel must be initialized.
       fullStudentsModel != null;
     *                                                  </pre>
     */
    public JList<Student> searchForStudent(String searchString)
    {
        ArrayList<Student> simStudents = fullStudentsModel.getSimilarStudents(searchString);
        searchStudentsModel = new StudentListModel<Student>();
        
        for(Student stu: simStudents)
        {
            searchStudentsModel.addElement(stu);
        }
        return new JList<Student>(searchStudentsModel);
    }
    
    /**
     * Returns a list of students that match the search string.
     *                                                 <pre>
     pre:
       // fullTutorialsModel must be initialized.
       fullTutorialsModel != null;
     *                                                  </pre>
     */
    public JList<Tutorial> searchForTutorial(String searchString)
    {
        ArrayList<Tutorial> simTutorials = fullTutorialsModel.getSimilarTutorials(new Tutorial(searchString, null));  
        searchTutorialsModel = new TutorialListModel<Tutorial>();
        
        for(Tutorial tut: simTutorials)
        {
            searchTutorialsModel.addElement(tut);
        }
        return new JList<Tutorial>(searchTutorialsModel);
    }
    

}