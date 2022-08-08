import java.util.*;

public class Main {
	//this code will only work if there is no duplicate elements
    public static int solve(int[][] nums1, int[][] nums2, int target) {
		int i = 0;
		int j = nums2.length * nums2[0].length - 1;
		int count = 0;
		while(i < nums1.length * nums1[0].length && j >= 0){
		    int r1 = i / nums1[0].length;
		    int c1 = i % nums1[0].length;
		    
		    int r2 = j / nums2[0].length;
		    int c2 = j % nums2[0].length;
		    
		    int sum = nums1[r1][c1] + nums2[r2][c2];
		    
		    if(sum > target){
		        j--;
		    }else if(sum < target){
		        i++;
		    }else{
		        count++;
		        i++;
		        j--;
		    }
		}

		return count;
	}
	
	//work even when duplicates elements are there
	public static int solve2(int[][] nums1, int[][] nums2, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums1.length; ++i){
		    for(int j = 0; j < nums1[0].length; ++j){
		        map.put(nums1[i][j], map.getOrDefault(nums1[i][j], 0) + 1);
		    }
		}
		
		int res = 0;
		for(int i = 0; i < nums2.length; ++i){
		    for(int j = 0; j < nums2[0].length; ++j){
		        if(map.containsKey(target - nums2[i][j])){
		            res += map.get(target - nums2[i][j]);
		        }
		    }
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] mat1 = new int[N][N];
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}

		int[][] mat2 = new int[N][N];
		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		System.out.println(solve2(mat1, mat2, K));

	}

}
