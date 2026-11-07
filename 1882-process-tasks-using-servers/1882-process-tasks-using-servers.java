
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        int n = servers.length;
        int m = tasks.length;

        // Available servers: {weight, index}
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        );

        // Busy servers: {freeTime, weight, index}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return Long.compare(a[0], b[0]);
                if (a[1] != b[1]) return a[1] - b[1];
                return a[2] - b[2];
            }
        );

        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[m];
        long time = 0;

        for (int i = 0; i < m; i++) {

            time = Math.max(time, i);

            // Move all free servers into available heap
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] s = busy.poll();
                available.offer(new int[]{s[1], s[2]});
            }

            // If no server is available, jump to earliest free time
            if (available.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    int[] s = busy.poll();
                    available.offer(new int[]{s[1], s[2]});
                }
            }

            int[] server = available.poll();

            int weight = server[0];
            int index = server[1];

            ans[i] = index;

            busy.offer(new int[]{
                (int)(time + tasks[i]), weight, index
            });
        }

        return ans;
    }
}
