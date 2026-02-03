import java.util.*;

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
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < s.length(); i++) {
            if( map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public char findTheDifference(String s, String t) {
        HashMap <Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c) || map.get(c) == 0){
                return t.charAt(i);
            }
            map.put(c,map.get(c)-1);
        }
        return ' ';
    }
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int size = t.length();
        HashMap<Character,Character> mapST = new HashMap<>();
        HashMap<Character,Character> mapTS = new HashMap<>();

        for (int i = 0; i < size; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(mapST.containsKey(a) && mapST.get(a) !=b){
                return false;
            }
            if(mapTS.containsKey(b) && mapTS.get(b) !=a){
                return false;
            }

            mapST.put(a,b);
            mapTS.put(b,a);
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();

        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        for (int i = 0; i <words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(words[i])){
                return false;
            }
            if (reverseMap.containsKey(word) && reverseMap.get(word) != c) {
                return false;
            }
            map.put(pattern.charAt(i),word);
            reverseMap.put(word,pattern.charAt(i));

        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String word : strs){
            char chars [] = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord,new ArrayList<>());
            }
            map.get(sortedWord).add(word);

        }
        return new ArrayList<>(map.values());

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],(map.getOrDefault(nums[i],0)+1));
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> Integer.compare(map.get(b), map.get(a)));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys.get(i);
        }

        return result;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // نمشي على كل رقم
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
    public void reverseString(char[] s) {
        int left =0 ;
        int right = s.length - 1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }

        System.out.println(s);
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left<right){
            while (left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution test = new Solution();
//        System.out.print(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 9)));
//        System.out.println( test.isValid("()[]{}"));
//        System.out.println(test.isAnagram("anagram","nagaram"));
//        String[] words = {"flower", "flow", "flight"};
//        System.out.println(test.longestCommonPrefix(words));
//        System.out.println(test.containsDuplicate(new int[]{1,2,3}));
//        System.out.println(test.firstUniqChar("leetcode"));
//        System.out.println(test.findTheDifference("aabb","aabbb"));
//        System.out.println(test.isIsomorphic("f11","b22"));
//        System.out.println(test.wordPattern("abba","dog cat cat dog"));
//        System.out.println(test.groupAnagrams({"eat","tea","tan","ate","nat","bat"}));
//        int[] nums = {1, 1, 1, 2, 2, 3};
//        int k = 2;
//        int[] topK = test.topKFrequent(nums, k);
//        System.out.println("Top " + k + " frequent elements:");
//
//        for (int num : topK) {
//            System.out.print(num + " ");
//        }
//        System.out.println(test.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
//        test.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});

        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));

    }
}
