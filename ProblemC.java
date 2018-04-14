/*
   This program is to apply Dijsktra to sovle GPS poroblenm
 */
import java.util.*;
public class ProblemC {
    private static class Edge  {
        int to;
        double cost;

        public Edge(int to, double cost)
        {
            this.to = to;
            this.cost = cost;
        }
    }

    public static class State implements Comparable<State> {
        int node;
        double distance;

        public State(int node, double distance)
        {
            this.node = node;
            this.distance = distance;
        }

        public int compareTo(State o)
        {
            return Double.compare(distance, o.distance);

        }
    }

    static Map<String, Integer> getIndex;
    static Map<Integer, String> getName;

    static int n, m, q;
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        getIndex = new HashMap<String, Integer>();
        getName = new HashMap<Integer, String>();

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++)
        {
            String name = sc.next();
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            getIndex.put(name, i);
            getName.put(i, name);
        }

        List<Edge>[] adj = new List[n];
        for(int i = 0; i < n; i++)
        {
            adj[i] = new ArrayList<Edge>();
        }

        for(int i = 0; i < m; i++) {
            int u = getIndex.get(sc.next());
            int v = getIndex.get(sc.next());
            double cost = sc.nextDouble();
            Edge uToV = new Edge(v, cost);
            adj[u].add(uToV);
            Edge vToU = new Edge(u, cost);
            adj[v].add(vToU);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            int src = getIndex.get(sc.next());
            int tar = getIndex.get(sc.next());
            sb.append(dijkstra(adj,src, tar ));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static String dijkstra(List<Edge>[] adj, int start, int end)
    {
        StringBuilder sb2 = new StringBuilder();
        int numNodes = adj.length;
        double[] dists = new double[numNodes];
        Arrays.fill(dists,Long.MAX_VALUE);

        int[] pre = new int[numNodes];

        dists[start] = 0;
        PriorityQueue<State>  pq = new PriorityQueue<>();
        pq.offer(new State(start, 0));

        while(!pq.isEmpty())
        {
            State cur = pq.poll();
            int u = cur.node;
            double distance = cur.distance;

            //
            if(dists[u] < cur.distance)
                continue;

            if(u == end)
                break;

            for(Edge e: adj[u])
            {
                int v = e.to;
                double distToV = dists[u] + e.cost;
                if(distToV < dists[v])
                {
                    dists[v] = distToV;
                    pre[v] = u;
                    pq.offer(new State(v, dists[v]));
                }
            }
        }

        if(dists[end] < Long.MAX_VALUE) {
            List<String> path = new ArrayList<>();
            int cur = end;
            path.add(getName.get(cur));
            while (cur != start) {
                cur = pre[cur];
                path.add(getName.get(cur));
            }
            Collections.reverse(path);
            sb2.append(dists[end]);
            sb2.append(" ");
            for(int idx = 0; idx < path.size(); idx++) {
                sb2.append(path.get(idx));
                sb2.append(" ");
            }
        }
        return sb2.toString();
    }
}
