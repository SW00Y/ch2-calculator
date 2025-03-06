package ch2.calculator.challengeversion;

public enum Operator {
    //열거형 선언- 람다
    PLUS("+", (a,b) -> a+b),
    MINUS("-",(a,b) -> a-b),
    TIMES("*",(a,b) -> a*b),
    DIVISION("/",(a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    });

    private final String operationChar; //연산자 문자
    private final Operation operation;  // 연산 구현 ( 람다식으로 전달 Operataion )

    //생성자
    Operator(String operationChar, Operation operation){

        this.operationChar = operationChar;
        this.operation = operation;
    }

    public <T extends Number, X extends Number> double doCalculator(T num1, X num2) {
//        System.out.println("계산"); // 아래 input에서 int, double 변환사용 (Generic)
        return operation.input(num1.doubleValue(), num2.doubleValue());
    }

}
