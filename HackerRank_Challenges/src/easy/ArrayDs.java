package easy;
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


public class ArrayDs {

    /*
            * Complete the 'reverseArray' function below.
            *
            * The function is expected to return an INTEGER_ARRAY.
            * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {

        List<Integer> b = new ArrayList<>();
        for(int i = a.size()-1 ; i >= 0 ; i--) {
            b.add(a.get(i));
        }
        return b;


    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> res = ArrayDs.reverseArray(arr);

        for(Integer p: res) {
           System.out.println(p);
        }

        bufferedReader.close();

    }
}

