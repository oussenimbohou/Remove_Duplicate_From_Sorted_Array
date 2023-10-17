import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {0,0,0,0};
        System.out.println("Remove Duplicate " + sol.removeDuplicatesV3(numbers));

    }
    public int removeDuplicates(int[] nums) {
        List<Integer> inList = Arrays.asList(Arrays.stream(nums)
                                                   .boxed()
                                                   .toArray(Integer[]::new));

        List<Integer> no_duplicated = inList.stream().distinct().toList();
        System.out.println("No duplicates = " + no_duplicated);
        return no_duplicated.size();
    }

    public int removeDuplicatesV1(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums.length; i++) {
            if(i < nums.length - 1) j = i + 1;
            if(nums[i] != nums[j]) list.add(nums[i]);
        }
        if(!list.contains(nums[nums.length - 1])) list.add(nums[nums.length - 1]);
        System.out.println("List = " + list);
        return list.size();
    }
    public int removeDuplicatesV2(int[] nums){
        int current = 0;
        int temp = 1;
        int counter = 0;

        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != '\0') break;
            if(i == nums.length - 1) return 1;
        }
        while(current < nums.length && counter < nums.length){
           if(nums[current] == nums[temp]){
               rightShift(nums, temp);
           } else{
               temp++;
               current++;
               if(temp == nums.length) break;
           }
           counter++;
           System.out.println("current = "+current+" temp = "+temp);
        }
        System.out.println("nums = " + Arrays.toString(nums));
        int count = 0;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            if(nums[i] == '\0') count++;
            if(nums[i] != '\0') break;
        }
        return nums.length - count;
    }

    private static void rightShift(int[] nums, int temp) {
        int i;
        for ( i = temp; i < nums.length ; i++) {
            if (i < nums.length - 1) nums[i] = nums[i + 1];
            else break;
        }
        nums[i] = '\0';
        System.out.println("nums = " + Arrays.toString(nums) + ", temp = " + temp);
    }
    public int removeDuplicatesV3(int[] nums){
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[k-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
