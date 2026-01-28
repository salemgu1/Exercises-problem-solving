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

    public static void main(String[] args) {
        Solution test = new Solution();
//        System.out.print(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println( test.isValid("()[]{}"));
    }
}
