package ch2.calculator.classversion;

import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        /*********************************
         * Calculator 클래스 선언
         ********************************/
        Calculator calculator = new Calculator();

        /*********************************
         * while 외부에서 초기화 해야하는 변수
         ********************************/
        Scanner scanner = new Scanner(System.in);
        String inContinueCal = "";

        while (!inContinueCal.equals("exit")) {
            /*********************************
             * 초기화
             ********************************/
            int inNumFirst;
            int inNumSecond;
            char inCalOperator;
            int inChoiceNum = 0;
            String inContinueDeleteHistory = "";


            System.out.println("===================================================");
            System.out.println("                    계   산   기                    ");
            System.out.println("");
            System.out.println("        해당하는 메뉴를 입력해주세요.");
            System.out.println("===================================================");
            System.out.println("");
            System.out.println("         (1) 계산기  (2) 기록조회  (3) 종료");
            System.out.println("");
            System.out.println("===================================================");
            System.out.print("입력 : ");

            try {
                inChoiceNum = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 오류내용 : " + e);
                scanner.nextLine();
                continue;
            }

            //바로 종료할때
            if (inChoiceNum == 3) {
                System.out.println("계산을 종료합니다.");
                break;
            }

            //기록 출력
            if (inChoiceNum == 2) {
                while (!inContinueDeleteHistory.equals("exit")) {
                    calculator.getHistory();

                    System.out.println("기록을 수정하시겠습니까? ( exit 입력 시 종료 )");
                    inContinueDeleteHistory = scanner.nextLine();

                    if (!inContinueDeleteHistory.equals("exit")) {
                        System.out.println("몇번째 기록을 수정하시겠습니까?");
                        inChoiceNum = scanner.nextInt();
                        scanner.nextLine();
                        calculator.setHistory(inChoiceNum);
                        calculator.getHistory();

                        System.out.println("수정을 종료하시겠습니까? ( exit 입력 시 종료 )");
                        inContinueDeleteHistory = scanner.nextLine();
                    }

                }


                continue;
            }

            /*********************************
             * 숫자 입력 받음
             ********************************/
            try {
                System.out.println("첫번째 숫자 입력");
                inNumFirst = scanner.nextInt();
                scanner.nextLine();
                System.out.println("수학 기호 입력 ( +, -, *, / )");
                inCalOperator = scanner.next().charAt(0);
                scanner.nextLine();
                System.out.println("두번째 숫자 입력");
                inNumSecond = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
                System.out.println("오류내용 : " + e);
                continue;
            }

            /*********************************
             * 스위치로 result에 결과값 저장, 기록에 쓰일 계산기호 저장
             ********************************/

            System.out.println(calculator.calculate(inNumFirst, inNumSecond, inCalOperator));


            System.out.println("계속 사용하시겠습니까? (exit 입력 시 종료)");
            inContinueCal = scanner.nextLine();
        }


    }
}