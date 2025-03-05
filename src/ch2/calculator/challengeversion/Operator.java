package ch2.calculator.challengeversion;

public enum Operator {

    PLUS("+", (a,b) -> a+b),
    MINUS("-",(a,b) -> a-b),
    TIMES("*",(a,b) -> a*b),
    DIVISION("/",(a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    });

    private final String operationChar;
    private final Operation operation;

    Operator(String operationChar, Operation operation){
//        System.out.println("생성");
        this.operationChar = operationChar;
        this.operation = operation;
    }

    public <T extends Number, X extends Number> double doCalculator(T num1, X num2) {
//        System.out.println("계산"); // 아래 input에서 int, double 변환사용
        return operation.input(num1.doubleValue(), num2.doubleValue());
    }

}
