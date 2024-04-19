import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        System.out.println("Добро пожаловать в \"Calorie Counter\".");

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            String month = "";

            switch (command) {
                case (1):
                    System.out.println("Enter the nam of month in format: \"January\", \" February\" ");
                    month = scanner.next();
                    System.out.println("Enter the number of day from 1 to 30.");
                    int day = scanner.nextInt();
                    System.out.println("Enter the number of steps completed.");
                    int steps = scanner.nextInt();
                    stepTracker.saveStep(month, day, steps);
                    break;

                case (2) :
                    System.out.println("Enter the nam of month in format: \"January\", \" February\"");
                    month = scanner.next();
                    stepTracker.printStatistic(month);
                    break;
                case (3) :
                    System.out.println("Enter the required number of steps");
                    int targetStepsCount = scanner.nextInt();
                    stepTracker.changePurposeOfDailySteps(targetStepsCount);
                    break;
                case (0) :
                    break;
                default:
                    System.out.println("Sorry, there is no such team yet.");
                    break;
            }
        }
    }

    // Печать меню приложения
    public static void printMenu() {
        System.out.println("What do you want to do? " +
                "Enter the number corresponding to the menu item");
        System.out.println("1 - Enter the number of steps for a certain day");
        System.out.println("2 - Print statistics for a specific month");
        System.out.println("3 - Change the goal by the number of steps per day");
        System.out.println("0 - Exit the application");
    }
}