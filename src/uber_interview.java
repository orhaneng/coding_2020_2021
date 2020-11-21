import java.util.*;

public class uber_interview {

    public static void main(String[] args) {
        List<String[]> list = new LinkedList<>();

        list.add(new String[]{"RestaurantA", "apple"});
        list.add(new String[]{"RestaurantA", "banana"});
        list.add(new String[]{"RestaurantA", "apple"});
        list.add(new String[]{"RestaurantB", "coke"});
        list.add(new String[]{"RestaurantB", "coffee"});
        list.add(new String[]{"RestaurantB", "coffee"});
        list.add(new String[]{"RestaurantA", "banana"});
        list.add(new String[]{"RestaurantA", "orange"});
        list.add(new String[]{"RestaurantA", "apple"});
        bestKSellingFood(list, 2);




        PriorityQueue<Food> queue = new PriorityQueue<>(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o2.freq-o2.freq;
            }
        });
    }
    public static void bestKSellingFood(List<String[]> menu, int k){

        Map<String, Map<String, Integer>> map = new HashMap<>();

        for(String[] m : menu){
            if(!map.containsKey(m[0])){
                Map<String,Integer> internalMap = new HashMap<>();

                internalMap.put(m[1], 1);
                map.put(m[0], internalMap);
            }else {
                Map<String, Integer> internalMap = map.get(m[0]);
                if(!internalMap.containsKey(m[1])){
                    internalMap.put(m[1], 1);
                }else {
                    internalMap.put(m[1], internalMap.get(m[1]) + 1);
                }
                map.put(m[0], internalMap);
            }
        }

        for(Map.Entry<String, Map<String, Integer>> entry : map.entrySet()){
            Map<String, Integer> internalMap = entry.getValue();

            PriorityQueue<Food> pq = new PriorityQueue<>(new Comparator<Food>() {
                public int compare(Food food1, Food food2) {
                    return food2.freq - food1.freq;
                }
            });

            for(Map.Entry<String, Integer> internalEntry : internalMap.entrySet()){
                pq.add(new Food(internalEntry.getKey(), internalEntry.getValue()));
            }

            System.out.print(entry.getKey() + ": ");
            int bestK = k;
            while(!pq.isEmpty() && bestK > 0){
                Food f = pq.poll();
                System.out.print(f.foodName + "->" + f.freq + "  ");
                bestK--;
            }
            System.out.println();
        }
    }
    public  static class Food{
        public String foodName;
        public Integer freq;
        public Food(String foodName, Integer freq){
            this.foodName = foodName;
            this.freq = freq;
        }
    }

}

