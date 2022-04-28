package calculations;

/*
    ***OBJECTIVES***
 */

import models.Disease;
import models.Lifestyle;
import models.Patient;
import models.Symptoms;

public class Diagnosis {
    public static Symptoms symptoms = new Symptoms();
    public Patient newPatient = new Patient();
    public Lifestyle lifestyle = new Lifestyle();
    public Disease disease = new Disease();
    public QueryProlog queryProlog = new QueryProlog();
    BloodPressure bloodPressure = new BloodPressure();

//Blood Pressure

    final int covidRiskThreshold=10;
    private int covidExposureMod;
    private int improperCovidProtocolMod;
    private int highSymptomsMod;
    private int highDiseaseMod;

    private int totalModifier;
    private int totalSymptoms;
    private int totalCalculation;

    // Blood pressure values :  will be used to calculate if blood pressure is low or not and display result in  Diagnosis as
    // well as save to database for that patient
    private int systolicValue;
    private int diastolicValue;

    private static Boolean highRiskPatient;
    private String covidPrediction;
    private String patientDiagnosisReport;
    private String symptomsList;
    private String variantSymptomsList;
    private String diseaseList;
    private static String haveCovid;
    private static String haveVariant;

    private static int regularSymptoms=0;
    private static int mildSymptoms=0;
    private static int severeSymptoms=0;
    private static int muVariant=0;
    private static int deltaVariant=0;

    //
    public void exposureCalculator() {
        StringBuffer actualSymptomsList = new StringBuffer(symptomsList);
        actualSymptomsList.deleteCharAt(actualSymptomsList.length()-1);

        setHighSymptomsMod(queryProlog.listOfSymptomsRisk(actualSymptomsList));

        if (disease.getAsthma()) {
            diseaseList = diseaseList.concat(disease.asthmaProlog).concat(",");
        }
        if (disease.getBronchitis()) {
            diseaseList = diseaseList.concat(disease.bronchitisProlog).concat(",");
        }
        if (disease.getDiabetes()) {
            diseaseList = diseaseList.concat(disease.diabetesProlog).concat(",");
        }

        if (diseaseList == null) {
            setHighDiseaseMod(0);
        }else {
            StringBuffer actualDiseaseList = new StringBuffer(diseaseList);
            actualDiseaseList.deleteCharAt(actualDiseaseList.length() - 1);

            setHighDiseaseMod(queryProlog.listOfDiseasesRisk(actualDiseaseList));
        }

        if (symptoms.getCovidExposure()) {
            setCovidExposureMod(queryProlog.covidExposure("true"));
        }else {
            setCovidExposureMod(queryProlog.covidExposure("false"));
        }

        if (symptoms.getImproperCovidProtocol()) {
            setImproperCovidProtocolMod(queryProlog.covidProtocol("true"));
        }else {
            setImproperCovidProtocolMod(queryProlog.covidProtocol("false"));
        }

        setTotalModifier(getHighSymptomsMod()+getHighDiseaseMod()+getCovidExposureMod()+getImproperCovidProtocolMod());

        setHighRiskPatient((getTotalModifier() > covidRiskThreshold));

        if (getHighRiskPatient()) {
            setCovidPrediction("Patient is at HIGH risk of having Covid-19");
        } else {
            setCovidPrediction("Patient is at LOW risk of having Covid-19");
        }
    }

    //
    public void covidPredictor() {
        if (symptoms.getFever()) {
            symptomsList = symptomsList.concat(symptoms.feverProlog).concat(",");
        }
        if (symptoms.getCough()) {
            symptomsList = symptomsList.concat(symptoms.coughProlog).concat(",");
        }
        if (symptoms.getTiredness()) {
            symptomsList = symptomsList.concat(symptoms.tirednessProlog).concat(",");
        }
        if (symptoms.getNoTaste()) {
            symptomsList = symptomsList.concat(symptoms.noTasteProlog).concat(",");
        }
        if (symptoms.getNoSmell()) {
            symptomsList = symptomsList.concat(symptoms.noSmellProlog).concat(",");
        }
        if (symptoms.getRunningNose()) {
            symptomsList = symptomsList.concat(symptoms.runningNoseProlog).concat(",");
        }
        if (symptoms.getSoreThroat()) {
            symptomsList = symptomsList.concat(symptoms.soreThroatProlog).concat(",");
        }
        if (symptoms.getHeadache()) {
            symptomsList = symptomsList.concat(symptoms.headacheProlog).concat(",");
        }
        if (symptoms.getPains()) {
            symptomsList = symptomsList.concat(symptoms.painsProlog).concat(",");
        }
        if (symptoms.getDiarrhoea()) {
            symptomsList = symptomsList.concat(symptoms.diarrhoeaProlog).concat(",");
        }
        if (symptoms.getIrritatedEyes()) {
            symptomsList = symptomsList.concat(symptoms.irritatedEyesProlog).concat(",");
        }
        if (symptoms.getDizziness()) {
            symptomsList = symptomsList.concat(symptoms.dizzinessProlog).concat(",");
        }
        if (symptoms.getBlurredVision()) {
            symptomsList = symptomsList.concat(symptoms.blurredVisionProlog).concat(",");
        }
        if (symptoms.getDifficultyBreathing()) {
            symptomsList = symptomsList.concat(symptoms.difficultyBreathingProlog).concat(",");
        }
        if (symptoms.getShortnessOfBreath()) {
            symptomsList = symptomsList.concat(symptoms.shortnessOfBreathProlog).concat(",");
        }
        if (symptoms.getLossOfSpeech()) {
            symptomsList = symptomsList.concat(symptoms.lossOfSpeechProlog).concat(",");
        }
        if (symptoms.getLossOfMobility()) {
            symptomsList = symptomsList.concat(symptoms.lossOfMobilityProlog).concat(",");
        }
        if (symptoms.getConfusion()) {
            symptomsList = symptomsList.concat(symptoms.confusionProlog).concat(",");
        }
        if (symptoms.getChestPain()) {
            symptomsList = symptomsList.concat(symptoms.chestPainProlog).concat(",");
        }
        if (symptoms.getRashOnSkin()) {
            symptomsList = symptomsList.concat(symptoms.rashOnSkinProlog).concat(",");
        }
        if (symptoms.getFainting()) {
            symptomsList = symptomsList.concat(symptoms.faintingProlog).concat(",");
        }

        //symptomsList = symptomsList.concat(symptoms.getNewSymptom().concat(","));

        StringBuffer actualSymptomsList = new StringBuffer(symptomsList);
        //actualSymptomsList.deleteCharAt(actualSymptomsList.length()-1);

        System.out.println(actualSymptomsList);

        String covidResult = queryProlog.checkForCovid(actualSymptomsList);

        switch (covidResult) {
            case "regularSymptoms" -> {
                setHaveCovid("Regular Covid Symptoms");
                setRegularSymptoms(getRegularSymptoms()+1);
            }
            case "mildSymptoms" -> {
                setHaveCovid("Mild Covid Symptoms");
                setMildSymptoms(getMildSymptoms()+1);
            }
            case "severeSymptoms" -> {
                setHaveCovid("Severe Covid Symptoms");
                setSevereSymptoms(getSevereSymptoms()+1);
            }
            case "covid" -> {
                setHaveCovid("Regular Covid Symptoms");
                setSevereSymptoms(getRegularSymptoms()+1);
            }
            case "covidFree" -> setHaveCovid("No Covid");
        }

        covidVariantPredictor();
    }

    //
    public void covidVariantPredictor() {
        if (symptoms.getNausea()) {
            symptomsList = symptomsList.concat(symptoms.nauseaProlog).concat(",");
        }
        if (symptoms.getVomiting()) {
            symptomsList = symptomsList.concat(symptoms.vomitingProlog).concat(",");
        }
        if (symptoms.getContinuousCough()) {
            symptomsList = symptomsList.concat(symptoms.continuousCoughProlog).concat(",");
        }
        //symptomsList = symptomsList.concat(symptoms.getNewSymptom().concat(","));

        StringBuffer actualSymptomsList = new StringBuffer(symptomsList);
        //actualSymptomsList.deleteCharAt(actualSymptomsList.length()-1);

        String covidResult = queryProlog.checkForCovidVariant(actualSymptomsList);

        switch (covidResult) {
            case "deltaVariant" -> {
                setHaveVariant("Delta Variant");
                setDeltaVariant(getDeltaVariant()+1);
            }
            case "muVariant" -> {
                setHaveVariant("Mu Variant");
                setMuVariant(getMuVariant()+1);
            }
            case "noVariant" -> setHaveVariant("No Variant");
        }
    }

    public String patientDiagnosisReport() {

        System.out.println(bloodPressure.toString());
        System.out.println(bloodPressure.getDiastolicValue());
        System.out.println(bloodPressure.getSystolicValue());
        setPatientDiagnosisReport(getHaveCovid() + "\n" + getHaveVariant() + "\n" +getCovidPrediction() + "\n" + "\n" +
                symptoms.toString());
        return getPatientDiagnosisReport();
    }

    public Diagnosis() {
        this.improperCovidProtocolMod = 0;
        this.totalModifier = 0;
        this.totalSymptoms = 0;
        this.totalCalculation = 0;
        this.systolicValue = 0;
        this.diastolicValue = 0;
        symptomsList="";
        highRiskPatient = false;
    }

    public Diagnosis(int improperCovidProtocolMod, int totalModifier, int totalSymptoms, int totalCalculation, int systolicValue, int diastolicValue) {
        this.improperCovidProtocolMod = improperCovidProtocolMod;
        this.totalModifier = totalModifier;
        this.totalSymptoms = totalSymptoms;
        this.totalCalculation = totalCalculation;
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
    }

    public Symptoms getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symptoms symptoms) {
        Diagnosis.symptoms = symptoms;
    }

    public Patient getNewPatient() {
        return newPatient;
    }

    public void setNewPatient(Patient newPatient) {
        this.newPatient = newPatient;
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

    public static void setHighRiskPatient(Boolean highRiskPatient) {
        Diagnosis.highRiskPatient = highRiskPatient;
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

    public int getCovidExposureMod() {
        return covidExposureMod;
    }

    public void setCovidExposureMod(int covidExposureMod) {
        this.covidExposureMod = covidExposureMod;
    }

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public static String getHaveCovid() {
        return haveCovid;
    }

    public void setHaveCovid(String haveCovid) {
        this.haveCovid = haveCovid;
    }

    public static String getHaveVariant() {
        return haveVariant;
    }

    public void setHaveVariant(String haveVariant) {
        this.haveVariant = haveVariant;
    }

    public int getHighSymptomsMod() {
        return highSymptomsMod;
    }

    public void setHighSymptomsMod(int highSymptomsMod) {
        this.highSymptomsMod = highSymptomsMod;
    }

    public String getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(String diseaseList) {
        this.diseaseList = diseaseList;
    }

    public int getHighDiseaseMod() {
        return highDiseaseMod;
    }

    public void setHighDiseaseMod(int highDiseaseMod) {
        this.highDiseaseMod = highDiseaseMod;
    }

    public static int getRegularSymptoms() {
        return regularSymptoms;
    }

    public static void setRegularSymptoms(int regularSymptoms) {
        Diagnosis.regularSymptoms = regularSymptoms;
    }

    public static int getMildSymptoms() {
        return mildSymptoms;
    }

    public static void setMildSymptoms(int mildSymptoms) {
        Diagnosis.mildSymptoms = mildSymptoms;
    }

    public static int getSevereSymptoms() {
        return severeSymptoms;
    }

    public static void setSevereSymptoms(int severeSymptoms) {
        Diagnosis.severeSymptoms = severeSymptoms;
    }

    public static int getMuVariant() {
        return muVariant;
    }

    public static void setMuVariant(int muVariant) {
        Diagnosis.muVariant = muVariant;
    }

    public static int getDeltaVariant() {
        return deltaVariant;
    }

    public static void setDeltaVariant(int deltaVariant) {
        Diagnosis.deltaVariant = deltaVariant;
    }
}
