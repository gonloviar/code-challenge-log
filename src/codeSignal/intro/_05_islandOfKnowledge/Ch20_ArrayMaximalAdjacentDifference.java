package codeSignal.intro._05_islandOfKnowledge;

import java.util.stream.IntStream;

public class Ch20_ArrayMaximalAdjacentDifference {

    int arrayMaximalAdjacentDifference(int[] inputArray) {
        int max=0;
        for(int i=0; i<inputArray.length-1; i++){
            int curr= Math.abs(inputArray[i]-inputArray[i+1]);
            if(curr > max) max= curr;
        }
        return max;
    }


// ====================  TOP ======================
    int arrayMaximalAdjacentDifference2(int[] inputArray) {
        int max=0;
        for( int i = 1 ; i < inputArray.length ; i++ ){
            max = Math.max(max,Math.abs(inputArray[i] - inputArray[i-1]));   //Libraries, libraries!!
        }
        return max;
    }

//    streams!
    int arrayMaximalAdjacentDifference3(int[] inputArray) {
        return IntStream
                .range(0,inputArray.length-1)
                .map(i->Math.abs(inputArray[i]-inputArray[i+1]))
                .max()
                .getAsInt();
    }

}
