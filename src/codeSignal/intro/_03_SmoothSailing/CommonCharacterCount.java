package codeSignal.intro._03_SmoothSailing;

import java.util.HashMap;
import java.util.Map;

public class CommonCharacterCount {

    /*
    Given two strings, find the number of common characters between them.

    Example
    For s1 = "aabcc" and s2 = "adcaa", the output should be
    commonCharacterCount(s1, s2) = 3.
    Strings have 3 common characters - 2 "a"s and 1 "c".
     */

    static int  commonCharacterCount(String s1, String s2) {
        Map<Character, Integer> m = new HashMap<>(); //m maps last visited index in s2 of every char
        int count= 0;

        for(char c : s1.toCharArray()){
            if( !m.containsKey(c) )  m.put(c, 0); // search starts in index -
            int lastVisitChar = s2.indexOf(c, m.get(c));
            if(lastVisitChar != -1){
                count++;
                m.put(c,lastVisitChar+1);
            }
        }
        return count;
    }


//top
//    a similar idea but using only the strings...  remember Strings are immutable
    public static int commonCharacterCount2(String s1, String s2) {
        int counter = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s2.contains(String.valueOf(s1.charAt(i)))){
                counter++;
                s2 = s2.replaceFirst(String.valueOf(s1.charAt(i)), "");
            }
        }
        return counter;
    }

//    same idea
    int commonCharacterCount3(String s1, String s2) {
        int result = 0;
        StringBuilder string2 = new StringBuilder(s2);
        for (char ch : s1.toCharArray()) {
            int pos = string2.indexOf(String.valueOf(ch));
            if (pos >= 0) {
                result++;
                string2.deleteCharAt(pos);
            }
        }
        return result;
    }

}
