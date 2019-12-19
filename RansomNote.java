import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static boolean checkMagazine(String[] magazine, String[] note) {

        Hashtable<String, Integer> magazineCount = new Hashtable<>(magazine.length);
        Hashtable<String, Integer> noteCount = new Hashtable<>(magazine.length);
        for(String word : magazine){
            if(!magazineCount.containsKey(word))
                magazineCount.put(word,0);
            else
                magazineCount.put(word, magazineCount.get(word)+1);
        }
        for(String word: note){
            if(!noteCount.containsKey(word))
                noteCount.put(word, 0);
            else
                noteCount.put(word, noteCount.get(word)+1);
        }

        for(String key: noteCount.keySet()){
            if(!magazineCount.containsKey(key)){
                return false;
            }
            int count = noteCount.get(key);
            if(magazineCount.get(key) < count){
                return false;
            }
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        System.out.println(checkMagazine(magazine, note) ? "Yes" : "No");

        scanner.close();
    }
}
