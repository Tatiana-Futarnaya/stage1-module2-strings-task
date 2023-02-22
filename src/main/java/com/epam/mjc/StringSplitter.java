package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;


public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> list=new ArrayList<>();
        String str="";

        for (String item:delimiters.toString().split("[, ]")) {
            str=str+item;
        }

        StringTokenizer st1 = new StringTokenizer(source, str);
        while (st1.hasMoreTokens()) {
            list.add(st1.nextToken());
        }

        if(list==null){
            throw new UnsupportedOperationException("You should implement this method.");
        }
       return list;
    }
}
