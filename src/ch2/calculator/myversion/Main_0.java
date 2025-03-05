//package ch2.calculator.myversion;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main_0 {
//    public static void main(String[] args) {
//        String input = "1+5+5*8+5*2*2";
//        calculator(input);
//    }
//
//    public static void calculator(String input) {
//
//        StringBuilder stringBuilder = new StringBuilder();
//        List<Double> numList = new ArrayList<>();
//        List<Character> operList = new ArrayList<>();
//
//        for (int i = 0; i < input.length(); i++) {
//            char inputChar = input.charAt(i);
//            if (Character.isDigit(inputChar) || inputChar == '.') {
//                stringBuilder.append(inputChar);
//            } else {
//                numList.add(Double.parseDouble(stringBuilder.toString()));
//                stringBuilder.setLength(0);
//                operList.add(inputChar);
//            }
//        }
//
//        //마지막 숫자가 안들어감 --> 마지막에 숫자로 끝나는데 if에 안들어가서 넣어야함
//        if (stringBuilder.length() > 0) {
//            numList.add(Double.parseDouble(stringBuilder.toString()));
//        }
//
//        System.out.println("===================================");
//        System.out.println("시작정보");
//        System.out.println(numList);
//        System.out.println(operList);
//        System.out.println("===================================");
//
//        double result = 0;
//
//        for (int i = 0; i < operList.size(); i++) {
//            if (operList.get(i) == '*' || operList.get(i) == '/') {
//                System.out.println("===================================");
//                System.out.println("******************");
//                System.out.println("현재 i = " + i + " operList.size = "  + operList.size());
//                System.out.println("현재 operList : " + operList);
//                System.out.println("현재 numList : " + numList);
//
//                result = numList.get(i) * numList.get(i+1); // 나중에 switch -> enum
//                System.out.println("result = " + numList.get(i) +  " + " + numList.get(i+1) );
//
//                operList.remove(i);
//                numList.remove(i+1);
//                numList.set(i,result);
//
//                System.out.println("변화 i = " + i + " operList.size = "  + operList.size());
//                System.out.println("변화 operList : " + operList);
//                System.out.println("변화 numList : " + numList);
//
//                System.out.println("===================================");
//                i--;
//            }
//            result = 0;
//        }
//
//        System.out.println("* / 종료 ===================================");
//
//        for (int i = 0; i < numList.size(); i++) {
//        System.out.println("+ - 시작 ===================================");
////            operator 구분 추가해야함
//            System.out.println("result = " +  result + " + " + numList.get(i));
//            result = result + numList.get(i);
//        }
//        System.out.println("+ - 종료 ===================================");
//
//        System.out.println(result);
//        System.out.println(numList);
//        System.out.println(operList);
//    }
//}
