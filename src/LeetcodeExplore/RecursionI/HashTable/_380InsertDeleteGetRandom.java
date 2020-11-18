package LeetcodeExplore.RecursionI.HashTable;
//https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class _380InsertDeleteGetRandom {

    public static void main(String[] args) {
        _380InsertDeleteGetRandom insertDeleteGetRandom = new _380InsertDeleteGetRandom();
        insertDeleteGetRandom.insert(2);
        insertDeleteGetRandom.insert(3);
        insertDeleteGetRandom.insert(1);
        insertDeleteGetRandom.remove(4);
        insertDeleteGetRandom.remove(2);
    }
    List<Integer> list;
    Map<Integer,Integer> map;
    static java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public _380InsertDeleteGetRandom() {
        list =new ArrayList<>();
        map = new HashMap();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        if(index<list.size()-1){
            int lastone = map.get(list.get(list.size()-1));
            map.put(index, lastone);
            list.set(index,lastone);
        }
        map.remove(list.size()-1);
        list.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get( rand.nextInt(list.size()) );
    }
}
