import java.util.*;

public class Main {

	public static int solution(String s, int k) {
		if(k == 0) return 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int count = 0;
        int l = 0;

        for(int r = 0; r < s.length(); ++r){
            char ch = s.charAt(r);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            if(freq.size() > k){
                while(l < r && freq.size() > k){
                    char chl = s.charAt(l);
                    if(freq.get(chl) == 1){
                        freq.remove(chl);
                    }else{
                        freq.put(chl, freq.get(chl) - 1);
                    }
                    l++;
                }
            }

            count += (r - l + 1);
        }

        return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
