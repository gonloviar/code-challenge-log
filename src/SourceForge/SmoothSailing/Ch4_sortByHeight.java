package SourceForge.SmoothSailing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Ch4_sortByHeight {
    /*
    Some people are standing in a row in a park. There are trees between them which cannot be moved.
    Your task is to rearrange the people by their heights in a non-descending order without moving the trees.
    People can be very tall!

    Example

    For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
    sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */

    int[] sortByHeight(int[] a) {
        Set<Integer> treesIdx = new HashSet<>();
        List<Integer> heights = new LinkedList<>();

        for(int i=0; i<a.length; i++){
            if(a[i]==-1){
                treesIdx.add(i);
            }else{
                heights.add(a[i]);
            }
        }

        heights.sort(null); //sort in natural order

        int[] sorted = new int[a.length];
        for(int i=0; i<a.length; i++){
            if(treesIdx.contains(i)){
                sorted[i]= -1;
            }else{
                sorted[i]= heights.remove(0);
            }
        }
        return sorted;
    }
}

//kotlin
//       fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
//          val s = a.filter { it != -1 }.sorted().toMutableList()
//          return a.map { if (it == -1) -1 else s.removeAt(0)}.toMutableList()
//        }

