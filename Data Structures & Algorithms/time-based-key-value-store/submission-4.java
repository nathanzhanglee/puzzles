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
        if (map.get(key) == null || map.get(key).floorKey(timestamp) == null) {
            return "";
        }
        return map.get(key).get(map.get(key).floorKey(timestamp));
    }
}
