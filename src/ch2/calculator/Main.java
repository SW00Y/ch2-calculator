package ch2.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //클래스 없이 하나, 클래스 있는거 하나

    public static void main(String[] args) {
        /*********************************
         * while 외부에서 초기화 해야하는 변수
         ********************************/
        String inContinueCal = "";
        List<String> calHistory = new ArrayList<>();
        int count = 1;

        while (!inContinueCal.equals("exit")) {
            /*********************************
             * 초기화
             ********************************/
            Scanner scanner = new Scanner(System.in);
            int inNumFirst;
            int inNumSecond;
            int result = 0;
            char chCalType = 0;
            int inScType = 0;

            System.out.println("===================================================");
            System.out.println("                    계   산   기                    ");
            System.out.println("");
            System.out.println("        해당하는 숫자를 입력하여 계산을 시작하세요.       ");
            System.out.println("===================================================");
            System.out.println("");
            System.out.println("         (1) ＋    (2) －    (3) ×    (4) ÷         ");
            System.out.println("");
            System.out.println("         (5) 기록  (6) 종료                          ");
            System.out.println("");
            System.out.println("exit 입력 시 종료됩니다.");
            System.out.println("===================================================");
            System.out.print("숫자 입력 : ");


            try {
                inScType = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
                System.out.println("오류내용 : " + e.getMessage());
                continue;
            }

            //바로 종료할때
            if (inScType == 6) {
                System.out.println("계산을 종료합니다.");
                inContinueCal = "exit";
                break;
            }

            //기록 출력
            if (inScType == 5) {
                System.out.println(calHistory);
                continue;
            }

            //숫자입력
            try{
                System.out.println("첫번째 숫자 입력");
                inNumFirst = scanner.nextInt();
                System.out.println("두번째 숫자 입력");
                inNumSecond = scanner.nextInt();
            }catch (Exception e)
            {
                System.out.println("잘못된 입력입니다.");
                System.out.println("오류내용 : " + e.getMessage());
                continue;
            }

            //스위치로 result에 결과값 저장
            //기록에 쓰일 계산기호 저장

            switch (inScType) {
                case 1:
                    result = inNumFirst + inNumSecond;
                    chCalType = '＋';
                    break;
                case 2:
                    result = inNumFirst - inNumSecond;
                    chCalType = '－';
                    break;
                case 3:
                    result = inNumFirst * inNumSecond;
                    chCalType = '×';
                    break;
                case 4:
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
