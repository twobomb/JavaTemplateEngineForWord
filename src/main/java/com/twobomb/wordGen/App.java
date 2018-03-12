package com.twobomb.wordGen;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
        public static void main(String[] args) throws Exception {
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("code_group","33.55.66");
            map.put("group_name","4PI");

            List<String> name = new ArrayList<String>();
            name.add("1.\tВася Пупкин");
            name.add("2.\tJohn Doe");
            List<String> theme   = new ArrayList<String>();
            theme.add("Lorem ipsum....");
            theme.add("Test");
            List<String> head_teacher_name = new ArrayList<String>();
            head_teacher_name.add("Вася Пупкин head");
            head_teacher_name.add("John Doe head");
            List<String> adviser_teacher_name = new ArrayList<String>();
            adviser_teacher_name.add("Вася Пупкин adviser");
            adviser_teacher_name.add("John Doe adviser");

            map.put("student_name",name);
            map.put("student_theme",theme);
            map.put("head_teacher_name",head_teacher_name);
            map.put("adviser_teacher_name",adviser_teacher_name);


            WordController wc = new WordController("C:\\Users\\twobomb\\Desktop\\ШАБЛОН_1ГРУППА.docx","C:\\Users\\twobomb\\Desktop\\ВЫХОД.docx");
            wc.convert(map);

/*
            HashMap<String,Object> map = new HashMap<String,Object>();

            List<String> groupname  = new ArrayList<>();
            groupname.add("4ПИ");
            groupname.add("4СА");

            List<String> groupcode  = new ArrayList<>();
            groupcode.add("666");
            groupcode.add("33.22.11");

            List<String> students4pi  = new ArrayList<>();
            students4pi.add("1.\tВася пупкин");
            students4pi.add("2.\tJohn Doe");

            List<String> students4sa  = new ArrayList<>();
            students4sa.add("1.\tВася пупкин СА");
            students4sa.add("2.\tJohn Doe СА");
            students4sa.add("3.\tТестер");

            List<List<String>> students  = new ArrayList<>();
            students.add(students4pi);
            students.add(students4sa);

            List<String> head4pi  = new ArrayList<>();
            head4pi.add("Вася пупкин head");
            head4pi.add("John Doe head");

            List<String> head4sa  = new ArrayList<>();
            head4sa.add("Вася пупкин СА head");
            head4sa.add("John Doe СА head");
            head4sa.add("Тестер head");

            List<List<String>> heads  = new ArrayList<>();
            heads.add(head4pi);
            heads.add(head4sa);

            List<String> adv4pi  = new ArrayList<>();
            adv4pi.add("Вася пупкин adv");
            adv4pi.add("John Doe adv");

            List<String> adv4sa  = new ArrayList<>();
            adv4sa.add("Вася пупкин СА adv");
            adv4sa.add("");
            adv4sa.add("Тестер adv");
            List<List<String>> advs  = new ArrayList<>();
            advs.add(adv4pi);
            advs.add(adv4sa);

            List<String> themes4pi  = new ArrayList<>();
            themes4pi.add("Lorem 123");
            themes4pi.add("Тема 2");

            List<String> themes4sa  = new ArrayList<>();
            themes4sa.add("Тема 1 йцуцйу");
            themes4sa.add("Тема 2");
            themes4sa.add("Тема 3 тест");

            List<List<String>> themes  = new ArrayList<>();
            themes.add(themes4pi);
            themes.add(themes4sa);

            map.put("code_group",groupcode);
            map.put("group_name",groupname);
            map.put("student_name",students);
            map.put("student_theme",themes);
            map.put("head_teacher_name",heads);
            map.put("adviser_teacher_name",advs);

            WordController wc = new WordController("C:\\Users\\twobomb\\Desktop\\ШАБЛОН_ВСЕ_ГРУППЫ.docx","C:\\Users\\twobomb\\Desktop\\ВЫХОД2.docx");
            wc.convert(map);
*/


        }
}
