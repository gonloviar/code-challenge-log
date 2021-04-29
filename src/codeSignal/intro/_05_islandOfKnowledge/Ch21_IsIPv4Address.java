package codeSignal.intro._05_islandOfKnowledge;

import java.util.Arrays;

/*
An IP address is a numerical label assigned to each device (e.g., computer, printer)
participating in a computer network that uses the Internet Protocol for communication.
There are two versions of the Internet protocol, and thus two versions of addresses.
One of them is the IPv4 address.

Given a string, find out if it satisfies the IPv4 address naming rules.

Example

    For inputString = "172.16.254.1", the output should be
    isIPv4Address(inputString) = true;

    For inputString = "172.316.254.1", the output should be
    isIPv4Address(inputString) = false.

    316 is not in range [0, 255].

    For inputString = ".254.255.0", the output should be
    isIPv4Address(inputString) = false.

    There is no first number.
 */

public class Ch21_IsIPv4Address {

    static boolean  isIPv4Address(String in) {
        String[] ip= in.split("\\.");
        if (ip.length != 4) return false;

        for(String elem : ip){
            if( (elem.length()>1 && elem.charAt(0) == '0')) return false;

            int num;
            try {
                num = Integer.parseInt(elem);
            }catch(NumberFormatException e){
                return false;
            }

            if( num<0 || num>255) return  false;
        }
        return true;
    }

// ====================  TOP ======================
    boolean isIPv4Address2(String inputString) {   //is this black magic???
        return inputString.matches(
                "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
    }

    boolean isIPv4Address3(String inputString) {
        String[] splitString = inputString.split("[.]");
        if (splitString.length > 4) {
            return false;
        }
        for (String string : splitString) {
            if (string.isEmpty()) {
                return false;
            }
            if (!string.matches("[0-9]{1,3}")) {   //more REGEX!!
                return false;
            }
            int number = Integer.parseInt(string);
            if (!(number >= 0 && number <= 255)) {
                return false;
            }
        }
        return true;
    }

}
