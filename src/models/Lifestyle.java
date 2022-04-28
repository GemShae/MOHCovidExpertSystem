package models;

public class Lifestyle {
    //Lifestyle issues that could put you at risk for having covid
    private Boolean exercise;
    private Boolean alcohol;

    public Lifestyle() {
        this.exercise = false;
        this.alcohol = false;
    }

    public Lifestyle(Boolean exercise, Boolean alcohol) {
        this.exercise = exercise;
        this.alcohol = alcohol;;
    }

    public Boolean getExercise() {
        return exercise;
    }

    public void setExercise(Boolean exercise) {
        this.exercise = exercise;
    }

    public Boolean getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Boolean alcohol) {
        this.alcohol = alcohol;
    }


    @Override
    public String toString() {
        return "*** Lifestyle ***" +
                "\n Exercise: " + exercise +
                "\n Alcohol: " + alcohol;
    }
}
