package com.paul.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MagicNum {

    enum MagicNumEnum {
        ONE(1, new String[]
                {"   *   ",
                 "  **   ",
                 "   *   ",
                 "   *   ",
                 "   *   ",
                 "  ***  "
    }),
        TWO(2, new String[]
                {"  ***  ",
                 " *   * ",
                 "    *  ",
                 "   *   ",
                 "  *    ",
                 " ***** "
    }),
        THREE(3, new String[]
                {"  ***  ",
                 "     * ",
                 "   **  ",
                 "   **  ",
                 "     * ",
                 "  ***  "
    });

        private int value;

        private String[] stars;

        MagicNumEnum(int value, String[] stars) {
            this.value = value;
            this.stars = stars;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String[] getStars() {
            return stars;
        }

        public void setStars(String[] stars) {
            this.stars = stars;
        }

        private static Map<Integer, MagicNumEnum> values;

        static {
            values = new HashMap<>();
            MagicNumEnum[] numEnums = MagicNumEnum.values();
            for (MagicNumEnum magicNumEnum : numEnums) {
                values.put(magicNumEnum.getValue(), magicNumEnum);
            }
        }

        public static MagicNumEnum getEnumByValue(int _value) {
            return values.get(_value) == null ? null : values.get(_value);
        }
    }

    public static void printMagicNumStar(Long normalNum) {
        char[] charArray = String.valueOf(normalNum).toCharArray();

        int starWidth = MagicNumEnum.ONE.getStars().length;
        String[] starArray = new String[starWidth];

        for (int width = 0; width < starWidth; ++width) {
            StringBuffer stringBuffer = new StringBuffer("");
            for (char c : charArray) {
                Integer charValue = Integer.valueOf("" + c);
                if (MagicNumEnum.getEnumByValue(charValue) == null) {
                    continue;
                }
                stringBuffer.append(MagicNumEnum.getEnumByValue(charValue).getStars()[width]);
            }
            starArray[width] = stringBuffer.toString();
        }

        Arrays.stream(starArray).forEach(stars -> System.out.println(stars + "\n"));
    }

    public static void main(String[] args) {
        Long num = 1254554323231L;
        printMagicNumStar(num);
    }



}
