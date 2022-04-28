package test;

import org.jpl7.Query;
import org.jpl7.Term;

import java.util.Hashtable;
import java.util.Map;

public class Family {
    public static void main(String[] args) {
        Query query = new Query("consult('First_Lab.pl')");
        query.hasSolution();

        //System.out.println("Family.pl " + (query.hasSolution() ? "Succeeded":"Failed"));

        //query = new Query("parent(Who)");
        query = new Query("son(Parent,Son)");

        Map<String, Term>[] result = query.allSolutions();
        //Hashtable[] result = (Hashtable[]) query.allSolutions();

        for (Map<String, Term> stringTermMap : result) {
            System.out.println(stringTermMap);
        }

        for (Map<String, Term> stringTermMap : result) {
            System.out.println(stringTermMap.get("Son"));
        }

        System.out.println("First Solution: " + query.oneSolution().get("Parent"));

       /*System.out.println("Each solution: ");
        while (query.hasMoreSolutions()) {
            query.nextSolution();
        } */
    }
}
