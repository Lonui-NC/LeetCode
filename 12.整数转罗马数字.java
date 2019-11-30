/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    // v1 版 - 后期分析其实可以用递归或函数来调用重复的逻辑
    public String intToRoman(int num) {
        // 类似是一个依次取余的设置
        // 虽然是5进制，但考虑用10进制来进行parse
        int MNum = 0;
        StringBuilder roman = new StringBuilder();
        MNum = num / 1000;
        num = num - MNum * 1000;
        while (MNum > 0) {
            roman.append("M");
            MNum--;
        }

        int CDNum = 0; 
        CDNum = num / 100;
        num = num - 100 * CDNum;
        if (CDNum == 9) {
            roman.append("CM");
        } else if (CDNum == 4) {
            roman.append("CD");
        } else {
            if (CDNum >= 5) {
                roman.append("D");
                CDNum -= 5;
            }
            while (CDNum > 0) {
                roman.append("C");
                CDNum--;
            }
        }

        int XLNum = 0; 
        XLNum = num / 10;
        num = num - 10 * XLNum;
        if (XLNum == 9) {
            roman.append("XC");
        } else if (XLNum == 4) {
            roman.append("XL");
        } else {
            if (XLNum >= 5) {
                roman.append("L");
                XLNum -= 5;
            }
            while (XLNum > 0) {
                roman.append("X");
                XLNum--;
            }
        }
        
        int IVNum = 0; 
        IVNum = num;
        if (IVNum == 9) {
            roman.append("IX");
        } else if (IVNum == 4) {
            roman.append("IV");
        } else {
            if (IVNum >= 5) {
                roman.append("V");
                IVNum -= 5;
            }
            while (IVNum > 0) {
                roman.append("I");
                IVNum--;
            }
        }

        return roman.toString();
    }

    // 改进版 - 增加函数和判断处理逻辑 
    public String intToRomanV2(int num) {
        StringBuilder roman = new StringBuilder();

        if (num >= 1000) {
            int MNum = 0;
            MNum = num / 1000;
            num = num - MNum * 1000;
            while (MNum > 0) {
                roman.append("M");
                MNum--;
            }
        }
        
        if (num >= 100) {
            roman.append(processSubRoman(num, 100, "C", "D", "M"));
            num = num % 100; 
        }

        if (num >= 10) {
            roman.append(processSubRoman(num, 10, "X", "L", "C"));
            num = num % 10; 
        }

        if (num >= 1) {
            roman.append(processSubRoman(num, 1, "I", "V", "X"));
        }

        return roman.toString();
    }

    public String processSubRoman(int num, int base, String first, String fifth, String tenth) {
        int subNum = 0;
        StringBuilder subRoman = new StringBuilder();
        subNum = num / base; 
        if (subNum == 9) {
            subRoman.append(first);
            subRoman.append(tenth);
        } else if (subNum == 4) {
            subRoman.append(first);
            subRoman.append(fifth);
        } else {
            if (subNum >= 5) {
                subRoman.append(fifth);
                subNum -= 5;
            }
            while (subNum > 0) {
                subRoman.append(first);
                subNum--;
            }
        }
        return subRoman.toString();
    }

    // 贪心算法 - 不停用数字去拼凑
    public String intToRomanV3(int num) {
        StringBuilder ans = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  // 罗马数字
        int[] arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  // 阿拉伯数字
        int index = 0;
        while (num > 0) {
            int count = num / arab[index];
            while (count-- > 0) {
                ans.append(roman[index]);
            }
            num %= arab[index];
            index++;
        }
        return ans.toString();
    }

}
// @lc code=end

