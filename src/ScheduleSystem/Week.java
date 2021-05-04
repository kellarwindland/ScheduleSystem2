package ScheduleSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week {

    private int hours;
    private List<Day> days;


    public Week(){
        days = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            days.add(new Day());
        }
        hours = 41;
    }

    public String getTotalHours(){
        StringBuilder result = new StringBuilder();

        Map<Employee, Integer> totalHours = new HashMap<>();

        for(Day day : days){

            for(Map.Entry<Employee, Integer> entry : day.getTotalHours().entrySet()){
                if(totalHours.containsKey(entry.getKey())){
                    int currentHours = totalHours.get(entry.getKey());
                    currentHours += entry.getValue();
                    totalHours.put(entry.getKey(), currentHours);
                }else{
                    totalHours.put(entry.getKey(), entry.getValue());
                }
            }
        }

        for(Map.Entry<Employee, Integer> entry : totalHours.entrySet()){
                result.append(entry.getKey().getName()).append(": ");
                result.append(entry.getValue());
                result.append("\n");
        }

        return result.toString();
    }

    public boolean moreWorkHours(){
        return hours < 41;
    }

    public List<Day> getDays(){
        return days;
    }

}
