package ch2.calculator.lvQ;

@FunctionalInterface    //함수형 인터페이스선언
public interface Operation {
    double input(double a, double b);       //하나의 추상 메서드만 선언
}
