import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Remove Duplicate " + sol.removeDuplicatesV1(numbers));

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
}
