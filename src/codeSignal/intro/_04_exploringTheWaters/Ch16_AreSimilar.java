package codeSignal.intro._04_exploringTheWaters;

/*
Two arrays are called similar if one can be obtained from another
by swapping at most one pair of elements in one of the arrays.

Given two arrays a and b, check whether they are similar.

Example

    For a = [1, 2, 3] and b = [1, 2, 3], the output should be
    areSimilar(a, b) = true.

    The arrays are equal, no need to swap any elements.

    For a = [1, 2, 3] and b = [2, 1, 3], the output should be
    areSimilar(a, b) = true.

    We can obtain b from a by swapping 2 and 1 in b.

    For a = [1, 2, 2] and b = [2, 1, 1], the output should be
    areSimilar(a, b) = false.

    Any swap of any two elements either in a or in b won't make a and b equal.

 */

public class Ch16_AreSimilar {

    boolean areSimilar(int[] a, int[] b) {

        int diff =0;
        int idxDiff1=0, idxDiff2=0;

        for(int i = 0; i<a.length; i++){
            if(a[i] != b[i]){
                idxDiff1 = diff == 0? i : idxDiff1;
                idxDiff2 = diff == 1? i : idxDiff2;
                diff++;
            }
        }

        if(diff>2)
            return false;

        return diff == 0 ||
                (a[idxDiff1] == b[idxDiff2] && a[idxDiff2] == b[idxDiff1]);
    }

}
