
class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] freq = new int[26];

        for(char c : tasks){
            freq[c - 'A']++;
        }

        // Max Heap: highest frequency first
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> b - a);

        for(int f : freq){
            if(f > 0){
                pq.offer(f);
            }
        }

        // Queue stores: [remaining frequency, available time]
        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while(!pq.isEmpty() || !cooldown.isEmpty()){

            time++;

            // Execute the task with highest frequency
            if(!pq.isEmpty()){
                int remaining = pq.poll() - 1;

                if(remaining > 0){
                    cooldown.offer(new int[]{
                        remaining,
                        time + n
                    });
                }
            }

            // Add tasks whose cooldown has finished
            if(!cooldown.isEmpty() &&
               cooldown.peek()[1] == time){

                pq.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}
