/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSTutor.View.Chat;

import CSTutor.Model.Chat.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Simon Vurens
 */
public class Online extends JFrame{

    JList<String> listbox;
    JPopupMenu rightClick;
    JFrame selfRef = this;
    Student student;

    public void init()
    {
        JPanel overallPanel = new JPanel();
        JMenuItem menuOption1 = new JMenuItem("Private Message");
        JMenuItem menuOption2 = new JMenuItem("View Session");
        JMenuItem menuOption3 = new JMenuItem("Share Session");
        rightClick = new JPopupMenu("Menu");
        rightClick.add(menuOption1);
        rightClick.add(menuOption2);
        rightClick.add(menuOption3);

        String  listData[] = { "Student 1","Student 2","Student 3","Student 4" };
        listbox = new JList<String>( listData );

        listbox.addMouseListener( new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if ( SwingUtilities.isRightMouseButton(e) )
                {
                    listbox.setSelectedIndex(getRow(e.getPoint()));
                    rightClick.show(selfRef, e.getX(), e.getY());
                }
            }
        });
        menuOption1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                student.requestPrivateMessage();
   		    }
        });
        menuOption2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	student.requestScreenSharing();
   		    }
        });
        menuOption3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	student.inviteScreenSharing();
   		    }
        });
            

        listbox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        overallPanel.add(rightClick);
        overallPanel.add(listbox);
        add(overallPanel);
        listbox.setVisible(true);
        listbox.setFocusable(false);
        this.pack();
    }



    private int getRow(Point point)
    {
        return listbox.locationToIndex(point);
    }


    /**
     * Creates new form Online
     */
    public Online(Student student) {
        init();
        setVisible(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.student = student;
    }


    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        jInternalFrame1.setVisible(!jInternalFrame1.isVisible());
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
