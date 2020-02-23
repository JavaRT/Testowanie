package org.example;

public class RomanConv {
        // przyjmuje stringa,który jest liczbą rzymską i zwraca arabską
        public int valueOfSingleRoman(char singleRoman) {
            int result = 0;
            if (singleRoman == 'I') {
                result = 1;
            }
            if (singleRoman == 'V') {
                result = 5;
            }
            if (singleRoman == 'X') {
                result = 10;
            }
            if (singleRoman == 'L') {
                result = 50;
            }
            if (singleRoman == 'C') {
                result = 100;
            }
            if (singleRoman == 'D') {
                result = 500;
            }
            if (singleRoman == 'M') {
                result = 1000;
            }
            return result;
        }
        public int convertRomanToArabic(String RomanNumber) {
            char[] chars = RomanNumber.toCharArray();
            int sum = 0;
            for (int i = 0; i < chars.length-1; i++) {
                char current = chars[i];
                char next = chars[i+1];
                int currentValue = valueOfSingleRoman(current);
                int nextValue = valueOfSingleRoman(next);
                if (currentValue >= nextValue) {
                    sum = sum + valueOfSingleRoman(current);
                } else {
                    sum = sum - valueOfSingleRoman(current);
                }
            }
            return sum+valueOfSingleRoman(chars[chars.length-1]);
        }
    }