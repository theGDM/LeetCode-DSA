import java.util.*;

public class Main {

  public static List<List<Integer>> twoSum(int left, int target, int[] nums) {
    int start = left;
    int right = nums.length - 1;
    List<List<Integer>> res = new ArrayList<>();
    while (left < right) {
      if (left > start && nums[left] == nums[left - 1]) {
        left++;
        continue;
      }

      int sum = nums[left] + nums[right];

      if (sum < target) {
        left++;
      } else if (sum > target) {
        right--;
      } else {
        List<Integer> part = new ArrayList<>();
        part.add(nums[left]);
        part.add(nums[right]);

        res.add(part);
        left++;
        right--;
      }
    }

    return res;
  }

  public static List<List<Integer>> kSumHelper(int start, int target, int[] nums, int k) {
    if (k == 2) {
      return twoSum(start, target, nums);
    }

    List<List<Integer>> res = new ArrayList<>();
    for (int i = start; i <= nums.length - k; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue; //skip duplicates

      //important
      if ((long)target - nums[i] < Integer.MIN_VALUE || (long)target - nums[i] > Integer.MAX_VALUE) {
        return new ArrayList<>(); //avoid overflow
      }
      //sub result
      List<List<Integer>> subRes = kSumHelper(i + 1, target - nums[i], nums, k - 1);

      for (List<Integer> sub : subRes) {
        sub.add(0, nums[i]);
        res.add(sub);
      }
    }

    return res;
  }

  public static List<List<Integer>> kSum(int[] nums, int target, int k) {
    Arrays.sort(nums);
    return kSumHelper(0, target, nums, k);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    int k = scn.nextInt();
    List<List<Integer>> res = kSum(arr, target, k);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }

}
