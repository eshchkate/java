package net.thumbtack.school.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for(String elem : strings) {
            sb.append(elem);
        }
        return sb.length();
    }

    public static String getFirstAndLastLetterString(String string) {
        return String.valueOf(string.charAt(0)) + string.charAt(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return  string1.regionMatches(index,string2,index,1);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return isSameCharAtPosition(string1,string2,(string1.indexOf(character)));
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return isSameCharAtPosition(string1,string2,(string1.lastIndexOf(character)));
    }

	public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return isSameCharAtPosition(string1,string2,(string1.indexOf(str)));
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return isSameCharAtPosition(string1,string2,(string1.lastIndexOf(str)));
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string2.compareTo(string1) > 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string2.compareToIgnoreCase(string1) > 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int  length = Math.min(string1.length(), string2.length());
        for (int i=0; i<length; i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return string1.substring(0,i);
            }
        }
        return string1.substring(0, length);
    }

    public static boolean isPalindrome(String string) {
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(new StringBuilder(string).reverse().toString());
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        int maxLength = 0;
        String result  = "";
        for (String el : strings) {
            if (isPalindromeIgnoreCase(el)) {
                if (el.length() > maxLength) {
                    maxLength = el.length();
                    result = el;
                }
            }
        }
        return result;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        int len = length + index;
        return string1.length() >= len &&
                string2.length() >= len &&
                string2.substring(index, len).equals(string1.substring(index, len));

    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                        String string2, char replaceInStr2, char replaceByInStr2) {
       return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2,replaceByInStr2));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                     String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).equals(string2.replace(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replaceAll(" ",""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
       return  makeCsvStringBuilderFromInts(array).toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        return makeCsvStringBuilderFromDoubles(array).toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        if (array.length>0) {
            sb.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                sb.append(",").append(array[i]);
            }
        }
        return sb;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        if (array.length>0) {
            sb.append(BigDecimal.valueOf(array[0]).setScale(2, RoundingMode.HALF_UP));
            for (int i = 1; i < array.length; i++) {
                sb.append(",").append(BigDecimal.valueOf(array[i]).setScale(2, RoundingMode.HALF_UP));
            }
        }
        return sb;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder sb = new StringBuilder(string);
        for (int i = positions.length-1; i>=0; i--) {
            sb.deleteCharAt(positions[i]);
        }
        return sb;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder(string);
        for (int i = positions.length-1; i>=0; i--) {
            sb.insert(positions[i],characters[i]);
        }
        return sb;
    }

}
