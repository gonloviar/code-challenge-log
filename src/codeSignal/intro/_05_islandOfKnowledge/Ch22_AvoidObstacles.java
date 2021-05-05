package codeSignal.intro._05_islandOfKnowledge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ch22_AvoidObstacles {

/*
    You are given an array of integers representing coordinates of obstacles situated on a straight line.
    Assume that you are jumping from the point with coordinate 0 to the right.
    You are allowed only to make jumps of the same length represented by some integer.

    Find the minimal length of the jump enough to avoid all the obstacles.
        Example
    For inputArray = [5, 3, 6, 7, 9], the output should be
    avoidObstacles(inputArray) = 4.

    Check out the image below for better understanding:

 */

    static int avoidObstacles(int[] inputArray) {
//        al parecer para pasar int[] a Integer[] o List<Integer> habia q usar un for.  Los streams solucionarion eso
        List<Integer> obst = Arrays.stream(inputArray).boxed().sorted().collect(Collectors.toList());

        int n=2;
        int lastPos = obst.get(obst.size()-1);
        while(n < lastPos ){
            int pos=0;

            while(!obst.contains(pos) && pos <= lastPos ){
                pos += n;
            }

            if(pos > lastPos){
                return n;
            }else{
                n++;
            }
        }
        return n + 1;
    }

// ====================  TOP ======================
    int avoidObstacles2(int[] inputArray) {

        int jump = 1;
        boolean fail = true;

        while(fail) {
            jump++;
            fail = false;
            for(int i=0; i<inputArray.length; i++)
                if(inputArray[i]%jump==0) {
                    fail = true;
                    break;
                }
        }
        return jump;
    }

    int avoidObstacles3(int[] a) {
        return IntStream
                .range( 2,Arrays.stream(a).max().getAsInt()+2 )
                .filter( i->Arrays.stream(a).allMatch(j->j%i!=0) )
                .min()
                .getAsInt();
    }

}
