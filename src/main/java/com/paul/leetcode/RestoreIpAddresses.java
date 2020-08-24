package com.paul.leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    public static List<String> restoreIpAddresses(String s) {
        if (s == null) {
            return new ArrayList<>();
        }

        int length = s.length();

        if (length < 4 || length > 12) {
            return new ArrayList<>();
        }

        return ipSplitWithPoint(s, 0, 3);
    }

    public static List<String> ipSplitWithPoint(String s, int startIndex, int pointNum) {
        if (startIndex >= s.length() || pointNum <= 0) {
            return new ArrayList<>();
        }

        int length = s.length();

        if ((length - startIndex) > (pointNum * 3 + 3) || (length - startIndex) < pointNum + 1) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();


        if (pointNum == 1) {
            String ip1, ip2;

            for (int i = Math.max(length - 3, startIndex + 1); i < length; ++i) {
                ip1 = s.substring(startIndex, i);
                ip2 = s.substring(i, length);

                if (checkIsLegalIp(ip1) && checkIsLegalIp(ip2)) {
                    result.add(new StringBuilder(ip1).append(".").append(ip2).toString());
                }
            }

            return result;
        }

        List<String> shorterIpArray;

        for (int i = 1; i <= 3; ++i) {
            String ipPart = s.substring(startIndex, startIndex + i);

            if (!checkIsLegalIp(ipPart)) {
                continue;
            }

            shorterIpArray = ipSplitWithPoint(s, startIndex + i, pointNum - 1);
            if (shorterIpArray == null || shorterIpArray.size() == 0) {
                continue;
            }

            for (String shorterIp : shorterIpArray) {
                result.add(new StringBuilder(ipPart).append(".").append(shorterIp).toString());
            }
        }

        return result;
    }

    public static boolean checkIsLegalIp(String s) {
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }

        Integer sIp = Integer.valueOf(s);

        if (sIp < 0 || sIp > 255) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
    }
}
