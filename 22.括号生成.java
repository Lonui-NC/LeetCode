import java.util.*;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
// 简单递归来一个
class Solution {
    // failed - 因为没考虑到所有情况
    public List<String> generateParenthesisV1(int n) {
        List<String> res = null;
        if (n < 1) {
            return res;
        } else if (n == 1) {
            // 返回初始值
            return Arrays.asList("()");
        }

        // 本质是一个递归，迭代
        // 假设res中的子字符串为S(n)
        // S(n) = '()' + S(n-1)
        // S(n) = '(' + S(n-1) + ')'
        // S(n) = S(n-1) + '()'
        // 当然要去重
        Set<String> resSet = new HashSet<>();
        List<String> preRes = generateParenthesis(n - 1);
        for (String string : preRes) {
            resSet.add("()" + string);
            resSet.add("(" + string + ")");
            resSet.add(string + "()");
        }
        // 基本思路对，但在4的这个地方出错，是因为有不同的组合方式
        // 除了上述的这个包裹性之外，还有独立性！
        // 类似单个括号'()', 也可以左右'(())'
        // 其实这样想起来是对半拆分，然后两边再自由组合，去重
        // set加上对半拆分的例外情况
        int left = n/2;
        int right = n - n/2;
        if (left > 0 && right > 0) {
            String leftStr = "";
            String rightStr = "";
            for (int i = 0; i < left; i++) {
                leftStr.concat("(");
            }
            for (int i = 0; i < left; i++) {
                leftStr.concat(")");
            }
            for (int i = 0; i < right; i++) {
                rightStr.concat("(");
            }
            for (int i = 0; i < right; i++) {
                rightStr.concat(")");
            }
            resSet.add(leftStr + rightStr);
            resSet.add(rightStr + leftStr);
        }
        res = new LinkedList<>(resSet);
        return res;
    }

    // 暴力法 - 遍历所有的可能，通过valid判断
    public List<String> generateParenthesisV2(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2*n], 0, combinations);
        return combinations;
    }

    // 其实更倾向于我的解法
    // 为了生成所有序列，我们可以使用递归。长度为 n 的序列就是在长度为 n-1 的序列前加一个 '(' 或 ')'。
    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0; 
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            // 左右必须成对出现，如果小于0 右面多了不能补，证明错误
            if (balance < 0) return false;
        }
        return (balance == 0); 
    }

    // 回溯法
    // 我们可以只在序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。
    // 我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
    // 如果左括号数量不大于 nn，我们可以放一个左括号。
    // 如果右括号数量小于左括号的数量，我们可以放一个右括号。
    public List<String> generateParenthesisV3(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    // 太难理解，想不到！
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    // 按括号长度递归 
    // 这样一来，每一个括号序列可以用 (a)b 来表示，其中 a 与 b 分别是一个合法的括号序列（可以为空）。
    ArrayList[] cache = new ArrayList[100];
    // 更像这个方法！主要是递归条件找错了！
    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left : generate(c)) {
                    for (String right : generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                } 
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

}
// @lc code=end

