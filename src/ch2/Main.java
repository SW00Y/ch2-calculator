package ch2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "122*5*3-1+5";
        calculator(input);
    }

    public static void calculator(String input){

        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> numList = new ArrayList<>();
        List<Character> operList = new ArrayList<>();

        for(int i=0;i<input.length();i++){
            char inputChar = input.charAt(i);
            if (Character.isDigit(inputChar) || inputChar == '.')
            {
                stringBuilder.append(inputChar);
            }
            else
            {
                numList.add(Integer.parseInt(stringBuilder.toString()));
                stringBuilder.setLength(0);
                operList.add(inputChar);
            }
        }
        
        //마지막에 숫자로 끝나는데 if에 안들어가서 넣어야함
        if (stringBuilder.length() > 0) {
            numList.add(Integer.parseInt(stringBuilder.toString()));
        }

        int result = numList.get(0);
        for (int i = 0; i < operList.size(); i++) {
            char operator = operList.get(i);
            int nextNum = numList.get(i + 1);
            switch (operator)
            {
                case '+' : result = result + nextNum;
                    break;

                case '-' : result = result - nextNum;
                    break;

                case '*' : result = result * nextNum;
                    break;

                case '/' : result = result / nextNum;
                    break;
            }
        }

        System.out.println(result);
        System.out.println(numList);
        System.out.println(operList);





    }
}
