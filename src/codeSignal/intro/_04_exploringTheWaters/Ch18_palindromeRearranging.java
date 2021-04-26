package codeSignal.intro._04_exploringTheWaters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ch18_palindromeRearranging {

/*
Given a string, find out if its characters can be rearranged to form a palindrome.
Example
For inputString = "aabb", the output should be
palindromeRearranging(inputString) = true.

We can rearrange "aabb" to make "abba", which is a palindrome.
 */

//    A lo sumo de un tipo de caracter puede haber una cantidad impar
    boolean palindromeRearranging(String inputString) {
        Map<Character, Integer> m = new HashMap<>();
        for(Character c : inputString.toCharArray()){
            if(!m.containsKey(c))
                m.put(c,1);
            else
                m.put(c, m.get(c)+1);
        }
        int odds=0;
        for(Character c : m.keySet()){
            if(m.get(c)%2 != 0) odds++;
            if(odds >= 2) return false;
        }
        return true;
    }

// ====================  TOP ======================
boolean palindromeRearranging2(String inputString) {
    Set<Character> chars = new HashSet<>();

    for (int i = 0; i < inputString.length();  ++i) {
        char c = inputString.charAt(i);
        if (chars.contains(c)) {
            chars.remove(c);
        }
        else {
            chars.add(c);
        }
    }
    return chars.size() <= 1;
}

}
