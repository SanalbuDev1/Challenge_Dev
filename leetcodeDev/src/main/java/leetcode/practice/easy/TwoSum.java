package leetcode.practice.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * author: SanalbuDev1
 * date: 202304060
 */

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 18;
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

    // Otro ejemplo que me copie
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

}
