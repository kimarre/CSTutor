
package CSTutor.View.Chat;

import CSTutor.Model.Chat.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author Simon Vurens
 */
public class ChatBox extends JFrame {
	
	ChatWindow chatWindow;
    JTextArea msgArea;
    JTextArea displayArea;
    JFrame selfRef = this;
    /**
     * Creates new form ChatBox
     */
    public ChatBox(ChatWindow CW) {
        initComponents();
        
        this.chatWindow = CW;
        this.setVisible(true);
        this.setSize(300, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
   	 JPanel overallPanel = new JPanel();
   	 overallPanel.setLayout(new BorderLayout());
   	 JPanel sendPanel = new JPanel();
   	 JButton enterBut = new JButton("Enter");
   	 
   	 enterBut.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e) {
             if(chatWindow.Enter(msgArea.getText())) {
            	 displayArea.setText("a\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\n");
            	 selfRef.repaint();
             }
   		 }
   	 });
   	 
   	 msgArea = new JTextArea();
   	 
   	 sendPanel.setLayout(new BoxLayout(sendPanel, BoxLayout.X_AXIS));
   	 sendPanel.add(new JScrollPane(msgArea));
   	 sendPanel.add(enterBut);
   	 sendPanel.setBorder(new EtchedBorder());
   	 
   	 displayArea = new JTextArea();
   	 displayArea.setEditable(false);
   	 overallPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
   	 overallPanel.add(sendPanel, BorderLayout.SOUTH);
   	 add(overallPanel);
     setVisible(false);
     setDefaultCloseOperation(HIDE_ON_CLOSE);
     setTitle("Chat");
     this.setResizable(false);
       // pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables
}
