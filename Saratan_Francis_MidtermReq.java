import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Saratan_Francis_MidtermReq {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Francis\\.vscode\\JAVA Coding\\Saratan_.txt"; 
        BigDecimal[] numbers = readNumbersFromFile(filename);
        if (numbers != null) {
            BigDecimal average = calculateAverage(numbers);
            System.out.println("Average: " + average);
        } else {
            System.out.println("No valid numbers found in the file.");
        }
    }

    public static BigDecimal[] readNumbersFromFile(String filename) {
        List<BigDecimal> numberList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    BigDecimal number = new BigDecimal(line.trim());
                    numberList.add(number);
                } catch (NumberFormatException e) {
                    
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }

        return numberList.toArray(new BigDecimal[0]);
    }

    public static BigDecimal calculateAverage(BigDecimal[] numbers) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal num : numbers) {
            sum = sum.add(num);
        }

        if (numbers.length == 0) {
            return BigDecimal.ZERO; 
        }

        return sum.divide(new BigDecimal(numbers.length), BigDecimal.ROUND_HALF_UP);
    }
}
