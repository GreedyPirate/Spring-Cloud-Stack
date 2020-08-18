package com.ttyc.redisson.delay.consistentHash;

public class VirtualNode implements Node{

    private HostNode actualNode;

    private int replicaIndex;

    public VirtualNode(HostNode actualNode, int replicaIndex) {
        this.actualNode = actualNode;
        this.replicaIndex = replicaIndex;
    }

    @Override
    public String getKey() {
        return actualNode.getKey() + "-" + replicaIndex;
    }

    public HostNode getActualNode() {
        return actualNode;
    }
}
