package Overview;



import Chat.*;
import Login.*;
import Manager.*;
import Progress.*;
import Tutorial.*;
import Quiz.*;
import javax.swing.*;
import java.awt.*;

public class Overview extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu jMenuHome;
    private JMenu jMenuTutorials;
    private JMenu jMenuQuizzes;
    private JMenu jMenuProgress;
    private JMenu jMenuLogin;
    private JMenuItem myTuts;
    private JMenuItem createTuts;
    private JMenuItem myQuiz;
    private JMenuItem createQuiz;
    private Login login;
    private JPanel mainPanel;
    private JPanel mainTop;
    private JPanel insideTop;
    private JPanel chatBar;
    
    public static void main(String[] args) {
        new Overview();
    }
    public Overview() {
        init();
        mainPanel = new JPanel();
        mainTop = new JPanel(new CardLayout());
        //insideTop = new ManagerGUI();
        chatBar = new ChatBar();
        
        //
        JPanel test = new JPanel();
        test.setSize(300, 100);
    	test.add(new JButton("BOTMENU GOES HERE!!!"));
        //
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        mainTop.add(new ManagerGUI(), "Manager");
        mainTop.add(new InstructorView(), "Progress");
        mainTop.add(new Tutorial(), "Tutorial");
        mainTop.add(new QuizGui(), "Quiz");
        mainPanel.add(mainTop);
        mainPanel.add(chatBar);
        add(mainPanel);
        //add(mainInternal);
        //add(chatBar);
        pack();
        setVisible(true);
    }
   
    private void init()
    {
        jMenuBar = new JMenuBar();
        jMenuHome = new JMenu();
        jMenuTutorials = new JMenu();
        jMenuQuizzes = new JMenu();
        jMenuProgress = new JMenu();
        jMenuLogin = new JMenu();
        myTuts = new JMenuItem();
        createTuts = new JMenuItem();
        myQuiz = new JMenuItem();
        createQuiz = new JMenuItem();
        
        // Home
        jMenuHome.setText("Home");
        jMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeAction(evt);
            }
        });
        jMenuBar.add(jMenuHome);
        
        // Tutorials
        jMenuTutorials.setText("Tutorials");
        jMenuBar.add(jMenuTutorials);
        
        myTuts.setText("My Tutorials");
        myTuts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TutorialAction(evt);
            }
        });
        jMenuTutorials.add(myTuts);
        
        createTuts.setText("Create Tutorial");
        jMenuTutorials.add(createTuts);
        
        // Quizzes
        jMenuQuizzes.setText("Quizzes");
        jMenuBar.add(jMenuQuizzes);
        
        myQuiz.setText("My Quizzes");
        myQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuizAction(evt);
            }
        });
        jMenuQuizzes.add(myQuiz);
        
        createQuiz.setText("Create Quiz");
        jMenuQuizzes.add(createQuiz);
        
        // Progress
        jMenuProgress.setText("Progress");
        jMenuProgress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProgressAction(evt);
            }
        });
        jMenuBar.add(jMenuProgress);
        
        // Login
        jMenuLogin.setText("Login");
        jMenuLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginAction(evt);
            }
        });
        jMenuBar.add(jMenuLogin);
        
        setJMenuBar(jMenuBar);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    private void LoginAction(java.awt.event.MouseEvent evt) {                             
        login = new Login();
        login.setVisible(true);
    } 
    
    private void HomeAction(java.awt.event.MouseEvent evt) {
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Manager");
    }
    
    private void TutorialAction(java.awt.event.ActionEvent evt) { 
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Tutorial");
    }
    
    private void QuizAction(java.awt.event.ActionEvent evt) { 
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Quiz");
    }
    
    private void ProgressAction(java.awt.event.MouseEvent evt) {
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Progress");
        
    }
}
