package views;

import calculations.ActionListeners;
import calculations.Diagnosis;
import calculations.Recomendations;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiagnosisandRecomendation extends JFrame {
    private JLabel recommendationsLabel;
    private JLabel diagnosisandRecomendationsLabel;
    private JLabel patientOverviewLabel;
    private JLabel diagnosisLabel;
    private JLabel logoDisplayLabel;
    private JButton addPatientButton;
    private JButton viewHistoryPatientButton;
    private JButton dashboardButton;
    private JButton queryButton;
    private JButton signOutButton;
    private JScrollPane diagnosisOverviewScrollPane;
    private JScrollPane patientOverviewScrollPane;
    private JScrollPane recommendationOverviewScrollPane;
    private JTextArea diagnosisOverviewTextArea;
    private JTextArea patientOverviewTextArea;
    private JTextArea recommendationOverviewTextArea;
    private JPanel logoDisplayPanel;
    private JPanel sidebarPanel;
    private JSeparator sidebarSeparator;

    public static Diagnosis report = new Diagnosis();
    ActionListeners actionListeners = new ActionListeners();

    public DiagnosisandRecomendation() {
        initialiseComponents();
        addToFrame();
        registerActionListeners();
    }

    public DiagnosisandRecomendation(String basicInfo, String diagnosis, String recommendations) {
        initialiseComponents();
        addToFrame();
        registerActionListeners();

        patientOverviewTextArea.setText(basicInfo);
        diagnosisOverviewTextArea.setText(diagnosis);
        recommendationOverviewTextArea.setText(recommendations);
    }

    public void initialiseComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900,530));
        setPreferredSize(new Dimension(900,530));
        setResizable(false);
        setSize(900,530);
        getContentPane().setLayout(null);

        recommendationsLabel = new JLabel();
        recommendationsLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        recommendationsLabel.setText("Recommendations");
        recommendationsLabel.setBounds(600,200,240,30);

        diagnosisandRecomendationsLabel = new JLabel();
        diagnosisandRecomendationsLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        diagnosisandRecomendationsLabel.setText("Diagnosis & Recommendations");
        diagnosisandRecomendationsLabel.setBounds(180,20,350,30);

        patientOverviewLabel = new JLabel();
        patientOverviewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        patientOverviewLabel.setText("Patient Overview");
        patientOverviewLabel.setBounds(350,60,290,30);

        diagnosisLabel = new JLabel();
        diagnosisLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        diagnosisLabel.setText("Diagnosis");
        diagnosisLabel.setBounds(300,200,240,30);

        logoDisplayLabel = new JLabel();
        logoDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoDisplayLabel.setIcon(new ImageIcon("images/logofix.png"));

        dashboardButton = new JButton();
        dashboardButton.setText("Dashboard");
        dashboardButton.setBounds(510,20,130,30);
        dashboardButton.setBackground(new Color(255, 135, 75));
        dashboardButton.setFont(new Font("Futura Md BT", Font.BOLD,16));

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

        patientOverviewTextArea = new JTextArea();
        patientOverviewTextArea.setColumns(50);
        patientOverviewTextArea.setLineWrap(true);
        patientOverviewTextArea.setRows(8);
        patientOverviewTextArea.setEditable(false);

        recommendationOverviewTextArea = new JTextArea();
        recommendationOverviewTextArea.setColumns(50);
        recommendationOverviewTextArea.setLineWrap(true);
        recommendationOverviewTextArea.setRows(8);
        recommendationOverviewTextArea.setWrapStyleWord(true);
        recommendationOverviewTextArea.setEditable(false);

        diagnosisOverviewTextArea = new JTextArea();
        diagnosisOverviewTextArea.setColumns(50);
        diagnosisOverviewTextArea.setLineWrap(true);
        diagnosisOverviewTextArea.setRows(8);
        diagnosisOverviewTextArea.setWrapStyleWord(true);
        diagnosisOverviewTextArea.setEditable(false);

        patientOverviewScrollPane = new JScrollPane();
        patientOverviewScrollPane.setViewportView(patientOverviewTextArea);
        patientOverviewScrollPane.setBounds(180,98,680,100);

        recommendationOverviewScrollPane= new JScrollPane();
        recommendationOverviewScrollPane.setViewportView(recommendationOverviewTextArea);
        recommendationOverviewScrollPane.setBounds(520,230,335,260);

        diagnosisOverviewScrollPane = new JScrollPane();
        diagnosisOverviewScrollPane.setViewportView(diagnosisOverviewTextArea);
        diagnosisOverviewScrollPane.setBounds(180,230,335,260);

        logoDisplayPanel = new JPanel();
        logoDisplayPanel.setBackground(new Color(0,204,204));
        logoDisplayPanel.setBounds(10,10,130,110);

        GroupLayout logoDisplayPanelLayout = new GroupLayout(logoDisplayPanel);
        logoDisplayPanel.setLayout(logoDisplayPanelLayout);
        logoDisplayPanelLayout.setHorizontalGroup(
                logoDisplayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(logoDisplayLabel,
                        GroupLayout.DEFAULT_SIZE,130,Short.MAX_VALUE)
        );
        logoDisplayPanelLayout.setVerticalGroup(
                logoDisplayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(logoDisplayLabel,
                        GroupLayout.DEFAULT_SIZE,100,Short.MAX_VALUE)
        );

        sidebarPanel = new JPanel();
        sidebarPanel.setBackground(new Color(0,204,204));
        sidebarPanel.setLayout(null);
        sidebarPanel.setBounds(0,0,150,500);

        sidebarSeparator = new JSeparator();
        sidebarSeparator.setToolTipText("");
        sidebarSeparator.setBounds(10,125,135,5);
    }

    public void addToFrame() {
        sidebarPanel.add(logoDisplayPanel);
        sidebarPanel.add(sidebarSeparator);
        sidebarPanel.add(addPatientButton);
        sidebarPanel.add(queryButton);
        sidebarPanel.add(viewHistoryPatientButton);
        sidebarPanel.add(signOutButton);

        getContentPane().add(sidebarPanel);
        getContentPane().add(dashboardButton);
        getContentPane().add(patientOverviewScrollPane);
        getContentPane().add(recommendationOverviewScrollPane);
        getContentPane().add(diagnosisOverviewScrollPane);
        getContentPane().add(recommendationsLabel);
        getContentPane().add(diagnosisandRecomendationsLabel);
        getContentPane().add(patientOverviewLabel);
        getContentPane().add(diagnosisLabel);

        pack();
    }

    public void registerActionListeners() {
        dashboardButton.addActionListener(e -> {
            actionListeners.dashboardButtonActionPerformed();
            dispose();
        });

        queryButton.addActionListener(e -> {
            actionListeners.queryButtonActionPerformed();
            dispose();
        });

        addPatientButton.addActionListener(e -> {
            actionListeners.addPatientButtonActionPerformed();
            dispose();
        });

        diagnosisOverviewTextArea.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                actionListeners.diagnosisOverviewTextAreaAncestorAdded(event);
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {

            }

            @Override
            public void ancestorMoved(AncestorEvent event) {

            }
        });
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

        EventQueue.invokeLater(() -> new DiagnosisandRecomendation().setVisible(true));
    }
}
