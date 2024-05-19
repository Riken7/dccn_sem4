import java.util.*;
public class Dijkstra {
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int v = sc.nextInt();
        for(int i=0 ; i<v ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0 ; i< v ; i++){
            System.out.println("Enter number of vertices adjacent to vertex " + i + ": ");
            int n = sc.nextInt();
            for(int j=0 ; j<n ; j++ ){
                System.out.println("Enter the adjacent vertex:");
                int ver = sc.nextInt();
                System.out.println("Enter the weight of edge between " + i + " and " + ver);
                int wt = sc.nextInt();
                adj.get(i).add(new ArrayList<>(List.of(ver,wt)));
            }
        }
        System.out.println("Enter the source and destination vertex: ");
        int s = sc.nextInt();
        int d = sc.nextInt();
        dijkstra(v, adj, s, d);
    }
    public static void dijkstra(int v , ArrayList<ArrayList<ArrayList<Integer>>> adj, int s, int d){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance);
        int [] distance = new int[v];
    
        for(int i=0 ; i<v ; i++){
            distance[i] = (int)(1e8);
        }
        distance[s] = 0;
        pq.add(new Pair(0,s));
    
        while(!pq.isEmpty()){
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
    
            for(ArrayList<Integer> it : adj.get(node)){
                int edW = it.get(1);
                int adjNode = it.get(0);
    
                if(edW + wt < distance[adjNode]){
                    distance[adjNode] = edW + wt;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        System.out.println("Shortest distance from source vertex: " + Arrays.toString(distance));
        System.out.println("Shortest distance from source vertex to destination vertex: " + distance[d]);
    
        ArrayList<Integer> path = new ArrayList<>();
        int temp = d;
        while(temp!=s){
            path.add(temp);
            for(ArrayList<Integer> it : adj.get(temp)){
                int edW = it.get(1);
                int adjNode = it.get(0);
    
                if(distance[temp] - edW == distance[adjNode]){
                    temp = adjNode;
                    break;
                }
        }   
    }   
            System.out.println("Path taken from " + s + " to " + d + " is: ");
            for(int i=path.size()-1 ; i>=0 ; i--){
                System.out.print(path.get(i) + " ");
            }
        }
}
class Pair{
    int distance;
    int node;
    public Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}