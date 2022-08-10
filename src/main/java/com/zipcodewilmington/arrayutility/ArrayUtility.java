package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T> {
    private T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public T[] removeValue(T valueToRemove) {

        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != valueToRemove) {
                list.add(inputArray[i]);
            }
        }
        if(valueToRemove instanceof Integer){
            return (T[]) list.toArray(new Integer[0]);
        }
        if(valueToRemove instanceof String){
            return (T[]) list.toArray(new String[0]);
        }
        if(valueToRemove instanceof Long){
            return (T[]) list.toArray(new Long[0]);
        }
        else {
            return (T[]) list.toArray(new Object[0]);
        }
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] == valueToEvaluate){
                count++;
            }
        }

        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        Integer max = 0;
        Boolean change = true;
        T returnKey = null;
        Integer keyPlace = 1;
        Integer count = 0;
        ArrayList<T> combinedList = new ArrayList<>(inputArray.length + arrayToMerge.length);
        combinedList.addAll(Arrays.asList(inputArray));
        combinedList.addAll(Arrays.asList(arrayToMerge));
        HashMap<T, Integer> map = new HashMap<>();
        for (T t : combinedList) {
            if (!map.containsKey(t)) {
                map.put(t, 1);
            } else {
                count = map.get(t) + 1;
                map.put(t, count);
            }
        }
        while(change == true) {
            for (Map.Entry<T, Integer> entry : map.entrySet()) {
                change = false;
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    returnKey = entry.getKey();
                    change = true;
                }
            }
        }
            return returnKey;
        }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer count1 = getNumberOfOccurrences(valueToEvaluate);
        Integer count2 = 0;
        for (int i = 0; i < arrayToMerge.length; i++) {
            if(arrayToMerge[i] == valueToEvaluate){
                count2++;
            }
        }
        return count1 + count2;
    }


}
