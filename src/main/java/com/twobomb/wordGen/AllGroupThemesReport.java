package com.twobomb.wordGen;

import java.util.ArrayList;
import java.util.List;

public class AllGroupThemesReport implements WordGenValues {
    String[][] student_name = {{"Студент 1","Студент 2"},{"Студент 3","Студент 4","Студент 5"}};
    String[][] adviser_teacher_name= {{"Вася Пупкин(adv)","John Doe(adv)"},{"Вася Пупкин1(adv)",null,"Genry Smith(adv)"}};
    String[][] head_teacher_name= {{"Вася Пупкин(head)","John Doe(head)"},{"Вася Пупкин1(head)","John Doe2(head)","Genry Smith(head)"}};
    String[][] student_theme= {{"Тема 1 azaazaz","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi "},{"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ","Lorem ipsum dolor sit amet, consectetur adipiscing elit, ","WTF???"}};
    String[] code_group = {"01.01.9999","23.444.333"};
    String[] group_name = {"Программная инженерия","Системный анализ"};
    public AllGroupThemesReport() {

    }

    @Override
    public String getValue(String code) {
        return null;
    }

    @Override
    public String getValue(String code, List<Integer> indexes) {
        switch (code){
            case "student_name": return (indexes.get(1)+1)+".\t"+student_name[indexes.get(0)][indexes.get(1)];
            case "student_theme": return student_theme[indexes.get(0)][indexes.get(1)];
            case "head_teacher_name": return head_teacher_name[indexes.get(0)][indexes.get(1)];
            case "adviser_teacher_name": return adviser_teacher_name[indexes.get(0)][indexes.get(1)];
            case "code_group": return code_group[indexes.get(0)];
            case "group_name": return group_name[indexes.get(0)];
        }
        return null;
    }

    @Override
    public int getCount(String list_id) {
        switch (list_id){
            case "0": return  code_group.length;
        }
        return 0;
    }

    @Override
    public int getCount(String list_id, List<Integer> indexes) {
        switch (list_id){
            case "00": return  student_name[indexes.get(0)].length;
        }
        return 0;
    }
}
