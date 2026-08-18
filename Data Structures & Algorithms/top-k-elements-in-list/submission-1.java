class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for (int key: map.keySet()) {
            minHeap.add(key);

            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }

        int[] top = new int[k];
        for (int i = k-1; i >= 0; i--) {
            top[i] = minHeap.poll();
        }

        return top;
    }
}
