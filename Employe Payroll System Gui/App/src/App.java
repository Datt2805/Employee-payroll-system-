import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    JFrame mainFrame = new JFrame("Employee Payroll System");
    JTextField nameField, idField, salaryField, hoursWorkedField, hourlyRateField;
    JLabel welcomeLabel = new JLabel("Welcome to Employee Payroll System");

    public void mainMenu(){

        // main body
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        welcomeLabel.setBounds(250, 60, 800, 50);
        mainFrame.add(welcomeLabel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        mainFrame.setSize(1100, 750);
        mainFrame.setLayout(null); // Use a layout manager or set layout as needed
        mainFrame.setVisible(true); 

        // Add Employee Button
        JButton addEmpButton = new JButton("Add an employee");
        addEmpButton.setBounds(400, 210, 300, 40);
        addEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        addEmpButton.setFocusPainted(false);
        mainFrame.add(addEmpButton);
        addEmpButton.addActionListener(actionEvent -> Type_of_employee());

        // View Employee's
        JButton viewEmpButton = new JButton("View all employees");
        viewEmpButton.setBounds(400, 280, 300, 40);
        viewEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        viewEmpButton.setFocusPainted(false);
        mainFrame.add(viewEmpButton);


        // Delete Employee 
        JButton deleteEmpButton = new JButton("Delete an employee");
        deleteEmpButton.setBounds(400, 350, 300, 40);
        deleteEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        deleteEmpButton.setFocusPainted(false);
        mainFrame.add(deleteEmpButton);


        // Exit
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 420, 300, 40);
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(actionEvent -> {
            mainFrame.dispose();
        });
        mainFrame.add(exitButton);
    }

    public void Type_of_employee(){
        JPanel type_of_employee = new JPanel();
        type_of_employee.setBackground(new Color(254, 251, 246));
        type_of_employee.setLayout(null);

        JButton FullTimeEmp = new JButton("Full Time Employee");
        FullTimeEmp.setBounds(400, 210, 300, 40);
        FullTimeEmp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        FullTimeEmp.setFocusPainted(false);
        type_of_employee.add(FullTimeEmp);
        FullTimeEmp.addActionListener(actionEvent -> addEmpFull());

        JButton PartTimeEmp = new JButton("Part Time Employee");
        PartTimeEmp.setBounds(400, 280, 300, 40);
        PartTimeEmp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        PartTimeEmp.setFocusPainted(false);
        type_of_employee.add(PartTimeEmp);
        PartTimeEmp.addActionListener(actionEvent -> addEmpPart());

        JButton backButton = new JButton("Back");
        backButton.setBounds(400, 350, 300, 40);
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> mainMenu());
        type_of_employee.add(backButton);

        mainFrame.setContentPane(type_of_employee);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void addEmpFull() {
        JPanel addEmpPanel = new JPanel();
        addEmpPanel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 200, 30);
        addEmpPanel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(250, 30, 200, 30);
        addEmpPanel.add(nameField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 80, 200, 30);
        addEmpPanel.add(idLabel);

        idField = new JTextField(5);
        idField.setBounds(250, 80, 200, 30);
        addEmpPanel.add(idField);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(50, 130, 200, 30);
        addEmpPanel.add(salaryLabel);

        salaryField = new JTextField(10);
        salaryField.setBounds(250, 130, 200, 30);
        addEmpPanel.add(salaryField);

        JButton backButton = new JButton("Back");
        backButton.setBounds(370, 180, 80, 30);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> Type_of_employee());
        addEmpPanel.add(backButton);


        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 180, 80, 30);
        submitButton.addActionListener(actionEvent -> submitEmpDetails());



        addEmpPanel.add(submitButton);
        mainFrame.setContentPane(addEmpPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void addEmpPart(){
        JPanel addEmpPanel = new JPanel();
        addEmpPanel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 200, 30);
        addEmpPanel.add(nameLabel);
        nameField = new JTextField(20);
        nameField.setBounds(250, 30, 200, 30);
        addEmpPanel.add(nameField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 80, 200, 30);
        addEmpPanel.add(idLabel);
        idField = new JTextField(5);
        idField.setBounds(250, 80, 200, 30);
        addEmpPanel.add(idField);

        JLabel hoursWorkedLabel = new JLabel("Hours Worked:");
        hoursWorkedLabel.setBounds(50, 130, 200, 30);
        addEmpPanel.add(hoursWorkedLabel);
        hoursWorkedField = new JTextField(5);
        hoursWorkedField.setBounds(250, 130, 200, 30);
        addEmpPanel.add(hoursWorkedField);

        JLabel hourlyRateLabel = new JLabel("Hourly Rate:");
        hourlyRateLabel.setBounds(50, 180, 200, 30);
        addEmpPanel.add(hourlyRateLabel);
        hourlyRateField = new JTextField(10);
        hourlyRateField.setBounds(250, 180, 200, 30);
        addEmpPanel.add(hourlyRateField);

        JButton backButton = new JButton("Back");
        backButton.setBounds(370, 230, 80, 30);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> Type_of_employee());
        addEmpPanel.add(backButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 230, 80, 30);
        submitButton.addActionListener(actionEvent -> submitEmpDetails());

        addEmpPanel.add(submitButton);
        mainFrame.setContentPane(addEmpPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void submitEmpDetails(){
        String name = nameField.getText();
        String id = idField.getText();
        String salary = salaryField.getText();
        String hoursWorked = hoursWorkedField.getText();
        String hourlyRate = hourlyRateField.getText();

        // Validate input (you might want to add more validation logic)

        // Print details to console (you can modify this part based on your requirements)
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: " + hourlyRate);
    }



    public static void main(String[] args) throws Exception {
        App s = new App();
        s.mainMenu();
    }
}
