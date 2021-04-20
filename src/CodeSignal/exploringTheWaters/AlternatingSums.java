package CodeSignal.exploringTheWaters;

/*
Several people are standing in a row and need to be divided into two teams. The first person goes into team 1,
the second goes into team 2, the third goes into team 1 again, the fourth into team 2, and so on.

You are given an array of positive integers - the weights of the people. Return an array of two integers,
where the first element is the total weight of team 1, and the second element is the total weight of team 2 after the division is complete.

Example
For a = [50, 60, 60, 45, 70], the output should be
alternatingSums(a) = [180, 105].
 */

public class AlternatingSums {
    int[] alternatingSums(int[] a) {
        int teamA=0, teamB=0;
        for(int i=0; i<a.length; i++){
            if(i%2>0){
                teamB += a[i];
            }else
                teamA += a[i];
        }
        int[] result = {teamA, teamB};
        return result;
    }

    int[] alternatingSums2(int[] a) {

        int []niz = new int[2];

        for(int i=0; i<a.length; i++)
            niz[i%2]+=a[i];

        return niz;
    }
}


