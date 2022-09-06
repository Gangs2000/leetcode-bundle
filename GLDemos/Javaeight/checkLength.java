package Javaeight;

public class checkLength {
    public static void main(String[] aa) {

        Function<String, Integer> lenFunc = x -> x.length();

        Function<Integer, Integer> powFunc = x -> x * x;

        int strLen = lenFunc.apply("This is Test Method");

        Integer valPower = powFunc.apply(4);

        System.out.println("The Length Of String " + strLen);

        System.out.println("The power of number " + valPower);
    }
}