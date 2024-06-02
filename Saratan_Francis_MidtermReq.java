import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Saratan_Francis_MidtermReq {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Francis\\.vscode\\JAVA Coding\\Saratan_.txt"; 
        BigDecimal[] numbers = readNumbersFromFile(filename);// Read numbers from the file
        if (numbers != null) {
            BigDecimal average = calculateAverage(numbers);// Calculate the average of the numbers
            System.out.println("Average: " + average); // Print the average
        } else {
            System.out.println("No valid numbers found in the file."); // Inform the user if no valid numbers were found
        }
    }
    
    // Method to read numbers from a file and return them as an array of BigDecimal
    public static BigDecimal[] readNumbersFromFile(String filename) {
        List<BigDecimal> numberList = new ArrayList<>(); // Use ArrayList to store numbers
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { // BufferedReader and FileReader for efficient reading
            String line;
            while ((line = br.readLine()) != null) { // Read file line by line
                try {
                    BigDecimal number = new BigDecimal(line.trim()); // Trim the line and convert to BigDecimal
                    numberList.add(number); // Add number to the list
                } catch (NumberFormatException e) {
                    // Skip lines that cannot be converted to BigDecimal
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage()); // Print error message if file reading fails
            return null; // Return null if an IOException occurs
        }

        return numberList.toArray(new BigDecimal[0]); // Convert list to array and return
    }
    
    // Method to calculate the average of an array of BigDecimal numbers
    public static BigDecimal calculateAverage(BigDecimal[] numbers) {
        BigDecimal sum = BigDecimal.ZERO; // Initialize sum as zero
        for (BigDecimal num : numbers) { // Iterate through the numbers
            sum = sum.add(num); // Add each number to the sum
        }

        if (numbers.length == 0) {
            return BigDecimal.ZERO; // Return zero if the array is empty to avoid division by zero
        }

        return sum.divide(new BigDecimal(numbers.length), BigDecimal.ROUND_HALF_UP); // Calculate average with roundin
    }
}
