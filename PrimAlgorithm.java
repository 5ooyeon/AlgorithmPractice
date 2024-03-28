import java.util.*;

public class PrimAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    // 그래프의 인접 행렬을 생성합니다.
    private int[][] createGraph(int[][] graph) {
        int[][] adjMatrix = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 0) {
                    adjMatrix[i][j] = INF; // 연결되지 않은 경우 무한대로 설정
                } else {
                    adjMatrix[i][j] = graph[i][j];
                }
            }
        }
        return adjMatrix;
    }

    // Prim 알고리즘을 사용하여 최소 신장 트리를 찾습니다.
    public void primMST(int[][] graph) {
        int numVertices = graph.length;

        // 최소 신장 트리에 속한 정점을 저장하는 배열
        int[] parent = new int[numVertices];

        // 해당 정점이 이미 포함되었는지 여부를 저장하는 배열
        boolean[] visited = new boolean[numVertices];

        // 각 정점까지의 최소 가중치를 저장하는 배열
        int[] key = new int[numVertices];

        // key 배열을 무한대로 초기화하고, 모든 정점을 아직 방문하지 않은 것으로 표시합니다.
        for (int i = 0; i < numVertices; i++) {
            key[i] = INF;
            visited[i] = false;
        }

        // 시작점을 선택하고 가중치를 0으로 설정합니다.
        key[0] = 0;
        parent[0] = -1;

        // 모든 정점을 방문할 때까지 반복합니다.
        for (int count = 0; count < numVertices - 1; count++) {
            // 방문하지 않은 정점 중에서 최소 가중치를 가진 정점을 찾습니다.
            int u = minKey(key, visited);

            // 해당 정점을 방문한 것으로 표시합니다.
            visited[u] = true;

            // 선택한 정점의 이웃 정점에 대한 가중치를 업데이트합니다.
            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] != INF && !visited[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // 최소 신장 트리를 출력합니다.
        printMST(parent, graph);
    }

    // key 배열에서 최소 값을 가진 정점의 인덱스를 찾습니다.
    private int minKey(int[] key, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < key.length; v++) {
            if (!visited[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // 최소 신장 트리를 출력합니다.
    private void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        PrimAlgorithm prim = new PrimAlgorithm();
        prim.primMST(graph);
    }
}
