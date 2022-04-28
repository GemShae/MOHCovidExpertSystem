package views;

import calculations.ActionListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame{
    private JLabel expertSystemHeaderLabel;
    private JLabel iconDisplayLabel;
    private JLabel jLabel1;
    private JLabel loginHeaderLabel;
    private JLabel mohHeaderLabel;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JPanel iconDisplayPanel;
    private JPanel jPanel1;
    public static JTextField usernameTextField;
    public static JPasswordField passwordField;
    private JButton resetButton;
    private JButton signInButton;

    public ActionListeners actionListeners = new ActionListeners();

    public Login () {
        initialiseComponents();
        addToFrame();
        registerActionListeners();
    }

    public void initialiseComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new Dimension(650,400));
        setResizable(false);
        setSize(650,400);

        mohHeaderLabel = new JLabel();
        mohHeaderLabel.setFont(new Font("Bebas", Font.PLAIN,24));
        mohHeaderLabel.setForeground(new Color(255,255,255));
        mohHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mohHeaderLabel.setText("MOH COVID-19");

        expertSystemHeaderLabel = new JLabel();
        expertSystemHeaderLabel.setFont(new Font("Bebas", Font.PLAIN,24));
        expertSystemHeaderLabel.setForeground(new Color(255,255,255));
        expertSystemHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        expertSystemHeaderLabel.setText("EXPERT SYSTEM");

        iconDisplayLabel = new JLabel();
        iconDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        iconDisplayLabel.setIcon(new ImageIcon("images/logofix.png"));

        passwordLabel = new JLabel();
        passwordLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
        passwordLabel.setText("PASSWORD");

        usernameLabel = new JLabel();
        usernameLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
        usernameLabel.setText("USERNAME");

        loginHeaderLabel = new JLabel();
        loginHeaderLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
        loginHeaderLabel.setForeground(new Color(255, 135, 75));
        loginHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginHeaderLabel.setText("LOGIN");

        jLabel1 = new JLabel();
        jLabel1.setFont(new Font("Futura Md BT", Font.BOLD, 12));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("X");

        usernameTextField = new JTextField();
        usernameTextField.setFont(new Font("Segoe UI Light", Font.ITALIC, 11));

        passwordField = new JPasswordField();

        resetButton = new JButton();
        resetButton.setText("Reset");

        signInButton = new JButton();
        signInButton.setText("Sign In");

        jPanel1 = new JPanel();
        jPanel1.setBackground(new Color(255, 135, 75));

        iconDisplayPanel = new JPanel();
        iconDisplayPanel.setBackground(new Color(255, 135, 75));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(mohHeaderLabel,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(iconDisplayLabel,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
            .addComponent(expertSystemHeaderLabel,GroupLayout.DEFAULT_SIZE,280,Short.MAX_VALUE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(iconDisplayPanel,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)))
            .addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(mohHeaderLabel)
                        .addGap(3, 3, 3)
                        .addComponent(expertSystemHeaderLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(iconDisplayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconDisplayLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout iconDisplayPanelLayout = new GroupLayout(iconDisplayPanel);
        iconDisplayPanel.setLayout(iconDisplayPanelLayout);
        iconDisplayPanelLayout.setHorizontalGroup(iconDisplayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0,0,Short.MAX_VALUE));
        iconDisplayPanelLayout.setVerticalGroup(iconDisplayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0,0,Short.MAX_VALUE));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                                                .addComponent(signInButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(usernameTextField)
                                                        .addComponent(passwordField))
                                                .addGap(0, 40, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(loginHeaderLabel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(95, 95, 95))
                                                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loginHeaderLabel)
                                .addGap(26, 26, 26)
                                .addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(resetButton)
                                        .addComponent(signInButton))
                                .addGap(91, 91, 91))
        );

        pack();
    }

    public void addToFrame() {

    }

    public void registerActionListeners() {
        resetButton.addActionListener(e -> actionListeners.resetButtonActionPerformed(e));

        signInButton.addActionListener(e -> {
            actionListeners.signInButtonActionPerformed(e);
            dispose();
        });

        jLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                dispose();
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

        EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}
