package com.paul.leetcode;

public class StringMultiply {

    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }

        String longer, shorter;

        if (num1.length() > num2.length()) {
            longer = num1;
            shorter = num2;
        } else {
            longer = num2;
            shorter = num1;
        }

        int oneAdderMaxLength = longer.length() + shorter.length();

        byte[] longerBytes = new byte[longer.length()];

        for (int i = 0; i < longer.length(); ++i) {
            longerBytes[i] = (byte) (longer.charAt(i) - '0');
        }

        byte[][] adder = new byte[shorter.length()][];

        for (int i = shorter.length() - 1; i >= 0; --i) {
            adder[i] = oneCharMultiplyAndReverseWithPaddingZero((byte) (shorter.charAt(i) - '0'), longerBytes, shorter.length() - i - 1);
        }

        return multiStrNumAdder(adder, oneAdderMaxLength);
    }

    public static String multiStrNumAdder(byte[][] adder, int oneAdderMaxLength) {
        if (adder == null || adder.length == 0) {
            return null;
        }

        if (adder.length == 1) {
            return convertByteArray2NumStr(reverseByteArrayWithPaddingZero(adder[0], 0));
        }

        byte[] partResult = new byte[oneAdderMaxLength];

        int carryOver = 0;
        int innerSum = 0;

        for (int i = 0; i < oneAdderMaxLength; ++i) {
            innerSum = carryOver;
            for (int j = 0; j < adder.length; ++j) {
                if (adder[j] != null && i < adder[j].length) {
                    innerSum += adder[j][i];
                }
            }

            partResult[i] = (byte) (innerSum % 10);
            carryOver = (byte) (innerSum / 10);
        }

        return new StringBuilder(carryOver == 0 ? "" : "" + carryOver).append(convertByteArray2NumStr(reverseByteArrayWithPaddingZero(partResult, 0))).toString();
    }

    public static byte[] oneCharMultiplyAndReverseWithPaddingZero(byte multiplier, byte[] multiplicand, int paddingZeroNum) {
        if (multiplier == 0) {
            return null;
        }

        if (multiplier == 1) {
            return reverseByteArrayWithPaddingZero(multiplicand, paddingZeroNum);
        }

        byte[] result = new byte[multiplicand.length + 1 + paddingZeroNum];

        byte carryOver = 0;

        int innerAmass = 0;

        for (int i = multiplicand.length - 1, j = paddingZeroNum; i >= 0 && j < result.length; --i, ++j) {
            innerAmass = multiplicand[i] * multiplier + carryOver;
            result[j] = (byte) (innerAmass % 10);
            carryOver = (byte) (innerAmass / 10);
        }

        result[result.length - 1] = carryOver;

        return result;
    }

    public static byte[] reverseByteArrayWithPaddingZero(byte[] bytes, int paddingZeroNum) {
        if (bytes == null || bytes.length == 1) {
            return bytes;
        }

        byte[] result = new byte[bytes.length + paddingZeroNum];

        for (int i = 0; i < bytes.length; ++i) {
            result[result.length - 1 - i] = bytes[i];
        }

        return result;
    }


    public static String multiply_better(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }

        byte[] result = new byte[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; --i) {
            byte n1 = (byte) (num1.charAt(i) - '0');

            for (int j = num2.length() - 1; j >= 0; --j) {
                byte n2 = (byte) (num2.charAt(j) - '0');

                int ammas = result[i + j + 1] + n1 * n2;

                result[i + j + 1] = (byte) (ammas % 10);
                result[i + j] += (byte) (ammas / 10);
            }
        }

        return convertByteArray2NumStr(result);
    }

    public static String convertByteArray2NumStr(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < bytes.length) {
            if (bytes[i] != 0) {
                break;
            }
            ++i;
        }

        for (; i < bytes.length; ++i) {
            result.append((char) (bytes[i] + '0'));
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static String multiply_2(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }

        byte[] result = new byte[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; --i) {
            byte n1 = (byte) (num1.charAt(i) - '0');

            for (int j = num2.length() - 1; j >= 0; --j) {
                byte n2 = (byte) (num2.charAt(j) - '0');

                result[i + j + 1] += n1 * n2;
            }
        }

        for (int i = num1.length() + num2.length() - 1; i > 0; --i) {
            if (result[i] > 9) {
                result[i - 1] += (byte) (result[i] / 10);
                result[i] = (byte) (result[i] % 10);
            }
        }

        return convertByteArray2NumStr(result);
    }

    public static void main(String[] args) {
        System.out.println(multiply("140", "721"));
        System.out.println(multiply_better("140", "721"));
        System.out.println(multiply_2("140", "721"));
    }
}