package models;

public class Disease {
    //Underlying diseases that puts people at risk for Covid
    private Boolean asthma;
    private Boolean bronchitis;
    private Boolean diabetes;

    //Strings to send over to Prolog for query
    public String asthmaProlog = "asthma";
    public String bronchitisProlog = "bronchitis";
    public String diabetesProlog = "diabetes";

    public Disease() {
        this.asthma = false;
        this.bronchitis = false;
        this.diabetes = false;
    }

    public Disease(Boolean asthma, Boolean bronchitis, Boolean diabetes) {
        this.asthma = asthma;
        this.bronchitis = bronchitis;
        this.diabetes = diabetes;
    }

    public Boolean getAsthma() {
        return asthma;
    }

    public void setAsthma(Boolean asthma) {
        this.asthma = asthma;
    }

    public Boolean getBronchitis() {
        return bronchitis;
    }

    public void setBronchitis(Boolean bronchitis) {
        this.bronchitis = bronchitis;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    @Override
    public String toString() {
        return "*** Disease ***" +
                "\n Asthma: " + asthma +
                "\n Bronchitis: " + bronchitis +
                "\n Diabetes"  + diabetes;
    }
}
