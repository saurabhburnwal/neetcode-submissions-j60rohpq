class Solution {
    public int climbStairs(int n) {
        if (n < 3)  return n;
        int res[] = new int[n + 1];
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2];

        return res[n];
    }
}

// arr[1] = 1
// arr[2] = 2
// arr[3] = 3
// arr[4] = 5

// arr[n] = arr[n - 1] + arr[n - 2]
