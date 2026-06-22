import java.util.Scanner;

public class SmartCityAirQualityMonitoringSystem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Program Started...");
        System.out.print("Enter  the number of AQI readings: ");
        int n = s.nextInt();
        while (n < 1) {
            System.out.println("invalid input number must be valid:");
            n = s.nextInt();
        }
        float[] data = loadAQIData(n);
        System.out.println("\nProcessing data...");
        System.out.println("\nDetecting pollution surges...\n");
        int[] indices = detectSurges(data);
        if (indices.length == 0) {
            System.out.println("No pollution surges detected.");
        } else {
            for (int i = 0; i < indices.length; i++) {
                System.out.println("Surge found at index " + indices[i]);
            }
        }
        System.out.println();
        System.out.println("Generating report.....");
        System.out.println();
        displayReport(data, indices);
    }// main

    public static float[] loadAQIData(int n) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the AQi values: ");
        float[] datas = new float[n];
        for (int i = 0; i < n; i++) {
            datas[i] = s.nextFloat();
        }
        return datas;

    }//

    public static int[] detectSurges(float[] data) {
        int[] index = new int[data.length];
        int count = 0;
        for (int i = 1; i < data.length - 1; i++) {
            if (data[i] > data[i - 1] + 15 && data[i] > data[i + 1] + 15) {
                index[count] = i;
                count++;
            } // if
        } // for
        int[] finalIndices = new int[count];
        for (int j = 0; j < count; j++) {
            finalIndices[j] = index[j];
        }//for

        return finalIndices;

    }// detectsurges

    public static String checksAQI(float value) {
        if (value >= 0 && value <= 50) {
            return "Good";
        } else if (value <= 100) {
            return "Moderate";
        } else if (value <= 150) {
            return "Unhealthy";
        } else {
            return "Hazardous";
        }//else
    }// checks

    public static String generateAlert(float value) {
        String condition = checksAQI(value);

        if (condition.equals("Good")) {
            return "Safe to go outside";
        } else if (condition.equals("Moderate")) {
            return "Wear mask";
        } else if (condition.equals("Unhealthy")) {
            return "Avoid outdoor activity";
        } else if (condition.equals("Hazardous")) {
            return "Emergency: Stay indoors";
        } else {
            return "No alert";
        }
    }// generatealert

    public static void displayReport(float[] data, int[] indices) {
        if (indices.length == 0) {
            System.out.println("No surge data available to display.");
            return;
        }

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            float value = data[index];
            System.out.println("------------------------------------------------");
            System.out.println("Index: " + index + " | AQI: " + value + " | condition; " + checksAQI(value)
                    + " | Alert; " + generateAlert(value));
        }
        System.out.println("----------------------------------------------");
        System.out.println("Total surges Deteced:" + indices.length);
        System.out.println();
        System.out.println("Program Ended Successfully.");
    }

}// class