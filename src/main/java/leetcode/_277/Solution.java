package leetcode._277;



public class Solution {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if(candidate != i && knows(candidate, i)) {
                candidate = i;
            }
        }
        for(int i = 0; i < n; i++) {
            if(candidate != i && (!knows(i, candidate) || knows(candidate, i))) {
                return -1;
            }
        }
        return candidate;
    }

    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
    private boolean knows(int i, int candidate) {
        return false;
    }
}