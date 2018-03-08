package com.twobomb.wordGen;

import jdk.nashorn.tools.Shell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.impl.store.Cursor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTPImpl;
import sun.awt.shell.Win32ShellFolderManager2;
import sun.security.action.OpenFileInputStreamAction;

import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.twobomb.wordGen.App.q;

//Добавить нумерация, переносы,необяхательные, сохранение, в getBlock проверка синтаксиса (закрывающая есть\нет)
public class WordController {
    private String input;
    private String output;

    public WordController(String inputPattern, String output){
        this.input = inputPattern;
        this.output = output;
    }
    public void convert(WordGenValues dataHandler) throws Exception {
        XWPFDocument doc = read();
        Unit u = Unit.Instance(getText(doc));
        List<Unit> ll = u.getChildren();
        for (Unit z:ll)
            replace(doc, z.getTextblock(), z.getText(dataHandler));
        write(u.getText(dataHandler),doc);
        doc.close();
    }
    private XWPFDocument read() throws IOException, InvalidFormatException {
        FileInputStream fis = new FileInputStream(input);
        XWPFDocument doc = new XWPFDocument(OPCPackage.open(fis));
        fis.close();
        return doc;
    }

    private void setStyle(XWPFParagraph p){
        p.setAlignment(ParagraphAlignment.BOTH);//по ширине
        p.setFirstLineIndent(711);// первая строка отступ 1,25 см
        p.setSpacingBetween(1f,LineSpacingRule.AUTO);//Междустрочный одинарный

        p.setSpacingLineRule(LineSpacingRule.AUTO);
        p.setIndentFromRight(0);
        p.setIndentFromLeft(0);
        p.setIndentationLeft(0);
        p.setIndentationRight(0);
        //p.setIndentationHanging(0);
        p.setSpacingAfter(0);
        p.setSpacingBeforeLines(0);
        p.setSpacingBefore(0);
        p.setSpacingAfterLines(0);

    }
    private void replace(XWPFDocument doc, String oldValue, String newValue) {
        String str = "";
        int ss = -1;
        for (int i = 0; i < doc.getParagraphs().size(); i++) {
            XWPFParagraph par = doc.getParagraphs().get(i);
            str+=par.getText() + "\n";
            if(ss == -1)
                ss = i;
            if(Unit.getCountDuplicate(str,"\\$") % 2 == 0 || Unit.getCountDuplicate(str,"\\$") == 0){
                if(str.contains(oldValue)){
                    List<XWPFParagraph> parToDelete = new ArrayList<XWPFParagraph>();

                    for(int j = ss; j <= i ; j++)
                        parToDelete.add(doc.getParagraphs().get(j));

                    XmlCursor cur = parToDelete.get(0).getCTP().newCursor();


                    for(XWPFParagraph del:parToDelete) {
                        doc.removeBodyElement(doc.getPosOfParagraph(del));
                    }
                    str = str.replaceFirst(Unit.addSlashes(oldValue),newValue);
                    XWPFRun run = null;
                    XWPFParagraph p = null;
                        for (int k = 0; k < str.length(); k++) {
                            if(k == 0) {
                                p = doc.insertNewParagraph(cur);
                                setStyle(p);
                                run= p.createRun();

                            }
                            switch (str.charAt(k)) {
                                case '\t':
                                    q("\t");
                                    run.addTab();
                                    break;
                                case '\n':
                                    if(k == str.length()-1)
                                        return;
                                    q("\n");
                                    //run.addCarriageReturn();
                                    //Старим курсор в конец певого параграфа или в начало следующего
                                    if(doc.getParagraphs().indexOf(p) != -1 && doc.getParagraphs().indexOf(p)+1 < doc.getParagraphs().size()) {
                                        cur = doc.getParagraphs().get(doc.getParagraphs().indexOf(p) + 1).getCTP().newCursor();
                                        p = doc.insertNewParagraph(cur);
                                    }
                                    else {
                                        p = doc.createParagraph();
                                    }

                                    setStyle(p);
                                    run= p.createRun();
                                    break;
                                default:
                                    q(String.valueOf(str.charAt(k)));
                                    run.setText(String.valueOf(str.charAt(k)));
                            }

                            run.setFontSize(14);
                            run.setFontFamily("Times New Roman");
                        }



                    return;
                }
                else{
                    ss = -1;
                    str = "";
                }
            }

        }
    }

    private String getText(XWPFDocument doc){
        String str = "";
        for(XWPFParagraph p :doc.getParagraphs()) {
            str += p.getText()+ "\n";
        }
        return str;
    }
    private void write(String str,XWPFDocument doc) throws IOException {

        FileOutputStream fos = new FileOutputStream(new File(output));
        doc.write(fos);
        fos.close();
        Desktop.getDesktop().open(new File(output));

    }
}