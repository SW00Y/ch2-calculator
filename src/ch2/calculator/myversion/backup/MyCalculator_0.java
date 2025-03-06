//package ch2.calculator.myversion;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyCalculator_0 {
//
//    private List<String> calHistory = new ArrayList<>();  // 계산 이력 저장
//
//    public void getHistory(){
//        for(int i=0;i<calHistory.size();i++){
//            System.out.println(i + "번째 " + calHistory.get(i));
//        }
//    }
//
//    public void getConditionHistory(double conditionNum){
//
////        List<String> calConditionHistory = calHistory.stream()
////                .filter(history -> Double.parseDouble(history.split("= ")[1]) > conditionNum)
////                .collect(Collectors.toList());
////
////        System.out.println(conditionNum + "보다 결과값이 높은 계산결과 목록");
////        for(int i=0;i<calConditionHistory.size();i++){
////            System.out.println(calConditionHistory.get(i));
////        }
////        몇번째 계산인지 filter로 인해서 index를 제공하기가 까다로워서 for문으로 변경
//
//        if(calHistory.isEmpty())
//        {
//            System.out.println("계산 결과가 존재하지 않습니다.");
//            return;
//        }
//        for(int i=0;i < calHistory.size(); i++){
//            String[] parts = calHistory.get(i).split("= ");
//            if(Double.parseDouble(parts[1]) >= conditionNum)
//            {
//                System.out.println(i + "번째 계산 : " + calHistory.get(i));
//            }
//        }
//    }
//
//    public void setHistory(int idx) {
//
//        if (idx > calHistory.size()) {
//            System.out.println("저장된 범위를 벗어났습니다.");
//        } else {
//            try {
//                calHistory.remove(idx);
//                System.out.println(idx + " 번째 계산이 삭제되었습니다.");
//            } catch (Exception e) {
//                System.out.println("오류발생 내용 : " + e);
//            }
//        }
//    }
//
////    public Double Calculate(String input) {
////        StringBuilder stringBuilder = new StringBuilder();
////        List<Double> numList = new ArrayList<>();
////        List<MyOperator> operList = new ArrayList<>();
////
////        for (int i = 0; i < input.length(); i++) {
////            char inputChar = input.charAt(i);
////
////            if (Character.isDigit(inputChar) || inputChar == '.')
////            {
////                stringBuilder.append(inputChar);
////            }
////            else
////            {
////                numList.add(Double.parseDouble(stringBuilder.toString()));
////                stringBuilder.setLength(0);
////
////                operList.add(MyOperator.getOperator(inputChar));
////            }
////        }
////
////        if (stringBuilder.length() > 0)     //마지막 숫자가 안들어가서 ++
////        {
////            numList.add(Double.parseDouble(stringBuilder.toString()));
////        }
////
////
////        for (int i = 0; i < operList.size(); i++) {
////            if (operList.get(i).highPriority()) {
////                double result = operList.get(i).doCalculator(numList.get(i), numList.get(i + 1));
////                numList.remove(i + 1);
////                numList.set(i, result);
////                operList.remove(i);
////                i--;
////            }
////        }
////
////        double result = numList.get(0);
////        for (int i = 0; i < operList.size(); i++) {
////            result = operList.get(i).doCalculator(result, numList.get(i + 1));
////        }
////
////        calHistory.add(input + " = " + result);
////        return result;
////    }
//
//    public Double Calculate(String input) {
//        StringBuilder stringBuilder = new StringBuilder();
//        List<Double> numList = new ArrayList<>();
//        List<MyOperator> operList = new ArrayList<>();
//
//        // 현재 입력된 문자가 숫자인지 연산자인지 체크함, 처음 문자는 반드시 숫자이기 때문에 true로 초기화
//        boolean isNumberOrOperator = true;
//
//        for (int i = 0; i < input.length(); i++) {
//            char inputChar = input.charAt(i);
//
//            // 숫자 또는 소수점이 입력된 경우
//            if (Character.isDigit(inputChar) || inputChar == '.') {
//                stringBuilder.append(inputChar);
//                isNumberOrOperator = false;
//            }
//            // '-' 연산자이며 숫자가 입력된 경우 ( 음수로 처리 되어야 하는 상황, 스트링빌더에 - append )
//            else if (inputChar == '-' && isNumberOrOperator) {
//                stringBuilder.append(inputChar);
//            }
//            // 연산자가 입력된 경우
//            else {
//                if (stringBuilder.length() > 0) {   //스트링빌더에 값이 남아있는 경우 numList에 add 후 초기화
//                    numList.add(Double.parseDouble(stringBuilder.toString()));
//                    stringBuilder.setLength(0);
//                }
//
//                operList.add(MyOperator.getOperator(inputChar));
//                isNumberOrOperator = true;  // 연산자가 올 차례면 그 뒤에는 숫자가 와야 하므로 true
//            }
//        }
//
//        // 마지막 숫자 처리
//        if (stringBuilder.length() > 0) {
//            numList.add(Double.parseDouble(stringBuilder.toString()));
//        }
//
//        // 우선순위 연산 먼저 처리
//        for (int i = 0; i < operList.size(); i++) {
//            if (operList.get(i).highPriority()) {
//                double result = operList.get(i).doCalculator(numList.get(i), numList.get(i + 1));
//                numList.remove(i + 1);
//                numList.set(i, result);
//                operList.remove(i);
//                i--;
//            }
//        }
//
//        // 남은 +, - 계산
//        double result = numList.get(0);
//        for (int i = 0; i < operList.size(); i++) {
//            result = operList.get(i).doCalculator(result, numList.get(i + 1));
//        }
//
//        calHistory.add(input + " = " + result);
//        return result;
//    }
//
//
//
//
//
//}
