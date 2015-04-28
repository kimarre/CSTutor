package CSTutor.Model.Progress;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;



/****
 * Class Student is a model class for the Calendar Tool progress and
 * assessment feature. It contains methods for all of the operations defined
 * for Student users, including retrieving data from the database.
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 13Apr15
 */
public class InstructorModel
{
    private ArrayList<TutorialData> tutorialList;
    //private ArrayList<String> tutorialList;
    private ArrayList<Class> classList;
    private ArrayList<Student> studentList;
    
    public InstructorModel()
    {
        retrieveClassesData();
        retrieveStudentData();
        retrieveTutorialData(); 
    }
    
    /**
     * Get list of this instructor's tutorials from the database. Puts this
     * data into an arraylist for easy retrieval later on. Currently sample 
     * data is filling the arraylist for viewing purposes until further 
     * database implementation is done.
     */
    private void retrieveTutorialData()
    {
        System.out.println("In InstructorModel.retrieveTutorialData");
        
        tutorialList = new ArrayList<TutorialData>();
        tutorialList.add(new TutorialData("-  Hello World!"));
        tutorialList.add(new TutorialData("-  Intro. to C"));
        tutorialList.add(new TutorialData("-  Data Types"));
        tutorialList.add(new TutorialData("-  Conditionals"));
        tutorialList.add(new TutorialData("-  Loops in C"));
        tutorialList.add(new TutorialData("-  Functions"));
        tutorialList.add(new TutorialData("-  The Stack"));
    }
    
    /**
     * Get list of students enrolled in any of this instructor's tutorials 
     * from the database. Puts this data into an arraylist for easy retrieval 
     * later on. Currently sample data is filling the arraylist for viewing
     * purposes until further database implementation is done.
     */
    private void retrieveStudentData()
    {
        System.out.println("In InstructorModel.retrieveStudentData");
        
        studentList = new ArrayList<Student>();
        studentList.add(new Student("Maria Auxier"));
        studentList.add(new Student("-  Marian Bell"));
        
        studentList.add(new Student("-  Eugene Brown"));
        studentList.add(new Student("-  Jamie Bryant"));
        studentList.add(new Student("-  Danielle Carter"));
        studentList.add(new Student("-  Vernon Chilton"));
        studentList.add(new Student("-  Mary Clark"));
        
        studentList.add(new Student("-  Laurie Crawford"));
        studentList.add(new Student("-  Geoffrey Dunning"));
        studentList.add(new Student("-  Lester Flores"));
        studentList.add(new Student("-  Suzanne Gridley"));
        studentList.add(new Student("-  Bruce Griffin"));
        studentList.add(new Student("-  Jennifer Headrick"));
        studentList.add(new Student("-  Kevin Hoover"));
        studentList.add(new Student("-  Constance Jackson"));
        studentList.add(new Student("-  Chris Kapp"));
        studentList.add(new Student("-  Leon Lewis"));
        studentList.add(new Student("-  Victor Massey"));
        studentList.add(new Student("-  Blanche Natal"));
        studentList.add(new Student("-  Dianne Ohara"));
        studentList.add(new Student("-  Charlotte Perry"));
        studentList.add(new Student("-  Eric Prince"));
        studentList.add(new Student("-  Frank Reed"));
        studentList.add(new Student("-  Nicole Rios"));
        studentList.add(new Student("-  David Rodriguez"));
        studentList.add(new Student("-  James Scott"));
        studentList.add(new Student("-  Robert Taylor"));
        studentList.add(new Student("-  Anna Turley"));
        studentList.add(new Student("-  Paula Webb"));
        studentList.add(new Student("-  James Welsh"));
        studentList.add(new Student("-  Marlene Williams"));
        
        
        
    }
    
    /**
     * Get list of this instructor's classes from the database. Puts this 
     * data into an arraylist for easy retrieval later on. Currently sample 
     * data is filling the arraylist for viewing purposes until further
     *  database implementation is done.
     */
    private void retrieveClassesData()
    {
        System.out.println("In InstructorModel.retrieveClassesData");
        
        classList = new ArrayList<Class>();
        classList.add(new Class("CPE 101"));
        classList.add(new Class("CPE 102"));
        classList.add(new Class("CPE 103"));
        classList.add(new Class("CPE 225"));
        classList.add(new Class("CPE 357"));
        classList.add(new Class("CPE 305"));
        classList.add(new Class("CPE 308"));
        classList.add(new Class("CPE 309"));
    }
    
    public JList<Student> getStudentList()
    {
        System.out.println("In InstructorModel.getStudentList");
        
        
        /* Students List */
        DefaultListModel<Student> studentModel = new DefaultListModel<Student>();
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
        JList<Student> studentJList = new JList<Student>(studentModel);
        return studentJList;
        
    }
    
    public JList<TutorialData> getTutorialList()
    {
        System.out.println("In InstructorModel.getTutorialList");
        
        
        
        /* Tutorials list */
        DefaultListModel<TutorialData> tutorialsModel = new DefaultListModel<TutorialData>();
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
        JList<TutorialData> tutorialJList = new JList<TutorialData>(tutorialsModel);
        
        
        return tutorialJList;
    }
    
    public JList<Class> getClassList()
    {
        System.out.println("In InstructorModel.getClassList");
        
        /* Classes list */
        DefaultListModel<Class> classesModel = new DefaultListModel<Class>();
        classesModel.addElement(new Class("CPE 123"));
        classesModel.addElement(new Class("CPE 101"));
        classesModel.addElement(new Class("CPE 102"));
        classesModel.addElement(new Class("CPE 103"));
        classesModel.addElement(new Class("CPE 357"));
        classesModel.addElement(new Class("CPE 305"));
        classesModel.addElement(new Class("CPE 308"));
        JList<Class> classesJList = new JList<Class>(classesModel);
        
        return classesJList;
    }

}
