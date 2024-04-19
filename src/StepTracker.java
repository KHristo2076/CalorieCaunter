import java.util.ArrayList;
import java.util.HashMap;


class StepTracker {
    HashMap<String, ArrayList<Integer>> stepCount;
    ArrayList<Integer> calendar;
    int stepsPerDay;
    int targetStepCount;

    StepTracker() {
        stepCount = new HashMap<>();
        stepsPerDay = 0;
        targetStepCount = 10_000;
        stepCount.put("January", initArraylist());
        stepCount.put("February", initArraylist());
        stepCount.put("March", initArraylist());
        stepCount.put("April", initArraylist());
        stepCount.put("May", initArraylist());
        stepCount.put("June", initArraylist());
        stepCount.put("July", initArraylist());
        stepCount.put("August", initArraylist());
        stepCount.put("September", initArraylist());
        stepCount.put("October", initArraylist());
        stepCount.put("November", initArraylist());
        stepCount.put("December", initArraylist());
    }

    private ArrayList<Integer> initArraylist() {
        calendar = new ArrayList<>();
        for (int i = 0; i < 30; i++) calendar.add(stepsPerDay);

        return calendar;

    }
    public void saveStep(String month, int day, int step){
        if (step < 0) {
            System.out.println("The number of steps must be non-negative");
            return;
        }
        if (day <1 || day > 31){
            System.out.println("The day must be between 1 and 31");
            return;
        }
        if (stepCount.containsKey(month)) {
            stepCount.get(month).set((day - 1),step);
            System.out.println("Saved the data");
        }
        else System.out.println("The name of month" + month + " does not exist");

    }
    public void printStatistic(String month){
        int totalSumSteps = 0;
        int maxSteps = 0;
        int dayOfMaxSteps = 0;
        int bestSeries = 0;
        int tmpCurrentSeries = 0;
        if (stepCount.containsKey(month)){
            for (int i = 0; i < calendar.size();i++){
                int step = stepCount.get(month).get(i);
                if(i!=29)System.out.print((i + 1) + " day: " + step + ", ");

                else System.out.println((i + 1) + "day:" + step + "\n");

                totalSumSteps+=step;

                if  (step > maxSteps){
                    maxSteps = step;
                    dayOfMaxSteps = i + 1;
                }
                if (step > targetStepCount) tmpCurrentSeries++;
                else{
                    bestSeries = Math.max(bestSeries,tmpCurrentSeries);
                    tmpCurrentSeries = 0;
                }
            }
            int avgStep = totalSumSteps / calendar.size();
            System.out.println("Summary steps in the month: " + totalSumSteps);
            System.out.println("Max just did steps - " + maxSteps + "in this day" + dayOfMaxSteps);
            System.out.println("Average steps in day: " + avgStep);
            Converter.convert(totalSumSteps);
            System.out.println("The best series: " + bestSeries + " day");
        }
        else System.out.println("The name of month is not exist");
    }
    void changePurposeOfDailySteps(int targetStepsCount){
        if(targetStepsCount < 0) System.out.println("The entered value must not be negative");
        else {
            this.targetStepCount = targetStepsCount;
            System.out.println("Your data is saved!");
        }

    }
}

