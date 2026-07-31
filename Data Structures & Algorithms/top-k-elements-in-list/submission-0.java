class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create a hashmap to store freq
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // create a minHeap where min freq is top
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for (int key: map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
