class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> tmps = new Stack<>();
        tmps.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            while (!tmps.isEmpty() && temperatures[tmps.peek()] < temperatures[i]) {
                result[tmps.peek()] = i - tmps.peek();
                tmps.pop();
            }
            tmps.push(i);
        }

        return result;
    }
}
