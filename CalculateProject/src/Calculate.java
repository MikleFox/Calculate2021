import javax.imageio.IIOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Calculate {
    public static void main(String[] args) throws IOException, NumberOutsideException, WrongExpressionException {
        Map<String, Integer> RimNumbers = new HashMap<>();
        RimNumbers.put("I", 1);
        RimNumbers.put("II", 2);
        RimNumbers.put("III", 3);
        RimNumbers.put("IV", 4);
        RimNumbers.put("V", 5);
        RimNumbers.put("VI", 6);
        RimNumbers.put("VII", 7);
        RimNumbers.put("VIII", 8);
        RimNumbers.put("IX", 9);
        RimNumbers.put("X", 10);

        int numb1, numb2;
        String symbol;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String[] words = str.split("\\s+");

        if (RimNumbers.containsKey(words[0]) && RimNumbers.containsKey(words[2]) && words.length == 3) {
            numb1 = RimNumbers.get(words[0]);
            numb2 = RimNumbers.get(words[2]);
            symbol = words[1];
            if (numb1 <= 0 | numb1 > 10) throw new NumberOutsideException("Введено не верное число " + numb1);
            if (numb2 <= 0 | numb1 > 10) throw new NumberOutsideException("Введено не верное число " + numb2);
            System.out.println(RomanToArab.arabicToRoman(GetResult(symbol, numb1, numb2)));
        }

        if (!RimNumbers.containsKey(words[0]) && !RimNumbers.containsKey(words[2]) && words.length == 3) {
            numb1 = Integer.parseInt(words[0]);
            numb2 = Integer.parseInt(words[2]);
            symbol = words[1];
            if (numb1 <= 0 | numb1 > 10) throw new NumberOutsideException("Введено не верное число " + numb1);
            if (numb2 <= 0 | numb2 > 10) throw new NumberOutsideException("Введено не верное число " + numb2);
            System.out.println(GetResult(symbol, numb1, numb2));
        }

    }

    public static int GetResult(String symbol, int numb1, int numb2) throws WrongExpressionException {
        if (symbol.equals("+")) {
            return (numb1 + numb2);
        } else if (symbol.equals("-")) {
            return (numb1 - numb2);
        } else if (symbol.equals("*")) {
            return (numb1 * numb2);
        } else if (symbol.equals("/")) {
            return (numb1 / numb2);
        } else
            throw new WrongExpressionException("Неверный логический оператор");
    }
}

