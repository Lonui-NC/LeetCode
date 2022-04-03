Overview Tips 
* 写完之后重新看一遍再Run -》 适当优化


Array Tips
* 数组的长度是 arr.length
* Arrays.sort => `Arrays.sort(nums, i, j);` -> 可以指定下标 同取值，下标值exclusive 
* Arrays.sort(a,Collections.reverseOrder());-> 倒序
* `int[] G = new int[n+1];`

Math Tips
* `res = Math.max(resLeft, resRight) + 1;`

Foreach Tips
```java
for (TreeNode l : leftTrees) {
    for (TreeNode r: rightTrees) {
        curNode.left = l;
        curNode.right = r;
        result.add(curNode);
    }
}
```

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
* 二叉搜索树 -> 回溯法 -> 二叉搜索树关键的性质是根节点的值大于左子树所有节点的值，小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树。
* 通常来说，对于二叉搜索树，我们可以通过中序遍历得到一个递增的有序序列。 我们将在另一张卡片（数据结构介绍 – 二叉搜索树）中再次提及。

递归 Tips
* 所有的递归都能用回溯来实现 -> 需要用到栈的实现 -> 递归的本质就是栈！
二叉树递归实现栈 -> 参照递归的方式去思考！
```java
while(root != null || !stack.isEmpty()) { 
      // 这个的作用在于遍历完所有的root和root的left！
      while(root != null) {
        stack.push(root);
        // 永远先拿root的val
        result.add(root.val);
        root = root.left;
      }
      // 如果左边都遍历完，那么走右边的！
      root = stack.pop().right;
    }
```

Java 队列 - Queue
* Queue 
```java
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
        return queue1.isEmpty() && queue2.isEmpty();
        u = q.poll();
        v = q.poll();
```
* LinkedList => add & addAll(Collection c)

Java 集合 - Set
* Set
```java
Set<Integer> set = new HashSet<Integer>();
set.add(a);
set.contains(b);
```