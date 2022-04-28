package calculations;

public class BloodPressure {
    private int systolicValue;
    private int diastolicValue;
    private String bloodPressureReview;
    private Boolean lowBloodPressure;

    QueryProlog queryProlog = new QueryProlog();

    public Boolean lowBloodPressureReader(int systolic, int diastolic) {
        //setLowBloodPressure(systolic < 90 || diastolic < 60);

        int risk = queryProlog.checkForPressure(systolic,diastolic);

        setLowBloodPressure(risk == 5);

        return getLowBloodPressure();
    }

    public String bloodPressureReview() {
        if(getLowBloodPressure()){
            setBloodPressureReview("Patient's blood pressure is low.\n");
        }
        else{
            setBloodPressureReview("Patient's blood pressure is normal.\n");
        }
        return getBloodPressureReview();
    }

    public BloodPressure() {
    }

    public BloodPressure(int systolicValue, int diastolicValue, String bloodPressureReview, Boolean lowBloodPressure) {
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
        this.bloodPressureReview = bloodPressureReview;
        this.lowBloodPressure = lowBloodPressure;
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

    public String getBloodPressureReview() {
        return bloodPressureReview;
    }

    public void setBloodPressureReview(String bloodPressureReview) {
        this.bloodPressureReview = bloodPressureReview;
    }

    public Boolean getLowBloodPressure() {
        return lowBloodPressure;
    }

    public void setLowBloodPressure(Boolean lowBloodPressure) {
        this.lowBloodPressure = lowBloodPressure;
    }

    @Override
    public String toString() {
        return "BloodPressure: " +
                "Systolic Value= " + systolicValue +
                ", Diastolic Value= " + diastolicValue +
                ", Blood Pressure Review= " + bloodPressureReview;
    }
}
