package com.jk.power.leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * Created by jinkai on 2017/7/10.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] rightNums = {2,7,11,15};
        int[] errorNums = {1,7,11,15};

        int target = 9;

        try {
            System.out.println("Right-1 : "+ Arrays.toString(twoSum1(rightNums,target)));
//            System.out.println("Error-1 : "+ Arrays.toString(twoSum1(errorNums,target)));

            System.out.println("Rigth-2 : " + Arrays.toString(twoSum2(rightNums,target)));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 时间复杂度 : O（n^2）
     * 空间复杂度 : O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums,int target) throws Exception{

        for(int i =0 ;i < nums.length;i++){

            for(int j = i+1;j< nums.length;j++){

                if(target == nums[i]+ nums[j]){
                    return new int[]{i,j};
                }

            }

        }
        throw new IllegalArgumentException(String.format("no two sum in %s is %s.",Arrays.toString(nums),target));

    }


    /**
     *
     * 时间复杂度 : O(1)~O(n)
     * 空间复杂度 : O(n)
     * @param nums
     * @param target
     * @return
     * @throws Exception
     */
    public static int[] twoSum2(int[] nums,int target) throws Exception{

        Map<Integer,Integer> numMap = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            numMap.put(nums[i],i);
        }

        int sub;
        for(int j = 0;j< nums.length;j++){

            sub = target - nums[j];

            if(numMap.containsKey(sub) && numMap.get(sub) != j){
                return new int[]{j,numMap.get(sub)};
            }

        }



        throw new IllegalArgumentException(String.format("no two sum in %s is %s.",Arrays.toString(nums),target));

    }

}
