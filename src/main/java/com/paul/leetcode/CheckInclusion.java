package com.paul.leetcode;


import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {


    public static boolean checkInclusion(String s1, String str) {
        if (s1 == null || s1.length() == 0 || str == null || str.length() == 0) {
            return false;
        }

        if (s1.length() > str.length()) {
            return false;
        }

        Map<Character, Integer> s1Meta = new HashMap<>();
        Map<Character, Integer> wantMatchMeta = new HashMap<>();

        for (int i = 0; i < s1.length(); ++i) {
            s1Meta.put(s1.charAt(i), s1Meta.getOrDefault(s1.charAt(i), 0) + 1);
            wantMatchMeta.put(str.charAt(i), wantMatchMeta.getOrDefault(str.charAt(i), 0) + 1);
        }

        Integer matchCharCount = 0;

        for (Character character : s1Meta.keySet()) {
            if (s1Meta.get(character).equals(wantMatchMeta.getOrDefault(character, 0))) {
                ++matchCharCount;
            }
        }

        if (matchCharCount.equals(s1Meta.size())) {
            return true;
        }

        for (int i = 0, j = s1.length(); j < str.length(); ++i, ++j) {
            Integer oldCharNum = wantMatchMeta.get(str.charAt(i));

            wantMatchMeta.put(str.charAt(i), oldCharNum - 1);

            if (s1Meta.getOrDefault(str.charAt(i), 0).equals(oldCharNum)) {
                --matchCharCount;
            }

            if (oldCharNum > 1 && s1Meta.getOrDefault(str.charAt(i), 0).equals(oldCharNum - 1)) {
                ++matchCharCount;
            }

            oldCharNum = wantMatchMeta.getOrDefault(str.charAt(j), 0);

            wantMatchMeta.put(str.charAt(j), oldCharNum + 1);

            if (oldCharNum > 0 && s1Meta.getOrDefault(str.charAt(j), 0).equals(oldCharNum)) {
                --matchCharCount;
            }

            if (s1Meta.getOrDefault(str.charAt(j), 0).equals(oldCharNum + 1)) {
                ++matchCharCount;
            }

            if (matchCharCount.equals(s1Meta.size())) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));

    }
}