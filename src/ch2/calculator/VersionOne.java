package ch2.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//클래스 없이 하나, 클래스 있는거 하나
public class VersionOne {

    public static void main(String[] args) {
        /*********************************
         * while 외부에서 초기화 해야하는 변수
         ********************************/
        String inContinueCal = "";
        List<String> calHistory = new ArrayList<>();
        int count = 1;

        while (inContinueCal != "exit") {
            /*********************************
             * 초기화
             ********************************/
            Scanner scanner = new Scanner(System.in);
            int inNumFirst;
            int inNumSecond;
            char inCalType;
            int result = 0;
            char chCalType = 0;
            int inScType = 0;



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
                inScType = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
                System.out.println("오류내용 : " + e);
                continue;
            }

            //바로 종료할때
            if (inScType == 3) {
                System.out.println("계산을 종료합니다.");
                inContinueCal = "exit";
                break;
            }

            //기록 출력
            if (inScType == 2) {
                System.out.println(calHistory);
                continue;
            }

            //숫자입력
            try{
                System.out.println("첫번째 숫자 입력");
                inNumFirst = scanner.nextInt();
                System.out.println("수학 기호 입력 ( +, -, *, / )");
                inCalType = scanner.next().charAt(0);
                System.out.println("두번째 숫자 입력");
                inNumSecond = scanner.nextInt();
            }catch (Exception e)
            {
                System.out.println("잘못된 입력입니다.");
                System.out.println("오류내용 : " + e);
                continue;
            }

            /*********************************
             * 스위치로 result에 결과값 저장, 기록에 쓰일 계산기호 저장
             ********************************/
            switch (inCalType) {
                case '+':
                    result = inNumFirst + inNumSecond;
                    chCalType = '＋';
                    break;
                case '-':
                    result = inNumFirst - inNumSecond;
                    chCalType = '－';
                    break;
                case '*':
                    result = inNumFirst * inNumSecond;
                    chCalType = '×';
                    break;
                case '/':
                    if (inNumSecond == 0) {
                        System.out.println("분모가 0입니다.");
                        continue;
                    }
                    result = inNumFirst / inNumSecond;
                    chCalType = '÷';
                    break;
            }
            System.out.println(count + "번째 계산 : " + inNumFirst + " " + chCalType + " " + inNumSecond + " = " + result);
            calHistory.add(count + "번째 계산 : " + inNumFirst + " " + chCalType + " " + inNumSecond + " = " + result);
            count += 1;


            System.out.println("계속 사용하시겠습니까? (exit 입력 시 종료)");
            inContinueCal = scanner.nextLine();

        }


    }
}
