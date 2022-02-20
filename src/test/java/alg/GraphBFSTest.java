package alg;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class GraphBFSTest {

    @ParameterizedTest
    @MethodSource("graphSource")
    void isolatedNode(Graph graph) {
        assertEquals(List.of(2), graph.doBFS(2));
    }

    @ParameterizedTest
    @MethodSource("graphSource")
    void otherNodes(Graph graph) {
        assertEquals(List.of(1, 0, 6, 7), graph.doBFS(1));
        assertEquals(List.of(4, 6, 7), graph.doBFS(4));
        assertEquals(List.of(6, 7), graph.doBFS(6));
        assertEquals(List.of(7, 6), graph.doBFS(7));
        assertEquals(List.of(3, 1, 5, 0, 6, 7), graph.doBFS(3));
        assertEquals(List.of(5, 1, 3, 0, 6, 7), graph.doBFS(5));
    }

    @ParameterizedTest
    @MethodSource("graphSource")
    void nonExistentNodes(Graph graph) {
        assertThrows(Exception.class, () -> graph.addEdge(4, 8));
        assertThrows(Exception.class, () -> graph.addEdge(10, 1));
        assertThrows(Exception.class, () -> graph.addEdge(15, 16));
    }

    /*
                       +----+
                       | 0  |
              +------->|    |
              |        +----+
              |
              |
              |
              |
           +--+-+                +----+
           | 1  |                | 2  |
  +------> |    | --------->+    |    |
  |        +----+           |    +----+
  |            ^            |
  |            |            |
  |            |            |              +----+
+-+--+         |            |              | 4  |
| 3  |         |            |      +-------+    |
|    |         |            |      |       +----+
++---+         |            |      |
 |  ^          |            |      v
 |  |       +--+-+          |   +----+
 |  +-------+ 5  |          +-->| 6  |
 |          |    |              |    |
 +--------->+----+          +-->+---++
                            |       |
                          +-+--+    |
                          | 7  |    |
                          |    |<---+
                          +----+
    */
    static Stream<Graph> graphSource() throws Exception {
        Graph graph = new Graph(8);
        graph.addEdge(1, 0);
        graph.addEdge(1, 6);
        graph.addEdge(3, 1);
        graph.addEdge(5, 1);
        graph.addBidirectionalEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addBidirectionalEdge(6, 7);
        return Stream.of(graph);
    }
}
