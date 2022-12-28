class Solution {
    private HashMap<String,PriorityQueue<String>> map=new HashMap<>();
    private LinkedList<String> res=new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
     for(List<String> ticket:tickets)
     {
         String u=ticket.get(0);
         String v=ticket.get(1);
         PriorityQueue<String> temp=map.getOrDefault(u,new PriorityQueue<>());
         temp.offer(v);
         map.put(u,temp);
     }
     dfs("JFK");
     return res;
    }
    private void dfs(String src)
    {
        PriorityQueue<String> pq=map.get(src);
        while(pq!=null && pq.size()>0){
            String temp=pq.poll();
            dfs(temp);
        }
        res.addFirst(src);
        return;
    }
}

    
}
