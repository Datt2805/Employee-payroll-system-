
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

abstract class Employee {
    protected String name;
    private int id;
    protected double monthlySalary;
    protected boolean isFullTime;

    public Employee(String name, double monthlySalary, boolean isFullTime) {
        this.monthlySalary = monthlySalary;
        this.name = name;
        this.isFullTime = isFullTime;
    }
    public Employee(){

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary(){
        return monthlySalary;
    }
    

    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + id + ", salary=" + getSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double monthlySalary, boolean isFullTime) {
        super.name = name;
        super.monthlySalary = monthlySalary;
        super.isFullTime = isFullTime;
    }

    public FullTimeEmployee(){

    }

}

class PartTimeWmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeWmployee(String name, int hoursWorked, double hourlyRate, boolean isFullTime) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        super.name = name;
        super.isFullTime = isFullTime;
    }
    public PartTimeWmployee(){

    }

    public double calculateSalary(){
        return super.monthlySalary=hoursWorked * hourlyRate;
    }
}

class PayRollSystem {
    // private ArrayList<Employee> employeeList;
    private List<Employee> employeeList;

    public PayRollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }

        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public List<Employee> displayEmployees() {
        // for (Employee employee : employeeList) {
        // System.out.println(employee);
        // }
        return new ArrayList<>(employeeList);
    }
}

public class App1 {
    JFrame mainFrame = new JFrame("Employee Payroll System");
    JTextField nameField, idField, salaryField, hoursWorkedField, hourlyRateField;
    JLabel welcomeLabel = new JLabel("Welcome to Employee Payroll System");
    PayRollSystem payrollSystem = new PayRollSystem();

    public void mainMenu() {
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        welcomeLabel.setBounds(250, 60, 800, 50);
        mainFrame.add(welcomeLabel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1100, 750);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);

        JButton addEmpButton = new JButton("Add an employee");
        addEmpButton.setBounds(400, 210, 300, 40);
        addEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        addEmpButton.setFocusPainted(false);
        mainFrame.add(addEmpButton);
        addEmpButton.addActionListener(actionEvent -> Type_of_employee());

        JButton viewEmpButton = new JButton("View all employees");
        viewEmpButton.setBounds(400, 280, 300, 40);
        viewEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        viewEmpButton.setFocusPainted(false);
        mainFrame.add(viewEmpButton);
        viewEmpButton.addActionListener(actionEvent -> viewEmployee());// viewEmployee()

        JButton deleteEmpButton = new JButton("Delete an employee");
        deleteEmpButton.setBounds(400, 350, 300, 40);
        deleteEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        deleteEmpButton.setFocusPainted(false);
        mainFrame.add(deleteEmpButton);
        deleteEmpButton.addActionListener(actionEvent -> RemoveEmployee());

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 420, 300, 40);
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(actionEvent -> {
            mainFrame.dispose();
        });
        mainFrame.add(exitButton);
    }

    public void Type_of_employee() {
        JPanel type_of_employee = new JPanel();
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

        backButton.addActionListener(actionEvent -> {
            mainFrame.getContentPane().removeAll();
            mainMenu();
        });
        type_of_employee.add(backButton);
        mainFrame.setContentPane(type_of_employee);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void addEmpFull() {

        isFullTime = true;

        JPanel addEmpPanel = new JPanel();
        addEmpPanel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 200, 30);
        addEmpPanel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(250, 30, 200, 30);
        addEmpPanel.add(nameField);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(50, 80, 200, 30);
        addEmpPanel.add(salaryLabel);

        salaryField = new JTextField(10);
        salaryField.setBounds(250, 80, 200, 30);
        addEmpPanel.add(salaryField);

        JButton backButton = new JButton("Back");
        backButton.setBounds(370, 180, 80, 30);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            mainFrame.getContentPane().removeAll();
            Type_of_employee();
        });
        addEmpPanel.add(backButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 180, 80, 30);
        submitButton.addActionListener(actionEvent -> submitEmpDetails());
        addEmpPanel.add(submitButton);

        mainFrame.setContentPane(addEmpPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void addEmpPart() {
        isFullTime = false;
        JPanel addEmpPanel = new JPanel();
        addEmpPanel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 200, 30);
        addEmpPanel.add(nameLabel);
        nameField = new JTextField(20);
        nameField.setBounds(250, 30, 200, 30);
        addEmpPanel.add(nameField);

        JLabel hoursWorkedLabel = new JLabel("Hours Worked:");
        hoursWorkedLabel.setBounds(50, 80, 200, 30);
        addEmpPanel.add(hoursWorkedLabel);
        hoursWorkedField = new JTextField(5);
        hoursWorkedField.setBounds(250, 80, 200, 30);
        addEmpPanel.add(hoursWorkedField);

        JLabel hourlyRateLabel = new JLabel("Hourly Rate:");
        hourlyRateLabel.setBounds(50, 130, 200, 30);
        addEmpPanel.add(hourlyRateLabel);
        hourlyRateField = new JTextField(10);
        hourlyRateField.setBounds(250, 130, 200, 30);
        addEmpPanel.add(hourlyRateField);

        JButton backButton = new JButton("Back");
        backButton.setBounds(370, 230, 80, 30);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            mainFrame.getContentPane().removeAll();
            Type_of_employee();
        });
        addEmpPanel.add(backButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 230, 80, 30);
        submitButton.addActionListener(actionEvent -> submitEmpDetails());
        addEmpPanel.add(submitButton);

        mainFrame.setContentPane(addEmpPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    boolean isFullTime = false;

    public void submitEmpDetails() {
        String name = nameField.getText();
        // int id = Integer.parseInt(idField.getText());

        if (isFullTime) {
            double salary = Double.parseDouble(salaryField.getText());
            // FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(name,salary);
            // String insertDataQuery = "INSERT INTO Employee (id, name, age) VALUES " +
            // (id, name, salary);
            try {
                statement = connection.prepareStatement(
                        "INSERT INTO Employee (id, name, salary, isFullTime, workingHours, hourlyRate) VALUES(null,?,?,?,null,null)");

                // statement.setInt(1, id);
                statement.setString(1, name);
                statement.setDouble(2, salary);
                statement.setBoolean(3, isFullTime);
                statement.executeUpdate();
                statement.close();
                System.out.println("Inserted");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // payrollSystem.addEmployee(fullTimeEmployee);
        } else {
            // double salary = Double.parseDouble(salaryField.getText());
            int hoursWorked = Integer.parseInt(hoursWorkedField.getText());
            double hourlyRate = Double.parseDouble(hourlyRateField.getText());

            PartTimeWmployee partTimeWmployee = new PartTimeWmployee(name, hoursWorked, hourlyRate,isFullTime);
            double salary = partTimeWmployee.calculateSalary();

            try {
                statement = connection.prepareStatement(
                        "INSERT INTO Employee (id, name, salary, isFullTime, workingHours, hourlyRate) VALUES(null,?,?,?,?,?)");

                // statement.setInt(1, id);
                statement.setString(1, name);
                statement.setDouble(2, salary);
                statement.setBoolean(3, isFullTime);
                statement.setInt(4, hoursWorked);
                statement.setDouble(5, hourlyRate);
                statement.executeUpdate();
                statement.close();
                System.out.println("Inserted");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            payrollSystem.addEmployee(partTimeWmployee);
        }

        System.out.println("Employee added successfully");
    }

    public void RemoveEmployee() {
        JPanel RemoveEmployee = new JPanel();
        RemoveEmployee.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 80, 200, 30);
        RemoveEmployee.add(idLabel);

        idField = new JTextField(5);
        idField.setBounds(250, 80, 200, 30);
        RemoveEmployee.add(idField);

        JButton backButton = new JButton("Back");
        backButton.setBounds(370, 230, 80, 30);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            mainFrame.getContentPane().removeAll();
            mainMenu();
        });
        RemoveEmployee.add(backButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(250, 230, 80, 30);
        submitButton.addActionListener(actionEvent -> removeEmployee());
        RemoveEmployee.add(submitButton);

        mainFrame.setContentPane(RemoveEmployee);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public void removeEmployee() {
        int id = Integer.parseInt(idField.getText());
        // payrollSystem.removeEmployee(id);
        try {
            statement = connection.prepareStatement("Delete from employee where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Employee removed successfully");
    }

    public void viewEmployee() {
        JPanel viewEmployeePanel = new JPanel();
        viewEmployeePanel.setLayout(new BorderLayout());

        // Create a JTable
        JTable employeeTable = new JTable();
        employeeTable.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        // Create a DefaultTableModel
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("ID");
        tableModel.addColumn("Salary");

        // Populate the table with data from the PayRollSystem
        // List<Employee> employees = payrollSystem.displayEmployees();
        // for (Employee employee : employees) {
        // Object[] rowData = { employee.getName(), employee.getId(),
        // employee.calculateSalary() };
        // tableModel.addRow(rowData);
        // }

        try {
            statement = connection.prepareStatement("select * from employee");
            ResultSet rs = statement.executeQuery();
            // Assuming employeeTable is a JTable
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Creating a DefaultTableModel to hold the data
            DefaultTableModel model = new DefaultTableModel();

            // Adding column names to the model
            for (int column = 1; column <= columnCount; column++) {
                model.addColumn(metaData.getColumnName(column));
            }

            // Adding data to the model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int column = 1; column <= columnCount; column++) {
                    row[column - 1] = rs.getObject(column);
                }
                model.addRow(row);
            }

            // Setting the model to the JTable
            employeeTable.setModel(model);

            // Close the ResultSet and PreparedStatement after usage
            rs.close();
            statement.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        viewEmployeePanel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionEvent -> {
            mainFrame.getContentPane().removeAll();
            mainMenu();
        });
        viewEmployeePanel.add(backButton, BorderLayout.SOUTH);

        mainFrame.setContentPane(viewEmployeePanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public static PreparedStatement statement;
    public static Connection connection;

    public static void main(String[] args) throws Exception {
        App1 s = new App1();
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String databaseName = "My_db";
            String userName = "root";
            String password = "P@ssw0rd";

            connection = DriverManager.getConnection(url + databaseName, userName, password);

            statement = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS employee (id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(50),salary DOUBLE,isFullTime BOOLEAN,workingHours INT,hourlyRate DOUBLE)");

            // statement.executeQuery();
            statement.executeUpdate();
            System.out.println("created");
            // Creating a Statement object to execute SQL queries
            // statement = connection.createStatement();
            // connection.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace(); // Print the exception details for debugging
        }
        s.mainMenu();
    }
}
