import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    static double getAverage(int values[]) {
        int sum = 0;

        for (int num : values) {
            sum += num;
        }

        return (double) sum/values.length;
    }

    public static void main(String[] args) throws IOException {
        Random random = new Random();
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);
        int[] dataPoints = new int[100];

        for (int i = 0; i < 100; i++) {
            dataPoints[i] = random.nextInt(100) + 1;
        }

        int sum = 0;
        for (int i : dataPoints) {
            System.out.print(i + " | ");
            sum += i;
        }
        System.out.println("\nAvg: " + (sum/ dataPoints.length));

        int userNum = SafeInput.getRangedInt(br,"Enter number (1-100): ",1, 100);
        int ocur = 0;
        for (int i : dataPoints) {
            if (userNum == i) {
                ocur += 1;
            }
        }

        System.out.println(userNum + " appeared " + ocur + " times\n");

        userNum = SafeInput.getRangedInt(br, "Enter number (1-100): ", 1, 100);
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (userNum == dataPoints[i]) {
                System.out.println(userNum + " appears at index " + i + "\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(userNum + " does not appear in any indexes\n");
        }

        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int num : dataPoints) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Max value: " + max + "\nMin value: " + min + "\n");
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

    }
}
