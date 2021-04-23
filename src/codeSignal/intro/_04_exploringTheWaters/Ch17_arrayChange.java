package codeSignal.intro._04_exploringTheWaters;

/*
You are given an array of integers. On each move you are allowed to increase
exactly one of its element by one. Find the minimal number of moves required
to obtain a strictly increasing sequence from the input.

Example
For inputArray = [1, 1, 1], the output should be
arrayChange(inputArray) = 3.
 */

public class Ch17_arrayChange {
    int arrayChange(int[] a) {
        int count=0;

        for(int i=0; i<a.length-1; i++){
            while(a[i] >= a[i+1]){
                a[i+1]++;
                count++;
            }
        }
        return count;
    }

// ====================  TOP ======================

    int arrayChange2(int[] a) {
        int cnt=0, t;
        for(int i=0; i<a.length-1; i++)
            if(a[i]>=a[i+1]) {
                t = a[i]-a[i+1]+1;    //more efficient doing some math.
                a[i+1] += t;
                cnt+=t;
            }

        return cnt;
    }

}
