import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        int number = 10012; // = some int

        while (number > 0) {
            System.out.println(number % 10);
            number = number / 10;
        }
    }

    public List<Integer> sequentialDigitsOne(int low, int high) {
        List<Integer> res = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            int digit = i % 10;
            int number = i / 10;
            boolean isSequentialDigit = true;

            while (number > 0) {
                if (number % 10 != digit - 1) {
                    isSequentialDigit = false;
                    break;
                }
                digit = number % 10;
                number = number / 10;
            }
            if(isSequentialDigit) res.add(i);
        }
        return res;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean skip = false;
        int level = 2;

        while (level < 10) {
            for (int i = 0; i < 8; i++) {
                sb.delete(0, sb.length());
                int digit = i + 1;

                for (int j = 0; j < level; j++) {
                    if (digit != 10) {
                        sb.append(digit++);
                    } else {
                        skip = true;
                        break;
                    }
                }
                if(skip) {
                    skip = false;
                    break;
                }

                int num;
                try {
                    num = Integer.parseInt(sb.toString());
                } catch (NumberFormatException e) {
                    return res;
                }

                if(low <= num && num <= high) {
                    res.add(num);
                }
                if(num > high) {
                    return res;
                }
            }
            level++;
        }

        return res;
    }
}
