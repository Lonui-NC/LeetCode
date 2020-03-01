import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
// Personal Solution 
class SolutionV1 {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> numberMap = new HashMap<>(); 
        numberMap.put(2, "abc");
        numberMap.put(3, "def");
        numberMap.put(4, "ghi");
        numberMap.put(5, "jkl");
        numberMap.put(6, "mno");
        numberMap.put(7, "pqrs");
        numberMap.put(8, "tuv");
        numberMap.put(9, "wxyz");
        List<String> result = new LinkedList<>();
        List<String> midResult = new LinkedList<>();
        if ((digits == null) || (digits.length() == 0)) {
            return result; 
        }
        // step 1 - 初始化
        char ch = digits.charAt(0);
        String cur = numberMap.get(ch - '0');
        for (int k = 0; k < cur.length(); k++) {
            result.add(cur.substring(k, k+1));
        }
        for (int i = 1; i < digits.length(); i++) {
            // step 2 - 具体实现
            cur = numberMap.get(digits.charAt(i) - '0');
            midResult.clear();
            while (result.size() > 0) {
                // always remove the first str
                String temp = result.remove(0);
                for (int j = 0; j < cur.length(); j++) {
                    midResult.add(temp + String.valueOf(cur.charAt(j)));
                }
            }
            result.addAll(midResult);
        }
        return result;
    }
}

class Solution {
    // 的确，使用了字符串做key就不用转化了
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<>();

    // 使用回溯递归的方法来做
    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check - return 
        if (next_digits.length() == 0) {
            output.add(combination);
        // if there are still digits to check 
        } else { 
            // iterate over all letters which map 
            // the next available digit 
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                // 这里其实用了一个类似分支的方法，将这个东西直接传递给下个function来做处理和扩散
                // 这里其实类似连续掉了三遍方法来维系状态 - 比起我的好在不用记录中间值
                backtrack(combination + letter, next_digits.substring(1));
              }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return output;
    }
}





// @lc code=end

