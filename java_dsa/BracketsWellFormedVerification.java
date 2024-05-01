import java.util.ArrayDeque;
import java.util.Deque;

public class BracketsWellFormedVerification {
    public static void main(String[] args) {
        String input = "({[sdssdrerer})";
        System.out.println("input: "+input+" \nBracketsWellFormed: "+validBracketsCheck(input));
    }
    private static boolean validBracketsCheck(String input) {
        Deque<Character> mycharstack = new ArrayDeque<>();
        for(char c : input.toCharArray()) {
            if(c == '{'  || c == '(' || c == '[') {
                mycharstack.push(c);
            }
            else if(c == '}'  || c == ')' || c == ']') {
                char t = mycharstack.pop();
                if((c == ']' && t == '[') || (c == ')' && t == '(') || (c == '}' && t == '{')) 
                    continue;
                else return false;
            }
        }
        return mycharstack.size()>0 ? false : true;
    }
}
