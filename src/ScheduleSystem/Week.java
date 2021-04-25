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

    public boolean moreWorkHours(){
        return hours < 41;
    }

    public List<Day> getDays(){
        return days;
    }

}
