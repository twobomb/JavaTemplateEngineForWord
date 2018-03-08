package com.twobomb.wordGen;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.util.ArrayList;
import java.util.List;

public class App {
        public static void main(String[] args) throws Exception {

            WordController wc = new WordController("C:\\Users\\twobomb\\Desktop\\ШАБЛОН_1ГРУППА.docx","C:\\Users\\twobomb\\Desktop\\ВЫХОД.docx");
            wc.convert(new GroupThemesReport());

/*
            WordController wc = new WordController("C:\\Users\\twobomb\\Desktop\\ШАБЛОН_ВСЕ_ГРУППЫ.docx","C:\\Users\\twobomb\\Desktop\\ВЫХОД1.docx");
            wc.convert(new AllGroupThemesReport());
*/



        }

}
