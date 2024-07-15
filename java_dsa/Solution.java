
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class SalesForceStringValidWordResult {

    /*
     * Complete the 'getValidWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING_ARRAY dictionary
     */

    public static String getValidWord(String s, List<String> dictionary) {
    // Write your code here
    String output = "";
    List<String> opList = new ArrayList<>();
    System.out.println(s+"---"+dictionary);
    
    Comparator<String> comp = new Comparator<String>(){
        public int compare(String c1, String c2) {
            return c1.compareTo(c2);
        }
    };
    
    //split string and put it in a char array
    char[] ch = s.toCharArray();
    System.out.println(ch);
    dictionary.stream().forEach(x -> {
        char[] ip = x.toCharArray();
        int i = 0;
        boolean dictFoundFlg = true;
        if(ip.length>ch.length) {
            dictFoundFlg = false;
        } else {
            for(char c : ip) {
            for(;i<ch.length;i++) {
                if(c==ch[i]) {
                    //letter found
                    break;
                } else {
                    //letter not found 
                    if(i==ch.length-1) {
                        //end of search string
                        dictFoundFlg = false;
                        break;
                    }
                }
            }
        }
        }
        
        if(dictFoundFlg)
            opList.add(x);
    });
    opList.sort(comp);
    
    return opList.size()>=1 ? opList.get(0) : "-1";

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int dictionaryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dictionary = IntStream.range(0, dictionaryCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String result = SalesForceStringValidWordResult.getValidWord(s, dictionary);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
