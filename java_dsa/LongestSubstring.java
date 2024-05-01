public class LongestSubstring {
    static String X = "OldSite:GeeksforGeeks.org"; 
    static String Y = "NewSite:GeeksQuiz.com";
    public static void main(String[] args) {
        int xl = X.length();
        int yl = Y.length();
        System.out.println(lcs(xl,yl,0));
    }

    static int lcs(int i, int j, int count) {
        if(i==0 || j==0) {
            return count;
        }

        if(X.charAt(i-1) == Y.charAt(j-1)) {
            count = lcs(i-1,j-1,count+1);
        }

        count = Math.max(count, Math.max(lcs(i-1,j,0),lcs(i,j-1,0)));

        return count;
    }
}
