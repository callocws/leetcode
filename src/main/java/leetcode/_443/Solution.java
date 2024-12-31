package leetcode._443;

class Solution {
    int times = 1, index = 1;

    public int compress(char[] chars) {
        char c = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                times++;
            } else {
                append(chars);
                times = 1;
                chars[index++] = c = chars[i];
            }
        }
        append(chars);
        return index;
    }

    void append(char[] chars) {
        char[] timeChars = ("" + times).toCharArray();
        if (times == 1) {
            return;
        }
        for (char tc : timeChars) {
            chars[index++] = tc;
        }
    }
}

class Solution1 {
    public int compress(char[] chars) {
        int index = 0;
        for (int i = 0; i < chars.length; ) {
            char c = chars[i];
            int times = 0;
            for (; i < chars.length && chars[i] == c; i++) {
                times++;
            }
            chars[index++] = c;
            if (times > 1) {
                for (char tc : ("" + times).toCharArray()) {
                    chars[index++] = tc;
                }
            }
        }
        return index;
    }
}

class Solution2 {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        for (; j < chars.length; ) {
            int start = j;
            for (; j < chars.length && chars[j] == chars[start]; j++) {}
            int times = j - start;
            chars[i++] = chars[start];
            if (times > 1) {
                for (char tc : ("" + times).toCharArray()) {
                    chars[i++] = tc;
                }
            }
        }
        return i;
    }
}
