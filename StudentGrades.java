import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class StudentGradesApp extends JFrame {
    private ArrayList<Integer> grades;
    private JTextArea gradesArea;
    private JTextField gradeInputField;
    private JLabel averageLabel, highestLabel, lowestLabel;

    public StudentGradesApp() {

        grades = new ArrayList<>();

        
        setTitle("Student Grades Management");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel gradeInputLabel = new JLabel("Enter Grade:");
        gradeInputField = new JTextField(5);
        JButton addGradeButton = new JButton("Add Grade");

        addGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGrade();
            }
        });

        inputPanel.add(gradeInputLabel);
        inputPanel.add(gradeInputField);
        inputPanel.add(addGradeButton);


        gradesArea = new JTextArea(10, 30);
        gradesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(gradesArea);


        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new GridLayout(3, 1));

        averageLabel = new JLabel("Average Score: ");
        highestLabel = new JLabel("Highest Score: ");
        lowestLabel = new JLabel("Lowest Score: ");

        resultsPanel.add(averageLabel);
        resultsPanel.add(highestLabel);
        resultsPanel.add(lowestLabel);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(resultsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addGrade() {
        try {
            int grade = Integer.parseInt(gradeInputField.getText());
            if (grade < 0 || grade > 100) {
                JOptionPane.showMessageDialog(this, "Please enter a grade between 0 and 100.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } else {
                grades.add(grade);
                gradesArea.append("Grade: " + grade + "\n");
                updateStatistics();
            }
            gradeInputField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateStatistics() {
        if (!grades.isEmpty()) {
            double average = grades.stream().mapToInt(Integer::intValue).average().orElse(0);
            int highest = Collections.max(grades);
            int lowest = Collections.min(grades);

            averageLabel.setText("Average Score: " + String.format("%.2f", average));
            highestLabel.setText("Highest Score: " + highest);
            lowestLabel.setText("Lowest Score: " + lowest);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentGradesApp();
            }
        });
    }
}
