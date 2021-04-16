package SourceForge.EdgeOfTheOcean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AlmostIncreadingSequence {
    boolean almostIncreasingSequence(int[] seq) {

        ArrayList<Integer> seqList = new ArrayList<Integer>();
         for(int i=0; i<seq.length; i++){
             seqList.add(seq[i]);
         }
        return alsFunction(seqList, 1);

        // boolean removed= false;
        // int higher;

        // for(int i=0; i<seq.length-1; i++){
        //     if(seq[i] >= seq[i+1]){
        //         if(removed){
        //             return false;
        //         }
        //         removed= true;

        //         // if( i > 0  && (seq[i-1] >= seq[i+1])){
        //         //     return false;
        //         // }
        //     }
    }

    private boolean alsFunction(ArrayList<Integer> seqList, int n){
        if(n==-1){
            return false;
        }
        if(seqList.size() == 1){
            return true;
        }

        for(int i=0; i<seqList.size()-1; i++){
            if(seqList.get(i) >= seqList.get(i+1)){

                ArrayList<Integer> listA = new ArrayList<>();
                if(i>0) listA.add(seqList.get(i-1));
                if(seqList.size() > 2)
                    listA.addAll(seqList.subList(i+1, seqList.size()));

                ArrayList<Integer> listB = new ArrayList();
                if(i>0) listB.add(seqList.get(i-1));
                listB.add(seqList.get(i));
                if(seqList.size() > 2)
                    listB.addAll(seqList.subList(i+2, seqList.size()));
                                                                        System.out.println("listA:"+listA+", listB:"+listB);
                return alsFunction(listA,n-1) || alsFunction(listB, n-1);

            }
        }
        System.out.println("pasoss");
        return true;
    }

   public static void main(String ...args){
        int[] a = {1,2,3,15,4,5};
//       int[] a = {40,50,60,10,20,30};
        AlmostIncreadingSequence chall = new AlmostIncreadingSequence();

        System.out.println(chall.almostIncreasingSequence(a));
   }



}
