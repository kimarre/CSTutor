
package CSTutor.View.Chat;

import CSTutor.Model.Chat.*;
import CSTutor.Model.Chat.Server.ServerIF;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Simon Vurens Stephen Daily
 */
public class ChatBox extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	ChatOverlay chatOverlay;
    JTextArea msgArea;
    JTextArea displayArea;
    JFrame selfRef = this;
	
    /**
     * Creates new form ChatBox
     * @throws NotBoundException 
     * @throws RemoteException 
     * @throws MalformedURLException 
     */
    public ChatBox(ChatOverlay CW) {
        initComponents();
        
        this.chatOverlay = CW;
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
   			 if (chatOverlay.Enter(msgArea.getText())) {
   				 chatOverlay.pushText(msgArea.getText());
   				 msgArea.setText("");
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
   	 displayArea.setText("");
   	 overallPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
   	 overallPanel.add(sendPanel, BorderLayout.SOUTH);
   	 add(overallPanel);
     setVisible(false);
     setDefaultCloseOperation(HIDE_ON_CLOSE);
     setTitle("Chat");
     this.setResizable(false);
       // pack();
    }// </editor-fold>//GEN-END:initComponents
    
  	 public void updateConsole() {
   		 displayArea.append(chatOverlay.getLastString());
   	 }

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
