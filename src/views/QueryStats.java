package views;

import calculations.ActionListeners;
import calculations.Covid19Tracking;
import calculations.Diagnosis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueryStats extends JFrame {
    private JLabel logoDisplayLabel;
    private JLabel menuDisplayLabel;
    private JButton addPatientButton;
    private JButton queryButton;
    private JButton viewHistoryPatientButton;
    private JButton covidQueryButton;
    private JButton signOutButton;
    private JPanel displayPanel;
    private JPanel logoDisplayPanel;
    private JPanel sidebarPanel;
    private JPanel topPanel;
    private static JTextArea queryDisplayPane;
    private JScrollPane queryScrollPane;
    private JSeparator sidebarSeparator;

    public static Covid19Tracking covid19Tracking = new Covid19Tracking();
    public ActionListeners actionListeners = new ActionListeners();
    public static Diagnosis diagnosis = new Diagnosis();

    public QueryStats() {
        initialiseComponents();
        addToFrame();
        registerActionListeners();
    }

    public void initialiseComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900,530));
        setPreferredSize(new Dimension(900,530));
        setResizable(false);
        setSize(900,530);
        getContentPane().setLayout(null);

        logoDisplayLabel = new JLabel();
        logoDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoDisplayLabel.setIcon(new ImageIcon("images/logofix.png"));
        logoDisplayLabel.setFocusable(false);
        logoDisplayLabel.setMinimumSize(new Dimension(145,100));
        logoDisplayLabel.setPreferredSize(new Dimension(145,100));
        logoDisplayLabel.setBounds(0,0,145,100);

        menuDisplayLabel = new JLabel();
        menuDisplayLabel.setFont(new Font("Monotype Corsiva", Font.BOLD,30));
        menuDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuDisplayLabel.setText("QUERY STATISTICS");
        menuDisplayLabel.setBounds(0,0,500,50);

        addPatientButton = new JButton();
        addPatientButton.setBackground(new Color(255, 135, 75));
        addPatientButton.setFont(new Font("Futura Md BT", Font.BOLD,16));
        addPatientButton.setText("Add Patient");
        addPatientButton.setBounds(10,140,130,80);

        viewHistoryPatientButton = new JButton();
        viewHistoryPatientButton.setBackground(new Color(255, 135, 75));
        viewHistoryPatientButton.setFont(new Font("Futura Md BT", Font.BOLD,16));
        viewHistoryPatientButton.setText("View History");
        viewHistoryPatientButton.setBounds(10,230,130,80);

        queryButton = new JButton();
        queryButton.setBackground(new Color(255, 135, 75));
        queryButton.setFont(new Font("Futura Md BT", Font.BOLD,16));
        queryButton.setText("Query Stats.");
        queryButton.setBounds(10,320,130,80);

        signOutButton = new JButton();
        signOutButton.setBackground(new Color(255, 135, 75));
        signOutButton.setFont(new Font("Futura Md BT", Font.BOLD,16));
        signOutButton.setText("Sign Out");
        signOutButton.setBounds(10,410,130,80);

        covidQueryButton = new JButton();
        covidQueryButton.setText("Query");
        covidQueryButton.setBounds(150,30,190,30);

        queryDisplayPane = new JTextArea();
        queryDisplayPane.setColumns(50);
        queryDisplayPane.setLineWrap(true);
        queryDisplayPane.setRows(8);
        queryDisplayPane.setWrapStyleWord(true);
        queryDisplayPane.setEditable(false);

        queryScrollPane = new JScrollPane();
        queryScrollPane.setViewportView(queryDisplayPane);
        queryScrollPane.setBounds(20,70,640,370);

        sidebarSeparator = new JSeparator();
        sidebarSeparator.setToolTipText("");
        sidebarSeparator.setBounds(10,125,135,5);

        logoDisplayPanel = new JPanel();
        logoDisplayPanel.setBackground(new Color(255, 135, 75));
        logoDisplayPanel.setLayout(null);
        logoDisplayPanel.setBounds(10,10,130,110);

        displayPanel = new JPanel();
        displayPanel.setBackground(new Color(102,102,102));
        displayPanel.setLayout(null);
        displayPanel.setBounds(155,45,730,450);

        sidebarPanel = new JPanel();
        sidebarPanel.setBackground(new Color(255, 135, 75));
        sidebarPanel.setForeground(new Color(255,255,255));
        sidebarPanel.setLayout(null);
        sidebarPanel.setBounds(0,0,150,500);

        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(155,5,510,40);
    }

    public void addToFrame() {
        logoDisplayPanel.add(logoDisplayLabel);

        sidebarPanel.add(logoDisplayPanel);
        sidebarPanel.add(sidebarSeparator);
        sidebarPanel.add(addPatientButton);
        sidebarPanel.add(queryButton);
        sidebarPanel.add(viewHistoryPatientButton);
        sidebarPanel.add(signOutButton);

        displayPanel.add(covidQueryButton);
        displayPanel.add(queryScrollPane);

        topPanel.add(menuDisplayLabel);

        getContentPane().add(sidebarPanel);
        getContentPane().add(displayPanel);
        getContentPane().add(topPanel);

        pack();
    }

    public void registerActionListeners() {
        addPatientButton.addActionListener(e -> {
            actionListeners.addPatientButtonActionPerformed();
            dispose();
        });

        queryButton.addActionListener(e -> {
            actionListeners.queryButtonActionPerformed();
            dispose();
        });

        viewHistoryPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });

        signOutButton.addActionListener(e -> {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            dispose();
        });

        covidQueryButton.addActionListener(e -> actionListeners.covidQueryButtonActionPerformed(e));
    }

    public static void performStats(ResultSet resultSet) {
        int toTCount = 0;
        int severePatients = 0;

        try {
            while (resultSet.next()) {
                toTCount +=1;

                if (resultSet.getString("highriskPatient").equals("true")) {
                    severePatients +=1;
                }
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

        int mildPatients = toTCount - severePatients;

        covid19Tracking.setTotalPatients(toTCount);
        covid19Tracking.setSevereRiskPatients(severePatients);
        covid19Tracking.setMildRiskPatients(mildPatients);
        covid19Tracking.severeRiskPercentageCalc(toTCount,severePatients);
        covid19Tracking.mildRiskPercentageCalc(toTCount,mildPatients);

        covid19Tracking.setRegularSymptoms(Diagnosis.getRegularSymptoms());
        covid19Tracking.regularSymptomsPercentCalc(toTCount, Diagnosis.getRegularSymptoms());
        covid19Tracking.setMildSymptoms(Diagnosis.getMildSymptoms());
        covid19Tracking.mildSymptomsPercentCalc(toTCount,Diagnosis.getMildSymptoms());
        covid19Tracking.setSevereSymptoms(Diagnosis.getSevereSymptoms());
        covid19Tracking.severeSymptomsPercentCalc(toTCount,Diagnosis.getSevereSymptoms());
        covid19Tracking.setDeltaVariant(Diagnosis.getDeltaVariant());
        covid19Tracking.deltaPercentCalc(toTCount,Diagnosis.getDeltaVariant());
        covid19Tracking.setMuVariant(Diagnosis.getMuVariant());
        covid19Tracking.muPercentCalc(toTCount,Diagnosis.getMuVariant());
        covid19Tracking.covid19Report();

        queryDisplayPane.setText(covid19Tracking.toString());
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
                break;
            }
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE,null,ex);
        }

        EventQueue.invokeLater(() -> new QueryStats().setVisible(true));
    }
}
