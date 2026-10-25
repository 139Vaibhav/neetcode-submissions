
class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) return "";

        int[] mpT = new int[52];
        int[] mpS = new int[52];

        for (char c : t.toCharArray()) {
            mpT[idx(c)]++;
        }

        int i = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int j = 0; j < s.length(); j++) {
            mpS[idx(s.charAt(j))]++;

            boolean pos = true;
            for (int k = 0; k < 52; k++) {
                if (mpS[k] < mpT[k]) {
                    pos = false;
                    break;
                }
            }

            while (pos) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }

                mpS[idx(s.charAt(i))]--;
                i++;

                pos = true;
                for (int k = 0; k < 52; k++) {
                    if (mpS[k] < mpT[k]) {
                        pos = false;
                        break;
                    }
                }
            }
        }

        return minLen == Integer.MAX_VALUE
            ? ""
            : s.substring(start, start + minLen);
    }

    private int idx(char c) {
        if (c >= 'A' && c <= 'Z') return c - 'A';
        return c - 'a' + 26;
    }
}
