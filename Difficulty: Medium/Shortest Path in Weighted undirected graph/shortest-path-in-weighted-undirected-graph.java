class Solution {
    class Pair {
        int node, wt;
        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        // Step 2: Distance and Parent array
        int dist[] = new int[n + 1];
        int parent[] = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        for (int i = 1; i <= n; i++) parent[i] = i;

        dist[1] = 0;

        // Step 3: Min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(1, 0));

        // Step 4: Dijkstra with parent tracking
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int d = p.wt;

            if (d > dist[node]) continue;

            for (Pair neigh : adj.get(node)) {
                int next = neigh.node;
                int wt = neigh.wt;
                if (d + wt < dist[next]) {
                    dist[next] = d + wt;
                    parent[next] = node; // store path
                    pq.add(new Pair(next, dist[next]));
                }
            }
        }

        // Step 5: If no path to n
        if (dist[n] == (int) 1e9) {
            return Arrays.asList(-1);
        }

        // Step 6: Reconstruct path from n to 1
        List<Integer> path = new ArrayList<>();
        int curr = n;
        while (parent[curr] != curr) {
            path.add(curr);
            curr = parent[curr];
        }
        path.add(1);
        Collections.reverse(path);

        // Step 7: Add weight at beginning
        List<Integer> result = new ArrayList<>();
        result.add(dist[n]);
        result.addAll(path);

        return result;
    }
}
