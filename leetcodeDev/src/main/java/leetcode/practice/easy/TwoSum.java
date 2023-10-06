package leetcode.practice.easy;

import java.util.AbstractMap;
import java.util.stream.IntStream;

/**
 * author: SanalbuDev1
 * date: 202304060
 */

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = { 2, 7, 11, 15, 30 };
        int target = 45;
        TwoSum twoSum = new TwoSum();
        twoSum.twoSumFunctional(target, nums);

    }

    public static void twoSum(int target, int... nums) {

        int recorrido = nums.length;

        for (int i = 0; i < recorrido; i++) {
            for (int j = 0; j < recorrido; j++) {

                if (i != j) {
                    if (target == (nums[i] + nums[j])) {
                        System.out.println("Se encontro el target " + nums[i] + nums[j]);
                        break;
                    }
                }

            }
        }

    }

    public int[] twoSumFunctional(int target, int[] nums) {
        // List<Integer> listaNumeros = Arrays.asList(numbers);
        int[] vectores = new int[2];

        IntStream.range(0, nums.length)
                .mapToObj((i) -> new AbstractMap.SimpleEntry<>(i, nums[i]))
                .forEach((map) -> {
                    Integer numero = map.getValue();
                    Integer posicion = map.getKey();

                    System.out.println("numero " + numero);
                    System.out.println("Posicion " + posicion);

                    IntStream.range(0, nums.length)
                            .mapToObj((j) -> new AbstractMap.SimpleEntry<>(j, nums[j]))
                            .filter((map2) -> posicion != map2.getKey())
                            .filter((map2) -> target == (numero + map2.getValue()))
                            .forEach((map2) -> {
                                System.out.println("Se encontro el target " + (numero + map2.getValue()));
                                System.out.println("Posicion 1: " + posicion + " Posicion 2: " +
                                        map2.getKey());
                                vectores[0] = posicion;
                                vectores[1] = map2.getKey();
                            });
                });

        return vectores;

    }

    // Otro ejemplo que me copie
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

}
