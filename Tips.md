Overview Tips 
* 写完之后重新看一遍再Run -》 适当优化


Array Tips
* 数组的长度是 arr.length
* Arrays.sort => `Arrays.sort(nums, i, j);` -> 可以指定下标 同取值，下标值exclusive 
* Arrays.sort(a,Collections.reverseOrder());-> 倒序

Math Tips
* `res = Math.max(resLeft, resRight) + 1;`


String Tips
* stringA.length() => 长度
* 滑动窗口下标 - N - L + 1
* stringA == "" || stringA.length() == 0
* haystack.charAt(i+j) != needle.charAt(j)
* haystack.indexOf(needle)
```java
for (int start = 0 ; start < N - L + 1; start++) {
  if (haystack.substring(start, start + L).equals(needle)) {
      return start;
  }
}
```

Stack Tips
* [Java recommend to use `Deque` to replace `Stack`](https://chengfeng96.com/blog/2018/01/20/Java%E4%B8%AD%E7%94%A8Deque%E6%8E%A5%E5%8F%A3%E4%BB%A3%E6%9B%BFStack%E6%8E%A5%E5%8F%A3%E5%AE%8C%E6%88%90%E6%A0%88%E5%8A%9F%E8%83%BD/)
* `Deque<Integer> stack = new ArrayDeque<Integer>();`
* Deque可以由ArrayDeuqe或者LinkedList实现，它们两者使用的区别以及优劣也就是数组和链表的区别，你懂得。

Binary Tree
* 中序遍历 -> 注意List ArrayList的用法和integer
```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return new ArrayList<Integer>();
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
}
```

递归 Tips
* 所有的递归都能用回溯来实现 -> 需要用到栈的实现 -> 递归的本质就是栈！