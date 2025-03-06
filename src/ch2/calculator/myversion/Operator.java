package ch2.calculator.myversion;

import java.util.Arrays;

public enum Operator{   //열거형
    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    TIMES('*', (a, b) -> a * b),
    DIVISION('/', (a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");    //예외처리
        return a / b;
    });

    private final char operationChar;   //연산자 문자
    private final Operation operation;  // 연산 구현 ( 람다식으로 전달 Operataion )

    //생성자
    Operator(char operationChar, Operation operation) {
        this.operationChar = operationChar;
        this.operation = operation;
    }

    //연산자문자 operatorChar( + - * / )를 연산자 열거형을 반환
    public static Operator getOperator(char operatorChar) {
        return Arrays.stream(values())      //values() = Operator.열거형을 반환
                .filter(check -> check.operationChar == operatorChar)   //operatorChar과 해당하는 열거형 필터링 
                .findFirst()                                            //첫번째 일치한값 반환
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 : " + operatorChar)); //없는경우 예외
    }

    public boolean highPriority() {
        return this == TIMES || this == DIVISION;    //TIMES, DIVISION 연산인 경우 return true (높은우선순위 */+- )
    }

    public double doCalculator(double a, double b) {
        return operation.input(a, b); // operation 의 input 호출, 계산 수행
    }

}
