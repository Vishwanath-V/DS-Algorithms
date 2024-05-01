public class ReverseInteger {
    public static void main(String[] args) {
        int x = -123;
        int reversedInt = reverseInt(Math.abs(x));
        System.out.println(x<0 ? -1*reversedInt : reversedInt);
    }

    static int reverseInt(int x) {
        StringBuilder sb = new StringBuilder();
        while(x>0) {
            sb.append(x%10);
            x=x/10;
        }
        return Integer.parseInt(sb.toString());
    }
}
