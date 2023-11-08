package Folderr.ui;


import Folderr.main.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;



public class App extends Launcher {

    private JPanel Panel1;
    private JTabbedPane Management;
    private JPanel EventManagement;
    private JPanel VenueManagement;
    private JPanel AthleteManagement;
    private JPanel Athlete;
    private JLabel Name;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JComboBox JcomboBox1;
    private JButton DELETEButton;
    private JButton EDITButton;
    private JButton CREATEButton;
    private JComboBox comboxBox1;
    private JLabel VenueType;
    private JLabel PhoneNumber;
    private JTextArea textArea1;
    private JLabel Discipline;
    private JLabel Schedule;
    private JLabel ScheduleTime;
    private JButton CREATE;
    private JButton DELETE;
    private JButton EDIT;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton createButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel Match;
    private JTable tableevent;
    private JTable tablevenue;
    private JTable tableathlete;
    private JButton editButton1;
    private JButton deleteButton1;
    private JButton editButton2;
    private JButton deleteButton2;
    private JButton editButton3;
    private JButton deleteButton3;
    private JComboBox m1;
    private JComboBox m2;
    private JTextField m3;
    private JTextArea m4;
    private JTextField mm1;
    private JTextField mm2;
    private JTextField mm3;
    private JTextField mm4;
    private JTextField mmm1;
    private JTextField mmm2;
    private JTextField mmm3;
    private JComboBox mm5;
    private JButton ADDButton;
    private DefaultTableModel tableModel1;
    private DefaultTableModel tableModel2;
    private DefaultTableModel tableModel3;
    private DefaultTableModel tableModel4;
    private DefaultTableModel tableModel5;
    private DefaultTableModel tableModel6;
    private Folderr.main.Match match;

    public App() {
        String[] Event = {"Name", "Schedule date", "Schedule time"};
        String[] Venue = {"Stadium", "Discipline", "Phone Number", "Name"};
        String[] Athlete = {"Name", "Surname", "Athlete Number", "Date of Birth", "Discipline"};
        String[] Event1 = {"Name", "Schedule date", "Schedule time"};
        String[] Venue1 = {"Stadium", "Discipline", "Phone Number", "Name"};
        String[] Athlete1 = {"Name", "Surname", "Athlete Number", "Date of Birth", "Discipline"};
        tableModel1 = new DefaultTableModel(Event, 0);
        tableModel2 = new DefaultTableModel(Venue, 0);
        tableModel3 = new DefaultTableModel(Athlete, 0);
        tableModel4 = new DefaultTableModel(Event1, 0);
        tableModel5 = new DefaultTableModel(Venue1, 0);
        tableModel6 = new DefaultTableModel(Athlete1, 0);

        table1.setModel(tableModel1);
        table2.setModel(tableModel2);
        table3.setModel(tableModel3);
        tableevent.setModel(tableModel4);
        tablevenue.setModel(tableModel5);
        tableathlete.setModel(tableModel6);
        this.match = new Match();

        // Action listener for Event create
        CREATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the data and add a new row to the table model
                String name = textField5.getText();
                LocalDate ScheduleDate = LocalDate.parse(textField6.getText());
                LocalTime ScheduleTime = LocalTime.parse(textField7.getText());
                tableModel1.addRow(new Object[]{name, ScheduleDate, ScheduleTime});
                tableModel4.addRow(new Object[]{name, ScheduleDate, ScheduleTime});
                // Clear the text fields
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");
            }
        });

        // Action listener for Event edit
        EDIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Check if a row is selected
                if (table1.getSelectedRow() > -1) {

                    String EditedName = textField5.getText();
                    LocalDate EditedScheduleDate = LocalDate.parse(textField6.getText());
                    LocalTime EditedScheduleTime = LocalTime.parse(textField7.getText());

                    tableModel1.setValueAt(EditedName, table1.getSelectedRow(), 0);
                    tableModel1.setValueAt(EditedScheduleDate, table1.getSelectedRow(), 1);
                    tableModel1.setValueAt(EditedScheduleTime, table1.getSelectedRow(), 2);

                    textField5.setText("");
                    textField6.setText("");
                    textField7.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });

        // Action listener for Event delete
        DELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (table1.getSelectedRow() > -1) {
                    tableModel1.removeRow(table1.getSelectedRow());

                    textField5.setText("");
                    textField6.setText("");
                    textField7.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });

        // Action listener for venue create
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Stadium = comboxBox1.getSelectedItem().toString();
                String Discipline = JcomboBox1.getSelectedItem().toString();
                String name = textField8.getText();
                int PhoneNumber = Integer.parseInt(textArea1.getText());

                tableModel2.addRow(new Object[]{Stadium, Discipline, name, PhoneNumber});
                tableModel5.addRow(new Object[]{Stadium, Discipline, name, PhoneNumber});

                comboxBox1.setSelectedIndex(0);
                textArea1.setText("");
                JcomboBox1.setSelectedIndex(0);
                textField8.setText("");
            }
        });

        // Action listener for Venue edit
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (table2.getSelectedRow() > -1) {

                    String EditedStadium = comboxBox1.getSelectedItem().toString();
                    String EditedDiscipline = JcomboBox1.getSelectedItem().toString();
                    String EditedName = textField8.getText();
                    int EditedPhoneNUmber = Integer.parseInt(textArea1.getText());

                    tableModel2.setValueAt(EditedStadium, table2.getSelectedRow(), 0);
                    tableModel2.setValueAt(EditedDiscipline, table2.getSelectedRow(), 1);
                    tableModel2.setValueAt(EditedName, table2.getSelectedRow(), 2);
                    tableModel2.setValueAt(EditedPhoneNUmber, table2.getSelectedRow(), 3);

                    comboxBox1.setSelectedIndex(0);
                    textArea1.setText("");
                    JcomboBox1.setSelectedIndex(0);
                    textField8.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });

        // Action listener for Venue delete
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (table2.getSelectedRow() > -1) {
                    // Remove the selected row from the table model
                    tableModel2.removeRow(table2.getSelectedRow());

                    comboxBox1.setSelectedIndex(0);
                    textArea1.setText("");
                    JcomboBox1.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });
        // Action listener for Athlete create
        CREATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String surname = textField2.getText();
                int athletenumber = Integer.parseInt(textField3.getText());
                LocalDate dateofbirth = LocalDate.parse(textField4.getText());
                String discipline = comboBox1.getSelectedItem().toString();

                tableModel3.addRow(new Object[]{name, surname, athletenumber, dateofbirth, discipline});
                tableModel6.addRow(new Object[]{name, surname, athletenumber, dateofbirth, discipline});


                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");

            }
        });

        // Action listener for Athlete edit
        EDITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (table3.getSelectedRow() > -1) {

                    String EditedDName = textField1.getText();
                    String EditedSurname = textField2.getText();
                    int EditedAthleteNumber = Integer.parseInt(textField3.getText());
                    LocalDate EditedDateOfBirth = LocalDate.parse(textField4.getText());

                    tableModel3.setValueAt(EditedDName, table3.getSelectedRow(), 0);
                    tableModel3.setValueAt(EditedSurname, table3.getSelectedRow(), 1);
                    tableModel3.setValueAt(EditedAthleteNumber, table3.getSelectedRow(), 2);
                    tableModel3.setValueAt(EditedDateOfBirth, table3.getSelectedRow(), 3);

                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });

        // Action listener for Athlete delete
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table3.getSelectedRow() > -1) {
                    tableModel3.removeRow(table3.getSelectedRow());

                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });

        //venue match edit
        editButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablevenue.getSelectedRow() > -1) {

                    String EditedStadium1 = m1.getSelectedItem().toString();
                    String EditedDiscipline1 = m2.getSelectedItem().toString();
                    String EditedName1 = m3.getText();
                    int EditedPhoneNUmber1 = Integer.parseInt(m4.getText());

                    tableModel5.setValueAt(EditedStadium1, tablevenue.getSelectedRow(), 0);
                    tableModel5.setValueAt(EditedDiscipline1, tablevenue.getSelectedRow(), 1);
                    tableModel5.setValueAt(EditedName1, tablevenue.getSelectedRow(), 2);
                    tableModel5.setValueAt(EditedPhoneNUmber1, tablevenue.getSelectedRow(), 3);

                    m1.setSelectedIndex(0);
                    m3.setText("");
                    m2.setSelectedIndex(0);
                    m4.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });
        //venue match delete
        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tablevenue.getSelectedRow() > -1) {
                    // Remove the selected row from the table model
                    tableModel5.removeRow(tablevenue.getSelectedRow());

                    m1.setSelectedIndex(0);
                    m3.setText("");
                    m2.setSelectedIndex(0);
                    m4.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });

        //athlete match edit and delete
        editButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableathlete.getSelectedRow() > -1) {

                    String EditedDName5 = mm1.getText();
                    String EditedSurname5 = mm2.getText();
                    int EditedAthleteNumber5 = Integer.parseInt(mm3.getText());
                    LocalDate EditedDateOfBirth5 = LocalDate.parse(mm4.getText());
                    String editeddiscipline5 = mm5.getSelectedItem().toString();

                    tableModel6.setValueAt(EditedDName5, tableathlete.getSelectedRow(), 0);
                    tableModel6.setValueAt(EditedSurname5, tableathlete.getSelectedRow(), 1);
                    tableModel6.setValueAt(EditedAthleteNumber5, tableathlete.getSelectedRow(), 2);
                    tableModel6.setValueAt(EditedDateOfBirth5, tableathlete.getSelectedRow(), 3);
                    tableModel6.setValueAt(editeddiscipline5, tableathlete.getSelectedRow(), 4);

                    mm1.setText("");
                    mm2.setText("");
                    mm3.setText("");
                    mm4.setText("");
                    mm5.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });
        deleteButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableathlete.getSelectedRow() > -1) {
                    tableModel6.removeRow(tableathlete.getSelectedRow());

                    mm1.setText("");
                    mm2.setText("");
                    mm3.setText("");
                    mm4.setText("");
                    mm5.setSelectedIndex(0);
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });
        editButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableevent.getSelectedRow() > -1) {

                    String EditedName = mmm1.getText();
                    LocalDate EditedScheduleDate = LocalDate.parse(mmm2.getText());
                    LocalTime EditedScheduleTime = LocalTime.parse(mmm3.getText());

                    tableModel4.setValueAt(EditedName, tableevent.getSelectedRow(), 0);
                    tableModel4.setValueAt(EditedScheduleDate, tableevent.getSelectedRow(), 1);
                    tableModel4.setValueAt(EditedScheduleTime, tableevent.getSelectedRow(), 2);

                    mmm1.setText("");
                    mmm2.setText("");
                    mmm3.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });
        deleteButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableevent.getSelectedRow() > -1) {
                    tableModel4.removeRow(tableevent.getSelectedRow());

                    mmm1.setText("");
                    mmm2.setText("");
                    mmm3.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "You did not select anything");
                }
            }
        });
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableathlete.getSelectedRow() > -1) {
                    if (tableevent.getSelectedRow() > -1) {
                        // Create an Athlete object from the selected row
                        String name = (String) tableModel6.getValueAt(tableathlete.getSelectedRow(), 0);
                        String surname = (String) tableModel6.getValueAt(tableathlete.getSelectedRow(), 1);
                        int athleteNumber = (int) tableModel6.getValueAt(tableathlete.getSelectedRow(), 2);
                        LocalDate dateOfBirth = (LocalDate) tableModel6.getValueAt(tableathlete.getSelectedRow(), 3);
                        String discipline = (String) tableModel6.getValueAt(tableathlete.getSelectedRow(), 4);
                        String EventName = (String) tableModel1.getValueAt(tableevent.getSelectedRow(), 0);
                        Folderr.main.Discipline disciplineObj = Folderr.main.Discipline.valueOf(discipline);

                        Folderr.main.Athlete athlete = new Athlete(name, surname, athleteNumber, dateOfBirth, disciplineObj);
                        Match match1 = new Match(EventName, Folderr.main.Event.getSchedule());
                        try {
                            match.addAthleteToMatch(athlete);
                            System.out.println(athlete.toString());
                            System.out.println(match1.toString());
                        } catch (AddingAthleteException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(null, "Athlete is added");
                    } else {
                        JOptionPane.showMessageDialog(null, "You did not select something");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().Panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}