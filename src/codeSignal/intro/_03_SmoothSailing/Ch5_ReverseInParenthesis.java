package codeSignal.intro._03_SmoothSailing;

public class Ch5_ReverseInParenthesis {

//    my solution using recursion... too long
    String reverseInParentheses5(String in){
        return reverseFunction(in, true);
    }

    private String reverseFunction(String s, boolean fromExterior) {
        int currIdx = 0;
        int nextParenthIdx = s.indexOf('(');

        if(nextParenthIdx == -1 && fromExterior)  return s;

        if(nextParenthIdx == -1)  return new StringBuilder(s).reverse().toString();

        String out = "";
        int closingParenthIdx=0;
        while(nextParenthIdx != -1){
            closingParenthIdx = findClosingParenthIdx(nextParenthIdx, s);
            out += s.substring(currIdx, nextParenthIdx) +
                    reverseFunction(s.substring(nextParenthIdx+1, closingParenthIdx), false);
            currIdx= closingParenthIdx + 1;
            nextParenthIdx = s.indexOf('(',closingParenthIdx+1);
        }

        if(fromExterior)  return out + s.substring(closingParenthIdx+1);

        return new StringBuilder(out + s.substring(closingParenthIdx+1) ).reverse().toString();
    }

    private int findClosingParenthIdx(int idx, String s){
        int amountInternal= 0;
        for(int i= idx+1; i<s.length(); i++ ){
            char c = s.charAt(i);
            if(c == ')' && amountInternal==0)   return i;
            if(c == ')') amountInternal--;
            if(c == '(') amountInternal++;
        }
        throw new  IllegalArgumentException("Index of opening parenthesis is wrong, or the string is not well-formed");
    }


//TOP solutions
    String reverseInParentheses2(String inputString) {
        StringBuilder str = new StringBuilder(inputString);
        int start, end;
        while(str.indexOf("(") != -1){
            start = str.lastIndexOf("(");
            end = str.indexOf(")", start);
            str.replace(start, end + 1, new StringBuilder(str.substring(start+1, end)).reverse().toString());
        }
        return str.toString();
    }

//  a good one using recursion
    String reverseInParentheses3(String inputString) {
        int start = inputString.lastIndexOf("(");
        int end = inputString.indexOf(")", start);
        if(start == -1 || end == -1 || start > end)
            return inputString;
        return reverseInParentheses(
                inputString.substring(0, start) +
                new StringBuilder(inputString.substring(start+1, end)).reverse().toString() +
                inputString.substring(end+1) );
    }

    String reverseInParentheses(String inputString) {
        if(inputString.isEmpty()){
            return inputString;
        }
        if(!inputString.contains("(")){
            return inputString;
        }
        String rStr=new String();
        String str1=new String();
        String str2=new String();
        int n1 = inputString.lastIndexOf('(');
        int n2=inputString.indexOf(')',n1);
        str1=inputString.substring(0,n1);
        str2=inputString.substring(n2+1);
        rStr=inputString.substring(n1+1,n2);
        StringBuilder input1 = new StringBuilder();
        input1.append(rStr);
        input1 = input1.reverse();
        String r=str1+input1+str2;
        return reverseInParentheses(r);
    }


    public static void main(String[] args) {
        Ch5_ReverseInParenthesis reverse = new Ch5_ReverseInParenthesis();
//        test findClosingParenthIdx
        String s1= "foo(bar(baz))blim";
        String s2 = "foo(bar)baz(blim)";
        String s3 = "hola(bye)";
        String s4 = "hola(123(adios)xyz)hola(456)hola(789)hola(abc)";
        int idx= reverse.findClosingParenthIdx(3, s1);
        System.out.println(idx);

        System.out.println(reverse.reverseInParentheses(s1));
        System.out.println(reverse.reverseInParentheses(s2));
        System.out.println(reverse.reverseInParentheses(s3));
        System.out.println(reverse.reverseInParentheses(s4));
    }
}
