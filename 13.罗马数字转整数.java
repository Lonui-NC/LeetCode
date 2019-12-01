/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        char[] a = s.toCharArray();
        int number = 0;
        int l = a.length;
        for(int i=0;i<l;i++) {
            if (a[i] == 'M') {
                number += 1000;
            }
            if (a[i] == 'D') {
                number += 500;
            }
            if (a[i] == 'C') {
                if((i + 1 < l) && a[i+1] == 'M') {
                    number += 900;
                    i++;
                    continue;
                } else if ((i + 1 < l) && a[i+1] == 'D') {
                    number += 400;
                    i++;
                    continue;
                }
                number += 100;
            }
            if (a[i] == 'L') {
                number += 50;
            }
            if (a[i] == 'X') {
                if((i + 1 < l) && a[i+1] == 'C') {
                    number += 90;
                    i++;
                    continue;
                } else if ((i + 1 < l) && a[i+1] == 'L') {
                    number += 40;
                    i++;
                    continue;
                }
                number += 10;
            }
            if (a[i] == 'V') {
                number += 5;
            }
            if (a[i] == 'I') {
                if((i + 1 < l) && a[i+1] == 'X') {
                    number += 9;
                    i++;
                    continue;
                } else if ((i + 1 < l) && a[i+1] == 'V') {
                    number += 4;
                    i++;
                    continue;
                }
                number += 1;
            }
        }
        return number;
    }
}
// @lc code=end

