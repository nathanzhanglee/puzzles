class TimeMap {
    HashMap<String, TreeMap<Integer, String>> m;
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> curr = m.getOrDefault(key, new TreeMap<>());
        curr.put(timestamp, value);
        m.put(key, curr);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> curr = m.getOrDefault(key, new TreeMap<>());
        if (curr.floorKey(timestamp) == null) {
            return "";
        } 
        return curr.get(curr.floorKey(timestamp));
    }
}
