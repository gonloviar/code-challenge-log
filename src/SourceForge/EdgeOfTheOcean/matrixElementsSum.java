package SourceForge.EdgeOfTheOcean;

import java.util.HashSet;
import java.util.Set;

/*
After becoming famous, the CodeBots decided to move into a new building together.
Each of the rooms has a different cost, and some of them are free,
but there's a rumour that all the free rooms are haunted! Since the CodeBots are quite superstitious,
they refuse to stay in any of the free rooms, or any of the rooms below any of the free rooms.

Given matrix, a rectangular matrix of integers, where each value represents the cost of the room,
your task is to return the total sum of all rooms that are suitable for the CodeBots
(ie: add up all the values that don't appear below a 0).

Example

    For
    matrix = [[0, 1, 1, 2],
              [0, 5, 0, 0],
              [2, 0, 3, 3]]

    the output should be
    matrixElementsSum(matrix) = 9.

 */

//my solution
public class matrixElementsSum {
    int matrixElementsSum(int[][] matrix) {
        Set<Integer> huntedColumns = new HashSet<>();
        int totalPrice= 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
//                keep record of hunted columns
                if(matrix[i][j] == 0){
                    huntedColumns.add(j);
                    continue;
                }
//                sum prices of suitable rooms
                if(!huntedColumns.contains(j)){
                    totalPrice += matrix[i][j];
                }
            }
        }
        return totalPrice;
    }

//top solutions
//      iterate by columns!  If a 0 is found, the column is disregarded
    int matrixElementsSum2(int[][] matrix) {
        int s = 0;
        for (int c = 0; c < matrix[0].length; ++c)
            for (int r = 0; r < matrix.length; ++r) {
                if (matrix[r][c] > 0)
                    s+=matrix[r][c];
                else break;
            }
        return s;
    }



}




