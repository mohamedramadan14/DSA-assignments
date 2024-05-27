package patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * S = "eceba" and k = 3
 * @author Mohamed Ramadan
 * @since 26/05/2024
 */
public class LongestSubstringKDistinct {
    public static int longestSubstringKDistinct(String s , int k){
        if(s.isEmpty() || k == 0) return  0;

        Map<Character , Integer> charCount = new HashMap<>();
        int maxLength = 0 , l = 0;
        int n = s.length();
        for(int r = 0 ; r < n ; ++r){
            char rightChar = s.charAt(r);
            charCount.put(rightChar , charCount.getOrDefault(rightChar , 0) + 1);

            while(charCount.size() > k){
                char leftChar = s.charAt(l);
                charCount.put(leftChar , charCount.get(leftChar) - 1);

                if(charCount.get(leftChar) == 0){
                    charCount.remove(leftChar);
                }
                ++l;
            }
            maxLength = Math.max(maxLength , r - l + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String S = "WORLD";
        int k = 4;
        System.out.println(longestSubstringKDistinct(S , k));
    }
}
