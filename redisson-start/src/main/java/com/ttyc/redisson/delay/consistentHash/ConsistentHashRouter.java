package com.ttyc.redisson.delay.consistentHash;

import java.util.Collection;
import java.util.TreeMap;

public class ConsistentHashRouter {

    private static int DEFAULT_VIRTUAL_NODE_NUMBER = 64;

    private TreeMap<String, Node> ring = new TreeMap<>();

    private HashFunction hashFunction;

    public ConsistentHashRouter(Collection<HostNode> nodes, HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        if(!nodes.isEmpty()) {
            init(nodes);
        }
    }

    private void init(Collection<HostNode> nodes) {
        nodes.forEach(t -> {
            addNode(t, DEFAULT_VIRTUAL_NODE_NUMBER);
        });
    }

    private void addNode(HostNode node, int virtualNodeNumber) {
        ring.put(node.getKey(), node);

        for (int i = 0; i < virtualNodeNumber; i++) {
            VirtualNode virtualNode = new VirtualNode(node, virtualNodeNumber);
            ring.put(virtualNode.getKey(), virtualNode);
        }
    }

    public HostNode router(String key) {
        int hash = hashFunction.hash(key);
        String nodeKey = ring.tailMap(key).firstKey();
        Node node = ring.get(nodeKey);
        if(node instanceof VirtualNode) {
            VirtualNode virtualNode = (VirtualNode) node;
            return virtualNode.getActualNode();
        }else {
            HostNode hostNode = (HostNode) node;
            return hostNode;
        }
    }
}
