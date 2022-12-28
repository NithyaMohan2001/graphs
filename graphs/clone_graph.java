pubclass Solution {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        Queue<Node> q=new LinkedList<>();
        Map<Node,Node> map=new HashMap<>();
        q.add(node);
        map.put(node,new Node(node.val));
        while(q.size()>0){
            Node temp=q.poll();
            for(Node neighbour:temp.neighbors){
                if(!map.containsKey(neighbour)){
                    map.put(neighbour,new Node(neighbour.val));
                    q.add(neighbour);
                }
                map.get(temp).neighbors.add(map.get(neighbour));

            }
        }
        return map.get(node);
    }
}

   lic class clone_graph {
    
}
