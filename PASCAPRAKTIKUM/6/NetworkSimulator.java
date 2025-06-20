import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class NetworkSimulator {
    private static Node findNode(List<Node> nodes, String id) {
        for (Node node : nodes) {
            if (node.id.equals(id)) {
                return node;
            }
        }
        return null;
    }

    public static void validatePacket(List<Node> nodes, Map<String, Set<Integer>> transmissionLog, Packet packet) throws NetworkException {
        Node fromNode = findNode(nodes, packet.from);
        Node toNode = findNode(nodes, packet.to);

        // Validasi keberadaan node
        if (fromNode == null || toNode == null) {
            throw new NetworkException();
        }

        // Validasi loopback
        if (fromNode.id.equals(toNode.id)) {
            throw new LoopbackException("Loopback: Node " + fromNode.id + " tidak boleh mengirim ke dirinya sendiri.");
        }

        // Validasi time desync
        if (packet.timestamp <= toNode.lastReceived) {
            throw new TimeDesyncException("Time desync: Node " + toNode.id + " sudah menerima hingga waktu " + toNode.lastReceived + ", tetapi kemudian menerima dari " + fromNode.id + " dengan waktu " + packet.timestamp);
        }

        // Validasi collision
        if (transmissionLog.containsKey(toNode.id)) {
            Set<Integer> timestamps = transmissionLog.get(toNode.id);
            if (timestamps.contains(packet.timestamp)) {
                throw new CollisionException("Collision: Ada lebih dari satu paket ke node " + toNode.id + " pada waktu " + packet.timestamp);
            }
        } else {
            // Inisialisasi HashSet kosong untuk node jika belum ada
            transmissionLog.put(toNode.id, new HashSet<>());
        }

        // Semua validasi lolos, update state
        toNode.lastReceived = packet.timestamp;
        transmissionLog.get(toNode.id).add(packet.timestamp);
    }
}

// Exception class (sudah benar, tidak diubah)
class NetworkException extends Exception {
    public NetworkException() {
        super();
    }

    public NetworkException(String message) {
        super(message);
    }
}

class LoopbackException extends NetworkException {
    public LoopbackException(String message) {
        super(message);
    }
}

class TimeDesyncException extends NetworkException {
    public TimeDesyncException(String message) {
        super(message);
    }
}

class CollisionException extends NetworkException {
    public CollisionException(String message) {
        super(message);
    }
}
