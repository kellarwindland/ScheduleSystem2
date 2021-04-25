package ScheduleSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day {

    private int hours;
    private Map<String, List<Employee>> schedule;

    public Day(){
        hours = 5;
        schedule = new HashMap<>();
    }

    public boolean addEmployeeToSchedule(String time, Employee employee){
        List<Employee> temp;
        if(schedule.containsKey(time)){
            temp = schedule.get(time);

            if(temp.size() == 2){
                return false;
            }

        }else{
            temp = new ArrayList<>();
        }
        temp.add(employee);
        schedule.put(time, temp);

        return true;
    }

    public String getSchedule(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String,List<Employee>> entry : schedule.entrySet()){
            result.append(entry.getKey()).append(": ");

            for(Employee employee : entry.getValue()){
                result.append(employee.getName()).append(", ");
            }

            result.delete(result.length() - 2, result.length());
            result.append("\n");
        }

        return result.toString();
    }

}
