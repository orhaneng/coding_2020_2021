package LeetcodeExplore.HashTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class _705DesignHashSet {

    public static void main(String[] args) {
        _705DesignHashSet myHashSet = new _705DesignHashSet();
        myHashSet.add(12);
        myHashSet.add(233);


    }

    int maxValue = 1000000;
    int ARRAY_SIZE = 100;
    List<List<Integer>> parent;
    /** Initialize your data structure here. */
    public _705DesignHashSet() {
        parent = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            parent.add(null);
        }
    }

    public void add(int key) {
        int index = key%ARRAY_SIZE;
        List<Integer> childList = parent.get(index);
        if(childList== null){
            List<Integer> list = new LinkedList();
            list.add(key);
            parent.set(index, list);
        }else{
            if(!childList.contains(index)){
                childList.add(key);
            }
        }
    }

    public void remove(int key) {
        int index = key%ARRAY_SIZE;
        List<Integer> childList = parent.get(index);
        if (childList != null) {
            childList.remove(Integer.valueOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key%ARRAY_SIZE;
        List<Integer> childList = parent.get(index);
        return childList!= null && childList.contains(key);
    }
}
