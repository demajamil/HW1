public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int n = m.length;
        int[] distance = new int[n];
        for (int vertex = 0; vertex < n; vertex++) {
            distance[vertex] = -1;
        }
        int[] queue = new int[n];
        int head = 0;
        int tail = 1;
        queue[0] = i;
        distance[i] = 0;
        while (head < tail) {
            int current = queue[head];
            head++;
            if (current == j) {
                return distance[current];
            }
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (m[current][neighbor] == 1 && distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue[tail] = neighbor;
                    tail++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}