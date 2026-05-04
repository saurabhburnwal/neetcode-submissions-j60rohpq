class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key))  return "";
        TreeMap<Integer, String> timestamps = map.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

// ["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2],
//  "set", ["alice", "sad", 3], "get", ["alice", 3]]

// alice -> (1 -> happy) (3 -> sad)

// entry.getKey() <= timestamp
//     1               1
//     1               2
//     3               3

//     1->happy
//         3->sad
//              