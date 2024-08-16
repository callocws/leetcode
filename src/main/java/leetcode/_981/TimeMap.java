package leetcode._981;

import java.util.ArrayList;
import java.util.HashMap;

class TimeMap {
    
    HashMap<String, ArrayList<Data>> map = new HashMap();

    class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        ArrayList<Data> l = map.get(key);
        if(l == null) {
            l = new ArrayList();
        }
        l.add(new Data(value, timestamp));
        map.put(key, l);
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Data> l = map.get(key);
        if(l == null) {
            return "";
        }
        int i = 0, j = l.size() - 1;
        for(; i <= j;) {
            int m = (i + j) / 2;
            Data d = l.get(m);
            if(d.timestamp == timestamp) {
                j = m;
                break;
            } else if(d.timestamp > timestamp){
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return j < 0 ? "" : l.get(j).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */


class TimeMap1 {

    HashMap<String, ArrayList<Data>> map = new HashMap();

    class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public void set(String key, String value, int timestamp) {
        ArrayList<Data> l = map.get(key);
        if(l == null) {
            l = new ArrayList();
        }
        l.add(new Data(value, timestamp));
        map.put(key, l);
    }

    public String get(String key, int timestamp) {
        ArrayList<Data> l = map.get(key);
        if(l == null) {
            return "";
        }
        int i = 0, j = l.size();
        for(; i < j;) {
            int m = (i + j) / 2;
            Data d = l.get(m);
            if(d.timestamp == timestamp) {
                i = m + 1;
                break;
            } else if(d.timestamp > timestamp){
                j = m;
            } else {
                i = m + 1;
            }
        }
        return --i < 0 ? "" : l.get(i).value;
    }
}