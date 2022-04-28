package models;

public class Symptoms {
    //Patient events
    private Boolean covidExposure;
    private Boolean improperCovidProtocol;
    //Mild Covid Symptoms
    private Boolean pains;
    private Boolean diarrhoea;
    private Boolean irritatedEyes;
    private Boolean dizziness;
    private Boolean blurredVision;
    //Regular Covid Symptoms
    private Boolean fever;
    private Boolean cough;
    private Boolean tiredness;
    private Boolean noTaste;
    private Boolean noSmell;
    private Boolean runningNose;
    private Boolean soreThroat;
    private Boolean headache;
    //Severe Covid Symptoms
    private Boolean difficultyBreathing;
    private Boolean shortnessOfBreath;
    private Boolean lossOfSpeech;
    private Boolean lossOfMobility;
    private Boolean confusion;
    private Boolean chestPain;
    private Boolean rashOnSkin;
    private Boolean fainting;
    //Variant Symptoms
    private Boolean nausea;
    private Boolean vomiting;
    private Boolean continuousCough;

    public String newSymptom;

    public String covidExposureWord = "Patient has been exposed to someone with covid-19 within the last 14 days.";
    public String improperCovidProtocolWord = "\"Patient has not been taking proper precautions for covid-19 within the last " +
            "14 days.\"";
    //Strings to send over to Prolog for query
    //Regular Covid Symptoms
    public String feverProlog = "fever";
    public String coughProlog = "cough";
    public String tirednessProlog = "tiredness";
    public String noTasteProlog = "noTaste";
    public String noSmellProlog = "noSmell";
    public String runningNoseProlog = "runningNose";
    public String soreThroatProlog = "soreThroat";
    public String headacheProlog = "headache";
    //Mild Covid Symptoms
    public String painsProlog = "pains";
    public String diarrhoeaProlog = "diarrhoea";
    public String irritatedEyesProlog = "irritatedEyes";
    public String dizzinessProlog = "dizziness";
    public String blurredVisionProlog = "blurredVision";
    //Severe Covid Symptoms
    public String difficultyBreathingProlog = "difficultyBreathing";
    public String shortnessOfBreathProlog = "shortnessofBreath";
    public String lossOfSpeechProlog = "lossOfSpeech";
    public String lossOfMobilityProlog = "lossOfMobility";
    public String confusionProlog = "confusion";
    public String chestPainProlog = "chestPain";
    public String rashOnSkinProlog = "rashOnSkin";
    public String faintingProlog = "fainting";
    //Variant Symptoms
    public String nauseaProlog = "nausea";
    public String vomitingProlog = "vomiting";
    public String continuousCoughProlog = "continuousCough";

    public Symptoms() {
        this.covidExposure = false;
        this.improperCovidProtocol = false;
        this.pains = false;
        this.diarrhoea = false;
        this.irritatedEyes = false;
        this.dizziness = false;
        this.blurredVision = false;
        this.fever = false;
        this.cough = false;
        this.tiredness = false;
        this.noTaste = false;
        this.noSmell = false;
        this.runningNose = false;
        this.soreThroat = false;
        this.headache = false;
        this.difficultyBreathing = false;
        this.shortnessOfBreath = false;
        this.lossOfSpeech = false;
        this.lossOfMobility = false;
        this.confusion = false;
        this.chestPain = false;
        this.rashOnSkin = false;
        this.fainting = false;
        this.nausea = false;
        this.vomiting = false;
        this.continuousCough = false;
        this.newSymptom = "";
    }

    public Symptoms(Boolean covidExposure, Boolean improperCovidProtocol, Boolean pains, Boolean diarrhoea, Boolean irritatedEyes, Boolean dizziness, Boolean blurredVision, Boolean fever, Boolean cough, Boolean tiredness, Boolean noTaste, Boolean noSmell, Boolean runningNose, Boolean soreThroat, Boolean headache, Boolean difficultyBreathing, Boolean shortnessOfBreath, Boolean lossOfSpeech, Boolean lossOfMobility, Boolean confusion, Boolean chestPain, Boolean rashOnSkin, Boolean fainting, Boolean nausea, Boolean vomiting, Boolean continuousCough, String newSymptom) {
        this.covidExposure = covidExposure;
        this.improperCovidProtocol = improperCovidProtocol;
        this.pains = pains;
        this.diarrhoea = diarrhoea;
        this.irritatedEyes = irritatedEyes;
        this.dizziness = dizziness;
        this.blurredVision = blurredVision;
        this.fever = fever;
        this.cough = cough;
        this.tiredness = tiredness;
        this.noTaste = noTaste;
        this.noSmell = noSmell;
        this.runningNose = runningNose;
        this.soreThroat = soreThroat;
        this.headache = headache;
        this.difficultyBreathing = difficultyBreathing;
        this.shortnessOfBreath = shortnessOfBreath;
        this.lossOfSpeech = lossOfSpeech;
        this.lossOfMobility = lossOfMobility;
        this.confusion = confusion;
        this.chestPain = chestPain;
        this.rashOnSkin = rashOnSkin;
        this.fainting = fainting;
        this.nausea = nausea;
        this.vomiting = vomiting;
        this.continuousCough = continuousCough;
        this.newSymptom = newSymptom;
    }

    public Boolean getCovidExposure() {
        return covidExposure;
    }

    public void setCovidExposure(Boolean covidExposure) {
        this.covidExposure = covidExposure;
    }

    public Boolean getImproperCovidProtocol() {
        return improperCovidProtocol;
    }

    public void setImproperCovidProtocol(Boolean improperCovidProtocol) {
        this.improperCovidProtocol = improperCovidProtocol;
    }

    public Boolean getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(Boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public Boolean getChestPain() {
        return chestPain;
    }

    public void setChestPain(Boolean chestPain) {
        this.chestPain = chestPain;
    }

    public Boolean getLossOfSpeech() {
        return lossOfSpeech;
    }

    public void setLossOfSpeech(Boolean lossOfSpeech) {
        this.lossOfSpeech = lossOfSpeech;
    }

    public Boolean getFever() {
        return fever;
    }

    public void setFever(Boolean fever) {
        this.fever = fever;
    }

    public Boolean getCough() {
        return cough;
    }

    public void setCough(Boolean cough) {
        this.cough = cough;
    }

    public Boolean getTiredness() {
        return tiredness;
    }

    public void setTiredness(Boolean tiredness) {
        this.tiredness = tiredness;
    }

    public Boolean getDizziness() {
        return dizziness;
    }

    public void setDizziness(Boolean dizziness) {
        this.dizziness = dizziness;
    }

    public Boolean getFainting() {
        return fainting;
    }

    public void setFainting(Boolean fainting) {
        this.fainting = fainting;
    }

    public Boolean getBlurredVision() {
        return blurredVision;
    }

    public void setBlurredVision(Boolean blurredVision) {
        this.blurredVision = blurredVision;
    }

    public Boolean getPains() {
        return pains;
    }

    public void setPains(Boolean pains) {
        this.pains = pains;
    }

    public Boolean getDiarrhoea() {
        return diarrhoea;
    }

    public void setDiarrhoea(Boolean diarrhoea) {
        this.diarrhoea = diarrhoea;
    }

    public Boolean getIrritatedEyes() {
        return irritatedEyes;
    }

    public void setIrritatedEyes(Boolean irritatedEyes) {
        this.irritatedEyes = irritatedEyes;
    }

    public Boolean getNoTaste() {
        return noTaste;
    }

    public void setNoTaste(Boolean noTaste) {
        this.noTaste = noTaste;
    }

    public Boolean getNoSmell() {
        return noSmell;
    }

    public void setNoSmell(Boolean noSmell) {
        this.noSmell = noSmell;
    }

    public Boolean getRunningNose() {
        return runningNose;
    }

    public void setRunningNose(Boolean runningNose) {
        this.runningNose = runningNose;
    }

    public Boolean getHeadache() {
        return headache;
    }

    public void setHeadache(Boolean headache) {
        this.headache = headache;
    }

    public Boolean getDifficultyBreathing() {
        return difficultyBreathing;
    }

    public void setDifficultyBreathing(Boolean difficultyBreathing) {
        this.difficultyBreathing = difficultyBreathing;
    }

    public Boolean getShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public void setShortnessOfBreath(Boolean shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public Boolean getLossOfMobility() {
        return lossOfMobility;
    }

    public void setLossOfMobility(Boolean lossOfMobility) {
        this.lossOfMobility = lossOfMobility;
    }

    public Boolean getConfusion() {
        return confusion;
    }

    public void setConfusion(Boolean confusion) {
        this.confusion = confusion;
    }

    public Boolean getRashOnSkin() {
        return rashOnSkin;
    }

    public void setRashOnSkin(Boolean rashOnSkin) {
        this.rashOnSkin = rashOnSkin;
    }

    public Boolean getNausea() {
        return nausea;
    }

    public void setNausea(Boolean nausea) {
        this.nausea = nausea;
    }

    public Boolean getVomiting() {
        return vomiting;
    }

    public void setVomiting(Boolean vomiting) {
        this.vomiting = vomiting;
    }

    public Boolean getContinuousCough() {
        return continuousCough;
    }

    public void setContinuousCough(Boolean continuousCough) {
        this.continuousCough = continuousCough;
    }

    public String getNewSymptom() {
        return newSymptom;
    }

    public void setNewSymptom(String newSymptom) {
        this.newSymptom = newSymptom;
    }

    @Override
    public String toString() {
        return "*** Symptoms ***" +
                "\n Known Covid Exposure within the last 14 days: " + covidExposure +
                "\n Improper Covid Protocols: " + improperCovidProtocol +
                "\n Pains: " + pains +
                "\n Diarrhoea: " + diarrhoea +
                "\n Irritated Eyes: " + irritatedEyes +
                "\n Dizziness: " + dizziness +
                "\n Blurred Vision: " + blurredVision +
                "\n Fever: " + fever +
                "\n Cough: " + cough +
                "\n Tiredness: " + tiredness +
                "\n No Taste: " + noTaste +
                "\n No Smell: " + noSmell +
                "\n Running Nose: " + runningNose +
                "\n Sore Throat: " + soreThroat +
                "\n Headache: " + headache +
                "\n Difficulty Breathing: " + difficultyBreathing +
                "\n Shortness of Breath: " + shortnessOfBreath +
                "\n Loss of Speech: " + lossOfSpeech +
                "\n Loss of Mobility: " + lossOfMobility +
                "\n Confusion: " + confusion +
                "\n Chest Pain: " + chestPain +
                "\n Rash on Skin: " + rashOnSkin +
                "\n Fainting: " + fainting +
                "\n Nausea: " + nausea +
                "\n Vomiting:" + vomiting +
                "\n Continuous Cough:" + continuousCough;
    }
}
