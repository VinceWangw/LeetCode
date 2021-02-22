package leetCodeEveryDay.统计同构子字符串的数目;

class Solution {
    public int countHomogenous(String s) {
        long res = 0;
        int cnt = 1;
        char pre = '0';
        for (char c : s.toCharArray()) {
            if (c != pre) {
                cnt = 1;
                pre = c;
                res++;
            } else {
                res += ++cnt;
            }
        }
        return (int) (res % (int) (1e9 + 7));
    }
}