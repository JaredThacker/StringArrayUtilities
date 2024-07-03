package com.zipcodewilmington;

import java.sql.Array;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {

        return Arrays.asList(array).contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

        Collections.reverse(Arrays.asList(array));
        return array;

    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

        String[] reversed = array.clone();
        Collections.reverse(Arrays.asList(array));

        return Arrays.equals(array, reversed);
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {


        String joined = String.join(" ", array);
        String joinedLower = joined.toUpperCase();

        boolean isPangram = true;
        int charCount = 0;

        for (int i = 65; i<= 90; i++){

            if (!joinedLower.contains(Character.toString((char)i))){
                isPangram = false;
                charCount++;
            } else if(charCount == 26) {
                isPangram = true;
            }

        }

        return isPangram;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {

        int occurences = 0;

        for(String s : array){
            if(s.contains(value)){
                occurences++;
            }
        }
        return occurences;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        List<String> list = new LinkedList<String>(Arrays.asList(array));
        list.remove(valueToRemove);

        String[] removedArr = (String[]) list.toArray(new String[array.length - 1]);

        return removedArr;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        ArrayList<String> removedClones = new ArrayList<>(Arrays.asList(array));
        ArrayList<Integer> duplicateIndexes = new ArrayList<>();

        for(int i = 0; i< array.length - 1; i++){
            if(array[i].equals(array[i+1])) {
                duplicateIndexes.add(i + 1);
            }
        }

        Collections.reverse(duplicateIndexes);

        for(int index: duplicateIndexes){
            removedClones.remove(index);
        }

        return removedClones.toArray(String[]::new);

    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

        ArrayList<String> consecutiveDupe = new ArrayList<>();
        String accum = "";

        for (String eachStr : array) {
            if (accum.isEmpty()) {

                accum = eachStr;
            } else {
                if (accum.charAt(0) == eachStr.charAt(0)) {

                    accum += eachStr;
                } else {

                    consecutiveDupe.add(accum);

                    accum = eachStr;
                }
            }
        }

        consecutiveDupe.add(accum);

        return consecutiveDupe.toArray(String[]::new);

    }
}
