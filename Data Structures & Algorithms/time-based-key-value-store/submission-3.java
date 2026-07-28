class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> curr = new TreeMap<>();
            curr.put(timestamp, value);
            map.put(key, curr);
        }
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> curr = map.getOrDefault(key, new TreeMap<>());
        if (curr == null || curr.floorKey(timestamp) == null) {
            return "";
        }
        return curr.get(curr.floorKey(timestamp));
    }
}
