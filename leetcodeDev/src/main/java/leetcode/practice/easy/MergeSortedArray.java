package leetcode.practice.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortedArray {

    static public void main(String... args) {

        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        merge2(nums1, 3, nums2, 3);

    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int o = m;

        while (m > 0) {
            nums1[m - 1] = nums1[m - 1];
            m--;
        }

        while (n > 0 && o > 0) {
            nums1[o - 1 + n] = nums2[n - 1];
            n--;
        }

        if (o == 0 && n > 0) {
            while (n > 0) {
                nums1[n - 1] = nums2[n - 1];
                n--;
            }
        }

        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        List<Integer> list = new ArrayList<>();

        Arrays.stream(nums1).forEach(num -> {
            list.add(num);
        });

        Arrays.stream(nums2).forEach(num -> {
            list.add(num);
        });

        nums1 = list.stream()
                .filter(x1 -> x1 != 0)
                .sorted()
                .mapToInt(x1 -> x1)
                .toArray();

        System.out.println(Arrays.toString(nums1));

        // nums1 = final2.stream().mapToInt(Integer::intValue).toArray();

        // String result = String.join(",",
        // final2.stream().map(String::valueOf).collect(Collectors.toList()));
        // System.out.println("[" + result + "]");

    }

}