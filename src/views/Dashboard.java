package views;

import calculations.ActionListeners;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame{
    private JLabel logoDisplayLabel;
    private JLabel menuDisplayLabel;
    private JLabel welcomeLabel;
    private JLabel beatCovidLabel;
    private JLabel dashboardImageLabel;
    private JButton addPatientButton;
    private JButton queryButton;
    private JButton viewHistoryPatientButton;
    private JButton signOutButton;
    private JPanel displayPanel;
    private JPanel logoDisplayPanel;
    private JPanel sidebarPanel;
    private JPanel topPanel;
    private JSeparator sidebarSeparator;

    ActionListeners actionListeners = new ActionListeners();

    public Dashboard () {
        initialiseComponents();
        addToFrame();
        registerActionListeners();
    }

    public void initialiseComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900,530));
        setPreferredSize(new Dimension(900,530));
        setResizable(false);
        setSize(900,530);
        getContentPane().setLayout(null);

        logoDisplayLabel = new JLabel();
        logoDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoDisplayLabel.setIcon(new ImageIcon("images/logofix.png"));
        //logoDisplayLabel.setFocusable(false);
        //logoDisplayLabel.setMinimumSize(new Dimension(145,100));
        //logoDisplayLabel.setPreferredSize(new Dimension(145,100));
        //logoDisplayLabel.setBounds(0,0,145,100);

        menuDisplayLabel = new JLabel();
        menuDisplayLabel.setFont(new Font("Monotype Corsiva", Font.BOLD,30));
        menuDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuDisplayLabel.setText("DASHBOARD");
        menuDisplayLabel.setBounds(0,0,500,50);

        welcomeLabel = new JLabel();
        welcomeLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 24));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setText("WELCOME, BIENVENUE, BIENVENIDOS");
        welcomeLabel.setForeground(new Color(255, 135, 75));
        welcomeLabel.setBounds(140,50,450,40);

        beatCovidLabel = new JLabel();
        beatCovidLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
        beatCovidLabel.setHorizontalAlignment(SwingConstants.CENTER);
        beatCovidLabel.setText("We can beat Covid-19 together");
        beatCovidLabel.setBounds(217,100,300,40);
        beatCovidLabel.setForeground(new Color(255, 135, 75));

        dashboardImageLabel = new JLabel();
        dashboardImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dashboardImageLabel.setIcon(new ImageIcon("images/dashboard.png"));
        dashboardImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        dashboardImageLabel.setBounds(260,140,240,300);

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

        sidebarPanel = new JPanel();
        sidebarPanel.setBackground(new Color(255, 135, 75));
        sidebarPanel.setLayout(null);
        sidebarPanel.setBounds(0,0,150,500);

        logoDisplayPanel = new JPanel();
        logoDisplayPanel.setBackground(new Color(255, 135, 75));
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

        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(155,5,510,40);

        displayPanel = new JPanel();
        displayPanel.setBackground(new Color(102,102,102));
        displayPanel.setLayout(null);
        displayPanel.setBounds(155,45,730,450);

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

        displayPanel.add(welcomeLabel);
        displayPanel.add(beatCovidLabel);
        displayPanel.add(dashboardImageLabel);

        topPanel.add(menuDisplayLabel);

        getContentPane().add(sidebarPanel);
        getContentPane().add(displayPanel);
        getContentPane().add(topPanel);

        pack();
    }

    public void registerActionListeners() {
        signOutButton.addActionListener(e -> {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            dispose();
        });

        addPatientButton.addActionListener(e -> {
            actionListeners.addPatientButtonActionPerformed();
            dispose();
        });

        queryButton.addActionListener(e -> {
            actionListeners.queryButtonActionPerformed();
            dispose();
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Dashboard().setVisible(true));
    }
}
