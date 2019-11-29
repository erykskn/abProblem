package com.ery;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(getABPairs(8, 2));
        System.out.println(getABPairs(10, 23));
        System.out.println(getABPairs(4, 6)); //result empty string

    }

    public static String getABPairs(int arraySize, int pairCount) {
        String pairString = "";
        int aCount = arraySize / 2;
        int bCount = arraySize - aCount;

        if (arraySize <= 0 || pairCount <= 0) {
            return pairString;
        } else if (!checkMaxPairCount(arraySize, pairCount)) {
            return pairString;
        }

        pairString = fillTheStringOfPairs(aCount, bCount, pairCount);

        return pairString;
    }


    private static String fillTheStringOfPairs(int aCount, int bCount, int pairCount) {
        String[] strArray = getStrABArray(aCount, bCount);
        int shiftCount = aCount * bCount - pairCount;
        int tempCount = bCount;

        while (shiftCount > 0) {
            if (shiftCount > tempCount) {
                strArray[aCount + bCount - 1] = "A";
                strArray[aCount - 1] = "B";
                aCount--;
                shiftCount = shiftCount - tempCount;
            } else {
                strArray[aCount + shiftCount - 1] = "A";
                strArray[aCount - 1] = "B";
                shiftCount = 0;
            }
        }

        return Arrays.toString(strArray);
    }

    private static String[] getStrABArray(int aCount, int bCount) {
        String[] strArray = new String[aCount + bCount];

        for (int a = 0; a < aCount; a++) {
            strArray[a] = "A";
        }
        for (int a = aCount; a < aCount + bCount; a++) {
            strArray[a] = "B";
        }
        return strArray;
    }

    private static boolean checkMaxPairCount(int arraySize, int pairCount) {
        int aCount = arraySize / 2;
        int bCount = arraySize - aCount;
        if (pairCount < aCount * bCount) {
            return true;
        }
        return false;
    }
}
