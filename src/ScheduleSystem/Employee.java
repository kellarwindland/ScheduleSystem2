package ScheduleSystem;
import java.util.*;

public class Employee {

    private final String nameField;
    private Set<String> timesWillingToWork = new HashSet<>();
    private Set<String> daysNotWillingToWork = new HashSet<>();
    private int hours;
    private boolean worked;
    private final boolean canOpen;

    public Employee(String name, String canOpenString){
        if(canOpenString.equals("No")){
            canOpen = false;
        }else{
            canOpen = true;
        }

        nameField = name;
        hours = 0;
        worked = false;
    }

    public String getName() {
        return nameField;
    }

    public boolean canWorkWeek(){
        return hours < 25;
    }

    public boolean hasWorkedDay(){
        return worked;
    }

    public void workedDay(){
        worked = !worked;
    }

    public void newWeek(){
        hours = 0;
    }

    public void newDay(){
        worked = false;
    }

    public void adjustTotalHours(String time){
        String[] nums = time.split("-");
        hours += Math.abs(Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]));
    }

    public void setHours(Set<String> times){
        timesWillingToWork = times;
    }

    public void setDays(Set<String> days){
        daysNotWillingToWork = days;
    }

    public Set<String> getHours(){
        return timesWillingToWork;
    }

    public Set<String> getDays(){
        return daysNotWillingToWork;
    }

    public boolean getCanOpen(){
        return canOpen;
    }

    public void reset(){
        hours = 0;
        worked = false;
    }
}

