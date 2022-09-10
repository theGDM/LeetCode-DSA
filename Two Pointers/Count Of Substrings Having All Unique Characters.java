import java.util.*;

public class Main {

	public static int solution(String s) {
		HashMap<Character, Integer> freq = new HashMap<>();
        int l = 0, maxLen = 0;
        int count = 0;
        for(int r = 0; r < s.length(); ++r){
            char ch = s.charAt(r);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            
            while(freq.get(ch) > 1){ //tab tak map se remove karte jao, jab tak, ch ka count 1 nahi ho jata
                char chl = s.charAt(l);
                freq.put(chl, freq.get(chl) - 1);
                l++;
            }
            count += r - l + 1;
        }
        return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
}
