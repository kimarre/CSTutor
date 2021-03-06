package CSTutor.View.Progress;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CSTutor.Model.Progress.*;

/****
 * Class MainContent is the JPanel where information about the item selected
 * in the side bar is displayed.
 * @author Erica Solum
 * @version 13Apr15
 */
public class MainContent extends JPanel
{
    /** Width of the section */
    private final int width = 750;
    /** Height of the section */
    private final int height = 550;
    /** Panel for displaying data about a selection */
    private JPanel content;
    /** Title of entity selected */
    private JLabel title;
    /** Panel containing the title */
    private JPanel titlePanel;
    /** Constant for the background color */
    private final Color LIGHT_BLUE = new Color(208, 226, 245);
    
    public MainContent()
    {
        super();
        init();
        
    }
    
    /**
     * Initializes the JPanel with the desired size, background color,
     * and sets the initial title to "Progress". Also creates separators between
     * the title and the content below.
     */
    public void init()
    {   
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setBackground(LIGHT_BLUE);
        setVisible(true);
        
        titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setMinimumSize(new Dimension(width, 50));
        titlePanel.setPreferredSize(new Dimension(width,50));
        titlePanel.setMaximumSize(new Dimension(width, 50));
        titlePanel.setBackground(LIGHT_BLUE);
        titlePanel.add(Box.createHorizontalStrut(30));
        
        title = new JLabel(new String("Progress"));
        title.setFont(new Font("Avenir", Font.PLAIN, 30));
        title.setVisible(true);
        titlePanel.add(title);
        this.add(titlePanel);
        
        JPanel separatorPanel = new JPanel();
        separatorPanel.setLayout(new BoxLayout(separatorPanel, BoxLayout.X_AXIS));
        separatorPanel.setBackground(LIGHT_BLUE);
        separatorPanel.add(Box.createHorizontalStrut(30));
        separatorPanel.setPreferredSize(new Dimension(width, 2));
        separatorPanel.setMinimumSize(new Dimension(width, 2));
        separatorPanel.setMaximumSize(new Dimension(width, 2));
        
        JLabel line = new JLabel();
        line.setPreferredSize(new Dimension(690, 2));
        line.setMinimumSize(new Dimension(690, 2));
        line.setMaximumSize(new Dimension(690, 2));
        line.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        separatorPanel.add(line);
        separatorPanel.add(Box.createHorizontalGlue());
        
        this.add(separatorPanel);
        this.add(Box.createVerticalStrut(15));
        
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(LIGHT_BLUE);
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        this.add(content);
    }
    
    /**
     * Deletes all content in the MainContent JPanel.
     */
    public void eraseContent()
    {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Changes the header to the provided text.
     */
    public void setTitleText(String text)
    {
         title.setText(text);
         this.revalidate();
         this.repaint();
    }
    
    /**
     * Displays the provided class' statistics in the content JPanel.
     * @param cl   selected class 
     */
    public void displayClassStatistics(CSTutor.Model.Progress.Class cl)
    {
        content.removeAll(); 
        JButton section1 = new JButton("Section 1");
        JButton section3 = new JButton("Section 3");
        JButton section5 = new JButton("Section 5");
        
        final JPanel studentListPanel = new JPanel();
        studentListPanel.setLayout(new BoxLayout(studentListPanel, BoxLayout.Y_AXIS));
        studentListPanel.setBackground(LIGHT_BLUE);
        
        section1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                studentListPanel.removeAll();
            }
        });
        
        section3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                studentListPanel.removeAll();
            }
        });
        
        section5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                studentListPanel.removeAll();
            }
        });
        
        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.X_AXIS));
        sectionPanel.setPreferredSize(new Dimension(width, 30));
        sectionPanel.setMinimumSize(new Dimension(width, 30));
        sectionPanel.setMaximumSize(new Dimension(width, 30));
        sectionPanel.setBackground(LIGHT_BLUE);
        sectionPanel.add(Box.createHorizontalStrut(20));
        sectionPanel.add(section1);
        sectionPanel.add(Box.createHorizontalStrut(20));
        sectionPanel.add(section3);
        sectionPanel.add(Box.createHorizontalStrut(20));
        sectionPanel.add(section5);
        
        content.add(sectionPanel);
        JLabel studentTitle = new JLabel("Students");
        studentTitle.setFont(new Font("Avenir", Font.PLAIN, 20));
        studentTitle.setBackground(LIGHT_BLUE);
        
        
        JPanel studentTitlePanel = new JPanel();
        studentTitlePanel.setLayout(new BoxLayout(studentTitlePanel, BoxLayout.X_AXIS));
        studentTitlePanel.setBackground(LIGHT_BLUE);
        studentTitlePanel.setPreferredSize(new Dimension(width, 50));
        studentTitlePanel.setMinimumSize(new Dimension(width, 50));
        studentTitlePanel.setMaximumSize(new Dimension(width, 50));
        
        studentTitlePanel.add(Box.createHorizontalStrut(20));
        studentTitlePanel.add(studentTitle);
        content.add(studentTitlePanel);
        content.add(studentListPanel);
        
        JPanel studentPanel = new JPanel();
        studentPanel.setBackground(LIGHT_BLUE);
        studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
        String[] students = new String[] {"Maria Auxier", "Marian Bell", "Eugene Brown",
                "Jamie Bryant","Danielle Carter", "Vernon Chilton", "Mary Clark", 
                "Laurie Crawford", "Geoffrey Dunning", "Lester Flores", "Suzanne Gridley", 
                "Bruce Griffin", "Jennifer Headrick", "Kevin Hoover", "Constance Jackson",
                "Chris Kapp", "Leon Lewis", "Victor Massey", "Blanche Natal",
                "Dianne Ohara", "Charlotte Perry", "Eric Prince", "Frank Reed",
                "Nicole Rios", "David Rodriguez", "James Scott", "Robert Taylor",
                "Anna Turley", "James Welsh", "Marlene Williams"};
        
        for(String st: students)
        {
            JLabel label = new JLabel(st);
            label.setFont(new Font("Avenir", Font.PLAIN, 16));
            label.setBackground(LIGHT_BLUE);
            studentPanel.add(label);
        }
        JPanel studentXDir = new JPanel();
        studentXDir.setLayout(new BoxLayout(studentXDir, BoxLayout.X_AXIS));
        studentXDir.setBackground(LIGHT_BLUE);
        studentXDir.add(Box.createHorizontalStrut(25));
        
        JScrollPane studentScroll = new JScrollPane(studentPanel);
        studentScroll.setBackground(LIGHT_BLUE);
        studentXDir.add(studentScroll);
        content.add(studentXDir);
    }
    
    /**
     * Displays the provided student's statistics in the content JPanel.
     * @param student
     */
    public void displayStudentStatistics(Student student)
    {
        content.removeAll();
        ArrayList<CSTutor.Model.Progress.Class> enCls = student.getEnrolledClasses();
        
        JPanel enrolledTitlePanel = new JPanel();
        enrolledTitlePanel.setLayout(new BoxLayout(enrolledTitlePanel, BoxLayout.X_AXIS));
        enrolledTitlePanel.setMinimumSize(new Dimension(width, 45));
        enrolledTitlePanel.setPreferredSize(new Dimension(width,45));
        enrolledTitlePanel.setMaximumSize(new Dimension(width, 45));
        enrolledTitlePanel.setBackground(LIGHT_BLUE);
        enrolledTitlePanel.add(Box.createHorizontalStrut(35));
        
        JLabel title = new JLabel(new String("Enrolled Classes"));
        title.setFont(new Font("Avenir", Font.PLAIN, 22));
        title.setVisible(true);
        enrolledTitlePanel.add(title);
        
        content.add(enrolledTitlePanel);
        
        
        JPanel separatorPanel = new JPanel();
        separatorPanel.setLayout(new BoxLayout(separatorPanel, BoxLayout.X_AXIS));
        separatorPanel.setBackground(LIGHT_BLUE);
        separatorPanel.add(Box.createHorizontalStrut(35));
        separatorPanel.setPreferredSize(new Dimension(width, 2));
        separatorPanel.setMinimumSize(new Dimension(width, 2));
        separatorPanel.setMaximumSize(new Dimension(width, 2));
        
        JLabel line = new JLabel();
        line.setPreferredSize(new Dimension(685, 2));
        line.setMinimumSize(new Dimension(685, 2));
        line.setMaximumSize(new Dimension(685, 2));
        line.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        separatorPanel.add(line);
        separatorPanel.add(Box.createHorizontalGlue());
        content.add(separatorPanel);
        content.add(Box.createVerticalStrut(15));
        
        JPanel overall = new JPanel();
        overall.setLayout(new BoxLayout(overall, BoxLayout.Y_AXIS));
        overall.setBackground(LIGHT_BLUE);
        
        
        JScrollPane scroll = new JScrollPane(overall);
        scroll.setBackground(LIGHT_BLUE);
        JPanel classPanel = new JPanel();
        classPanel.setLayout(new BoxLayout(classPanel, BoxLayout.Y_AXIS));
        classPanel.setBackground(LIGHT_BLUE);
        //classPanel.add(Box.createVerticalStrut(15));
        
        for(int i=0; i<enCls.size(); i++)
        {
            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
            tempPanel.setBackground(LIGHT_BLUE);
            tempPanel.add(Box.createHorizontalStrut(35));
            
            JLabel tempLabel = new JLabel(enCls.get(i).toString());
            //tempLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            tempLabel.setFont(new Font("Avenir", Font.PLAIN, 20));

            tempPanel.add(tempLabel);
            tempPanel.add(Box.createHorizontalGlue());
            classPanel.add(tempPanel);
        }
        content.add(classPanel);
        content.add(Box.createVerticalGlue());

        
    }
    
    /**
     * Displays the provided tutorial's statistics in the content JPanel.
     * @param tutorial
     */
    public void displayTutorialStatistics(ScoredTutorialTrack tutorial)
    {
        content.removeAll();
        content.setBackground(LIGHT_BLUE);
        
        if(tutorial.hasQuizzes())
        {
            String[] colNames = new String[tutorial.getNumQuizzes() + 2];
            colNames[0] = new String("Student");
            colNames[colNames.length - 1] = new String("Status");
            for(int i=1; (i-1) < tutorial.getNumQuizzes(); i++)
            {
                colNames[i] = tutorial.getQuizName(i-1);
            }
            String[] studentNames = tutorial.getStudents();
            Object[][] data = new Object[studentNames.length][colNames.length];
            int[][] quizScores = tutorial.getQuizScores();
            
            
            for(int row = 0; row < studentNames.length; row++)
            {
                for(int col = 0; col < colNames.length; col++)
                { 
                    if(col == 0)
                    {
                        data[row][col] = studentNames[row];
                    }
                    else if(col != 0 && col != (colNames.length - 1))
                    {
                        data[row][col] = quizScores[row][col-1];
                    }
                    else
                    {
                        int completionVal = (int) (Math.random()*2);
                        if(completionVal == 0)
                        {
                            data[row][col] = new String("NOT COMPLETED");
                        }
                        else
                        {
                            data[row][col] = new String("COMPLETED");
                        }
                        
                    }
                }
            }
            
            JPanel graphPanel = new JPanel();
            JPanel axisPanel = new JPanel();
            JPanel overallPanel = new JPanel();
            overallPanel.setLayout(new BoxLayout(overallPanel, BoxLayout.Y_AXIS));
            overallPanel.setBackground(LIGHT_BLUE);
            
            graphPanel.setLayout(new BoxLayout(graphPanel, BoxLayout.X_AXIS));
            graphPanel.setVisible(true);
            graphPanel.setBackground(LIGHT_BLUE);
            
            axisPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK));
            axisPanel.setPreferredSize(new Dimension(400, 250));
            axisPanel.setMinimumSize(new Dimension(400, 250));
            axisPanel.setMaximumSize(new Dimension(400, 250));
            axisPanel.setVisible(true); 
            
            BarGraph graph = new BarGraph(400, 250, tutorial.getAverageQuizScores());
            graph.setVisible(true);
            axisPanel.add(graph);
            
            JLabel yAxisLabel = new JLabel("Average Quiz Score");
            yAxisLabel.setUI(new VerticalLabelUI(false));
            yAxisLabel.setFont(new Font("Avenir", Font.PLAIN, 14));
            
            JLabel zeroLabel = new JLabel("0");
            zeroLabel.setFont(new Font("Avenir", Font.PLAIN, 12));
            zeroLabel.setAlignmentX(RIGHT_ALIGNMENT);
            
            JLabel dashLabel1 = new JLabel("-");
            dashLabel1.setAlignmentX(RIGHT_ALIGNMENT);
            
            JLabel twentyfiveLabel = new JLabel("25");
            twentyfiveLabel.setFont(new Font("Avenir", Font.PLAIN, 12));
            twentyfiveLabel.setAlignmentX(RIGHT_ALIGNMENT);
            
            JLabel dashLabel2 = new JLabel("-");
            dashLabel2.setAlignmentX(RIGHT_ALIGNMENT);
            
            JLabel fiftyLabel = new JLabel("50");
            fiftyLabel.setFont(new Font("Avenir", Font.PLAIN, 12));
            fiftyLabel.setAlignmentX(RIGHT_ALIGNMENT);
            
            JLabel dashLabel3 = new JLabel("-");
            dashLabel3.setAlignmentX(RIGHT_ALIGNMENT);
            
            JLabel seventyfiveLabel = new JLabel("75");
            seventyfiveLabel.setFont(new Font("Avenir", Font.PLAIN, 12));
            seventyfiveLabel.setAlignmentX(RIGHT_ALIGNMENT);
            
            JLabel dashLabel4 = new JLabel("-");
            dashLabel4.setAlignmentX(RIGHT_ALIGNMENT);
            
            
            JLabel hundredLabel = new JLabel("100");
            hundredLabel.setFont(new Font("Avenir", Font.PLAIN, 12));
            hundredLabel.setAlignmentX(RIGHT_ALIGNMENT);
            
            JPanel vertLabels = new JPanel();
            vertLabels.setLayout(new BoxLayout(vertLabels, BoxLayout.Y_AXIS));
            vertLabels.setBackground(LIGHT_BLUE);
            vertLabels.setPreferredSize(new Dimension(30, 250));
            vertLabels.setMinimumSize(new Dimension(30, 250));
            vertLabels.setMaximumSize(new Dimension(30, 250));
            vertLabels.add(hundredLabel);
            vertLabels.add(Box.createVerticalGlue());
            vertLabels.add(dashLabel1);
            vertLabels.add(Box.createVerticalGlue());
            vertLabels.add(seventyfiveLabel);
            vertLabels.add(Box.createVerticalGlue());
            vertLabels.add(dashLabel2);
            vertLabels.add(Box.createVerticalGlue());
            vertLabels.add(fiftyLabel);
            vertLabels.add(Box.createVerticalGlue());
            vertLabels.add(dashLabel3);
            vertLabels.add(Box.createVerticalGlue());
            vertLabels.add(twentyfiveLabel);
            vertLabels.add(Box.createVerticalGlue());
            vertLabels.add(dashLabel4);
            vertLabels.add(Box.createVerticalGlue());
            vertLabels.add(zeroLabel);
            
            
            JPanel quizLabels = new JPanel();
            quizLabels.setLayout(new BoxLayout(quizLabels, BoxLayout.X_AXIS));
            quizLabels.setBackground(LIGHT_BLUE);
            quizLabels.setPreferredSize(new Dimension(400, 15));
            quizLabels.setMinimumSize(new Dimension(400, 15));
            quizLabels.setMaximumSize(new Dimension(400, 15));
            quizLabels.add(Box.createHorizontalStrut(15));
            for(int i= 0; i< tutorial.getNumQuizzes(); i++)
            {
                JLabel quizLabel = new JLabel(tutorial.getQuizName(i));
                quizLabel.setFont(new Font("Avenir", Font.PLAIN, 9));
                quizLabels.add(quizLabel);
                if((i+1) != tutorial.getNumQuizzes())
                {
                    quizLabels.add(Box.createHorizontalGlue());
                }
                else
                {
                    quizLabels.add(Box.createHorizontalStrut(15));
                }
            }
            
            /*JLabel quiz1 = new JLabel("Quiz 1");
            JLabel quiz2 = new JLabel("Quiz 2");
            JLabel quiz3 = new JLabel("Quiz 3");
            JLabel quiz4 = new JLabel("Quiz 4");
            JLabel quiz5 = new JLabel("Quiz 5");
            
            JPanel quizLabels = new JPanel();
            quizLabels.setLayout(new BoxLayout(quizLabels, BoxLayout.X_AXIS));
            quizLabels.setPreferredSize(new Dimension(400, 15));
            quizLabels.setMinimumSize(new Dimension(400, 15));
            quizLabels.setMaximumSize(new Dimension(400, 15));
            quizLabels.add(Box.createHorizontalGlue());
            quizLabels.add(quiz1);
            quizLabels.add(Box.createHorizontalGlue());
            quizLabels.add(quiz2);
            quizLabels.add(Box.createHorizontalGlue());
            quizLabels.add(quiz3);
            quizLabels.add(Box.createHorizontalGlue());
            quizLabels.add(quiz4);
            quizLabels.add(Box.createHorizontalGlue());
            quizLabels.add(quiz5);
            quizLabels.add(Box.createHorizontalGlue());
            */
            
            
            graphPanel.add(yAxisLabel);
            graphPanel.add(vertLabels);
            graphPanel.add(axisPanel);
            
            
            overallPanel.add(graphPanel);
            overallPanel.add(quizLabels);
            
            content.add(overallPanel);
            content.add(Box.createVerticalStrut(15));
            
            JTable table = new JTable(data, colNames);
            
            JPanel tablePanel = new JPanel();
            tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));
            tablePanel.setBackground(LIGHT_BLUE);
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            tablePanel.add(Box.createHorizontalStrut(30));
            tablePanel.add(scrollPane);
            tablePanel.add(Box.createHorizontalStrut(30));
            
            content.add(tablePanel);
            
            content.add(Box.createVerticalStrut(15));
            
            
            
            
            //content.add(scrollPane);
        }
        else
        {
            System.out.println("No quiz data to display");
            JPanel noQuizDataPanel = new JPanel();
            noQuizDataPanel.setLayout(new BoxLayout(noQuizDataPanel, BoxLayout.X_AXIS));
            noQuizDataPanel.setBackground(new Color(208, 226, 245));
            noQuizDataPanel.setVisible(true);
            JLabel message = new JLabel("No quiz data to display.");
            message.setFont(new Font("Avenir", Font.PLAIN, 20));
            message.setVisible(true);
            message.setBackground(new Color(208, 226, 245));
            
            noQuizDataPanel.add(message);
            
            content.add(Box.createVerticalStrut(20));
            content.add(noQuizDataPanel);
            
        }
        
        this.revalidate();
        this.repaint(); 
    }
    
    /**
     * Contains the UI code for placing the Refresh Button.
     * @param button
     */
    public void sendRefreshButton(JButton button)
    {
        button.setMinimumSize(new Dimension(100, 25));
        button.setPreferredSize(new Dimension(100,25));
        button.setMaximumSize(new Dimension(100, 25));
        titlePanel.add(Box.createHorizontalGlue());
        titlePanel.add(button);
        titlePanel.add(Box.createHorizontalStrut(30));
    }
    
    /**
     * Displays the information for the given tutorial to
     * be viewed by a Student user. 
     * @param tutorial
     */
    public void displayStudentUI(FullStudentTutorial tutorial)
    {
        setTitleText("Tutorial Progress");
        content.removeAll();
        
        JPanel progressPanel = new JPanel();
        progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.X_AXIS));
        progressPanel.setMinimumSize(new Dimension(width, 75));
        progressPanel.setPreferredSize(new Dimension(width, 75));
        progressPanel.setMaximumSize(new Dimension(width, 75));
        progressPanel.setBackground(LIGHT_BLUE);
        
        ProgressBar bar = new ProgressBar(400, 26, tutorial.getNumberOfPagesSeen(), tutorial.getNumberOfPages());
        bar.setVisible(true);
        progressPanel.add(Box.createHorizontalStrut(30));
        progressPanel.add(bar);
        int percentage = (int)(((double)tutorial.getNumberOfPagesSeen())/((double)tutorial.getNumberOfPages()) * 100);
        JLabel label = new JLabel(new String(percentage + "% complete"));
        label.setFont(new Font("Avenir", Font.PLAIN, 12));
        label.setBackground(LIGHT_BLUE);
        progressPanel.add(Box.createHorizontalStrut(10));
        progressPanel.add(label);
        
        content.add(progressPanel);
        
        JPanel quizPanel = new JPanel();
        quizPanel.setLayout(new BoxLayout(quizPanel, BoxLayout.Y_AXIS));
        quizPanel.setBackground(LIGHT_BLUE);
        
        
        
        JPanel quizTitlePanel = new JPanel();
        quizTitlePanel.setLayout(new BoxLayout(quizTitlePanel, BoxLayout.X_AXIS));
        quizTitlePanel.setMinimumSize(new Dimension(width, 45));
        quizTitlePanel.setPreferredSize(new Dimension(width,45));
        quizTitlePanel.setMaximumSize(new Dimension(width, 45));
        quizTitlePanel.setBackground(LIGHT_BLUE);
        quizTitlePanel.add(Box.createHorizontalStrut(30));
        
        JLabel title = new JLabel(new String("Quiz Scores"));
        title.setFont(new Font("Avenir", Font.PLAIN, 25));
        title.setVisible(true);
        quizTitlePanel.add(title);
        
        quizPanel.add(quizTitlePanel);
        
        
        JPanel separatorPanel = new JPanel();
        separatorPanel.setLayout(new BoxLayout(separatorPanel, BoxLayout.X_AXIS));
        separatorPanel.setBackground(LIGHT_BLUE);
        separatorPanel.add(Box.createHorizontalStrut(30));
        separatorPanel.setPreferredSize(new Dimension(width, 2));
        separatorPanel.setMinimumSize(new Dimension(width, 2));
        separatorPanel.setMaximumSize(new Dimension(width, 2));
        
        JLabel line = new JLabel();
        line.setPreferredSize(new Dimension(690, 2));
        line.setMinimumSize(new Dimension(690, 2));
        line.setMaximumSize(new Dimension(690, 2));
        line.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        separatorPanel.add(line);
        separatorPanel.add(Box.createHorizontalGlue());
        quizPanel.add(separatorPanel);
        
        
        if(tutorial.hasQuizzes())
        {
            String[] colNames = {"Name", "Points", "Performance"};
            Object[][] data = new Object[tutorial.getNumberOfQuizzes()][colNames.length];
            
            
            for(int row = 0; row < tutorial.getNumberOfQuizzes(); row++)
            {
                for(int col=0; col<colNames.length; col++)
                {
                    if(col == 0)
                    {
                        data[row][col] = tutorial.getQuizName(row);
                    }
                    else if(col == 1)
                    {
                        data[row][col] = new String(tutorial.getScoreForQuiz(row) + "/" + tutorial.getNumQuestionsInQuiz(row));
                    }
                    else
                    {
                        data[row][col] = new String(" ");
                    }
                }
            }
            
            JTable table = new JTable(data, colNames);
            
            JPanel tablePanel = new JPanel();
            tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));
            tablePanel.setBackground(LIGHT_BLUE);
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            tablePanel.add(Box.createHorizontalStrut(30));
            tablePanel.add(scrollPane);
            tablePanel.add(Box.createHorizontalStrut(30));
            quizPanel.add(Box.createVerticalStrut(15));
            quizPanel.add(tablePanel);
        }
        else
        {
            JPanel noQuizPanel = new JPanel();
            noQuizPanel.setLayout(new BoxLayout(noQuizPanel, BoxLayout.X_AXIS));
            noQuizPanel.setBackground(LIGHT_BLUE);
            noQuizPanel.add(Box.createHorizontalStrut(40));
            JLabel noQuizLabel = new JLabel("No quizzes available.");
            noQuizLabel.setFont(new Font("Avenir", Font.PLAIN, 16));
            noQuizLabel.setBackground(LIGHT_BLUE);
            noQuizPanel.add(noQuizLabel);
            quizPanel.add(Box.createVerticalStrut(30));
            quizPanel.add(noQuizPanel);
        }
        content.add(Box.createVerticalStrut(30));
        content.add(quizPanel); 
        content.add(Box.createVerticalStrut(15));
        content.add(Box.createVerticalGlue());
    }
}
