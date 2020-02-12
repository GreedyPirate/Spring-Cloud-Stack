package com.ttyc.jdk;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class WeightRandom<K,V extends Number> {
    private TreeMap<Double, K> weightMap = new TreeMap<Double, K>();

    public WeightRandom(List<Pair<K, V>> list) {
        Preconditions.checkNotNull(list, "list can NOT be null!");
        for (Pair<K, V> pair : list) {
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey().doubleValue();//统一转为double
            this.weightMap.put(pair.getValue().doubleValue() + lastWeight, pair.getKey());//权重累加
        }
    }



    public K random() {
        double randomWeight = this.weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }

    public static void main(String[] args) {
        List<Pair<String, Integer>> pairs = Arrays.asList(Pair.of("A", 1), Pair.of("B", 2), Pair.of("C", 3), Pair.of("D", 4));
        WeightRandom<String, Integer> random = new WeightRandom<>(pairs);

        Map<String, Long> counter = Maps.newHashMap();

        for (int i = 0; i < 1000000; i++) {
            String ret = random.random();
            Long count = counter.get(ret);
            if(count != null) {
                counter.put(ret, ++count);
            }else {
                counter.put(ret, 1L);
            }
        }

        counter.entrySet().forEach(t -> {
            System.out.println("key = " + t.getKey() + ", count = " + t.getValue());
        });
    }
 
}