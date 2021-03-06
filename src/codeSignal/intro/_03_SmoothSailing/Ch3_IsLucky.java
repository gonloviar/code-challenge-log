package codeSignal.intro._03_SmoothSailing;


public class Ch3_IsLucky {

    /*
    Ticket numbers usually consist of an even number of digits.
    A ticket number is considered lucky if the sum of the first half of the digits
    is equal to the sum of the second half.

    Given a ticket number n, determine if it's lucky or not.

    Example
    For n = 1230, the output should be
    isLucky(n) = true;

    For n = 239017, the output should be
    isLucky(n) = false.

     */

//    my solution
    Boolean isLucky(int n){
        String s = Integer.toString(n);
        int l = s.length();
        return sumDigits(s.substring(0,l/2) ) ==
                sumDigits(s.substring(l/2, l) );
    }
    private int sumDigits(String half){
        int sum = 0;
        for(char c : half.toCharArray()){
            sum += Integer.parseInt(Character.toString(c));
        }
        return sum;
    }

//top
//        using java.util.streams   cool!
    boolean isLucky3(int n) {
        String s = Integer.toString(n);
        return s.substring(0, s.length() / 2).chars().sum() == s.substring(s.length() / 2).chars().sum();
    }


    boolean isLucky2(int n) {

        String s = n+"";
        int sum = 0;

        for(int i=0; i<s.length()/2; i++)
            sum+=( s.charAt(i) - s.charAt( s.length()-1-i ) );

        return sum==0;
    }




}
