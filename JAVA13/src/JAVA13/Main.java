package JAVA13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    List<String> strings = new ArrayList<String>();

    public static void main(String[] args) {
        Main main = new Main();
        main.loadStrings(
                "Gota", "Malo", "Mancha", "Nuez", "Enredadera", "Puntual", "Cosquillas", "Pulsera", "Obsequio", "Abismo");

        var sortLengthByAnonymousClass = main.sortLengtAnonymousClass();
        System.out.println("Length \n");
        System.out.println("Anonymous Class \n");
        main.showList(sortLengthByAnonymousClass);

        var sortLengthByLamda = main.sortLengtLamda();
        System.out.println("\nLambda \n");
        main.showList(sortLengthByLamda);

        var sortLengthByReference = main.sortLengtReference();
        System.out.println("\nReference \n");
        main.showList(sortLengthByReference);

        var sortAlphabeticByAnonymousClass = main.sortAlphabeticAnonymousClass();
        System.out.println("\nAlphabetic");
        System.out.println("\nAnonymous Class \n");
        main.showList(sortAlphabeticByAnonymousClass);

        var sortAlphabeticByLambda = main.sortAlphabeticLamda();
        System.out.println("\nLambda \n");
        main.showList(sortAlphabeticByLambda);

        var sortAlphabeticByReference = main.sortAlphabeticReference();
        System.out.println("\nReference \n");
        main.showList(sortAlphabeticByReference);

    }

    public void loadStrings(String... strings) {
        for (var string : strings) {
            this.strings.add(string);
        }
    }

    public List<String> sortLengtAnonymousClass() {
        List<String> strings = this.strings;
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        return strings;
    }

    public List<String> sortLengtLamda() {
        List<String> strings = this.strings;
        strings.sort((str1, str2) -> str1.length() - str2.length());
        return strings;
    }

    public List<String> sortLengtReference() {
        List<String> strings = this.strings;
        SortLengt sortLengt = new SortLengt();
        strings.sort(sortLengt::compare);
        return strings;

    }

    class SortLengt implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return o1.toString().length() - o2.toString().length();
        }
    }

    public List<String> sortAlphabeticAnonymousClass() {
        List<String> strings = this.strings;
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareToIgnoreCase(str2);
            }
        });
        return strings;
    }

    public List<String> sortAlphabeticLamda() {
        List<String> strings = this.strings;
        strings.sort((str1, str2) -> str1.compareToIgnoreCase(str2));
        return strings;
    }

    public List<String> sortAlphabeticReference() {
        List<String> strings = this.strings;
        SortAlphaetic sortAlphabetic = new SortAlphaetic();
        Collections.sort(strings, sortAlphabetic::compare);
        return strings;
    }

    class SortAlphaetic implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return o1.toString().compareToIgnoreCase(o2.toString());
        }
    }

    public void showList(List<String> strings) {
        strings.forEach(System.out::println);
    }

}
