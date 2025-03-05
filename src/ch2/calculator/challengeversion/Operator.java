package ch2.calculator.challengeversion;

public enum Operator {

    PLUS("+", (a,b) -> a+b),
    MINUS("-",(a,b) -> a-b),
    TIMES("*",(a,b) -> a*b),
    DIVISION("/",(a,b) -> a/b);


    private final String operationChar;
    private final Operation operation;

    Operator(String operationChar, Operation operation){
        System.out.println("생성");
        this.operationChar = operationChar;
        this.operation = operation;
    }

    public double doCalculator(double a, double b){
        System.out.println("계산");
        return operation.input(a, b);
    }

}
