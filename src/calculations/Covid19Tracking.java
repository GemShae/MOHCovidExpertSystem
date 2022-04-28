package calculations;

import java.sql.ResultSet;
import java.sql.SQLException;

//Scans database for new entries to the database, if more than  10+ new high-risk patients then reports since last
// login then handle as follow 0: significant increase in severe-cases : shows number of new cases
public class Covid19Tracking {
    //monitors table activity generates hourly reports
    //returns # of patients
    private int totalPatients;
    private int severeRiskPatients;
    private int mildRiskPatients;
    private int regularSymptoms;
    private double regularSymptomsPercentage;
    private int mildSymptoms;
    private double mildSymptomsPercentage;
    private int severeSymptoms;
    private double severeSymptomsPercentage;
    private int deltaVariant;
    private double deltaVariantPercentage;
    private int muVariant;
    private double muVariantPercentage;
    private double severeRiskPercentage;
    private double mildRiskPercentage;
    private String covidReport;

    public static void getNumPatients(ResultSet rs) throws SQLException {
        while (rs.next()) {
            StringBuffer buffer = new StringBuffer();
            buffer.append("test").append(rs.getBoolean("high_risk_patient"));
        }
    }

    //get # of patients in database , get # of severe, get # of low risk, compare # of severe to mild
    public void severeRiskPercentageCalc(int totalPersons, int severePersons) {
        double severePercentage = severePersons * 100 / totalPersons;
        setSevereRiskPercentage(severePercentage);
    }

    public void mildRiskPercentageCalc(int totalPersons, int mildPersons) {
        double mildPercentage = mildPersons * 100 / totalPersons;
        setMildRiskPercentage(mildPercentage);
    }

    public void regularSymptomsPercentCalc(int totalPatients, int regularSymptoms) {
        double regularPercentage = regularSymptoms*100/totalPatients;
        setRegularSymptomsPercentage(regularPercentage);
    }

    public void mildSymptomsPercentCalc(int totalPatients, int mildSymptoms) {
        double mildPercentage = (mildSymptoms/totalPatients)*100;
        setMildSymptomsPercentage(mildPercentage);
    }

    public void severeSymptomsPercentCalc(int totalPatients, int severeSymptoms) {
        double severePercentage = (severeSymptoms/totalPatients)*100;
        setSevereSymptomsPercentage(severePercentage);
    }

    public void deltaPercentCalc(int totalPatients, int deltaVariant) {
        double deltaPercent = (deltaVariant/totalPatients)*100;
        setDeltaVariantPercentage(deltaPercent);
    }

    public void muPercentCalc(int totalPatients, int muVariant) {
        double muPercent = (muVariant/totalPatients)*100;
        setMuVariantPercentage(muPercent);
    }

    //Need to save Previous Login date to database
    public void covid19Report() {
        if (getSevereRiskPatients() <= 10) {
            setCovidReport("There have been a low number of potential high risk cases since 'Last Login' ");
        } else if (getSevereRiskPatients() > 10 && getSevereRiskPatients() < 25) {
            setCovidReport("There have been a moderate increase in the number of potential high risk cases since ");
        } else if (getSevereRiskPatients() > 25 && getSevereRiskPatients() < 50) {
            setCovidReport("There cases been a considerable increase in number of potential high risk cases since , " +
                    "Another outbreak might be imminent");
        } else if (getSevereRiskPatients() > 50) {
            setCovidReport("There have been an alarming number of  number of potential new cases since April 29. " +
                    "There is a great likelihood that an outbreak is occurring.");
        }

    }

    public int getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(int totalPatients) {
        this.totalPatients = totalPatients;
    }

    public int getSevereRiskPatients() {
        return severeRiskPatients;
    }

    public void setSevereRiskPatients(int severeRiskPatients) {
        this.severeRiskPatients = severeRiskPatients;
    }

    public int getMildRiskPatients() {
        return mildRiskPatients;
    }

    public void setMildRiskPatients(int mildRiskPatients) {
        this.mildRiskPatients = mildRiskPatients;
    }

    public double getSevereRiskPercentage() {
        return severeRiskPercentage;
    }

    public void setSevereRiskPercentage(double severeRiskPercentage) {
        this.severeRiskPercentage = severeRiskPercentage;
    }

    public double getMildRiskPercentage() {
        return mildRiskPercentage;
    }

    public void setMildRiskPercentage(double mildRiskPercentage) {
        this.mildRiskPercentage = mildRiskPercentage;
    }

    public String getCovidReport() {
        return covidReport;
    }

    public void setCovidReport(String covidReport) {
        this.covidReport = covidReport;
    }

    public int getRegularSymptoms() {
        return regularSymptoms;
    }

    public void setRegularSymptoms(int regularSymptoms) {
        this.regularSymptoms = regularSymptoms;
    }

    public int getMildSymptoms() {
        return mildSymptoms;
    }

    public void setMildSymptoms(int mildSymptoms) {
        this.mildSymptoms = mildSymptoms;
    }

    public int getSevereSymptoms() {
        return severeSymptoms;
    }

    public void setSevereSymptoms(int severeSymptoms) {
        this.severeSymptoms = severeSymptoms;
    }

    public int getDeltaVariant() {
        return deltaVariant;
    }

    public void setDeltaVariant(int deltaVariant) {
        this.deltaVariant = deltaVariant;
    }

    public int getMuVariant() {
        return muVariant;
    }

    public void setMuVariant(int muVariant) {
        this.muVariant = muVariant;
    }

    public double getRegularSymptomsPercentage() {
        return regularSymptomsPercentage;
    }

    public void setRegularSymptomsPercentage(double regularSymptomsPercentage) {
        this.regularSymptomsPercentage = regularSymptomsPercentage;
    }

    public double getMildSymptomsPercentage() {
        return mildSymptomsPercentage;
    }

    public void setMildSymptomsPercentage(double mildSymptomsPercentage) {
        this.mildSymptomsPercentage = mildSymptomsPercentage;
    }

    public double getSevereSymptomsPercentage() {
        return severeSymptomsPercentage;
    }

    public void setSevereSymptomsPercentage(double severeSymptomsPercentage) {
        this.severeSymptomsPercentage = severeSymptomsPercentage;
    }

    public double getDeltaVariantPercentage() {
        return deltaVariantPercentage;
    }

    public void setDeltaVariantPercentage(double deltaVariantPercentage) {
        this.deltaVariantPercentage = deltaVariantPercentage;
    }

    public double getMuVariantPercentage() {
        return muVariantPercentage;
    }

    public void setMuVariantPercentage(double muVariantPercentage) {
        this.muVariantPercentage = muVariantPercentage;
    }

    @Override
    public String toString() {
        return "*** Covid Report ***\n" +
                "Total Patients=" + totalPatients +
                "\n Severe Risk Patients=" + severeRiskPatients +
                "\n Severe Risk Percentage=" + severeRiskPercentage + "%" +
                "\n Mild Risk Patients=" + mildRiskPatients +
                "\n Mild Risk Percentage=" + mildRiskPercentage + "%" +
                "\n Regular Symptoms Patients=" + regularSymptoms +
                "\n Regular Symptoms Percentage=" + regularSymptomsPercentage + "%" +
                "\n Mild Symptoms Patients=" + mildSymptoms +
                "\n Mild Symptoms Percentage=" + mildSymptomsPercentage + "%" +
                "\n Severe Symptoms Patients=" + severeSymptoms +
                "\n Severe Symptoms Percentage=" + severeSymptomsPercentage + "%" +
                "\n Delta Variant Patients=" + deltaVariant +
                "\n Delta Varient Percentage=" + deltaVariantPercentage + "%" +
                "\n Mu Variant Patients=" + muVariant +
                "\n Mu Variant Percentage=" + muVariantPercentage + "%" +
                "\n Be Advised: " + covidReport;
    }
}
