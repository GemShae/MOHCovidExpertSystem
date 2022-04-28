package calculations;

import static calculations.Diagnosis.getHighRiskPatient;
import static calculations.Diagnosis.symptoms;

public class Recomendations {

    private String bloodPressureReport;
    private String exposureRecommendation;
    private String treatmentRecommendation;
    private String shortTermRecommendations;
    private String longTermRecommendations;
    private String fullRecommendations;
    private String haveCovidRecommendations;
    private String variantCovidRecommendations;

    //Recommendations
    //Returns fullRecommendation : this is a variable String which output is dependent on probabilities of exposure, patient
    // covid protocol compliance and prediction
    public String recommendations() {
        if (symptoms.getCovidExposure() && symptoms.getImproperCovidProtocol() && getHighRiskPatient()) {
            setShortTermRecommendations("""
                    Short Term:\s
                     There is high probability that the patient has covid-19 given that he/she has been in contact\040
                     with someone with disease, doesn't regular practice disease safety protocol, and the list of symptoms\040
                     experienced. It is recommended that the patient stays home and self isolates
                    """);

            setLongTermRecommendations("\n Long Term: \n If symptoms worsens then patient should be admitted if possible \n");

        } else if (symptoms.getCovidExposure() && symptoms.getImproperCovidProtocol() && !getHighRiskPatient()) {
            setShortTermRecommendations("""
                    Short Term:\s
                     Though the patient has mild-risk of having covid19, he/she has been in contact with someone with the \040
                     disease and doesn't regular practice disease safety protocol, if possible patient should seek testing
                    """);

            setLongTermRecommendations("""
                     Long Term:\s
                     It is advised that the patient self isolates and monitors his/her health as well as follow proper
                      protocols(wear mask whenever in public, wash hands frequently, social distancing, etc)\s
                    \s""");

        } else if (symptoms.getCovidExposure() && !symptoms.getImproperCovidProtocol() && getHighRiskPatient()) {
            setShortTermRecommendations("""
                    Short Term:\s
                     It is recommended that the patient self isolates due to being at high risk of having the disease from\040
                     coming in contact with someone who has it and from symptoms experienced.
                    """);

            setLongTermRecommendations("\n Long Term: \n If symptoms worsen then patient should be admitted if possible");

        } else if (symptoms.getCovidExposure() && !symptoms.getImproperCovidProtocol() && !getHighRiskPatient()) {
            setShortTermRecommendations("""
                    Short Term:\s
                     It is recommended that the patient monitors their health as they have been in contact with someone with\040
                     the disease. Patient should continue to follow covid-19 protocol as they have been doing to lower the\040
                     chances of contracting the disease
                    """);

            setLongTermRecommendations("\n Long Term: \n It is advised that the patient seeks testing if possible");

        } else if (!symptoms.getCovidExposure() && symptoms.getImproperCovidProtocol() && getHighRiskPatient()) {
            setShortTermRecommendations("""
                    Short Term:\s
                     The patient should self-isolate as he/she is at high-risk of having covid19 and monitor intensity of\040
                     the symptoms. Patient should also comply with health protocols for the disease
                    """);

            setLongTermRecommendations("""
                     Long Term:\s
                     If symptoms progressively get worse it is advised that the patient be admitted to hospital
                    """);

        } else if (!symptoms.getCovidExposure() && symptoms.getImproperCovidProtocol() && !getHighRiskPatient()) {
            setShortTermRecommendations("""
                    Short Term:\s
                     Patient needs to comply with recommended covid 19 health protocols(wearing masks ,social distancing and\040
                     frequent sanitization)
                    """);

            setLongTermRecommendations("\n Long Term: \n Patient should monitor his/her health");

        } else if (!symptoms.getCovidExposure() && !symptoms.getImproperCovidProtocol() && getHighRiskPatient()) {
            setShortTermRecommendations("Short Term: \n Patient should monitor his/her health \n ");

            setLongTermRecommendations("""
                     Long Term:\s
                     If symptoms worsen then it is recommended that the patient gets screened
                    """);

        } else if (!symptoms.getCovidExposure() && !symptoms.getImproperCovidProtocol() && !getHighRiskPatient()) {
            setShortTermRecommendations("""
                    Short Term:\s
                     Patient is at low risk, hasn't reported being in contact with anyone with covid-19 and follows protocol.\040
                     Patient should continue with practices performed and be mindful of worsening symptoms
                    """);

            setLongTermRecommendations("\n Long Term: \nPatient should get vaccinated");
        }
        if (Diagnosis.getHaveCovid().equals("Regular Covid Symptoms")) {
            setHaveCovidRecommendations("Quarantine");
        }else if (Diagnosis.getHaveCovid().equals("Mild Covid Symptoms")) {
            setHaveCovidRecommendations("Quarantine at home and treat those symptoms");
        }else if(Diagnosis.getHaveCovid().equals("Severe Covid Symptoms") ) {
                setHaveCovidRecommendations("Get admitted to a health care facility and have your symptoms \" +\n" +
                        "                    \"treated by professionals");
        }



        setFullRecommendations(getShortTermRecommendations() + getLongTermRecommendations() + getHaveCovidRecommendations());
        return getFullRecommendations();
    }

    public Recomendations() {
        this.bloodPressureReport = "";
        this.shortTermRecommendations = "";
        this.longTermRecommendations = "";
        this.fullRecommendations = "";
    }

    public Recomendations(String bloodPressureReport, String covidPrediction, String exposureRecommendation, String treatmentRecommendation, String shortTermRecommendations, String longTermRecommendations, String fullRecommendations) {
        this.bloodPressureReport = bloodPressureReport;
        this.exposureRecommendation = exposureRecommendation;
        this.treatmentRecommendation = treatmentRecommendation;
        this.shortTermRecommendations = shortTermRecommendations;
        this.longTermRecommendations = longTermRecommendations;
        this.fullRecommendations = fullRecommendations;
    }

    public String getBloodPressureReport() {
        return bloodPressureReport;
    }

    public void setBloodPressureReport(String bloodPressureReport) {
        this.bloodPressureReport = bloodPressureReport;
    }

    public String getExposureRecommendation() {
        return exposureRecommendation;
    }

    public void setExposureRecommendation(String exposureRecommendation) {
        this.exposureRecommendation = exposureRecommendation;
    }

    public String getTreatmentRecommendation() {
        return treatmentRecommendation;
    }

    public void setTreatmentRecommendation(String treatmentRecommendation) {
        this.treatmentRecommendation = treatmentRecommendation;
    }

    public String getShortTermRecommendations() {
        return shortTermRecommendations;
    }

    public void setShortTermRecommendations(String shortTermRecommendations) {
        this.shortTermRecommendations = shortTermRecommendations;
    }

    public String getLongTermRecommendations() {
        return longTermRecommendations;
    }

    public void setLongTermRecommendations(String longTermRecommendations) {
        this.longTermRecommendations = longTermRecommendations;
    }

    public String getFullRecommendations() {
        return fullRecommendations;
    }

    public void setFullRecommendations(String fullRecommendations) {
        this.fullRecommendations = fullRecommendations;
    }

    public String getHaveCovidRecommendations() {
        return haveCovidRecommendations;
    }

    public void setHaveCovidRecommendations(String haveCovidRecommendations) {
        this.haveCovidRecommendations = haveCovidRecommendations;
    }

    public String getVariantCovidRecommendations() {
        return variantCovidRecommendations;
    }

    public void setVariantCovidRecommendations(String variantCovidRecommendations) {
        this.variantCovidRecommendations = variantCovidRecommendations;
    }
}
