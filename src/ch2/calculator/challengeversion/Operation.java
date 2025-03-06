package ch2.calculator.challengeversion;

@FunctionalInterface        //함수형 인터페이스
public interface Operation {
    double input(double a, double b);
}
