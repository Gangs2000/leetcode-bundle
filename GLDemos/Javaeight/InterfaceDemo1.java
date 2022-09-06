package Javaeight;

public class InterfaceDemo1 {

    public static void main(String[] aa) {

        System.out.println(changeCase("Welcome To Java8", new ProcessData() {

            @Override
            public String changeCase(String str) {
                return str.toUpperCase();
            }
        }));

    }

    public static String changeCase(String str, ProcessData pd) {
        return pd.changeCase(str);
    }
}

interface ProcessData {
    String changeCase(String str);
}