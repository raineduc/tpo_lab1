package alg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    private int nodeCount;
    private ArrayList<ArrayList<Integer>> adjacentNodes;

    public Graph(int nodeCount) {
        this.nodeCount = nodeCount;
        this.adjacentNodes = new ArrayList<>(nodeCount);

        for (int i = 0; i < nodeCount; i++) {
            this.adjacentNodes.add(new ArrayList<>());
        }
    }

    public void addBidirectionalEdge(int node1, int node2) throws Exception {
        if (node1 >= nodeCount || node2 >= nodeCount) throw new Exception("some of the nodes is not in the graph");

        if (!adjacentNodes.get(node1).contains(node2)) {
            adjacentNodes.get(node1).add(node2);
        }
        if (!adjacentNodes.get(node2).contains(node1)) {
            adjacentNodes.get(node2).add(node1);
        }
    }

    public void addEdge(int from, int to) throws Exception {
        if (from >= nodeCount || to >= nodeCount) throw new Exception("some of the nodes is not in the graph");

        if (!adjacentNodes.get(from).contains(to)) {
            adjacentNodes.get(from).add(to);
        }
    }

    public List<Integer> doBFS(int startNode) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(startNode);
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visitedNodes = new boolean[nodeCount];
        Arrays.fill(visitedNodes, false);
        visitedNodes[startNode] = true;

        while (!deque.isEmpty()) {
            int currentNode = deque.poll();
            result.add(currentNode);

            for (int node: adjacentNodes.get(currentNode)) {
                if (!visitedNodes[node]) {
                    deque.add(node);
                    visitedNodes[node] = true;
                }
            }
        }

        return result;
    }
}
