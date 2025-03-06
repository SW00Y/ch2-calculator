package ch2.calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private List<String> calHistory = new ArrayList<>();

    /****************************************
     * 사용하지 않음
     ****************************************/
//    public <T extends Number, X extends Number> double calculate(T num1, X num2, char operator) {
//        double result = 0;
//        double firstNum = num1.doubleValue();
//        double secondNum = num2.doubleValue();
//
//        switch (operator) {
//            case '+':
//                result = firstNum + secondNum;
//                break;
//            case '-':
//                result = firstNum - secondNum;
//                break;
//            case '*':
//                result = firstNum * secondNum;
//                break;
//            case '/':
//                if (secondNum == 0) {
//                    System.out.println("분모가 0입니다.");
//                    break;
//                }
//                result = firstNum / secondNum;
//                break;
//            default:
//                System.out.println("잘못된 연산자입니다.");
//                result = firstNum / secondNum;
//                break;
//        }
//
//        // firstNum && secondNum && result 가 소수점이 없는경우 int로 출력
//        if(firstNum == (int)firstNum && secondNum == (int)secondNum && (int) result == result)
//        {
//            calHistory.add((int)firstNum + " " + operator + " " + (int)secondNum + " = " + (int)result);
//        }
//        else
//        {
//            calHistory.add(firstNum + " " + operator + " " + secondNum + " = " + result);
//        }
//
//
//        return result;
//
//    } // enum 활용으로 사용 X

    /****************************************
     * 입력받은 연산기호를 Operator 열거형으로 반환
     ****************************************/
    public Operator operator(char operatorChar) {
        switch (operatorChar) {
            case '+':
                return Operator.PLUS;
            case '-':
                return Operator.MINUS;
            case '*':
                return Operator.TIMES;
            case '/':
                return Operator.DIVISION;
            default:
                throw new IllegalArgumentException();
        }
    }

    /****************************************
     * 연산
     ****************************************/
    public <T extends Number, X extends Number> double calculate(T num1, X num2, char operatorChar) {
        try{
            Operator operator = operator(operatorChar); //연산자를 Operator 열거형으로 변환
            double result = operator.doCalculator(num1, num2);  //계산결과
            calHistory.add(num1 + " " + operatorChar + " " + num2 + " = " + result);
            return result;
        }
        catch (IllegalArgumentException e){
            System.out.println("잘못된 입력입니다. : " + operatorChar);
            return Double.NaN;  //잘못된 입력시 NaN으로 예외처리
        }
    }

    /****************************************
     * 전체 기록 출력
     ****************************************/
    public void getHistory(){
        for(int i=0;i<calHistory.size();i++){
            System.out.println(i + "번째 " + calHistory.get(i));
        }
    }


    /****************************************
     * 계산기록 중 입력된 값보다 큰 결과값 기록 출력
     ****************************************/
    public void getConditionHistory(double conditionNum){

        List<String> calConditionHistory = calHistory.stream()
                .filter(history -> Double.parseDouble(history.split("= ")[1]) > conditionNum) // 결과값이 조건 값보다 큰 것만 필터링
                .collect(Collectors.toList());

        System.out.println(conditionNum + "보다 결과값이 높은 계산결과 목록");
        for(int i=0;i<calConditionHistory.size();i++){
            System.out.println(calConditionHistory.get(i));
        }
    }

    /****************************************
     * 기록중 입력된 값에 따른 특정 index 삭제
     ****************************************/
    public void setHistory(int idx) {
        if (idx > calHistory.size()) {
            System.out.println("저장된 범위를 벗어났습니다.");  //범위가 범어나면 오류
        } else {
            try {
                calHistory.remove(idx);
            } catch (Exception e) {
                System.out.println("오류발생 내용 : " + e);
            }
        }
    }
}
