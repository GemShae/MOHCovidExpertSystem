package calculations;

import org.jpl7.Query;

public class QueryProlog {
    public String fahrenheit;

    public QueryProlog() {

    }

    public void convertCelsiusToFah(double celsius) {
        Query query = new Query("consult('Covid19ExpSys.pl')");

        query.hasSolution();

        System.out.println("Expert System Convert to Celsius " + (query.hasSolution() ? "Succeeded":"Failed"));

        if (query.hasSolution()) {
            query = new Query("tempInFah(" + celsius + ",TempFah)");

            if (query.hasSolution()) {
                fahrenheit = query.oneSolution().get("TempFah").toString();
            }
        }
        // Else Need to call one of the error popups

    }

    public int checkForFever(double fahrenheit) {
        Query query = new Query("consult('Covid19ExpSys.pl')");
        int fevertrue=0;

        query.hasSolution();

        System.out.println("Expert System Check for Fever " + (query.hasSolution() ? "Succeeded":"Failed"));

        if (query.hasSolution()) {
            query = new Query("checkForFever(" + fahrenheit + ",Fever)");

            if (query.hasSolution()) {
                String fever = query.oneSolution().get("Fever").toString();

                fevertrue = Integer.parseInt(fever);
            }
        }
        return fevertrue;
    }

    public String checkForCovid(StringBuffer symptomsList) {
        String covid="covidFree";
        Query query = new Query("consult('Covid19ExpSys.pl')");
        StringBuffer actualSymptomsList = symptomsList.deleteCharAt(symptomsList.length()-1);

        query.hasSolution();

        System.out.println("Expert System Check for Covid " + (query.hasSolution() ? "Succeeded":"Failed"));
        System.out.println("List Covid: " + actualSymptomsList);
        if (query.hasSolution()) {
            System.out.println("Solution checking");
            query = new Query("listSymptoms([" + actualSymptomsList + "],X)");

            if (query.hasSolution()) {
                System.out.println("Solution got");
                covid = query.oneSolution().get("X").toString();
                System.out.println("Have:" + covid);
                return covid;
            }
        }
        return covid;
    }

    public String checkForCovidVariant(StringBuffer symptomsList) {
        String covidVariant="noVariant";
        Query query = new Query("consult('Covid19ExpSys.pl')");
        StringBuffer actualSymptomsList = symptomsList.deleteCharAt(symptomsList.length()-1);

        query.hasSolution();

        System.out.println("Expert System Check for Covid Variant " + (query.hasSolution() ? "Succeeded":"Failed"));
        System.out.println("List Covid: " + actualSymptomsList);
        if (query.hasSolution()) {
            query = new Query("listSymptomsVariant([" + actualSymptomsList + "],X)");

            if (query.hasSolution()) {
                covidVariant = query.oneSolution().get("X").toString();
                return covidVariant;
            }
        }
        return covidVariant;
    }

    public int listOfSymptomsRisk(StringBuffer symptomsList) {
        int risk=0;
        Query query = new Query("consult('Covid19ExpSys.pl')");
        StringBuffer actualSymptomsList = symptomsList.deleteCharAt(symptomsList.length()-1);

        query.hasSolution();

        System.out.println("Expert System Check for High Symptoms " + (query.hasSolution() ? "Succeeded":"Failed"));

        if (query.hasSolution()) {
            query = new Query("lengthOfSymptoms(["+actualSymptomsList+"],Count,Risk)");

            if (query.hasSolution()) {
                String riskString = query.oneSolution().get("Risk").toString();
                return Integer.parseInt(riskString);
            }
        }
        return risk;
    }

    public int listOfDiseasesRisk(StringBuffer diseasesList) {
        int risk=0;
        Query query = new Query("consult('Covid19ExpSys.pl')");
        StringBuffer actualSymptomsList = diseasesList.deleteCharAt(diseasesList.length()-1);

        query.hasSolution();

        System.out.println("Expert System Check for High Disease " + (query.hasSolution() ? "Succeeded":"Failed"));

        if (query.hasSolution()) {
            query = new Query("lengthOfDisease(["+actualSymptomsList+"],Count,Risk)");

            if (query.hasSolution()) {
                String riskString = query.oneSolution().get("Risk").toString();
                risk = Integer.parseInt(riskString);
            }
        }
        return risk;
    }

    public int covidExposure(String have) {
        int risk=0;
        Query query = new Query("consult('Covid19ExpSys.pl')");

        query.hasSolution();

        System.out.println("Expert System Check for Covid Exposure " + (query.hasSolution() ? "Succeeded":"Failed"));

        if (query.hasSolution()) {
            query = new Query("covidExposureEvents("+have+",ExposureRisk)");

            if (query.hasSolution()) {
                String riskString = query.oneSolution().get("ExposureRisk").toString();
                return Integer.parseInt(riskString);
            }
        }
        return risk;
    }

    public int covidProtocol(String have) {
        int risk=0;
        Query query = new Query("consult('Covid19ExpSys.pl')");

        query.hasSolution();

        System.out.println("Expert System Check for Covid Protocol " + (query.hasSolution() ? "Succeeded":"Failed"));

        if (query.hasSolution()) {
            query = new Query("improperProtocolEvents("+ have +",Risk)");

            if (query.hasSolution()) {
                String riskString = query.oneSolution().get("Risk").toString();
                return Integer.parseInt(riskString);
            }
        }
        return risk;
    }

    public int checkForPressure(int systolic, int diastolic) {
        Query query = new Query("consult('Covid19ExpSys.pl')");
        int pressuretrue=0;

        query.hasSolution();

        System.out.println("Expert System Check for Pressure " + (query.hasSolution() ? "Succeeded":"Failed"));

        if (query.hasSolution()) {
            query = new Query("bloodPressureCalculator(" + systolic +"," + diastolic + ",BPValue)");

            if (query.hasSolution()) {
                String pressure = query.oneSolution().get("BPValue").toString();

                pressuretrue = Integer.parseInt(pressure);
            }
        }
        return pressuretrue;
    }
}
