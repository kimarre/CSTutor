package CSTutor.View;

/**
 * The framework for the CSTutor GUI.
 * @author Kyle Reis
 */



import CSTutor.View.User.*;
import CSTutor.View.Chat.*;
import CSTutor.View.Manager.*;
import CSTutor.Model.Progress.Progress;
import CSTutor.View.Tutorial.*;
import CSTutor.View.Quiz.*;
import CSTutor.Model.User.*;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Overview extends JFrame implements Observer {
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
    private ChatBar chatBar;
    public User user;
    public UserDB userDB;
    private Tutorial tutorial;
    private static int INSTRUCTOR_ACCESS = 2;
    
    public static void main(String[] args) {
        new Overview();
    }
    public Overview() {
        /*
    	try
        {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/

    	try {
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
           ex.printStackTrace();
        } catch (IllegalAccessException ex) {
           ex.printStackTrace();
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           ex.printStackTrace();
        }
        userDB = new UserDB();
        init();
        mainPanel = new JPanel();
        mainTop = new JPanel(new CardLayout());
        chatBar = new ChatBar();
        tutorial = new Tutorial();
        
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        mainTop.add(new ManagerGUI(), "Manager");
        mainTop.add(new Progress(INSTRUCTOR_ACCESS).getView(), "Progress");
        mainTop.add(new CSTutor.View.Tutorial.EditTutorial(), "Tutorial");
        mainTop.add(tutorial, "Student Tutorial");
        mainTop.add(new QuizBuildGUI(), "Quiz");
        mainPanel.add(mainTop);
        mainPanel.add(chatBar);
        add(mainPanel);
        pack();
        setVisible(true);

        System.out.println("Componenets");
        for(Component comp : mainTop.getComponents())
        {
            System.out.println(comp.toString());
        }
    }

    private void addObservables()
    {
        //login.addObserver(this);
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
        myTuts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MyTutorialAction(evt);
            }
        });
        jMenuTutorials.add(myTuts);
        
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
        
        // Progress
        jMenuProgress.setText("Progress");
        jMenuProgress.setEnabled(false);
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
        login = new Login(this);
        login.setVisible(true);
    }

    private void LogoutAction(java.awt.event.MouseEvent evt) {
        user = null;
        jMenuLogin.setText("Login");
        jMenuLogin.removeMouseListener(jMenuLogin.getMouseListeners()[2]);
        jMenuLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginAction(evt);
            }
        });
        jMenuProgress.removeMouseListener(jMenuProgress.getMouseListeners()[2]);
        jMenuProgress.setEnabled(false);
        jMenuTutorials.remove(createTuts);
        jMenuQuizzes.remove(createQuiz);
        chatBar.disableButtons();
        revalidate();
        repaint();
    }
    
    private void HomeAction(java.awt.event.MouseEvent evt) {
        mainTop.remove(0);
        mainTop.add(new ManagerGUI(), "Manager", 0);
        pack();
        revalidate();
        repaint();
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Manager");
    }
    
    private void MyTutorialAction(java.awt.event.ActionEvent evt) {
        mainTop.remove(3);
        mainTop.add(tutorial, "Student Tutorial", 3);
        pack();
        revalidate();
        repaint();
        tutorial.initRoadmapContent(); 
       // roadmapList.setSelectedIndex(1);
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Student Tutorial");
    }
    
    private void CreateTutorialAction(java.awt.event.ActionEvent evt) {
        mainTop.remove(2);
        mainTop.add(new CSTutor.View.Tutorial.EditTutorial(), "Tutorial", 2);
        pack();
        revalidate();
        repaint();
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Tutorial");
    }
    
    private void QuizAction(java.awt.event.ActionEvent evt) {
        mainTop.remove(4);
        mainTop.add(new QuizBuildGUI(), "Quiz", 4);
        pack();
        revalidate();
        repaint();
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Quiz");
    }
    
    private void ProgressAction(java.awt.event.MouseEvent evt) {
        mainTop.remove(1);
        mainTop.add(new Progress(INSTRUCTOR_ACCESS).getView(), "Progress", 1);
        pack();
        revalidate();
        repaint();
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Progress");
    }

    public void LoggedIn()
    {
        jMenuLogin.setText("Logout");
        jMenuLogin.removeMouseListener(jMenuLogin.getMouseListeners()[2]);
        jMenuLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutAction(evt);
            }
        });
        jMenuProgress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProgressAction(evt);
            }
        });
        jMenuProgress.setEnabled(true);
        chatBar.enableButtons();

        if (user.isInstructor())
        {
            createTuts.setText("Create Tutorial");
            createTuts.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    CreateTutorialAction(evt);
                }
            });
            jMenuTutorials.add(createTuts);

            createQuiz.setText("Create Quiz");
            jMenuQuizzes.add(createQuiz);

            revalidate();
            repaint();
        }
    }

    public void update(Observable o, Object arg) {
    }
}
