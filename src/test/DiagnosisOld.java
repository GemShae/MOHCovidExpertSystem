package test;
import calculations.BloodPressure;
import models.Patient;
import models.Symptoms;

/*
    *****   OBJECTIVES    *****
    1. Initialize all values of database symptoms to no - the value system will then reflect 0 for all until new
       information is entered
    2. Modifiers -  If patient has had known contact with person with covid 19 then exposureModifier = +3 else 0
                        If the patient has had contact with person with covid19 - provide a solution
                    If patient has practiced consistent social distancing then bestPracticeModifier = 0 else +1
                    If patient doesn't practice bestPractices always = 0  sometimes = +1 never = +2
                        based on patients best practices system will provide recommendation for that patient
    3.Symptoms List Severe Symptoms = +3 per symptom , Common = +2,  less common = +1
    4.For each symptom which the patient has the system will add it to the modifiers and sum total
        If total is 0 - 11 then mild , if total is greater than 12 then severe
        this program will be used for query
 */
public class DiagnosisOld {
    public static Symptoms symptoms = new Symptoms();
    Patient patient = new Patient();
    BloodPressure bloodPressure = new BloodPressure();

    //Modifiers: true values of Booleans will alter value of Mods, the resulting calculation will be used to determine covid
    // Probability
    //Formula for covidProbability = value of each symptom + exposureModifiers + severity Modifier(s)
    //If patient were to have exposure to covidpatient = +5 , has soar throat = +3 , has chest pains = +3 (2 severe symptoms = +3),
    // and soar throat + 2 = (5 + 3 + 3 + 2 + 2) = 15 , 15 > 12 thus patient has high probability of having covid
    //Probability Modifiers
    final int covidSymptomThreshold = 12;
    private int covidExposureMod;
    private int improperCovidProtocolMod;

    //Severity Modifiers: 2 or more symptoms within the same group will receive a bonus value added
    private int totalModifier = covidExposureMod + improperCovidProtocolMod;
    private int totalSymptoms;
    private int totalCalculation;
    //Severe Covid Symptoms : base value = 3
    private int soreThroatMod;
    private int chestPainMod;
    private int lossOfSpeechMod;

    //common symptoms       : base value = 2
    private int feverMod;
    private int dryCoughMod;
    private int tirednessMod;

    //less common symptoms  : base value = 1
    private int dizzinessMod;
    private int faintingMod;
    private int blurredVisionMod;

    // Blood pressure values :  will be used to calculate if blood pressure is low or not and display result in  Diagnosis as
    // well as save to database for that patient
    private int systolicValue;
    private int diastolicValue;

    private static Boolean highRiskPatient;
    private String covidPrediction;
    private String patientDiagnosisReport;

    //*****         METHODS         *****
    //This method return integer values of possible exposure Events and returns the total
    //RETURNS totalExposure INT Value
    public void exposureModifier() {
        if (symptoms.getCovidExposure()) {
            setCovidExposureMod(5);
        } else if (!symptoms.getImproperCovidProtocol()) {
            setImproperCovidProtocolMod(0);
        } else if (!symptoms.getCovidExposure()) {
            setCovidExposureMod(0);
        } else if (symptoms.getImproperCovidProtocol()) {
            setImproperCovidProtocolMod(0);
        }
        setTotalModifier(getCovidExposureMod() + getImproperCovidProtocolMod());
    }

    //This Method calculates the likelihood of a patient having covid by symptoms and eventModifiers and returns a
    // boolean value on whether the patient is likely high risk or not
    //RETURNS likelihood of High Risk Patient BOOLEAN Value
    public void covidPredictor() {
        exposureModifier();

        if (symptoms.getSoreThroat()) {
            setSoreThroatMod(3);
        } else if (symptoms.getSoreThroat() == null) {
            symptoms.setSoreThroat(false);
            setSoreThroatMod(0);
        }

        if (symptoms.getChestPain()) {
            setChestPainMod(3);
        } else {
            setChestPainMod(0);
        }

        if (symptoms.getLossOfSpeech()) {
            setLossOfSpeechMod(3);
        } else {
            setLossOfSpeechMod(0);
        }

        if (symptoms.getFever()) {
            setFeverMod(2);
        } else {
            setFeverMod(0);
        }

        if (symptoms.getCough()) {
            setDryCoughMod(2);
        } else {
            setDryCoughMod(0);
        }

        if (symptoms.getTiredness()) {
            setTirednessMod(2);
        } else {
            setTirednessMod(0);
        }

        if (symptoms.getDizziness()) {
            setDizzinessMod(1);
        } else {
            setDizzinessMod(0);
        }

        if (symptoms.getFainting()) {
            setFaintingMod(1);
        } else {
            setFaintingMod(0);
        }
        if (symptoms.getBlurredVision()) {
            setBlurredVisionMod(1);
        } else {
            setBlurredVisionMod(0);
        }

        setTotalSymptoms(getSoreThroatMod() + getChestPainMod() + getLossOfSpeechMod() + getFeverMod() + getDryCoughMod() +
                getTirednessMod() + getDizzinessMod() + getFaintingMod() + getBlurredVisionMod());

        setTotalCalculation(getTotalModifier() + getTotalSymptoms());

        if (getTotalCalculation() > covidSymptomThreshold) {
            setHighRiskPatient(true);
        } else if (getTotalCalculation() < covidSymptomThreshold) {
            setHighRiskPatient(false);
        }
    }

    public void covidPredictionResult() {
        covidPredictor();

        if (getHighRiskPatient()) {
            setCovidPrediction("Patient is at HIGH risk of having Covid-19");
        } else if (!getHighRiskPatient()) {
            setCovidPrediction("Patient is at LOW risk of having Covid-19");
        }
    }

    //This Method returns the full Diagnostic Report for the patient
    public String patientDiagnosisReport() {
        covidPredictionResult();

        System.out.println(bloodPressure.toString());
        System.out.println(bloodPressure.getDiastolicValue());
        System.out.println(bloodPressure.getSystolicValue());
        setPatientDiagnosisReport(getCovidPrediction() + "\n" + "\n" + symptoms.toString());
        return getPatientDiagnosisReport();
    }


    public DiagnosisOld() {
        this.covidExposureMod = 0;
        this.improperCovidProtocolMod = 0;
        this.totalSymptoms = 0;
        this.totalCalculation = 0;
        this.soreThroatMod = 0;
        this.chestPainMod = 0;
        this.lossOfSpeechMod = 0;
        this.feverMod = 0;
        this.dryCoughMod = 0;
        this.tirednessMod = 0;
        this.dizzinessMod = 0;
        this.faintingMod = 0;
        this.blurredVisionMod = 0;
        this.systolicValue = 0;
        this.diastolicValue = 0;
    }

    public DiagnosisOld(int covidExposureMod, int improperCovidProtocolMod, int totalModifier, int totalSymptoms, int totalCalculation, int soreThroatMod, int chestPainMod, int lossOfSpeechMod, int feverMod, int dryCoughMod, int tirednessMod, int dizzinessMod, int faintingMod, int blurredVisionMod, int systolicValue, int diastolicValue) {
        this.covidExposureMod = covidExposureMod;
        this.improperCovidProtocolMod = improperCovidProtocolMod;
        this.totalModifier = totalModifier;
        this.totalSymptoms = totalSymptoms;
        this.totalCalculation = totalCalculation;
        this.soreThroatMod = soreThroatMod;
        this.chestPainMod = chestPainMod;
        this.lossOfSpeechMod = lossOfSpeechMod;
        this.feverMod = feverMod;
        this.dryCoughMod = dryCoughMod;
        this.tirednessMod = tirednessMod;
        this.dizzinessMod = dizzinessMod;
        this.faintingMod = faintingMod;
        this.blurredVisionMod = blurredVisionMod;
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {
        this.symptoms = symptoms;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public BloodPressure getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(BloodPressure bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getCovidExposureMod() {
        return covidExposureMod;
    }

    public void setCovidExposureMod(int covidExposureMod) {
        this.covidExposureMod = covidExposureMod;
    }

    public int getImproperCovidProtocolMod() {
        return improperCovidProtocolMod;
    }

    public void setImproperCovidProtocolMod(int improperCovidProtocolMod) {
        this.improperCovidProtocolMod = improperCovidProtocolMod;
    }

    public int getTotalModifier() {
        return totalModifier;
    }

    public void setTotalModifier(int totalModifier) {
        this.totalModifier = totalModifier;
    }

    public int getTotalSymptoms() {
        return totalSymptoms;
    }

    public void setTotalSymptoms(int totalSymptoms) {
        this.totalSymptoms = totalSymptoms;
    }

    public int getTotalCalculation() {
        return totalCalculation;
    }

    public void setTotalCalculation(int totalCalculation) {
        this.totalCalculation = totalCalculation;
    }

    public int getSoreThroatMod() {
        return soreThroatMod;
    }

    public void setSoreThroatMod(int soreThroatMod) {
        this.soreThroatMod = soreThroatMod;
    }

    public int getChestPainMod() {
        return chestPainMod;
    }

    public void setChestPainMod(int chestPainMod) {
        this.chestPainMod = chestPainMod;
    }

    public int getLossOfSpeechMod() {
        return lossOfSpeechMod;
    }

    public void setLossOfSpeechMod(int lossOfSpeechMod) {
        this.lossOfSpeechMod = lossOfSpeechMod;
    }

    public int getFeverMod() {
        return feverMod;
    }

    public void setFeverMod(int feverMod) {
        this.feverMod = feverMod;
    }

    public int getDryCoughMod() {
        return dryCoughMod;
    }

    public void setDryCoughMod(int dryCoughMod) {
        this.dryCoughMod = dryCoughMod;
    }

    public int getTirednessMod() {
        return tirednessMod;
    }

    public void setTirednessMod(int tirednessMod) {
        this.tirednessMod = tirednessMod;
    }

    public int getDizzinessMod() {
        return dizzinessMod;
    }

    public void setDizzinessMod(int dizzinessMod) {
        this.dizzinessMod = dizzinessMod;
    }

    public int getFaintingMod() {
        return faintingMod;
    }

    public void setFaintingMod(int faintingMod) {
        this.faintingMod = faintingMod;
    }

    public int getBlurredVisionMod() {
        return blurredVisionMod;
    }

    public void setBlurredVisionMod(int blurredVisionMod) {
        this.blurredVisionMod = blurredVisionMod;
    }

    public int getSystolicValue() {
        return systolicValue;
    }

    public void setSystolicValue(int systolicValue) {
        this.systolicValue = systolicValue;
    }

    public int getDiastolicValue() {
        return diastolicValue;
    }

    public void setDiastolicValue(int diastolicValue) {
        this.diastolicValue = diastolicValue;
    }

    public static Boolean getHighRiskPatient() {
        return highRiskPatient;
    }

    public void setHighRiskPatient(Boolean highRiskPatient) {
        DiagnosisOld.highRiskPatient = highRiskPatient;
    }

    public String getCovidPrediction() {
        return covidPrediction;
    }

    public void setCovidPrediction(String covidPrediction) {
        this.covidPrediction = covidPrediction;
    }

    public String getPatientDiagnosisReport() {
        return patientDiagnosisReport;
    }

    public void setPatientDiagnosisReport(String patientDiagnosisReport) {
        this.patientDiagnosisReport = patientDiagnosisReport;
    }
}
