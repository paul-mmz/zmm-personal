package com.paul.leetcode;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0 || path.charAt(0) != '/') {
            return "";
        }

        String[] pathArray = path.split("/");

        if (pathArray == null || pathArray.length == 0) {
            return "/";
        }

        int endIndex = -1;

        for (int i = 0; i < pathArray.length; ++i) {
            if (pathArray[i].length() == 0 || pathArray[i].equals(".")) {
                continue;
            }

            if (pathArray[i].equals("..")) {
                if (endIndex >= 0) {
                    --endIndex;
                }
                continue;
            }

            if (++endIndex != i) {
                pathArray[endIndex] = pathArray[i];
            }
        }

        if (endIndex < 0) {
            return "/";
        }

        StringBuilder absPath = new StringBuilder();

        for (int i = 0; i <= endIndex; ++i) {
            absPath.append("/").append(pathArray[i]);
        }

        return absPath.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));

    }
}
