import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
//        System.out.println(stack.toString());
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if (stack.isEmpty()) {
                    return false;
                }
                if(s.charAt(i)!=map.get(stack.pop())){
                    return false;
                }

            }


        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            if (!map.containsKey(c)) {
                return false;
            }

            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }
    public String longestCommonPrefix(String[] strs) {
        // ["flower","flow","flight"]
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],(map.getOrDefault(nums[i],0)  +1));
        }
        for (int i = 0; i <nums.length ; i++) {
            if (map.get(nums[i]) >1 ) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
//        System.out.print(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println( test.isValid("()[]{}"));
//        System.out.println(test.isAnagram("anagram","nagaram"));
//        String[] words = {"flower", "flow", "flight"};
//        System.out.println(test.longestCommonPrefix(words));
        System.out.println(test.containsDuplicate(new int[]{1,2,3}));

    }
}
