package CSTutor.Model.Progress;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import CSTutor.View.Progress.*;


/****
 * Class Student is a model class for the Calendar Tool progress and
 * assessment feature. It contains methods for all of the operations defined
 * for Student users, including retrieving data from the database.
 * @author Erica Solum (esolum@calpoly.edu)
 * @version 13Arp15
 */
public class InstructorModel
{
    private JList<String> tutorialList; 
    private JList<String> classList;
    private JList<String> studentList;
    
    public InstructorModel()
    {
        retrieveTutorialData();
        retrieveStudentData();
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
         System.out.println("In InstructorModel.retrieveTutorialData");
         
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
     * Get list of students enrolled in any of this instructor's tutorials 
     * from the database. Puts this data into an arraylist for easy retrieval 
     * later on. Currently sample data is filling the arraylist for viewing
     * purposes until further database implementation is done.
     */
    public void retrieveStudentData()
    {
        System.out.println("In InstructorModel.retrieveStudentData");
        
        /* Students List */
        DefaultListModel<String> studentModel = new DefaultListModel<>();
        studentModel.addElement("Students");
        studentModel.addElement("   - Maria Auxier");
        studentModel.addElement("   - Marian Bell");
        studentModel.addElement("   - Eugene Brown");
        studentModel.addElement("   - Jamie Bryant");
        studentModel.addElement("   - Danielle Carter");
        studentModel.addElement("   - Vernon Chilton");
        studentModel.addElement("   - Mary Clark");
        studentModel.addElement("   - Laurie Crawford");
        studentModel.addElement("   - Geoffrey Dunning");
        studentModel.addElement("   - Lester Flores");
        studentModel.addElement("   - Suzanne Gridley");
        studentModel.addElement("   - Bruce Griffin");
        studentModel.addElement("   - Jennifer Headrick");
        studentModel.addElement("   - Kevin Hoover");
        studentModel.addElement("   - Constance Jackson");
        studentModel.addElement("   - Chris Kapp");
        studentModel.addElement("   - Leon Lewis");
        studentModel.addElement("   - Victor Massey");
        studentModel.addElement("   - Blanche Natal");
        studentModel.addElement("   - Dianne Ohara");
        studentModel.addElement("   - Charlotte Perry");
        studentModel.addElement("   - Eric Prince");
        studentModel.addElement("   - Frank Reed");
        studentModel.addElement("   - Nicole Rios");
        studentModel.addElement("   - David Rodriguez");
        studentModel.addElement("   - James Scott");
        studentModel.addElement("   - Robert Taylor");
        studentModel.addElement("   - Anna Turley");
        studentModel.addElement("   - Paula Webb");
        studentModel.addElement("   - James Welsh");
        studentModel.addElement("   - Marlene Williams");
        studentList = new JList<>(studentModel);
        studentList.setCellRenderer(new ListRenderer());
    }
    
    /**
     * Get list of this instructor's classes from the database. Puts this 
     * data into an arraylist for easy retrieval later on. Currently sample 
     * data is filling the arraylist for viewing purposes until further
     *  database implementation is done.
     */
    public void retrieveClassesData()
    {
        System.out.println("In InstructorModel.retrieveClassesData");
        
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
    
    /**
     * Returns the list of students loaded from the database.
     */
    public JList<String> getStudentList()
    {
        System.out.println("In InstructorModel.getStudentList");
        return studentList;
        
    }
    
    /**
     * Returns the list of tutorials loaded from the database.
     */
    public JList<String> getTutorialList()
    {
        System.out.println("In InstructorModel.getTutorialList");
        return tutorialList;
    }
    
    /**
     * Returns the list of classes loaded from the database.
     */
    public JList<String> getClassList()
    {
        System.out.println("In InstructorModel.getClassList");
        return classList;
    }

}
