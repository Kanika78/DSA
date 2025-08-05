class Solution {
    class Pair {
        int node, cost, stops;
        Pair(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    class Edge {
        int v, w;
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int CheapestFLight(int n, int flights[][], int src, int dst, int K) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] f : flights) {
            adj.get(f[0]).add(new Edge(f[1], f[2]));
        }

        int[][] dist = new int[n][K + 2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], (int)1e9);
        dist[src][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(src, 0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node, cost = cur.cost, stops = cur.stops;

            if (node == dst) return cost;
            if (stops > K) continue;

            for (Edge e : adj.get(node)) {
                int next = e.v;
                int newCost = cost + e.w;
                if (newCost < dist[next][stops + 1]) {
                    dist[next][stops + 1] = newCost;
                    pq.add(new Pair(next, newCost, stops + 1));
                }
            }
        }

        return -1;
    }
}
