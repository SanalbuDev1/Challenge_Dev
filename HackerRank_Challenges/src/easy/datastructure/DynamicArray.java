package easy.datastructure;

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

class DynamicArray {

    /**
     * Este método realiza operaciones en una lista de listas de enteros basándose
     * en una serie de consultas.
     *
     * @param n       El número de listas vacías a inicializar en la lista de
     *                operaciones.
     * @param queries Una lista de consultas, donde cada consulta es una lista de
     *                enteros.
     *                Si el primer elemento de la consulta es 1, se añade un
     *                elemento a una de las listas en operaciones.
     *                Si el primer elemento de la consulta no es 1, se recupera un
     *                elemento de una de las listas en operaciones y se añade a la
     *                lista seq.
     * @return Una lista de enteros que contiene los resultados de las consultas de
     *         tipo 2.
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        int idx = 0;

        List<List<Integer>> operations = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> query = new ArrayList<>();
            operations.add(query);
        }

        for (int j = 0; j < queries.size(); j++) {
            List<Integer> q = queries.get(j);
            if (q.get(0) == 1) {
                idx = (q.get(1) ^ lastAnswer) % n;
                operations.get(idx).add(queries.get(j).get(2));
            } else {
                List<Integer> seqList = operations.get((q.get(1) ^ lastAnswer) % n);
                lastAnswer = seqList.get(q.get(2) % seqList.size());
                seq.add(lastAnswer);
            }
        }

        for (int k = 0; k < operations.size(); k++) {
            for (int l = 0; l < operations.get(k).size(); l++) {
                System.out.print(operations.get(k).get(l) + " ");
            }
            System.out.println();
        }

        return seq;

    }

}

class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/easy/output.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = DynamicArray.dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
