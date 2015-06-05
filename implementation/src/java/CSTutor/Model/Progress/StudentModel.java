package CSTutor.Model.Progress;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import CSTutor.View.Progress.*;
import CSTutor.Model.Tutorial.*;


/****
 * Class Student is a model class for the CSTutor progress and
 * assessment feature. It contains methods for all of the operations defined
 * for Student users, including retrieving data from the database.
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class StudentModel
{
    private JList<TutorialData> tutorialList;
    private JList<Class> classList;
    
    public StudentModel()
    {
        retrieveTutorialData();
        retrieveClassesData();
    }
    
    /**
     * Retrieves data about student's tutorials from the database. Puts
     * data into a JList for easy formatting later on. Currently sample 
     * data is filling the list for viewing purposes until further 
     * database implementation is done.
     */
    public void retrieveTutorialData()
    {
         System.out.println("In StudentModel.retrieveTutorialData");
         
         /* Tutorials list */
         DefaultListModel<TutorialData> tutorialsModel
             = new DefaultListModel<TutorialData>(); /* List model for the JList */
         
         /* Add sample elements to the list */
         /*tutorialsModel.addElement(new TutorialData("Hello World!"));
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
         tutorialList = new JList<TutorialData>(tutorialsModel);*/
    }
    
    /**
     * Retrieves list of student's classes from the database. Puts 
     * data into a JList for easy formatting later on. Currently sample 
     * data is filling the list for viewing purposes until further
     * database implementation is done.
     */
    public void retrieveClassesData()
    {
        System.out.println("In StudentModel.retrieveClassesData");
        
        /*
         * List model for the JList.
         */
        DefaultListModel<Class> classesModel = new DefaultListModel<Class>();
        
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
     * Returns the JList filled with tutorial data.
     */
    public JList<TutorialData> getTutorialList()
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

}
