package CSTutor.View.Progress;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.*;

import CSTutor.Model.Progress.*;

/****
 * Class MainContent is the JPanel where information about the item selected
 * in the side bar is displayed.
 * @author Erica Solum
 * @version 13Apr15
 */
public class MainContent extends JPanel
{
    private final int width = 750;
    private final int height = 550;
    private JPanel content;
    private JLabel title;
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
        //setBorder(BorderFactory.createEtchedBorder(1));
        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setBackground(LIGHT_BLUE);
        setVisible(true);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        titlePanel.setMinimumSize(new Dimension(width, 50));
        titlePanel.setPreferredSize(new Dimension(width,50));
        titlePanel.setMaximumSize(new Dimension(width, 50));
        titlePanel.setBackground(LIGHT_BLUE);
        titlePanel.add(Box.createHorizontalStrut(10));
        
        
        
        title = new JLabel(new String("Progress"));
        title.setFont(new Font("Avenir", Font.PLAIN, 30));
        title.setVisible(true);
        //title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(title);
        
        this.add(titlePanel);
        
        
        JPanel linePanel = new JPanel();
        linePanel.setPreferredSize(new Dimension(1000, 1));
        linePanel.setMinimumSize(new Dimension(1000, 1));
        linePanel.setMaximumSize(new Dimension(1000, 1));
        linePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.add(linePanel);
        this.add(Box.createVerticalStrut(15));
        
        content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        //content.setBorder(BorderFactory.createEtchedBorder(1));
        //content.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //content.setMaximumSize(new Dimension(750, 350));
        //content.setPreferredSize(new Dimension(750, 350));
        //content.setMinimumSize(new Dimension(750, 350));
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
        
    }
    
    /**
     * Displays the provided student's statistics in the content JPanel.
     * @param student
     */
    public void displayStudentStatistics(Student student)
    {
        content.removeAll();
        ArrayList<CSTutor.Model.Progress.Class> enCls = student.getEnrolledClasses();
        
        for(int i=0; i<enCls.size(); i++)
        {
            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
            tempPanel.setBackground(LIGHT_BLUE);
            
            JLabel tempLabel = new JLabel(enCls.get(i).toString());
            tempLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            tempLabel.setFont(new Font("Avenir", Font.PLAIN, 20));
            
            
            tempPanel.add(tempLabel);
            tempPanel.add(Box.createHorizontalGlue());
            content.add(tempPanel);
            
            
        }
        
        
        this.revalidate();
        this.repaint();
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
            String[] colNames = {"Student", "Quiz 1", "Quiz 2", "Quiz 3", 
                    "Quiz 4", "Quiz 5", "Status"};
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
                    else if(col != 0 && col != 6)
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
            
            /* BAR GRAPH STUFF */
            
            BarGraph graph = new BarGraph(400, 250, tutorial.getAverageQuizScores());
            graph.setVisible(true);
            axisPanel.add(graph);
            
            
            
            
            JLabel yAxisLabel = new JLabel("Y-Axis");
            yAxisLabel.setUI(new VerticalLabelUI(false));
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
            graphPanel.add(axisPanel);
            
            
            overallPanel.add(graphPanel);
            /*overallPanel.add(quizLabels);*/
            
            content.add(overallPanel);
            
            
            
            
            
            JTable table = new JTable(data, colNames);
            
            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            
            
            content.add(scrollPane);
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

}
