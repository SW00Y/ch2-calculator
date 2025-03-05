package ch2.calculator.myversion;

import java.util.Arrays;

public enum MyOperator {
    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    TIMES('*', (a, b) -> a * b),
    DIVISION('/', (a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    });

    private final char operationChar;
    private final MyOperation myOperation;

    MyOperator(char operationChar, MyOperation myOperation) {
        this.operationChar = operationChar;
        this.myOperation = myOperation;
    }

    public static MyOperator getOperator(char operatorChar) {
        return Arrays.stream(values())
                .filter(check -> check.operationChar == operatorChar)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자 : " + operatorChar));
    }

    public boolean highPriority() {
        return this == TIMES || this == DIVISION;
    }

    public double doCalculator(double a, double b) {
        return myOperation.input(a, b);
    }
}
