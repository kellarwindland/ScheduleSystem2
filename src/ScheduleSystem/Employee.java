package ScheduleSystem;
import java.util.*;

public class Employee {

    private String nameField;
    private Map<String, Boolean> timesAvailable = new HashMap<>();
    private Set<String> timesWillingToWork = new HashSet<>();
    private int hours;
    private boolean worked;

    public Employee(String name){
        nameField = name;
        hours = 0;
        worked = false;
    }

    public String getName() {
        return nameField;
    }

//    private List<String> listHours(List<String> timeList){
//        int count = 1;
//        List<String> result = new ArrayList<>();
//
//        for (String time : times) {
//            if(!timeList.contains(time)){
//                System.out.println(count + ": " + time);
//                count++;
//                result.add(time);
//            }
//        }
//
//        return result;
//    }

//    public void hoursOff(){
//        System.out.print("Are there hours that " + nameField + " does not want to work (0 = yes 1 = no): ");
//        if(Main.in.nextInt() == 0){
//            String temp = Main.in.nextLine();
//            List<String> timeList = new ArrayList<>();
//            while(!temp.equals("done")){
//                List<String> currentTimes = listHours(timeList);
//                System.out.print("Enter the number beside the time that cannot be worked, one at a time: ");
//                timeList.add(currentTimes.get(Main.in.nextInt() - 1));
//            }
//
//            for(String time : timeList){
//                timesAvailable.put(time, false);
//            }
//        }
//    }

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

    public Set<String> getHours(){
        return timesWillingToWork;
    }
}

