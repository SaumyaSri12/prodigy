
// TASK  1



import java.util.Scanner;

public class converter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the unit of measurement (Celsius, Fahrenheit, or Kelvin): ");
        String originalUnit = scanner.next().toLowerCase();

        // Convert temperature and display results
        convertAndDisplayTemperatures(temperature, originalUnit);

        // Additional feature: Provide a brief description
        describeTemperature(temperature, originalUnit);

        scanner.close();
    }

    private static void convertAndDisplayTemperatures(double temperature, String originalUnit) {
        double convertedCelsius = convertToCelsius(temperature, originalUnit);
        double convertedFahrenheit = convertToFahrenheit(convertedCelsius);
        double convertedKelvin = convertToKelvin(convertedCelsius);

        System.out.println("Converted Temperatures:");
        System.out.println("Celsius: " + convertedCelsius + " °C");
        System.out.println("Fahrenheit: " + convertedFahrenheit + " °F");
        System.out.println("Kelvin: " + convertedKelvin + " K");
    }

    private static double convertToCelsius(double temperature, String originalUnit) {
        switch (originalUnit) {
            case "celsius":
                return temperature;
            case "fahrenheit":
                return (temperature - 32) * 5 / 9;
            case "kelvin":
                return temperature - 273.15;
            default:
                throw new IllegalArgumentException("Invalid unit of measurement");
        }
    }

    private static double convertToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    private static double convertToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private static void describeTemperature(double temperature, String originalUnit) {
        System.out.println("\nTemperature Description:");
        switch (originalUnit) {
            case "celsius":
                System.out.println(temperature + " °C is a measurement on the Celsius scale.");
                break;
            case "fahrenheit":
                System.out.println(temperature + " °F is a measurement on the Fahrenheit scale.");
                break;
            case "kelvin":
                System.out.println(temperature + " K is a measurement on the Kelvin scale.");
                break;
            default:
                System.out.println("Invalid unit of measurement");
        }
    }
}
