package calculations;

import database.PatientAddDb;
import models.Disease;
import models.Lifestyle;
import models.Patient;
import models.Symptoms;
import views.*;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class ActionListeners {
    Symptoms symptoms = new Symptoms();
    Patient newPatient = new Patient();
    Lifestyle lifestyle = new Lifestyle();
    Disease disease = new Disease();
    QueryProlog queryProlog = new QueryProlog();
    PatientAddDb patientAddDb = new PatientAddDb();
    Diagnosis diagnosis = new Diagnosis();
    BloodPressure bloodPressure = new BloodPressure();
    Recomendations recomendations = new Recomendations();


    public ActionListeners() {
    }


    public void signInButtonActionPerformed(ActionEvent e) {
        String username = Login.usernameTextField.getText();
        String password = String.valueOf(Login.passwordField.getPassword());

        patientAddDb.signIn(username,password);
    }

    public void resetButtonActionPerformed(ActionEvent e) {
        Login.usernameTextField.setText("");
        Login.passwordField.setText("");
    }

    public void covidQueryButtonActionPerformed(ActionEvent e) {
        patientAddDb.selectAllForQuery();
    }

    public void diagnosisOverviewTextAreaAncestorAdded(AncestorEvent event) {
        DiagnosisandRecomendation.report.patientDiagnosisReport();
    }

    public void dashboardButtonActionPerformed() {
        new Dashboard().setVisible(true);
    }

    public void addPatientButtonActionPerformed() {
        AddPatient addPatientLink = new AddPatient();
        addPatientLink.setVisible(true);
    }

    public void queryButtonActionPerformed() {
        QueryStats queryStatsLink = new QueryStats();
        queryStatsLink.setVisible(true);
    }

    public void tirednessCheckBoxActionPerformed() {
        symptoms.setTiredness(AddPatient.tirednessCheckBox.isSelected());
    }

    public void noTasteCheckBoxActionPerformed() {
        symptoms.setNoTaste(AddPatient.noTasteCheckBox.isSelected());
    }

    public void noSmellCheckBoxActionPerformed() {
        symptoms.setNoSmell(AddPatient.noSmellCheckBox.isSelected());
    }

    public void runningNoseCheckBoxActionPerformed() {
        symptoms.setRunningNose(AddPatient.runningNoseCheckBox.isSelected());
    }

    public void soreThroatCheckBoxActionPerformed() {
        symptoms.setSoreThroat(AddPatient.soreThroatCheckBox.isSelected());
    }

    public void headacheCheckBoxActionPerformed() {
        symptoms.setHeadache(AddPatient.headacheCheckBox.isSelected());
    }

    public void painsCheckBoxActionPerformed() {
        symptoms.setPains(AddPatient.painsCheckBox.isSelected());
    }

    public void diarrhoeaCheckBoxActionPerformed() {
        symptoms.setDiarrhoea(AddPatient.diarrhoeaCheckBox.isSelected());
    }

    public void irritatedEyesActionPerformed() {
        symptoms.setIrritatedEyes(AddPatient.tirednessCheckBox.isSelected());
    }

    public void chestPainsCheckBoxActionPerformed() {
        symptoms.setChestPain(AddPatient.chestPainsCheckBox.isSelected());
    }

    public void rashOnSkinCheckBoxActionPerformed() {
        symptoms.setRashOnSkin(AddPatient.rashOnSkinCheckBox.isSelected());
    }

    public void lossOfSpeechCheckBoxActionPerformed() {
        symptoms.setLossOfSpeech(AddPatient.lossOfSpeechCheckBox.isSelected());
    }

    public void lossOfMobilityCheckBoxActionPerformed() {
        symptoms.setLossOfMobility(AddPatient.lossOfMobilityCheckBox.isSelected());
    }

    public void confusionCheckBoxActionPerformed() {
        symptoms.setConfusion(AddPatient.confusionCheckBox.isSelected());
    }

    public void feverCheckBoxActionPerformed() {
        symptoms.setFever(AddPatient.feverCheckBox.isSelected());
    }

    public void dryCoughCheckBoxActionPerformed() {
        symptoms.setCough(AddPatient.dryCoughCheckBox.isSelected());
    }

    public void blurredVisionCheckBoxActionPerformed() {
        if (AddPatient.blurredVisionCheckBox.isSelected()) {
            symptoms.setBlurredVision(true);
            AddPatient.systolicLabel.setVisible(true);
            AddPatient.diastolicLabel.setVisible(true);
            AddPatient.systolicComboBox.setVisible(true);
            AddPatient.diastolicComboBox.setVisible(true);
        }else {
            symptoms.setBlurredVision(false);
            AddPatient.systolicLabel.setVisible(false);
            AddPatient.diastolicLabel.setVisible(false);
            AddPatient.systolicComboBox.setVisible(false);
            AddPatient.diastolicComboBox.setVisible(false);
        }
    }

    public void difficultyBreathingCheckBoxActionPerformed() {
        symptoms.setDifficultyBreathing(AddPatient.difficultyBreathingCheckBox.isSelected());
    }

    public void shortnessOfBreathCheckBoxActionPerformed() {
        symptoms.setShortnessOfBreath(AddPatient.shortnessOfBreathCheckBox.isSelected());
    }

    public void faintingCheckBoxActionPerformed() {
        if (AddPatient.faintingCheckBox.isSelected()) {
            symptoms.setFainting(true);
            AddPatient.systolicLabel.setVisible(true);
            AddPatient.diastolicLabel.setVisible(true);
            AddPatient.systolicComboBox.setVisible(true);
            AddPatient.diastolicComboBox.setVisible(true);
        }else {
            symptoms.setFainting(false);
            AddPatient.systolicLabel.setVisible(false);
            AddPatient.diastolicLabel.setVisible(false);
            AddPatient.systolicComboBox.setVisible(false);
            AddPatient.diastolicComboBox.setVisible(false);
        }
    }

    public void dizzinessCheckBoxActionPerformed() {
        if (AddPatient.dizzinessCheckBox.isSelected()) {
            symptoms.setDizziness(true);
            AddPatient.systolicLabel.setVisible(true);
            AddPatient.diastolicLabel.setVisible(true);
            AddPatient.systolicComboBox.setVisible(true);
            AddPatient.diastolicComboBox.setVisible(true);
        }else {
            symptoms.setDizziness(false);
            AddPatient.systolicLabel.setVisible(false);
            AddPatient.diastolicLabel.setVisible(false);
            AddPatient.systolicComboBox.setVisible(false);
            AddPatient.diastolicComboBox.setVisible(false);
        }
    }

    public void nauseaCheckBoxActionPerformed() {
        symptoms.setNausea(AddPatient.nauseaCheckBox.isSelected());
    }

    public void vomitingCheckBoxActionPerformed() {
        symptoms.setVomiting(AddPatient.vomitingCheckBox.isSelected());
    }

    public void continuousCoughCheckBoxActionPerformed() {
        symptoms.setContinuousCough(AddPatient.continuousCoughCheckBox.isSelected());
    }

    public void firstNameTextFieldActionPerformed() {
        String firstName = AddPatient.firstNameTextField.getText();
        newPatient.setFirstName(firstName);
    }

    public void otherSymptomsTextFieldActionPerformed() {
        symptoms.setNewSymptom(AddPatient.otherSymptomsTextField.getText());
    }

    public void genderComboBoxActionPerformed() {
        String genderString = Objects.requireNonNull(AddPatient.genderComboBox.getSelectedItem()).toString();
        newPatient.setGender(genderString);
    }

    public void ageComboBoxActionPerformed() {
        String ageString = Objects.requireNonNull(AddPatient.ageComboBox.getSelectedItem()).toString();
        newPatient.setAge(Integer.parseInt(ageString));
    }

    public void lastNameTextFieldActionPerformed() {
        newPatient.setLastName(AddPatient.lastNameTextField.getText());
    }

    public void countryTextFieldActionPerformed() {
        //String country = AddPatient.countryTextField.getText();
        //System.out.println("Country: " + country);
        //newPatient.setCountry(country);
        newPatient.setCountry(AddPatient.countryTextField.getText());
    }

    public void celsiusComboBoxActionPerformed() {
        String celsiusValue = Objects.requireNonNull(AddPatient.celsiusComboBox.getSelectedItem()).toString();
        queryProlog.convertCelsiusToFah(Double.parseDouble(celsiusValue));

        String fahrenheitValue = queryProlog.fahrenheit;
        AddPatient.fahrenheitDisplay.setText(fahrenheitValue);

        int fever = queryProlog.checkForFever(Double.parseDouble(fahrenheitValue));

        symptoms.setFever(fever == 1);
    }

    public void saveButtonActionPerformed() {
        newPatient.setFirstName(AddPatient.firstNameTextField.getText());
        newPatient.setLastName(AddPatient.lastNameTextField.getText());
        diagnosis.setSymptoms(symptoms);
        diagnosis.setNewPatient(newPatient);
        diagnosis.setLifestyle(lifestyle);
        diagnosis.setDisease(disease);

        //System.out.println(newPatient.getCountry());
        //System.out.println(newPatient.toString());
        //System.out.println(symptoms.getCovidExposure().toString());

        diagnosis.covidPredictor();
        diagnosis.exposureCalculator();

        patientAddDb.insert(newPatient.getFirstName(), newPatient.getLastName(), newPatient.getAge(), newPatient.getGender(),
                newPatient.getCountry(), symptoms.getCovidExposure(), symptoms.getImproperCovidProtocol(),
                symptoms.toString(), AddPatient.fahrenheitDisplay.getText(), bloodPressure.toString(),
                diagnosis.getHighRiskPatient(), diagnosis.patientDiagnosisReport());


        JOptionPane.showMessageDialog(null, "Save Successful, Generating Report");

        bloodPressure.lowBloodPressureReader(bloodPressure.getSystolicValue(), bloodPressure.getDiastolicValue());
        bloodPressure.bloodPressureReview();

        new DiagnosisandRecomendation(newPatient.toString(), diagnosis.getPatientDiagnosisReport(),
                recomendations.recommendations()).setVisible(true);
    }

    public void systolicComboBoxActionPerformed() {
        String bloodPressureString = Objects.requireNonNull(AddPatient.systolicComboBox.getSelectedItem()).toString();
        int systolicValue = Integer.parseInt(bloodPressureString);
        bloodPressure.setSystolicValue(systolicValue);
    }

    public void diastolicComboBoxActionPerformed() {
        String bloodPressureString = Objects.requireNonNull(AddPatient.diastolicComboBox.getSelectedItem()).toString();
        int diastolicValue = Integer.parseInt(bloodPressureString);
        bloodPressure.setDiastolicValue(diastolicValue);
    }

    public void exposureYesOptionActionPerformed() {
        symptoms.setCovidExposure(true);
    }

    public void exposureNoOptionActionPerformed() {
        symptoms.setCovidExposure(false);
    }

    public void healthProtocolYesOptionActionPerformed() {
        symptoms.setImproperCovidProtocol(true);
    }

    public void healthProtocolNoOptionActionPerformed() {
        symptoms.setImproperCovidProtocol(false);
    }

    public void exerciseYesOptionActionPerformed() {
        lifestyle.setExercise(true);
    }

    public void exerciseNoOptionActionPerformed() {
        lifestyle.setExercise(false);
    }

    public void alcoholYesOptionActionPerformed() {
        lifestyle.setAlcohol(true);
    }

    public void alcoholNoOptionActionPerformed() {
        lifestyle.setAlcohol(false);
    }

    public void asthmaCheckBoxActionPerformed() {
        disease.setAsthma(AddPatient.asthmaCheckBox.isSelected());
    }

    public void bronchitisCheckBoxActionPerformed() {
        disease.setBronchitis(AddPatient.bronchitisCheckBox.isSelected());
    }

    public void diabetesCheckBoxActionPerformed() {
        disease.setBronchitis(AddPatient.diabetesCheckBox.isSelected());
    }
}
