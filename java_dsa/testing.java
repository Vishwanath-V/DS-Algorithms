import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class testing {

    static List<String> places = new ArrayList<>();

    static List<String> getPlaces() {
        places.add("Nepal, Pokhara");
        places.add("Nepal, Kathmandu");
        places.add("India, Delhi");
        places.add("USA, New York");
        places.add("Aafrica, Nigeria");
        return places;
    }
    public static void main(String[] args) {
        String s="abc123iop";
        printStringChars(s);

        List<String> myPlaces = getPlaces();
        System.out.println("Places from Nepal:");

        Comparator<String> cs = new Comparator<>() {

            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                // assuming String o1 & o2 are greater than length of 2 chars
                return o1.codePointAt(1) - o2.codePointAt(1);
                //throw new UnsupportedOperationException("Unimplemented method 'compare'");
            }
        };

        myPlaces.stream()
            //.filter(x -> x.startsWith("Nepal"))
            .map(x -> x.toLowerCase())
            //.sorted()
            .sorted(cs)
            .forEach(System.out::println);

    }

    static void printStringChars(String str) {
        for(char c : str.toCharArray()) {
            System.out.println(c);
        }
    }
}
