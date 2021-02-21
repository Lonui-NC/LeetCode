Overview Tips 
* 写完之后重新看一遍再Run -》 适当优化


Array Tips
* 数组的长度是 arr.length
* Arrays.sort => `Arrays.sort(nums, i, j);` -> 可以指定下标 同取值，下标值exclusive
* Arrays.sort(a,Collections.reverseOrder());-> 倒序

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