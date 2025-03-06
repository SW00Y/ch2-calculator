package ch2.calculator.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> calHistory = new ArrayList<>();

    //숫자 입력
    public int calculate(int firstNum, int secondNum, char operator) {
        int result = 0;

        //operator에 맞는 switch 문 결과 입력
        switch (operator) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                if (secondNum == 0) {
                    System.out.println("분모가 0입니다.");
                    break;
                }
                result = firstNum / secondNum;
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
                result = firstNum / secondNum;
                break;
        }


        //History 저장
        calHistory.add(firstNum + " " + operator + " " + secondNum + " = " + result);

        return result;

    }
    //History 불러오기
    public void getHistory(){
        for(int i=0;i<calHistory.size();i++){
            System.out.println(i + "번째 " + calHistory.get(i));
        }
    }
    //History 삭제
    public void setHistory(int idx) {
        if (idx > calHistory.size()) {
            System.out.println("저장된 범위를 벗어났습니다.");
        } else {
            try {
                calHistory.remove(idx);
            } catch (Exception e) {
                System.out.println("오류발생 내용 : " + e);
            }
        }
    }
}
