public class HailStones {
    public static void main(String[] args) {
        int n = 10;
        while(n!=1) {
            System.out.print(n+"\t");
            if(n%2 == 0) {
                n = n/2;
            } else {
                n = 3*n + 1;
            }
        }
    System.out.print(n);

    }
    
}
