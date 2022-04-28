package test;

import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

import java.util.Map;

public class CovidExpSystem {
    public static void main(String[] args) {
        Query query = new Query("consult('Covid19ExpSys.pl')");
        //Query query = new Query("consult('Review.pl')");
        query.hasSolution();

        System.out.println("Expert System " + (query.hasSolution() ? "Succeeded":"Failed"));

        if (query.hasSolution()) {
            //test1(query);
            //test2(query);
            test3(query);
        }

        //query = new Query("parent(Who)");
        //query = new Query("test");
        //query = new Query("symptom(fever)");
        //query = new Query("yes");

        //Map<String, Term>[] result = query.allSolutions();
        //Hashtable[] result = (Hashtable[]) query.allSolutions();

        /*for (Map<String, Term> stringTermMap : result) {
            System.out.println(stringTermMap);
        } */

        /*for (Map<String, Term> stringTermMap : result) {
            System.out.println(stringTermMap.get("Exercise"));
        } */

        //System.out.println("First Solution: " + query.oneSolution().get("ExerValue"));


        /*System.out.println("Each solution: ");
        while (query.hasMoreSolutions()) {
            query.nextSolution();
        } */
    }

    public static void test1(Query query) {
        int salary = 1000;
        //Variable tax = new Variable();
        query = new Query("caltax(" + salary + "," + "Tax)");

        if (query.hasSolution()) {
            String answerTax = query.oneSolution().get("Tax").toString();
            System.out.println("The tax is: " + answerTax);
        }

        query = new Query("univ");

        Map<String, Term>[] result = query.allSolutions();

        for (Map<String, Term> stringTermMap : result) {
            String answerUniversity = stringTermMap.toString();
            //String answerUniversity = stringTermMap.get("brighton").toString();   Doesn't work
            System.out.println("Answer: " + answerUniversity);
        }
    }

    public static void test2(Query query) {
        boolean covidexposure = true;
        String something="Hello";

        query = new Query("covidExposureEvents("+ covidexposure + ",ExposureRisk)");

        if (query.hasSolution()) {
            String exposureRisk = query.oneSolution().get("ExposureRisk").toString();
            //System.out.println("Risk: " + exposureRisk);

            something = something.concat(", Risk is: ").concat(exposureRisk);

            System.out.println(something);
        }
    }

    public static void test3(Query query) {
        String covid="covidFree";
        String fever = "fever";
        String cough = "coughad";
        String symptomsList = "";

        symptomsList = symptomsList.concat(fever).concat(",");
        symptomsList = symptomsList.concat(cough).concat(",");

        StringBuffer actualSymptomsList = new StringBuffer(symptomsList);
        actualSymptomsList.deleteCharAt(actualSymptomsList.length()-1);

        query = new Query("consult('Covid19ExpSys.pl')");

        query.hasSolution();

        System.out.println("Expert System Check for Covid " + (query.hasSolution() ? "Succeeded":"Failed"));

        if (query.hasSolution()) {
            System.out.println("Solution checking");
            query = new Query("listSymptoms([" + actualSymptomsList + "],X)");

            if (query.hasSolution()) {
                System.out.println("Solution got");
                covid = query.oneSolution().get("X").toString();

                System.out.println("WQEWAR:" + covid);
            }else {
                System.out.println(covid);
            }
        }

        //System.out.println("Symptoms List with comma: " + symptomsList);
        //System.out.println("Symptoms List without comms: " + actualSymptomsList);
        //System.out.println("Covid: " + covid);
    }
}
