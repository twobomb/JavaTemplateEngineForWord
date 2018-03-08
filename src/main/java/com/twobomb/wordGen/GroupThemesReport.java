package com.twobomb.wordGen;

import java.util.ArrayList;
import java.util.List;

public class GroupThemesReport implements WordGenValues {
    List<String> student_name = new ArrayList<String>();
    List<String> student_theme = new ArrayList<String>();
    List<String> adviser_teacher_name = new ArrayList<String>();
    List<String> head_teacher_name = new ArrayList<String>();
    String code_group = "666";
    String group_name = "4ПИ";

    public GroupThemesReport() {
        student_name.add("Вася Пупкин");
        student_name.add("John Doe");
        student_name.add("Тестер");
        student_name.add("Тестер");

        adviser_teacher_name.add("помощник Вася Пупкин");
        adviser_teacher_name.add("помощник John Doe");
        adviser_teacher_name.add(null);
        adviser_teacher_name.add("помощник Тестер");

        head_teacher_name.add("главный Вася Пупкин");
        head_teacher_name.add("главный John Doe");
        head_teacher_name.add("главный Тестер");
        head_teacher_name.add("главный Тестер");

        student_theme.add("Тема лалаалл");
        student_theme.add("Тема oefkwpkfopwk");
        student_theme.add("Тема йцуцйуцйуцй");
        student_theme.add("Тема 123");

    }

    @Override
    public String getValue(String code) {
        switch (code){
            case "code_group":return code_group;
            case "group_name":return group_name;
        }
        return null;
    }

    @Override
    public String getValue(String code, List<Integer> indexes) {
        switch (code){
            case "student_name": return (indexes.get(0)+1)+".\t"+student_name.get(indexes.get(0));
            case "student_theme": return student_theme.get(indexes.get(0));
            case "head_teacher_name": return head_teacher_name.get(indexes.get(0));
            case "adviser_teacher_name": return adviser_teacher_name.get(indexes.get(0));
        }
        return null;
    }

    @Override
    public int getCount(String list_id) {
        switch (list_id){
            case "0": return  student_name.size();
        }
        return 0;
    }

    @Override
    public int getCount(String list_id, List<Integer> indexes) {
        return 0;
    }
}
