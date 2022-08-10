package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;

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
        return null;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        return null;
    }


}
