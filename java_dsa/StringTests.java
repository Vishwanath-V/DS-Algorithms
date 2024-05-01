public class StringTests {
    private static CharSequence cs;

    public static void main(String[] args) {
        String s = "hello this is a test string";
        long cntl = s.chars().filter(x -> x == 'l').count();
        System.out.println(cntl);
        cs = s.subSequence(0, 5);

        System.out.println(s.subSequence(0, 5));

        System.out.println(s.startsWith("hello", 0));
    }
}
