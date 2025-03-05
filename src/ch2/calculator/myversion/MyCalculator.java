package ch2.calculator.myversion;

import java.util.ArrayList;
import java.util.List;

public class MyCalculator {

    private List<String> calHistory = new ArrayList<>();  // 계산 이력 저장

    public void getHistory(){
        for(int i=0;i<calHistory.size();i++){
            System.out.println(i + "번째 " + calHistory.get(i));
        }
    }

    public void getConditionHistory(double conditionNum){

//        List<String> calConditionHistory = calHistory.stream()
//                .filter(history -> Double.parseDouble(history.split("= ")[1]) > conditionNum)
//                .collect(Collectors.toList());
//
//        System.out.println(conditionNum + "보다 결과값이 높은 계산결과 목록");
//        for(int i=0;i<calConditionHistory.size();i++){
//            System.out.println(calConditionHistory.get(i));
//        }
//        몇번째 계산인지 filter로 인해서 index를 제공하기가 까다로워서 for문으로 변경
        if(calHistory.isEmpty())
        {
            System.out.println("계산 결과가 존재하지 않습니다.");
            return;
        }
        for(int i=0;i < calHistory.size(); i++){
            String[] parts = calHistory.get(i).split("= ");
            if(Double.parseDouble(parts[1]) >= conditionNum)
            {
                System.out.println(i + "번째 계산 : " + calHistory.get(i));
            }
        }
    }

    public void setHistory(int idx) {
        if (idx > calHistory.size()) {
            System.out.println("저장된 범위를 벗어났습니다.");
        } else {
            try {
                calHistory.remove(idx);
                System.out.println(idx + " 번째 계산이 삭제되었습니다.");
            } catch (Exception e) {
                System.out.println("오류발생 내용 : " + e);
            }
        }
    }

    public Double Calculate(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Double> numList = new ArrayList<>();
        List<MyOperator> operList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);

            if (Character.isDigit(inputChar) || inputChar == '.')
            {
                stringBuilder.append(inputChar);
            }
            else
            {
                numList.add(Double.parseDouble(stringBuilder.toString()));
                stringBuilder.setLength(0);

                operList.add(MyOperator.getOperator(inputChar));
            }
        }

        if (stringBuilder.length() > 0)     //마지막 숫자가 안들어가서 ++
        {
            numList.add(Double.parseDouble(stringBuilder.toString()));
        }

        for (int i = 0; i < operList.size(); i++) {
            if (operList.get(i).highPriority()) {
                double result = operList.get(i).doCalculator(numList.get(i), numList.get(i + 1));
                numList.remove(i + 1);
                numList.set(i, result);
                operList.remove(i);
                i--;
            }
        }

        double result = numList.get(0);
        for (int i = 0; i < operList.size(); i++) {
            result = operList.get(i).doCalculator(result, numList.get(i + 1));
        }

        calHistory.add(input + " = " + result);
        return result;
    }
}
