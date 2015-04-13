/**
 * REMEMBER TO CHANGE THE PACKAGE TO CSTUTOR.MODEL.PROGRESS
 */
package CSTutor.Model.Progress;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import view.ListRenderer;


/****
 * Class Student is a model class for the Calendar Tool progress and
 * assessment feature. It contains methods for all of the operations defined
 * for Student users, including retrieving data from the database.
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class StudentModel
{

    private JList<String> tutorialList; 
    private JList<String> classList;
    
    public StudentModel()
    {
        retrieveTutorialData();
        retrieveClassesData();
        
    }
    
    /**
     * Get list of this instructor's tutorials from the database. Puts this
     * data into an arraylist for easy retrieval later on. Currently sample 
     * data is filling the arraylist for viewing purposes until further 
     * database implementation is done.
     */
    public void retrieveTutorialData()
    {
         System.out.println("In StudentModel.retrieveTutorialData");
         
         /* Tutorials list */
         DefaultListModel<String> tutorialsModel = new DefaultListModel<>();
         tutorialsModel.addElement("Tutorials");
         tutorialsModel.addElement("   - Hello World!");
         tutorialsModel.addElement("   - Intro. to C");
         tutorialsModel.addElement("   - Data Types");
         tutorialsModel.addElement("   - If Statements");
         tutorialsModel.addElement("   - Loops in C");
         tutorialsModel.addElement("   - Functions");
         tutorialsModel.addElement("   - The Stack");
         tutorialsModel.addElement("     ...");
         tutorialsModel.addElement("     ...");
         tutorialsModel.addElement("     ...");
         tutorialsModel.addElement("     ...");
         tutorialsModel.addElement("     ...");
         tutorialsModel.addElement("     ...");
         tutorialsModel.addElement("     ...");
         tutorialList = new JList<>(tutorialsModel);
         tutorialList.setCellRenderer(new ListRenderer());
    }
    
    /**
     * Get list of this student's classes from the database. Puts this 
     * data into a list for easy retrieval later on. Currently sample 
     * data is filling the a list for viewing purposes until further
     *  database implementation is done.
     */
    public void retrieveClassesData()
    {
        System.out.println("In StudentModel.retrieveClassesData");
        
        /* Classes list */
        DefaultListModel<String> classesModel = new DefaultListModel<>();
        classesModel.addElement("Classes");
        classesModel.addElement("   - CPE 123");
        classesModel.addElement("   - CPE 101");
        classesModel.addElement("   - CPE 102");
        classesModel.addElement("   - CPE 103");
        classesModel.addElement("   - CPE 357");
        classesModel.addElement("   - CPE 305");
        classesModel.addElement("   - CPE 308");
        classList = new JList<>(classesModel);
        classList.setCellRenderer(new ListRenderer());
    }
    
    public JList<String> getTutorialList()
    {
        System.out.println("In StudentModel.getTutorialList");
        return tutorialList;
    }
    
    public JList<String> getClassList()
    {
        System.out.println("In StudentModel.getClassList");
        return classList;
    }

}
