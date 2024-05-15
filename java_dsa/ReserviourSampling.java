import java.util.Arrays;
import java.util.Random;

public class ReserviourSampling {
    public static void main(String[] args) {
        int[] inputElements = new int[] {2,3,45,6,7,8,9,4,2,4,6,8};
        Arrays.stream(sampleKitems(inputElements,inputElements.length,3)).forEach(System.out::println);
    }

    static int[] sampleKitems(int[] stream, int n, int k) {
        int reserviour[] = new int[k];
        int i=0;
        for(i=0;i<k;i++) {
            reserviour[i]=stream[i];
        }

        Random r = new Random();
        // iterate from kth element to nth element and randomly select & replace
        for(i=k;i<n;i++) {
            int ri = r.nextInt(i+1); //random index seen till ith index
            // if random index < k then replace that element in reserviour element with ith index from steam
            if(ri<k) {
                reserviour[ri]=stream[i];
            }
        }
        return reserviour;
    }
}
