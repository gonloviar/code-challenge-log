package codeSignal.intro._05_islandOfKnowledge;

public class Ch_23_BoxBlur {

    int[][] boxBlur(int[][] image) {
        int[][] newImage = new int[image.length-2][image[0].length-2];
        System.out.println();
        for(int i=1; i<image.length-1; i++){

            for(int j=1; j<image[0].length-1; j++){
                int sum = image[i-1][j-1] +
                        image[i][j-1] +
                        image[i+1][j-1] +
                        image[i-1][j] +
                        image[i][j] +
                        image[i+1][j] +
                        image[i-1][j+1] +
                        image[i][j+1] +
                        image[i+1][j+1] ;

                newImage[i-1][j-1] = sum/9;
            }
        }
        return newImage;
    }
}
