package views;

import calculations.ActionListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddPatient extends JFrame {
    //Variables Declaration
    private JLabel erfHeaderLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel countryLabel;
    private JLabel mildSymptomsLabel;
    private JLabel regularSymptomsLabel;
    private JLabel severeSymptomsLabel;
    private JLabel variantsSymptomsLabel;
    private JLabel otherSymptomsLabel;
    public static JLabel diastolicLabel;
    public static JLabel systolicLabel;
    private JLabel temperatureCelsiusLabel;
    //private JLabel temperatureCelsiusLabel2;
    private JLabel temperatureFahrComboLabel;
    //private JLabel temperatureFahrComboLabel2;
    private JLabel exposureQuestionLabel;
    private JLabel healthProtocolQuestionLabel;
    private JLabel healthProtocolQuestion2Label;
    private JLabel diseasesQuestionLabel;
    private JLabel exerciseQuestionLabel;
    private JLabel alcoholQuestionLabel;
    private JLabel logoDisplayLabel;
    private JLabel menuDisplayLabel;
    private JSeparator mildSymptomsSeparator;
    private JSeparator regularSymptomsSeparator;
    private JSeparator severeSymptomsSeparator;
    private JSeparator variantsSymptomsSeparator;
    private JSeparator allSymptomsSeparator;
    //private JSeparator seriousSymptomsSeperator2;
    private JSeparator sidebarSeparator;
    //private JSeparator jSeparator1;
    //private JSeparator jSeparator2;
    private JButton addPatientButton;
    private JButton queryButton;
    private JButton saveButton;
    private JButton viewHistoryPatientButton;
    private JButton signOutButton;
    private JTabbedPane addPatientTabPane;
    public static JComboBox<String> ageComboBox;
    public static JComboBox<String> genderComboBox;
    public static JComboBox<String> celsiusComboBox;
    public static JComboBox<String> diastolicComboBox;
    public static JComboBox<String> systolicComboBox;
    private JPanel basicInformationTab;
    private JPanel exposureRiskFactorTab;
    private JPanel symptomsTab;
    private JPanel displayPanel;
    private JPanel logoDisplayPanel;
    private JPanel sidebarPanel;
    private JPanel topPanel;
    public static JCheckBox painsCheckBox;
    public static JCheckBox diarrhoeaCheckBox;
    public static JCheckBox irritatedEyes;
    public static JCheckBox dizzinessCheckBox;
    public static JCheckBox blurredVisionCheckBox;
    public static JCheckBox feverCheckBox; //Gonna take out. Need to figure out from temperature
    public static JCheckBox dryCoughCheckBox; //Need to change to cough
    public static JCheckBox tirednessCheckBox;
    public static JCheckBox noTasteCheckBox;
    public static JCheckBox noSmellCheckBox;
    public static JCheckBox runningNoseCheckBox;
    public static JCheckBox soreThroatCheckBox;
    public static JCheckBox headacheCheckBox;
    public static JCheckBox difficultyBreathingCheckBox;
    public static JCheckBox shortnessOfBreathCheckBox;
    public static JCheckBox lossOfSpeechCheckBox;
    public static JCheckBox lossOfMobilityCheckBox;
    public static JCheckBox confusionCheckBox;
    public static JCheckBox chestPainsCheckBox;
    public static JCheckBox rashOnSkinCheckBox;
    public static JCheckBox faintingCheckBox;
    public static JCheckBox nauseaCheckBox;
    public static JCheckBox vomitingCheckBox;
    public static JCheckBox continuousCoughCheckBox;
    public static JCheckBox asthmaCheckBox;
    public static JCheckBox bronchitisCheckBox;
    public static JCheckBox diabetesCheckBox;
    private ButtonGroup bestPracticesButtonGroup;
    private ButtonGroup exposureValueButtonGroup;
    private ButtonGroup exerciseButtonGroup;
    private ButtonGroup alcoholButtonGroup;
    private JRadioButton exposureNoOption;
    private JRadioButton exposureYesOption;
    private JRadioButton healthProtocolNoOption;
    private JRadioButton healthProtocolYesOption;
    private JRadioButton exerciseNoOption;
    private JRadioButton exerciseYesOption;
    private JRadioButton alcoholNoOption;
    private JRadioButton alcoholYesOption;
    public static JTextField fahrenheitDisplay;
    public static JTextField firstNameTextField;
    public static JTextField lastNameTextField;
    public static JTextField countryTextField;
    public static JTextField otherSymptomsTextField;


    //Objects
    ActionListeners actionListeners = new ActionListeners();

    public AddPatient() {
        initialiseComponents();
        addToFrame();
        registerActionListeners();
        //registerKeyListeners();
    }

    //Called from within the constructor to initialise the GUI
    public void initialiseComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900,530));
        setPreferredSize(new Dimension(900,530));
        setResizable(false);
        setSize(900,530);
        getContentPane().setLayout(null);

        erfHeaderLabel = new JLabel();
        erfHeaderLabel.setText("Has the patient: ");
        erfHeaderLabel.setBounds(14,6,320,40);
        erfHeaderLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

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
        menuDisplayLabel.setText("ADD PATIENT");
        menuDisplayLabel.setBounds(0,0,500,50);

        firstNameLabel = new JLabel();
        firstNameLabel.setText("First Name:");
        firstNameLabel.setBounds(50,29,90,30);
        firstNameLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

        lastNameLabel = new JLabel();
        lastNameLabel.setText("Last Name:");
        lastNameLabel.setBounds(50,80,90,30);
        lastNameLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

        genderLabel = new JLabel();
        genderLabel.setText("Gender:");
        genderLabel.setBounds(50,133,90,30);
        genderLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

        ageLabel = new JLabel();
        ageLabel.setText("Age:");
        ageLabel.setBounds(50,184,90,30);
        ageLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

        countryLabel = new JLabel();
        countryLabel.setText("Country: ");
        countryLabel.setBounds(50,235,90,30);
        countryLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

        otherSymptomsLabel = new JLabel();
        otherSymptomsLabel.setText("Other Symptoms: ");
        otherSymptomsLabel.setBounds(400,265,100,30);

        exposureQuestionLabel = new JLabel();
        exposureQuestionLabel.setText("1. Had contact with anyone with Covid-19 in the past 14 days?");
        exposureQuestionLabel.setBounds(30,28,500,50);

        healthProtocolQuestionLabel = new JLabel();
        healthProtocolQuestionLabel.setText("2. Complied with recommended mask wearing and other protocols?");
        healthProtocolQuestionLabel.setBounds(30,80,500,30);

        healthProtocolQuestion2Label = new JLabel();
        healthProtocolQuestion2Label.setText("3. Practiced social distance in past 14 days?");
        healthProtocolQuestion2Label.setBounds(30,120,300,30);

        diseasesQuestionLabel = new JLabel();
        diseasesQuestionLabel.setText("4. Have any underlying diseases?");
        diseasesQuestionLabel.setBounds(30,160,300,30);

        exerciseQuestionLabel = new JLabel();
        exerciseQuestionLabel.setText("5. Exercise regularly?");
        exerciseQuestionLabel.setBounds(30, 200,300,30);

        alcoholQuestionLabel = new JLabel();
        alcoholQuestionLabel.setText("6. Drink alcohol regularly");
        alcoholQuestionLabel.setBounds(30,240,300,30);

        regularSymptomsLabel = new JLabel();
        regularSymptomsLabel.setText("Regular Symptoms");
        regularSymptomsLabel.setBounds(15,15,300,30);
        regularSymptomsLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

        mildSymptomsLabel = new JLabel();
        mildSymptomsLabel.setText("Mild Symptoms");
        mildSymptomsLabel.setBounds(200,15,130,30);
        mildSymptomsLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

        severeSymptomsLabel = new JLabel();
        severeSymptomsLabel.setText("Serious Symptoms");
        severeSymptomsLabel.setBounds(355,15,130,30);
        severeSymptomsLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

        variantsSymptomsLabel = new JLabel();
        variantsSymptomsLabel.setText("Variants Symptoms");
        variantsSymptomsLabel.setBounds(510,15,150,30);
        variantsSymptomsLabel.setFont(new Font("Times New Roman", Font.BOLD,17));

        temperatureCelsiusLabel = new JLabel();
        temperatureCelsiusLabel.setText("Temp. In Celsius:"); //Blood Pressure
        temperatureCelsiusLabel.setBounds(14,258,130,20);

        /*temperatureCelsiusLabel2 = new JLabel();
        temperatureCelsiusLabel2.setText("Blood Pressure");
        temperatureCelsiusLabel2.setBounds(170,180,130,20); */

        temperatureFahrComboLabel = new JLabel();
        temperatureFahrComboLabel.setText("Temp. In Fahrenheit:"); //C
        temperatureFahrComboLabel.setBounds(14,280,150,20);

        /*temperatureFahrComboLabel2 = new JLabel();
        temperatureFahrComboLabel2.setText("°F");
        temperatureFahrComboLabel2.setBounds(170,250,20,20); */

        systolicLabel = new JLabel();
        systolicLabel.setText("Systolic:");
        systolicLabel.setBounds(250,258,60,20);
        systolicLabel.setVisible(false);

        diastolicLabel = new JLabel();
        diastolicLabel.setText("Diastolic:");
        diastolicLabel.setBounds(250,280,60,20);
        diastolicLabel.setVisible(false);

        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(160,30,250,30);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(160,81,250,30);

        countryTextField = new JTextField();
        countryTextField.setBounds(160,235,250,30);

        otherSymptomsTextField = new JTextField();
        otherSymptomsTextField.setBounds(505,268,190,25);

        fahrenheitDisplay = new JTextField();
        fahrenheitDisplay.setEditable(false);
        fahrenheitDisplay.setBounds(140,280,60,25);

        genderComboBox = new JComboBox<>();
        genderComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Male", "Female"}));
        genderComboBox.setBounds(160,132,100,30);

        ageComboBox = new JComboBox<>();
        ageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120" }));
        ageComboBox.setBounds(160,185,100,30);

        celsiusComboBox = new JComboBox<>();
        celsiusComboBox.setModel(new DefaultComboBoxModel<>(new String[]{ "35", "35.1", "35.2", "35.3", "35.4", "35.5", "35.6", "35.7", "35.8", "35.9", "36", "36.1", "36.2", "36.3", "36.4", "36.5", "36.6", "36.7", "36.8", "36.9", "37", "37.1", "37.2", "37.3", "37.4", "37.5", "37.6", "37.7", "37.8", "37.9", "38", "38.1", "38.2", "38.3", "38.4", "38.5", "39.5", "39.6", "39.7", "39.8", "39.9", "40.0"}));
        celsiusComboBox.setBounds(140,260,60,20);

        exposureValueButtonGroup = new ButtonGroup();
        bestPracticesButtonGroup = new ButtonGroup();
        exerciseButtonGroup = new ButtonGroup();
        alcoholButtonGroup = new ButtonGroup();

        addPatientButton = new JButton();
        addPatientButton.setBackground(new Color(0,204,204));
        addPatientButton.setFont(new Font("Futura Md BT", Font.BOLD,16));
        addPatientButton.setText("Add Patient");
        addPatientButton.setBounds(10,140,130,80);

        viewHistoryPatientButton = new JButton();
        viewHistoryPatientButton.setBackground(new Color(0,204,204));
        viewHistoryPatientButton.setFont(new Font("Futura Md BT", Font.BOLD,16));
        viewHistoryPatientButton.setText("View History");
        viewHistoryPatientButton.setBounds(10,230,130,80);

        queryButton = new JButton();
        queryButton.setBackground(new Color(0,204,204));
        queryButton.setFont(new Font("Futura Md BT", Font.BOLD,16));
        queryButton.setText("Query Stats.");
        queryButton.setBounds(10,320,130,80);

        signOutButton = new JButton();
        signOutButton.setBackground(new Color(0,204,204));
        signOutButton.setFont(new Font("Futura Md BT", Font.BOLD,16));
        signOutButton.setText("Sign Out");
        signOutButton.setBounds(10,410,130,80);

        saveButton = new JButton();
        saveButton.setText("Save");
        saveButton.setBounds(310,330,100,40);
        saveButton.setFont(new Font("Futura Md BT", Font.BOLD,16));

        exposureNoOption = new JRadioButton();
        exposureNoOption.setText("No/(N/A)");
        exposureNoOption.setBounds(485,40,80,30);

        exposureYesOption = new JRadioButton();
        exposureYesOption.setText("Yes");
        exposureYesOption.setBounds(410,40,75,30);

        healthProtocolNoOption = new JRadioButton();
        healthProtocolNoOption.setText("No/(N/A)");
        healthProtocolNoOption.setBounds(485,120,80,30);

        healthProtocolYesOption = new JRadioButton();
        healthProtocolYesOption.setText("Yes");
        healthProtocolYesOption.setBounds(410,120,75,30);

        exerciseNoOption = new JRadioButton();
        exerciseNoOption.setText("No/(N/A)");
        exerciseNoOption.setBounds(485,200,80,30);

        exerciseYesOption = new JRadioButton();
        exerciseYesOption.setText("Yes");
        exerciseYesOption.setBounds(410,200,75,30);

        alcoholNoOption = new JRadioButton();
        alcoholNoOption.setText("No/(N/A)");
        alcoholNoOption.setBounds(485,240,80,30);

        alcoholYesOption = new JRadioButton();
        alcoholYesOption.setText("Yes");
        alcoholYesOption.setBounds(410,240,75,30);

        /* Regular Symptoms Check Boxes */
        feverCheckBox = new JCheckBox();
        feverCheckBox.setText("Fever");
        feverCheckBox.setBounds(14,55,130,20);

        dryCoughCheckBox = new JCheckBox();
        dryCoughCheckBox.setText("Cough");
        dryCoughCheckBox.setBounds(14,80,130,20);

        tirednessCheckBox = new JCheckBox();
        tirednessCheckBox.setText("Tiredness");
        tirednessCheckBox.setBounds(14,105,130,20);

        noTasteCheckBox = new JCheckBox();
        noTasteCheckBox.setText("No Taste");
        noTasteCheckBox.setBounds(14,130,130,20);

        noSmellCheckBox = new JCheckBox();
        noSmellCheckBox.setText("No smell");
        noSmellCheckBox.setBounds(14,155,130,20);

        runningNoseCheckBox = new JCheckBox();
        runningNoseCheckBox.setText("Running Nose");
        runningNoseCheckBox.setBounds(14,180,130,20);

        soreThroatCheckBox = new JCheckBox();
        soreThroatCheckBox.setText("Sore Throat");
        soreThroatCheckBox.setBounds(14,205,130,20);

        headacheCheckBox = new JCheckBox();
        headacheCheckBox.setText("Headache");
        headacheCheckBox.setBounds(14,230,130,20);

        /* Mild Symptom Checkboxes */
        painsCheckBox = new JCheckBox();
        painsCheckBox.setText("Body Pain");
        painsCheckBox.setBounds(199,55,130,20);

        diarrhoeaCheckBox = new JCheckBox();
        diarrhoeaCheckBox.setText("Diarrhoea");
        diarrhoeaCheckBox.setBounds(199,80,130,20);

        irritatedEyes = new JCheckBox();
        irritatedEyes.setText("Irritated Eyes");
        irritatedEyes.setBounds(199,105,130,20);

        dizzinessCheckBox = new JCheckBox();
        dizzinessCheckBox.setText("Dizziness");
        dizzinessCheckBox.setBounds(199,130,130,20);

        blurredVisionCheckBox = new JCheckBox();
        blurredVisionCheckBox.setText("Blurred Vision");
        blurredVisionCheckBox.setBounds(199,155,130,20);

        /* Severe Symptoms check boxes */
        difficultyBreathingCheckBox = new JCheckBox();
        difficultyBreathingCheckBox.setText("Difficulty Breathing");
        difficultyBreathingCheckBox.setBounds(352,55,140,20);

        shortnessOfBreathCheckBox = new JCheckBox();
        shortnessOfBreathCheckBox.setText("Shortness of Breath");
        shortnessOfBreathCheckBox.setBounds(352,80,150,20);

        lossOfSpeechCheckBox = new JCheckBox();
        lossOfSpeechCheckBox.setText("Loss of Speech");
        lossOfSpeechCheckBox.setBounds(352,105,150,20);

        lossOfMobilityCheckBox = new JCheckBox();
        lossOfMobilityCheckBox.setText("Loss of Mobility");
        lossOfMobilityCheckBox.setBounds(352,130,150,20);

        confusionCheckBox = new JCheckBox();
        confusionCheckBox.setText("Confusion");
        confusionCheckBox.setBounds(352,155,130,20);

        chestPainsCheckBox = new JCheckBox();
        chestPainsCheckBox.setText("Chest Pain");
        chestPainsCheckBox.setBounds(352,180,130,20);

        rashOnSkinCheckBox = new JCheckBox();
        rashOnSkinCheckBox.setText("Rash on Skin");
        rashOnSkinCheckBox.setBounds(352,205,130,20);

        faintingCheckBox = new JCheckBox();
        faintingCheckBox.setText("Fainting");
        faintingCheckBox.setBounds(352,230,130,20);

        /* Variant Symptoms */
        nauseaCheckBox = new JCheckBox();
        nauseaCheckBox.setText("Nausea");
        nauseaCheckBox.setBounds(510,55,130,20);

        vomitingCheckBox = new JCheckBox();
        vomitingCheckBox.setText("Vomiting");
        vomitingCheckBox.setBounds(510,80,130,20);

        continuousCoughCheckBox = new JCheckBox();
        continuousCoughCheckBox.setText("Continuous Cough");
        continuousCoughCheckBox.setBounds(510,105,150,20);

        /* Diseases */
        asthmaCheckBox = new JCheckBox();
        asthmaCheckBox.setText("Asthma");
        asthmaCheckBox.setBounds(250,167,100,20);

        bronchitisCheckBox = new JCheckBox();
        bronchitisCheckBox.setText("Bronchitis");
        bronchitisCheckBox.setBounds(360,162,100,30);

        diabetesCheckBox = new JCheckBox();
        diabetesCheckBox.setText("Diabetes");
        diabetesCheckBox.setBounds(480,162,100,30);

        systolicComboBox = new JComboBox<>();
        systolicComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200"}));
        systolicComboBox.setBounds(310,260,60,20);
        systolicComboBox.setVisible(false);

        diastolicComboBox = new JComboBox<>();
        diastolicComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180"}));
        diastolicComboBox.setSelectedItem(80);
        diastolicComboBox.setBounds(310,280,60,20);
        diastolicComboBox.setVisible(false);

        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(155,5,510,40);

        sidebarPanel = new JPanel();
        sidebarPanel.setBackground(new Color(255, 135, 75));
        sidebarPanel.setLayout(null);
        sidebarPanel.setBounds(0,0,150,500);

        logoDisplayPanel = new JPanel();
        logoDisplayPanel.setBackground(new Color(255, 135, 75));
        logoDisplayPanel.setLayout(null);
        logoDisplayPanel.setBounds(10,10,130,110);

        displayPanel = new JPanel();
        displayPanel.setBackground(new Color(51,51,51));
        displayPanel.setLayout(null);
        displayPanel.setBounds(155,45,730,450);

        basicInformationTab = new JPanel();
        basicInformationTab.setLayout(null);

        exposureRiskFactorTab = new JPanel();
        exposureRiskFactorTab.setLayout(null);

        symptomsTab = new JPanel();
        symptomsTab.setLayout(null);

        sidebarSeparator = new JSeparator();
        sidebarSeparator.setBounds(10,125,135,5);

        regularSymptomsSeparator = new JSeparator();
        regularSymptomsSeparator.setBounds(14,48,135,2);

        mildSymptomsSeparator = new JSeparator();
        mildSymptomsSeparator.setBounds(199,50,115,2);

        severeSymptomsSeparator = new JSeparator();
        severeSymptomsSeparator.setBounds(354,50,135,2);

        variantsSymptomsSeparator = new JSeparator();
        variantsSymptomsSeparator.setBounds(510,50,135,2);

        allSymptomsSeparator = new JSeparator();
        allSymptomsSeparator.setBounds(14,255,680,2);

        /*seriousSymptomsSeperator2 = new JSeparator();
        seriousSymptomsSeperator2.setBounds(320,50,130,2);

        jSeparator1 = new JSeparator();
        jSeparator1.setBounds(10,210,130,2);

        jSeparator2 = new JSeparator();
        jSeparator2.setBounds(170,210,130,2); */

        addPatientTabPane = new JTabbedPane();
        addPatientTabPane.setBackground(new Color(102,102,102));
        addPatientTabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        addPatientTabPane.setBounds(10,12,715,430);
    }

    public void addToFrame() {
        logoDisplayPanel.add(logoDisplayLabel);

        sidebarPanel.add(logoDisplayPanel);
        sidebarPanel.add(sidebarSeparator);
        sidebarPanel.add(addPatientButton);
        sidebarPanel.add(queryButton);
        sidebarPanel.add(viewHistoryPatientButton);
        sidebarPanel.add(signOutButton);

        topPanel.add(menuDisplayLabel);

        basicInformationTab.add(firstNameLabel);
        basicInformationTab.add(firstNameTextField);
        basicInformationTab.add(lastNameLabel);
        basicInformationTab.add(lastNameTextField);
        basicInformationTab.add(genderLabel);
        basicInformationTab.add(genderComboBox);
        basicInformationTab.add(ageLabel);
        basicInformationTab.add(ageComboBox);
        basicInformationTab.add(countryLabel);
        basicInformationTab.add(countryTextField);

        exposureValueButtonGroup.add(exposureYesOption);
        exposureValueButtonGroup.add(exposureNoOption);
        bestPracticesButtonGroup.add(healthProtocolYesOption);
        bestPracticesButtonGroup.add(healthProtocolNoOption);
        exerciseButtonGroup.add(exerciseYesOption);
        exerciseButtonGroup.add(exerciseNoOption);
        alcoholButtonGroup.add(alcoholYesOption);
        alcoholButtonGroup.add(alcoholNoOption);

        exposureRiskFactorTab.add(erfHeaderLabel);
        exposureRiskFactorTab.add(exposureQuestionLabel);
        exposureRiskFactorTab.add(exposureYesOption);
        exposureRiskFactorTab.add(exposureNoOption);
        exposureRiskFactorTab.add(healthProtocolQuestionLabel);
        exposureRiskFactorTab.add(healthProtocolQuestion2Label);
        exposureRiskFactorTab.add(healthProtocolYesOption);
        exposureRiskFactorTab.add(healthProtocolNoOption);
        exposureRiskFactorTab.add(diseasesQuestionLabel);
        exposureRiskFactorTab.add(asthmaCheckBox);
        exposureRiskFactorTab.add(bronchitisCheckBox);
        exposureRiskFactorTab.add(diabetesCheckBox);
        exposureRiskFactorTab.add(exerciseQuestionLabel);
        exposureRiskFactorTab.add(alcoholQuestionLabel);
        exposureRiskFactorTab.add(exerciseNoOption);
        exposureRiskFactorTab.add(exerciseYesOption);
        exposureRiskFactorTab.add(alcoholNoOption);
        exposureRiskFactorTab.add(alcoholYesOption);

        symptomsTab.add(regularSymptomsLabel);
        symptomsTab.add(regularSymptomsSeparator);
        symptomsTab.add(feverCheckBox);
        symptomsTab.add(dryCoughCheckBox);
        symptomsTab.add(tirednessCheckBox);
        symptomsTab.add(noTasteCheckBox);
        symptomsTab.add(noSmellCheckBox);
        symptomsTab.add(runningNoseCheckBox);
        symptomsTab.add(soreThroatCheckBox);
        symptomsTab.add(headacheCheckBox);
        symptomsTab.add(mildSymptomsLabel);
        symptomsTab.add(mildSymptomsSeparator);
        symptomsTab.add(painsCheckBox);
        symptomsTab.add(diarrhoeaCheckBox);
        symptomsTab.add(irritatedEyes);
        symptomsTab.add(dizzinessCheckBox);
        symptomsTab.add(blurredVisionCheckBox);
        symptomsTab.add(severeSymptomsLabel);
        symptomsTab.add(severeSymptomsSeparator);
        symptomsTab.add(difficultyBreathingCheckBox);
        symptomsTab.add(shortnessOfBreathCheckBox);
        symptomsTab.add(lossOfSpeechCheckBox);
        symptomsTab.add(lossOfMobilityCheckBox);
        symptomsTab.add(confusionCheckBox);
        symptomsTab.add(chestPainsCheckBox);
        symptomsTab.add(rashOnSkinCheckBox);
        symptomsTab.add(faintingCheckBox);
        symptomsTab.add(variantsSymptomsLabel);
        symptomsTab.add(variantsSymptomsSeparator);
        symptomsTab.add(nauseaCheckBox);
        symptomsTab.add(vomitingCheckBox);
        symptomsTab.add(continuousCoughCheckBox);
        symptomsTab.add(allSymptomsSeparator);
        symptomsTab.add(otherSymptomsLabel);
        symptomsTab.add(otherSymptomsTextField);

        symptomsTab.add(temperatureCelsiusLabel);
        symptomsTab.add(celsiusComboBox);
        symptomsTab.add(temperatureFahrComboLabel);
        symptomsTab.add(fahrenheitDisplay);

        symptomsTab.add(systolicLabel);
        symptomsTab.add(systolicComboBox);
        symptomsTab.add(diastolicLabel);
        symptomsTab.add(diastolicComboBox);

        symptomsTab.add(saveButton);

        //symptomsTab.add(temperatureCelsiusLabel2);
        //symptomsTab.add(temperatureFahrComboLabel2);
        //symptomsTab.add(seriousSymptomsSeperator2);
        //symptomsTab.add(jSeparator1);
        //symptomsTab.add(jSeparator2);

        addPatientTabPane.addTab("Basic Information", basicInformationTab);
        addPatientTabPane.addTab("Symptoms",symptomsTab);
        addPatientTabPane.addTab("Risk Factors", exposureRiskFactorTab);

        displayPanel.add(addPatientTabPane);

        getContentPane().add(sidebarPanel);
        getContentPane().add(topPanel);
        getContentPane().add(displayPanel);

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

        firstNameTextField.addActionListener(e -> actionListeners.firstNameTextFieldActionPerformed());

        lastNameTextField.addActionListener(e -> actionListeners.lastNameTextFieldActionPerformed());

        countryTextField.addActionListener(e -> actionListeners.countryTextFieldActionPerformed());

        otherSymptomsTextField.addActionListener(e -> actionListeners.otherSymptomsTextFieldActionPerformed());

        genderComboBox.addActionListener(e -> actionListeners.genderComboBoxActionPerformed());

        ageComboBox.addActionListener(e -> actionListeners.ageComboBoxActionPerformed());

        exposureYesOption.addActionListener(e -> actionListeners.exposureYesOptionActionPerformed());

        exposureNoOption.addActionListener(e -> actionListeners.exposureNoOptionActionPerformed());

        healthProtocolYesOption.addActionListener(e -> actionListeners.healthProtocolYesOptionActionPerformed());

        healthProtocolNoOption.addActionListener(e -> actionListeners.healthProtocolNoOptionActionPerformed());

        exerciseYesOption.addActionListener(e -> actionListeners.exerciseYesOptionActionPerformed());

        exerciseNoOption.addActionListener(e -> actionListeners.exerciseNoOptionActionPerformed());

        alcoholYesOption.addActionListener(e -> actionListeners.alcoholYesOptionActionPerformed());

        alcoholNoOption.addActionListener(e -> actionListeners.alcoholNoOptionActionPerformed());

        dizzinessCheckBox.addActionListener(e -> actionListeners.dizzinessCheckBoxActionPerformed());

        faintingCheckBox.addActionListener(e -> actionListeners.faintingCheckBoxActionPerformed());

        blurredVisionCheckBox.addActionListener(e -> actionListeners.blurredVisionCheckBoxActionPerformed());

        celsiusComboBox.addActionListener(e -> actionListeners.celsiusComboBoxActionPerformed());

        systolicComboBox.addActionListener(e -> actionListeners.systolicComboBoxActionPerformed());

        diastolicComboBox.addActionListener(e -> actionListeners.diastolicComboBoxActionPerformed());

        feverCheckBox.addActionListener(e -> actionListeners.feverCheckBoxActionPerformed());

        dryCoughCheckBox.addActionListener(e -> actionListeners.dryCoughCheckBoxActionPerformed());

        tirednessCheckBox.addActionListener(e -> actionListeners.tirednessCheckBoxActionPerformed());

        noTasteCheckBox.addActionListener(e -> actionListeners.noTasteCheckBoxActionPerformed());

        noSmellCheckBox.addActionListener(e -> actionListeners.noSmellCheckBoxActionPerformed());

        runningNoseCheckBox.addActionListener(e -> actionListeners.runningNoseCheckBoxActionPerformed());

        soreThroatCheckBox.addActionListener(e -> actionListeners.soreThroatCheckBoxActionPerformed());

        headacheCheckBox.addActionListener(e -> actionListeners.headacheCheckBoxActionPerformed());

        painsCheckBox.addActionListener(e -> actionListeners.painsCheckBoxActionPerformed());

        diarrhoeaCheckBox.addActionListener(e -> actionListeners.diarrhoeaCheckBoxActionPerformed());

        irritatedEyes.addActionListener(e -> actionListeners.irritatedEyesActionPerformed());

        difficultyBreathingCheckBox.addActionListener(e -> actionListeners.difficultyBreathingCheckBoxActionPerformed());

        shortnessOfBreathCheckBox.addActionListener(e -> actionListeners.shortnessOfBreathCheckBoxActionPerformed());

        lossOfMobilityCheckBox.addActionListener(e -> actionListeners.lossOfMobilityCheckBoxActionPerformed());

        confusionCheckBox.addActionListener(e -> actionListeners.confusionCheckBoxActionPerformed());

        chestPainsCheckBox.addActionListener(e -> actionListeners.chestPainsCheckBoxActionPerformed());

        rashOnSkinCheckBox.addActionListener(e -> actionListeners.rashOnSkinCheckBoxActionPerformed());

        lossOfSpeechCheckBox.addActionListener(e -> actionListeners.lossOfSpeechCheckBoxActionPerformed());

        nauseaCheckBox.addActionListener(e -> actionListeners.nauseaCheckBoxActionPerformed());

        vomitingCheckBox.addActionListener(e -> actionListeners.vomitingCheckBoxActionPerformed());

        continuousCoughCheckBox.addActionListener(e -> actionListeners.continuousCoughCheckBoxActionPerformed());

        asthmaCheckBox.addActionListener(e -> actionListeners.asthmaCheckBoxActionPerformed());

        bronchitisCheckBox.addActionListener(e -> actionListeners.bronchitisCheckBoxActionPerformed());

        diabetesCheckBox.addActionListener(e -> actionListeners.diabetesCheckBoxActionPerformed());

        saveButton.addActionListener(e -> {
            actionListeners.saveButtonActionPerformed();
            dispose();
        });

        /*fahrenheitDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fahrenheitDisplayActionPerformed(e);
            }
        }); */
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

        //Create and display the logoDisplayPanel
        EventQueue.invokeLater(() -> new AddPatient().setVisible(true));
    }
}
