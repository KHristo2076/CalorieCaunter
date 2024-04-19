// Converting steps into kilometers and calories
public class Converter {
    final static double lengthStep = 0.75d;
    final static double calorieStep = 50d;

    // Converting steps into kilometers and calories
    static void convert(int steps) {
        System.out.println("Distance covered (in km): " + (steps * lengthStep / 1000));
        System.out.println("The number of calories burned: " + (steps * calorieStep / 1000));
    }
}