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

public class Overview extends JFrame {
    private JMenuBar jMenuBar;
    private JMenu jMenuHome;
    private JMenu jMenuTutorials;
    private JMenu jMenuQuizzes;
    private JMenu jMenuProgress;
    private JMenu jMenuLogin;
    private JMenu jMenuProfile;
    private JMenuItem myTuts;
    private JMenuItem createTuts;
    private JMenuItem myQuiz;
    private JMenuItem createQuiz;
    private JMenuItem profile;
    private JMenuItem logout;
    private JMenuItem admin;
    private Login login;
    private JPanel mainPanel;
    private JPanel mainTop;
    private JPanel insideTop;
    private ChatBar chatBar;
    private JLabel userInfo;
    public User user;
    public Tutorial tutorial;
    private static int INSTRUCTOR_ACCESS = 2;
    private static int STUDENT_ACCESS = 1;

    /**
     * The programs main class.
     *
     * @param args Any arguments passed in at runtime.
     */
    public static void main(String[] args) {
        new Overview();
    }

    /**
     * The constructor for the Overview class.
     */
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
    }

    /**
     * initializes all of the components for the Overview frame.
     */
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
        profile = new JMenuItem();
        logout = new JMenuItem();
        admin = new JMenuItem();
        createQuiz = new JMenuItem();
        userInfo = new JLabel();


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
        jMenuBar.add(new JSeparator(SwingConstants.VERTICAL));
        userInfo.setText("     You are currently a Guest.     ");
        jMenuBar.add(userInfo);
        jMenuBar.add(new JSeparator(SwingConstants.VERTICAL));
        jMenuBar.add(jMenuLogin);
        
        setJMenuBar(jMenuBar);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Launches the login dialog.
     *
     * @param evt A mouse click.
     */
    private void LoginAction(java.awt.event.MouseEvent evt) {                             
        login = new Login(this);
        login.setVisible(true);
    }

    /**
     * Launches the profile dialog.
     *
     * @param evt A mouse click.
     */
    private void ProfileAction(java.awt.event.ActionEvent evt) {
        (new Profile(user)).setVisible(true);
    }

    /**
     * Launches the Admin Panel dialog.
     *
     * @param evt A mouse click.
     */
    private void AdminAction(java.awt.event.ActionEvent evt) {
        (new AdminPanel()).setVisible(true);
    }

    /**
     * Changes the Manager state back to the guest state
     *
     * @param evt A mouse click.
     */
    private void LogoutAction(java.awt.event.ActionEvent evt) {
        user = null;
        userInfo.setText("     You are currently a Guest.     ");
        jMenuBar.remove(jMenuProfile);
        jMenuBar.add(jMenuLogin);
        jMenuProgress.removeMouseListener(jMenuProgress.getMouseListeners()[2]);
        jMenuProgress.setEnabled(false);
        jMenuTutorials.remove(createTuts);
        jMenuQuizzes.remove(createQuiz);
        jMenuLogin.remove(logout);
        jMenuLogin.remove(profile);
        jMenuLogin.remove(admin);
        chatBar.disableButtons();
        jMenuBar.revalidate();
        jMenuBar.repaint();
        revalidate();
        repaint();
    }

    /**
     * Creates a new instance of the Manager screen and displays it when Home is selected from the menu.
     *
     * @param evt A mouse click.
     */
    private void HomeAction(java.awt.event.MouseEvent evt) {
        mainTop.remove(0);
        mainTop.add(new ManagerGUI(), "Manager", 0);
        pack();
        revalidate();
        repaint();
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Manager");
    }

    /**
     * Creates a new instance of the Tutorial screen and displays it when My Tutorials is selected from the menu.
     *
     * @param evt A mouse click.
     */
    private void MyTutorialAction(java.awt.event.ActionEvent evt) {
        tutorial.initRoadmapContent();
        // roadmapList.setSelectedIndex(1);
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Student Tutorial");
    }

    /**
     * Creates a new instance of the Tutorial Creator screen and displays it when Create Tutorial is selected from the menu.
     *
     * @param evt A mouse click.
     */
    private void CreateTutorialAction(java.awt.event.ActionEvent evt) {
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Tutorial");
    }

    /**
     * Creates a new instance of the Quiz screen and displays it when Quiz is selected from the menu.
     *
     * @param evt A mouse click.
     */
    private void QuizAction(java.awt.event.ActionEvent evt) {
        mainTop.remove(4);
        mainTop.add(new QuizBuildGUI(), "Quiz", 4);
        pack();
        revalidate();
        repaint();
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Quiz");
    }

    /**
     * Creates a new instance of the Progress screen and displays it when Progress is selected from the menu.
     *
     * @param evt A mouse click.
     */
    private void ProgressAction(java.awt.event.MouseEvent evt) {
        mainTop.remove(1);
        if(user.isInstructor()) {
            mainTop.add(new Progress(INSTRUCTOR_ACCESS).getView(), "Progress", 1);
        } else {
            mainTop.add(new Progress(STUDENT_ACCESS).getView(), "Progress", 1);
        }
        pack();
        revalidate();
        repaint();
        ((CardLayout)(mainTop.getLayout())).show(mainTop, "Progress");
    }

    /**
     * What to do when a user is logged in. Changes the state of the overview frame to reflect the change in login state.
     */
    public void LoggedIn()
    {

        jMenuProfile = new JMenu();
        userInfo.setText("     You are currently logged in as " + user.getName() + ".     ");
        jMenuBar.remove(jMenuLogin);

        jMenuProfile.setText("Profile");
        profile.setText("My Profile");
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileAction(evt);
            }
        });
        jMenuProfile.add(profile);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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

            admin.setText("Admin Panel");
            admin.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AdminAction(evt);
                }
            });
            jMenuProfile.add(admin);
        }

        jMenuProfile.add(logout);
        jMenuBar.add(jMenuProfile);
        jMenuBar.revalidate();
        jMenuBar.repaint();
        revalidate();
        repaint();
    }
}
