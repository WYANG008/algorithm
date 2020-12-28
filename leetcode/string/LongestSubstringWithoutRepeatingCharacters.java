package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s ==null || s.length() ==0) return 0;

        if(s.length() ==1) return 1;

        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        while (right < s.length()) {

            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) +1, left);
            }
            map.put(s.charAt(right), right);
            maxLen = Math.max(maxLen, right-left +1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters runClass  = new LongestSubstringWithoutRepeatingCharacters();
        int result = runClass.lengthOfLongestSubstring("abba");
        System.out.println(String.format("result is: %d", result));
    }
}
