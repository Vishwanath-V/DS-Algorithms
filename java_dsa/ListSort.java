import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(List.of(9,10,7,2,1,4,89,34,454,23));
        System.out.println(l);
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer u1, Integer u2) {
                return Integer.compare(u1, u2);
            }
        };
        l.sort(c);
        System.out.println(l);
        
        System.out.println(Integer.bitCount(6));
    }
}
