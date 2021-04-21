package codeSignal.intro._04_exploringTheWaters;

/*
Given a rectangular matrix of characters,
add a border of asterisks(*) to it.

Example
For picture = ["abc",
               "ded"]

the output should be
addBorder(picture) = ["*****",
                      "*abc*",
                      "*ded*",
                      "*****"]
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Ch15_AddBorder {

    String[] addBorder(String[] picture) {
        String[] withBorder = new String[picture.length + 2];
        String topBottomBorder = getTopBottomBorder(picture[0].length());

        for(int i = 0; i<picture.length + 2; i++){
            if(i==0 || i ==picture.length + 1){
                withBorder[i]=topBottomBorder;
            }else{
                withBorder[i]="*"+picture[i-1]+"*";
            }
        }
        return withBorder;
    }

    private String getTopBottomBorder(int n){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n+2; i++){
            sb.append('*');
        }
        return sb.toString();
    }


// ====================  TOP ======================

    String[] addBorder2(String[] picture) {
        String[] framedPicture = new String[picture.length + 2];

        for(int i = 0 ; i < picture.length ; i++) {
            framedPicture[i+1] = '*' + picture[i] + '*';
        }

        framedPicture[0] = framedPicture[picture.length + 1] =
                    framedPicture[1].replaceAll(".","*");

        return framedPicture;
    }

    String[] addBorder3(String[] picture) {
        String s = "";
        ArrayList<String> l = new ArrayList<String>();
        for (int i = 0; i < picture[0].length() + 2; i++)
            {s += "*";}
        for (int i = 0; i < picture.length; i++)
            {l.add("*" + picture[i] + "*");}
        l.add(0, s); l.add(s);
        return l.toArray(new String[l.size()]);}




    public static void main(String[] args) {
        Ch15_AddBorder a = new Ch15_AddBorder();
        String[] b = {"abc","def","ghi"};
        System.out.println(Arrays.toString(a.addBorder(b)));
    }
}


