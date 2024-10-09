import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int [] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            arr[c - 'a']++;
        }

        int max = 0;
        int idx = 0;
        boolean flag = false;
        for(int i = 0; i < 26; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
                flag = false;
            }

            else if (max == arr[i]) {
                flag = true;
            }
        }
        if (flag) System.out.println("?");
        else System.out.println((char) (idx + 'A'));
    }
}
