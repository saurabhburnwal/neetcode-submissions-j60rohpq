class Solution {
    public List<List<Integer>> combinationSum2(
        int[] candidates,
        int target
    ) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        search(
            candidates,
            target,
            0,
            new ArrayList<>(),
            result
        );

        return result;
    }

    private void search(
        int[] candidates,
        int remaining,
        int start,
        List<Integer> current,
        List<List<Integer>> result
    ) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (
                i > start
                && candidates[i] == candidates[i - 1]
            ) {
                continue;
            }

            int candidate = candidates[i];

            if (candidate > remaining) {
                break;
            }

            current.add(candidate);

            search(
                candidates,
                remaining - candidate,
                i + 1,
                current,
                result
            );

            current.remove(current.size() - 1);
        }
    }
}