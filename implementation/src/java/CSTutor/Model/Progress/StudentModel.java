package CSTutor.Model.Progress;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.tree.*;

import java.util.*;

import CSTutor.View.Progress.*;
import CSTutor.Model.Tutorial.*;
import CSTutor.Model.Database.*;
import CSTutor.Model.Manager.*;


/****
 * Class StudentModel is a model class for the CSTutor progress and
 * assessment feature. It contains methods for all of the operations defined
 * for Student users, including retrieving data from the database.
 * @author Erica Solum (esolum@calpoly.edu)
 *
 */
public class StudentModel
{
    /** List of tutorials the student user has access to */
    private JList<ScoredTutorialTrack> tutorialList;
    /** List of classes the student User is enrolled in */
    private JList<Class> classList;
    /** Tree containing the classes and their tutorials */
    private JTree tree;
    
    public StudentModel()
    {
        retrieveClassesData();
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
        
        ArrayList<CSTutor.Model.Manager.Class> managerClassList = (ArrayList<CSTutor.Model.Manager.Class>)TutorDB.getClasses();
        
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Classes");
        
        for(CSTutor.Model.Manager.Class thisClass: managerClassList)
        {
            DefaultMutableTreeNode classNode = new DefaultMutableTreeNode(thisClass);
            ArrayList<Section> sections = (ArrayList<Section>)TutorDB.getSections(thisClass);
            for(Section thisSection: sections)
            {
                ArrayList<Unit> units = (ArrayList<Unit>) TutorDB.getUnits(thisSection);
                for(Unit thisUnit: units)
                {
                    ArrayList<CSTutor.Model.Manager.Tutorial> tutorials = (ArrayList<CSTutor.Model.Manager.Tutorial>) TutorDB.getTutorials(thisUnit);
                    for(CSTutor.Model.Manager.Tutorial thisTutorial: tutorials)
                    {
                        FullStudentTutorial tut = new FullStudentTutorial(thisTutorial);
                        DefaultMutableTreeNode tutorialNode = new DefaultMutableTreeNode(tut);
                        classNode.add(tutorialNode);
                    }
                }
            }
            top.add(classNode);
        }
        tree = new JTree(top);
        tree.putClientProperty("JTree.lineStyle", "None");
    }
    
    /**
     * Returns the JList filled with tutorial data.
     */
    public JList<ScoredTutorialTrack> getTutorialList()
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
     * Search for a class or tutorial with a similar title.
     */
    public JList<Object> search(String searchString)
    {
        return null;
    }
    
    /**
     * Returns the original JTree containing every class and their tutorials.
     */
    public JTree getTree()
    {
        return tree;
    }

}
