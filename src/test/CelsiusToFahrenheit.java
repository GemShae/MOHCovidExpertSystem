package test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CelsiusToFahrenheit {
    public double celsius;
    public double fahrenheit;

    public double conversion(double celsius) {
        double fahrenheit;

        fahrenheit = ((celsius * 1.8) + 32);
        BigDecimal bd = new BigDecimal(fahrenheit).setScale(2, RoundingMode.HALF_UP);

        setFahrenheit(bd.doubleValue());

        return getFahrenheit();
    }

    public CelsiusToFahrenheit() {
    }

    public CelsiusToFahrenheit(double celsius, double fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @Override
    public String toString() {
        return "CelsiusToFahrenheit: " +
                "Celsius=" + celsius +
                ", Fahrenheit=" + fahrenheit;
    }
}
