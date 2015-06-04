
package CSTutor.View.Chat;

import CSTutor.Model.Chat.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.awt.*;
import java.net.MalformedURLException;

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
    
    private static final String TEXT_SUBMIT = "text-submit";
    private static final String INSERT_BREAK = "insert-break";
	
    /**
     * Creates new form ChatBox
     * @throws NotBoundException 
     * @throws RemoteException 
     * @throws MalformedURLException 
     */
    public ChatBox(ChatOverlay CW) {
        initComponents();
        
        this.chatOverlay = CW;
        this.setVisible(false);
        this.setSize(400, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("serial")
	private void initComponents() {
   	 JPanel overallPanel = new JPanel();
   	 overallPanel.setLayout(new BorderLayout());
   	 JPanel sendPanel = new JPanel();
   	 JButton enterBut = new JButton("Enter");
   	 
   	 enterBut.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e) {
   			handleInput();
   		 }
   	 });
   	 
   	 
   	 
     msgArea = new JTextArea();
  	 msgArea.setLineWrap(true);
  	 msgArea.setWrapStyleWord(true);
  	 
  	InputMap input = msgArea.getInputMap();
    KeyStroke enter = KeyStroke.getKeyStroke("ENTER");
    KeyStroke shiftEnter = KeyStroke.getKeyStroke("shift ENTER");
    input.put(shiftEnter, INSERT_BREAK);  // input.get(enter)) = "insert-break"
    input.put(enter, TEXT_SUBMIT);

    ActionMap actions = msgArea.getActionMap();
    actions.put(TEXT_SUBMIT, new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	handleInput();
        }
    });
  	 
  	 sendPanel.setLayout(new BoxLayout(sendPanel, BoxLayout.X_AXIS));
  	 sendPanel.add(new JScrollPane(msgArea));
  	 sendPanel.add(enterBut);
  	 sendPanel.setBorder(new EtchedBorder());
  	 
  	 displayArea = new JTextArea();
  	 displayArea.setEditable(false);
  	 displayArea.setText("");
  	 displayArea.setLineWrap(true);
  	 displayArea.setWrapStyleWord(true);
   	 
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
  	
  	public void handleInput() {
  		if (chatOverlay.Enter(msgArea.getText())) {
			chatOverlay.pushText(msgArea.getText());
			msgArea.setText("");
		}
  	}
  	
    /**
     * @param args the command line arguments
     */
    
}
