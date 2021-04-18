package CodeSignal.SmoothSailing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllLongestStrings {

/*
Given an array of strings, return another array containing all of its longest strings.

Example

For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
 */

    //    my solution,  using a map to store all the string according to its size in every key position
    String[] allLongestStrings(String[] inputArray) {
        int longest = 0;
        Map<Integer, ArrayList<String>> m = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            int currSize = inputArray[i].length();
            if (currSize > longest) longest = currSize;
            if (!m.containsKey(currSize)) m.put(currSize, new ArrayList());
            m.get(currSize).add(inputArray[i]);
        }
        return m.get(longest).toArray(new String[m.get(longest).size()]);
    }


    //top solutions
//     creative way of string manipulation
    String[] allLongestStrings2(String[] inputArray) {
        String l = ""; //full string with "-" separator
        for (String s : inputArray) {
            //length is first index of substring
            //if list has same size strings, add this one
            if (l.indexOf("-") == s.length()) l += s + "-";
                //reset if list has smaller strings
            else if (l.indexOf("-") < s.length()) l = s + "-";
        }
        return l.split("-");
    }

// kotlin
//    fun allLongestStrings(inputArray: MutableList<String>): List<String> {
//        return inputArray.filter { it.length == inputArray.maxBy { it.length }?.length }
//    }




}