class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a ,b) -> a[0]- b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int today = 0, totalEvent = events.length, count = 0, event = 0;

        while (!pq.isEmpty() || event < totalEvent){
        	if (pq.isEmpty()) {
        		pq.add(events[event][1]);
        		today = events[event][0];
        		event++;
        	}

        	while (event < totalEvent && events[event][0] == today) {
        		pq.add(events[event][1]);
        		event++;
        	}

        	pq.poll();
        	today++;
        	count++;

        	while (!pq.isEmpty() && pq.peek() < today) {
        		pq.poll();
        	}
        }
        return count;
    }
}