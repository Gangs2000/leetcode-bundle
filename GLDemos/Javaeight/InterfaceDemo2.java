package Javaeight;

import java.util.function.BiFunction;
import java.util.function.Function;

public class InterfaceDemo2 {

    public static void main(String[] aa) {

        System.out.println(changeCase("Welcome to Java", str -> str.toLowerCase()));

        System.out.println(subString("Welcome to Java", 7, (str, i) -> str.substring(i)));

    }

    public static String changeCase(String str, Function<String, String> pd) {
        return pd.apply(str);
    }

    public static String subString(String str, int i, BiFunction<String, Integer, String> pd) {
        return pd.apply(str, i);
    }
}

// I am using functions Interface which is having method apply();

// Predicate Bi
// Consumer Bi
