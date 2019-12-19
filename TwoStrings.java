import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.

     static String twoStrings(String s1, String s2) {
        Hashtable<Character, Integer> s1Counter = new Hashtable<>();
        for(char c : s1.toCharArray()){
            if(!s1Counter.containsKey(c))
                s1Counter.put(c, 0);
            else
                s1Counter.put(c, s1Counter.get(c)+1);
        }

        Hashtable<Character, Integer> s2Counter = new Hashtable<>();
        for(char c : s2.toCharArray()){
            if(!s2Counter.containsKey(c))
                s2Counter.put(c, 0);
            else
                s2Counter.put(c, s2Counter.get(c)+1);
        }

        for(Character c : s1Counter.keySet()){
            if(s2Counter.containsKey(c))
                return "YES";
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
