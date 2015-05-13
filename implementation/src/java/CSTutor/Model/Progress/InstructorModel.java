package CSTutor.Model.Progress;

import CSTutor.Model.Database.*;

import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import model.Class;
import model.Student;
import model.Tutorial;


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
    private DefaultListModel<TutorialData> tutorialsModel;
    private DefaultListModel<Student> studentModel;
    private DefaultListModel<Class> classesModel;
    
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
        
        /* Tutorials list */
        tutorialsModel
            = new DefaultListModel<TutorialData>(); /* List model for the JList */
        
        /* Add sample elements to the list */
        tutorialsModel.addElement(new TutorialData("Hello World!"));
        tutorialsModel.addElement(new TutorialData("Intro. to C"));
        tutorialsModel.addElement(new TutorialData("Data Types"));
        tutorialsModel.addElement(new TutorialData("If Statements"));
        tutorialsModel.addElement(new TutorialData("Loops in C"));
        tutorialsModel.addElement(new TutorialData("Functions"));
        tutorialsModel.addElement(new TutorialData("The Stack"));
        tutorialsModel.addElement(new TutorialData("     ..."));
        tutorialsModel.addElement(new TutorialData("     ..."));
        tutorialsModel.addElement(new TutorialData("     ..."));
        tutorialsModel.addElement(new TutorialData("     ..."));
        tutorialsModel.addElement(new TutorialData("     ..."));
        tutorialsModel.addElement(new TutorialData("     ..."));
        tutorialsModel.addElement(new TutorialData("     ..."));
        tutorialList = new JList<TutorialData>(tutorialsModel);
    }
    
    /**
     * Retrieves list of students enrolled in any of this instructor's tutorials 
     * from the database. Puts data into a JList for easy formatting
     * later on. Currently sample data is filling the list for viewing
     * purposes until further database implementation is done.
     */
    private void retrieveStudentData()
    {
        System.out.println("In InstructorModel.retrieveStudentData");
        
        /*
         * List model for the JList.
         */
        studentModel
            = new DefaultListModel<Student>(); 
        
        /*
         * Add sample elements to the list.
         */
        studentModel.addElement(new Student("Maria Auxier"));
        studentModel.addElement(new Student("Marian Bell"));
        studentModel.addElement(new Student("Eugene Brown"));
        studentModel.addElement(new Student("Jamie Bryant"));
        studentModel.addElement(new Student("Danielle Carter"));
        studentModel.addElement(new Student("Vernon Chilton"));
        studentModel.addElement(new Student("Mary Clark"));
        studentModel.addElement(new Student("Laurie Crawford"));
        studentModel.addElement(new Student("Geoffrey Dunning"));
        studentModel.addElement(new Student("Lester Flores"));
        studentModel.addElement(new Student("Suzanne Gridley"));
        studentModel.addElement(new Student("Bruce Griffin"));
        studentModel.addElement(new Student("Jennifer Headrick"));
        studentModel.addElement(new Student("Kevin Hoover"));
        studentModel.addElement(new Student("Constance Jackson"));
        studentModel.addElement(new Student("Chris Kapp"));
        studentModel.addElement(new Student("Leon Lewis"));
        studentModel.addElement(new Student("Victor Massey"));
        studentModel.addElement(new Student("Blanche Natal"));
        studentModel.addElement(new Student("Dianne Ohara"));
        studentModel.addElement(new Student("Charlotte Perry"));
        studentModel.addElement(new Student("Eric Prince"));
        studentModel.addElement(new Student("Frank Reed"));
        studentModel.addElement(new Student("Nicole Rios"));
        studentModel.addElement(new Student("David Rodriguez"));
        studentModel.addElement(new Student("James Scott"));
        studentModel.addElement(new Student("Robert Taylor"));
        studentModel.addElement(new Student("Anna Turley"));
        studentModel.addElement(new Student("Paula Webb"));
        studentModel.addElement(new Student("James Welsh"));
        studentModel.addElement(new Student("Marlene Williams"));
        studentList = new JList<Student>(studentModel);  
    }
    
    /**
     * Retrieves list of instructor's classes from the database. Puts 
     * data into a JList for easy formatting later on. Currently sample 
     * data is filling the list for viewing purposes until further
     *  database implementation is done.
     */
    private void retrieveClassesData()
    {
        System.out.println("In InstructorModel.retrieveClassesData");
        
        /*
         * List model for the JList.
         */
        classesModel = new DefaultListModel<Class>();
        
        /*
         * Add sample elements to the list.
         */
        classesModel.addElement(new Class("CPE 123"));
        classesModel.addElement(new Class("CPE 101"));
        classesModel.addElement(new Class("CPE 102"));
        classesModel.addElement(new Class("CPE 103"));
        classesModel.addElement(new Class("CPE 357"));
        classesModel.addElement(new Class("CPE 305"));
        classesModel.addElement(new Class("CPE 308"));
        classList = new JList<Class>(classesModel);
    }
    
    /**
     * Returns the JList filled with student data.
     */
    public JList<Student> getStudentList()
    {
        return studentList;     
    }
    
    /**
     * Returns the JList filled with tutorial data.
     */
    public JList<Tutorial> getTutorialList()
    {
        return tutorialList;
    }
    
    /**
     * Returns the JList filled with class data.
     */
    public JList<Class> getClassList()
    {
        return classList;
    }
    
    /**
     * Returns a list of classes that match the search string.
     */
    public void searchForClass(String searchString)
    {
        if(classesModel.contains(new Class(searchString)))
        {
            int index = classesModel.indexOf(new Class(searchString));
            System.out.println(index);
        }
    }
    
    /**
     * Returns a list of students that match the search string.
     */
    public void searchForStudent(String searchString)
    {
        if(studentModel.contains(new Student(searchString)))
        {
            int index = studentModel.indexOf(new Student(searchString));
            System.out.println(index);
        }
    }
    
    /**
     * Returns a list of students that match the search string.
     */
    public void searchForTutorial(String searchString)
    {
        if(tutorialsModel.contains(new TutorialData(searchString)))
        {
            int index = tutorialsModel.indexOf(new TutorialData(searchString));
            System.out.println(index);
        }
    }

}
