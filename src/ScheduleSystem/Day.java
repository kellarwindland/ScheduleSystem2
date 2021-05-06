package ScheduleSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day {

    private int hours;
    private Map<String, List<Employee>> schedule;

    private Map<Employee, Integer> totalHours;

    private int numberInMonth;
    static int counter = 1;

    public Day(){
        numberInMonth = counter;
        counter++;
        hours = 5;
        schedule = new HashMap<>();
        totalHours = new HashMap<>();
    }

    public boolean addEmployeeToSchedule(String time, Employee employee){
        List<Employee> temp;
        if(schedule.containsKey(time)){
            temp = schedule.get(time);

            if((time.startsWith("10") || time.startsWith("4")) && temp.size() == 2){
                return false;
            }else if((time.startsWith("3") || time.startsWith("5")) && temp.size() == 1){
                return false;
            }

        }else{
            temp = new ArrayList<>();
        }
        temp.add(employee);
        schedule.put(time, temp);

        String[] nums = time.split("-");
        int totalHoursTemp = Math.abs(Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]));

        if(totalHours.containsKey(employee)){
            int currentHours = totalHours.get(employee);
            currentHours += totalHoursTemp;
            totalHours.put(employee, currentHours);
        }else{
            totalHours.put(employee, totalHoursTemp);
        }

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

    public void reset(){
        schedule = new HashMap<>();
        totalHours = new HashMap<>();
    }

    public int getNumberInMonth(){
        return numberInMonth;
    }

    public Map<Employee, Integer> getTotalHours(){
        return totalHours;
    }

}
