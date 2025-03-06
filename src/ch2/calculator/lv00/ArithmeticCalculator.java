package ch2.calculator.lv00;

import java.util.Scanner;

public class ArithmeticCalculator {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        int inChoiceNum;

        while (1 == 1) {
            System.out.println("======================================================");
            System.out.println("                      계   산   기                      ");
            System.out.println("");
            System.out.println("        해당하는 메뉴를 입력해주세요.");
            System.out.println("======================================================");
            System.out.println("");
            System.out.println("         (1) 계산기  (2) 기록조회  (3) 조건조회 (4) 종료");
            System.out.println("");
            System.out.println("======================================================");
            System.out.print("입력 : ");
            
            //메뉴 선택
            try {
                inChoiceNum = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 오류내용 : " + e);
                scanner.nextLine();
                continue;
            }
            
            //계산
            if (inChoiceNum == 1) {

                System.out.println("계산식을 입력하세요.");
                String input = scanner.nextLine();
                try {
                    double result = calculator.Calculate(input);
                    System.out.println("결과값 : " + result);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }

            //기록 출력
            if (inChoiceNum == 2) {

                calculator.getHistory();

                System.out.println("기록을 삭제하시겠습니까?, Y,y 입력 시 삭제 진행");
                String inputAnswer = scanner.nextLine();

                if(inputAnswer.toUpperCase().equals("Y")) {
                    System.out.println("몇번째 기록을 삭제하시겠습니까?");
                    try {
                        inChoiceNum = scanner.nextInt();
                        scanner.nextLine();
                        calculator.setHistory(inChoiceNum);
                    }catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                        continue;
                    }catch (Exception e)
                    {
                        System.out.println("잘못된 입력입니다." + e);
                        continue;
                    }

                }
            }

            //조건조회
            if (inChoiceNum == 3) {
                {
                    System.out.println("숫자를 입력해주세요. ( 입력한 숫자 이상의 계산 결과값 출력 )");
                    try {
                        Double searchNum = scanner.nextDouble();
                        scanner.nextLine();
                        calculator.getConditionHistory(searchNum);
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다. : " + e);
                    }
                }
                continue;
            }

            //바로 종료할때
            if (inChoiceNum == 4) {
                System.out.println("계산을 종료합니다.");
                break;
            }
        }
    }
}
