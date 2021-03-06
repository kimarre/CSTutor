package CSTutor.Model.Progress;

import CSTutor.Model.Database.*;
import CSTutor.Model.Tutorial.*;

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
    /** List of instructor's tutorials */
    private JList<ScoredTutorialTrack> tutorialList;
    /** list of Classes with this user listed as an instructor */
    private JList<Class> classList;
    /** List of students that are enrolled in any of the instructor's classes */
    private JList<Student> studentList;
    /** List model for the classes that are listed in the Classes tab */
    private ClassListModel<Class> fullClassesModel;
    /** List model for the Students that are listed in the Students tab */
    private StudentListModel<Student> fullStudentsModel;
    /** List model for the tutorials that are listed in the Tutorials tab */
    private TutorialListModel<ScoredTutorialTrack> fullTutorialsModel;
    /** List model for the Classes that are found when conducting a search */
    private ClassListModel<Class> searchClassesModel;
    /** List model for the students that are found when conducting a search */
    private StudentListModel<Student> searchStudentsModel;
    /** List model for the tutorials that are found when conducting a search */
    private TutorialListModel<ScoredTutorialTrack> searchTutorialsModel;
    
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
        
        ArrayList<CSTutor.Model.Tutorial.TutorialData> tutorials = 
            (ArrayList<CSTutor.Model.Tutorial.TutorialData>) TutorDB.getAllTutorialData();
        
        fullTutorialsModel
            = new TutorialListModel<ScoredTutorialTrack>(); /* List model for the JList */
        
        ArrayList<QuizData> quizzes = new ArrayList<QuizData>();
        quizzes.add(new QuizData("For Loops Quiz Part 1", 1, 4));
        quizzes.add(new QuizData("For Loops Quiz Part 2", 2, 3));
        quizzes.add(new QuizData("While Loops Part 1", 3, 3));
        quizzes.add(new QuizData("While Loops Part 2", 4, 4));
        quizzes.add(new QuizData("While Loops Part 3", 5, 5));
        quizzes.add(new QuizData("While Loops Part 4", 6, 2));
        
        for(int i=0; i< tutorials.size(); i++)
        {
            ScoredTutorialTrack tempTrack = new ScoredTutorialTrack(tutorials.get(i));
            if(i == 0)
            {
                tempTrack.placeQuizInTrack(quizzes.get(0));
                tempTrack.placeQuizInTrack(quizzes.get(1));
            }
            if(i == 1)
            {
                tempTrack.placeQuizInTrack(quizzes.get(2));
                tempTrack.placeQuizInTrack(quizzes.get(3));
                tempTrack.placeQuizInTrack(quizzes.get(4));
                tempTrack.placeQuizInTrack(quizzes.get(5));
            }
            fullTutorialsModel.addElement(tempTrack);
        }
        tutorialList = new JList<ScoredTutorialTrack>(fullTutorialsModel);
    }
    
    /**
     * Retrieves list of students enrolled in any of this instructor's tutorials 
     * from the database. Puts data into a JList for easy formatting
     * later on. Currently sample data is filling the list for viewing
     * purposes until further database implementation is done.
     */
    private void retrieveStudentData()
    {
        fullStudentsModel = new StudentListModel<Student>(); 
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
        ArrayList<CSTutor.Model.Manager.Class> managerClassList = (ArrayList<CSTutor.Model.Manager.Class>)TutorDB.getClasses();
        CSTutor.Model.Manager.Class class1 = managerClassList.get(0);
        
        ArrayList<CSTutor.Model.Manager.Section> sections = (ArrayList<CSTutor.Model.Manager.Section>)TutorDB.getSections(class1);
        CSTutor.Model.Manager.Section section1 = sections.get(0);
        
        ArrayList<CSTutor.Model.Manager.Unit> units = (ArrayList<CSTutor.Model.Manager.Unit>) TutorDB.getUnits(section1);
        CSTutor.Model.Manager.Unit unit1 = units.get(0);
        
        ArrayList<CSTutor.Model.Manager.Tutorial> tutorials = (ArrayList<CSTutor.Model.Manager.Tutorial>) TutorDB.getTutorials(unit1);
        
        
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
    public JList<ScoredTutorialTrack> getTutorialList()
    {
        System.out.println("Tutorial List Size: " + tutorialList.getModel().getSize());
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
     * Returns a list of tutorials that match the search string.
     *                                                 <pre>
     pre:
       // fullTutorialsModel must be initialized.
       fullTutorialsModel != null;
     *                                                  </pre>
     */
    public JList<ScoredTutorialTrack> searchForTutorial(String searchString)
    {
        ArrayList<ScoredTutorialTrack> simTutorials = fullTutorialsModel.getSimilarTutorials(searchString);  
        searchTutorialsModel = new TutorialListModel<ScoredTutorialTrack>();
        
        for(ScoredTutorialTrack tut: simTutorials)
        {
            searchTutorialsModel.addElement(tut);
        }
        return new JList<ScoredTutorialTrack>(searchTutorialsModel);
    }
    

}