package lintcode._1527;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param cards: A list of cards.
     * @return: A list of feasible solution. we will sort your return value in output
     */
    public List<Integer> getTheNumber(int[] cards) {
        List<Integer> result = new ArrayList();
        int[] digits = new int[10];
        for (int c : cards) {
            digits[c]++;
        }
        for (int i = 1; i <= 9; i++) {
            if (digits[i] == 4) {
                continue;
            }
            digits[i]++;
            if (isValid(digits, 0, false)) {
                result.add(i);
            }
            digits[i]--;
        }
        return result.isEmpty() ? new ArrayList(List.of(0)) : result;
    }

    boolean isValid(int[] digits, int i, boolean pair) {
        if (i >= digits.length) {
            return true;
        }
        if (digits[i] < 0) {
            return false;
        }

        if (pair) {
            if (digits[i] == 0) {
                return isValid(digits, i + 1, true);
            }

            if (digits[i] >= 3) {
                digits[i] -= 3;
                try {
                    if (isValid(digits, i, true)) {
                        return true;
                    }
                } finally {
                    digits[i] += 3;
                }
            }

            if (i + 2 >= digits.length) {
                return false;
            }

            try {
                digits[i]--;
                digits[i + 1]--;
                digits[i + 2]--;
                if (isValid(digits, i, true)) {
                    return true;
                }
            } finally {
                digits[i]++;
                digits[i + 1]++;
                digits[i + 2]++;
            }

            return false;
        }

        for (int j = i; j < digits.length; j++) {
            if (digits[j] >= 2) {
                try {
                    digits[j] -= 2;
                    if (isValid(digits, 0, true)) {
                        return true;
                    }
                } finally {
                    digits[j] += 2;
                }
            }
        }
        return false;
    }
}
