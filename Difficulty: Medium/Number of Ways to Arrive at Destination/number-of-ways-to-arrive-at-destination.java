// User function Template for Java

class Solution {
    static class Pair {
        int v;
        long wt;
        Pair(int v , long wt){
            this.v = v;
            this.wt = wt;
        }
    }

    static int mod = 1000000007;

    static int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> list : roads) {
            int u = list.get(0);
            int v = list.get(1);
            int w = list.get(2);
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.wt, y.wt));
        pq.add(new Pair(0, 0));

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.v;
            long wt = p.wt;

            
            if (wt > dist[node]) continue;

            for (Pair neighs : adj.get(node)) {
                int neigh = neighs.v;
                long weight = neighs.wt;

                
                if (wt + weight < dist[neigh]) {
                    dist[neigh] = wt + weight;
                    pq.add(new Pair(neigh, dist[neigh]));
                    ways[neigh] = ways[node];
                } 
                
                else if (wt + weight == dist[neigh]) {
                    ways[neigh] = (ways[neigh] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
