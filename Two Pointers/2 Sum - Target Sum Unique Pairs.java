//TC : nlogn
import java.util.*;
public class Main {
  public static List<List<Integer>> twoSum(int[] arr, int target) {
    // write your code here
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(arr);
    int l = 0;
    int r = arr.length - 1;

    while(l < r){
      if(l > 0 && arr[l - 1] == arr[l]){
        l++;
        continue;
      }
      
      int sum = arr[l] + arr[r];
      if(sum > target){
        r--;
      }else if(sum < target){
        l++;
      }else{
        res.add(new ArrayList(Arrays.asList(arr[l], arr[r])));
        l++;
        r--;
      }
    }

    return res;
  }
  
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = twoSum(arr, target);
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
