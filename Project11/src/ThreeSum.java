package 琐碎知识点;

import java.util.*;
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

public class ThreeSum {
    public static List<List<Integer>> threeSum1(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i< nums.length-2;i++){
            int j = i + 1;
            int k = nums.length-1;
            while(j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if(s<0){
                    j++;
                }else if(s>0){
                    k--;
                }else{
                    //以数组的形式将结果 e 添加进链表并保存
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);

                    //去掉重复的数
                    while(j<k && nums[j] == nums[j+1]){
                        j++;
                    }
                    j++;

                    while(j<k && nums[k] == nums[k-1]){
                        k--;
                    }
                    k--;
                }
            }
            while(i < nums.length-2 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length-2){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                while(j < k && nums[i] + nums[j] + nums[k] < 0){
                    j++;
                }
                if(j >= k){
                    break;
                }
                if(nums[i]+nums[j]+nums[k] == 0){
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);

                    while(j < k && nums[j] == nums[j+1]){
                        j++;
                    }
                    j++;
                }

                while(j < k && nums[i]+nums[j]+nums[k] > 0){
                    k--;
                }
                if(j >= k){
                    break;
                }
                if(nums[i]+nums[j]+nums[k] == 0){
                    List<Integer> e = new ArrayList<>();
                    e.add(nums[i]);
                    e.add(nums[j]);
                    e.add(nums[k]);
                    result.add(e);
                    while(j < k && nums[k] == nums[k-1]){
                        k--;
                    }
                    k--;
                }
            }
            while(i < nums.length-2 && nums[i] == nums[i+1]){
                i++;
            }
            i++;
        }
        return result;
    }

    public static List<List<Integer>>thereSum3(int[] nums){
            HashSet<List<Integer>> result = new HashSet<>();
            Arrays.sort(nums);
            for(int i = 0;i < nums.length-2;i++){
                int j = i+1;
                int k = nums.length -1;
                while(j < k){
                    int s = nums[i] + nums[j] + nums[k];
                    if(s < 0){
                        j++;
                    }else if(s > 0){
                        k--;
                    }else{
                        List<Integer> e = new ArrayList<>();
                        e.add(nums[i]);
                        e.add(nums[j]);
                        e.add(nums[k]);
                        result.add(e);
                    }
                }
            }
            return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> r = threeSum2(nums);
        System.out.println(r);
    }

}
