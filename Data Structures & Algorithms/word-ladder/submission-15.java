class Solution {
    int res = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        
        int n = wordList.size();

        List<Integer>[] adj = new ArrayList[n + 1];
        Arrays.setAll(adj, i -> new ArrayList<>());

        wordList.add(beginWord);
        int end = n;
        for (int i = 0; i < n; i++) {
            if (wordList.get(i).equals(endWord))    end = i;
            for (int j = i + 1; j < n + 1; j++) {
                int count = 0;
                for (int k = 0; k < wordList.get(0).length(); k++) {
                    if (wordList.get(i).charAt(k) == wordList.get(j).charAt(k))
                        continue;
                    count++;
                }
                if (count == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        boolean[] vis = new boolean[n + 1];
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{n, -1, 0});
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int node = pair[0];
            int pNode = pair[1];
            int step = pair[2];
            vis[node] = true;

            if (node == end) {
                res = step + 1;
                break;
            }
            for (int i : adj[node]) {
                if (pNode != i && !vis[i]) {
                    q.offer(new int[]{i, node, step + 1});
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
