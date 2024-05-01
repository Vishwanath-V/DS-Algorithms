import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MovingAverageStream {

    Deque<Integer> dq;
    int sum=0, size=0, k;
    double mavg;

    MovingAverageStream(int k) {
        dq =  new ArrayDeque<>(k);
        this.k = k;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(x));
        //x[1],x[2] = x[2],x[3];
        System.out.println(Arrays.toString(x));
        MovingAverageStream mv = new MovingAverageStream(3);
        for(int i = 0; i<10; i++) {
            System.out.println("InputElement: "+i+"\tMovingAverage: "+mv.streamAverage((int) (1000*Math.random())));
        }
    }

    private double streamAverage(int x) {
        sum = sum+x;
        if(dq.size()+1 <= k) {
            dq.add(x);
        } else {
            int ele = dq.remove();
            sum = sum - ele;
            dq.add(x);
        }
        System.out.println(dq);
        return 1.0*sum/dq.size();
    }
}
