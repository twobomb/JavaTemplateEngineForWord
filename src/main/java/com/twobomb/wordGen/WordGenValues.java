package com.twobomb.wordGen;

import java.util.List;

public interface WordGenValues {

    public String getValue(String code);//Вернуть значение по коду (одиночное)
    public String getValue(String code, List<Integer> indexes);//Вернуть значение по коду(для листов), передается индекс массива
    public int getCount(String list_id);//Вернуть кол-во элементов в обычном листе
    public int getCount(String list_id, List<Integer> indexes);//Вернуть кол-во элементов в вложенном листе, передаются индексы родителей

}
