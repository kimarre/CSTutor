package CSTutor.View.Manager;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import CSTutor.Model.Manager.Class;
import CSTutor.Model.Manager.Section;
import CSTutor.Model.Manager.Unit;

import java.util.*;
/****
 * Class MoveGUI provides the GUI for moving objects.
 * 
 * @author Simon Vurens (svurens@calpoly.edu)
 */
public class MoveGUI extends JFrame{
	public static final int CLASS = 1;
	public static final int SECTION = 2;
	public static final int UNIT = 3;
	public static final int TUTORIAL = 4;
	
	public int selected;
	
	JPanel classPanel;
	JPanel sectPanel;
	JPanel unitPanel;
	JPanel tutPanel;
	JPanel selPanel;
	JComboBox<CSTutor.Model.Manager.Class> classOptions; 
	JComboBox<CSTutor.Model.Manager.Section> sectOptions; 
	JComboBox<CSTutor.Model.Manager.Unit> unitOptions;
    DefaultComboBoxModel<Class> classModel;
    DefaultComboBoxModel<Section> sectModel;
    DefaultComboBoxModel<Unit> unitModel;
	
	public MoveGUI() {
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("Move");
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        classPanel = new JPanel();
        sectPanel = new JPanel();
        unitPanel = new JPanel();
        tutPanel = new JPanel();
        
        addSelections();
        addUpDown();
        addButtons();
        this.pack();
        this.setVisible(false);
	}
	public void passClass() {
		System.out.println("Class is selected");
		selected = CLASS;
		selPanel.removeAll();
		selPanel.add(classPanel);
		selPanel.revalidate();
	}
	public void passSection() {
		System.out.println("Section is selected");
		selected = SECTION;
		JLabel mLabel = new JLabel("Move to: ");
        ArrayList<CSTutor.Model.Manager.Class> classList = ManagerGUI.getClasses();
        classModel.removeAllElements();
        for (Class c : classList) {
        	classModel.addElement(c);
        }
		sectPanel.removeAll();
		sectPanel.add(mLabel);
		sectPanel.add(classOptions);
		selPanel.removeAll();
		selPanel.add(sectPanel);
		selPanel.revalidate();
	}
	public void passUnit() {
		System.out.println("Unit is selected");
		selected = UNIT;
		JLabel mLabel = new JLabel("Move to: ");
        java.util.List<CSTutor.Model.Manager.Section> sectList = ManagerGUI.getSections();

        sectModel.removeAllElements();
        for (Section c : sectList) {
        	sectModel.addElement(c);
        }
		sectPanel.removeAll();
		sectPanel.add(mLabel);
		sectPanel.add(sectOptions);
		selPanel.removeAll();
		selPanel.add(unitPanel);
		selPanel.revalidate();
	}
	public void passTutorial() {
		System.out.println("Tutorial is selected");
		selected = TUTORIAL;
		JLabel mLabel = new JLabel("Move to: ");
        java.util.List<CSTutor.Model.Manager.Unit> unitList = ManagerGUI.getUnits(); 
        unitModel.removeAllElements();
        for (Unit c : unitList) {
        	unitModel.addElement(c);
        }
		sectPanel.removeAll();
		sectPanel.add(mLabel);
		sectPanel.add(unitOptions);
		selPanel.removeAll();
		selPanel.add(tutPanel);
		selPanel.revalidate();
	}
	
	public void addSelections() {
		selPanel = new JPanel();
		sectPanel.setLayout(new BoxLayout(sectPanel, BoxLayout.X_AXIS));
		unitPanel.setLayout(new BoxLayout(unitPanel, BoxLayout.X_AXIS));
		tutPanel.setLayout(new BoxLayout(tutPanel, BoxLayout.X_AXIS));
		JLabel sectLabel = new JLabel("Move to: ");
		JLabel unitLabel = new JLabel("Move to: ");
		JLabel tutLabel = new JLabel("Move to: ");
        java.util.List<CSTutor.Model.Manager.Class> classList = ManagerGUI.getClasses(); 
        java.util.List<CSTutor.Model.Manager.Section> sectList = ManagerGUI.getSections(); 
        java.util.List<CSTutor.Model.Manager.Unit> unitList = ManagerGUI.getUnits();

        classModel = new DefaultComboBoxModel<Class>(classList.toArray(new Class[0]));
        sectModel = new DefaultComboBoxModel<Section>(sectList.toArray(new Section[0]));
        unitModel = new DefaultComboBoxModel<Unit>(unitList.toArray(new Unit[0]));
        
		classOptions = new JComboBox<CSTutor.Model.Manager.Class>(classModel);
		sectOptions = new JComboBox<CSTutor.Model.Manager.Section>(sectModel);
		unitOptions = new JComboBox<CSTutor.Model.Manager.Unit>(unitModel);
		sectPanel.add(sectLabel);
		sectPanel.add(classOptions);
		unitPanel.add(unitLabel);
		unitPanel.add(sectOptions);
		tutPanel.add(tutLabel);
		tutPanel.add(unitOptions);
		
		selPanel.add(classPanel);
		this.add(selPanel);
	}
	public void addUpDown() {
		JPanel udPanel = new JPanel();
		
      JButton upBut = new JButton("Up");
      upBut.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
      	   System.out.println("Up button pressed");
         }
      });
      udPanel.add(upBut);
      
      JButton dBut = new JButton("Down");
      dBut.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
      	   System.out.println("Down button pressed");
         }
      });
      udPanel.add(dBut);
      
      this.add(udPanel);
	}
	
	public void addButtons() {
		JPanel butPanel = new JPanel();
		
        JButton canBut = new JButton("Cancel");
        canBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("Cancel button pressed");
        	   setVisible(false);
           }
        });
        butPanel.add(canBut);
        
        JButton kBut = new JButton("OK");
        kBut.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
        	   System.out.println("OK button pressed");
        	   setVisible(false);
           }
        });
        butPanel.add(kBut);
        
        this.add(butPanel);
	}
}
