package com.springapp.mvc;

import java.util.*;

/**
 * Created by eamonn on 15/07/2016.
 */
public class RoughWork {

    public static void main(String[] args){
        //Note about arrays they are fixed size (here is 10)
        List<String> arrayOfStrings = new ArrayList<String>();
        arrayOfStrings.add("eamonn"); //0
        arrayOfStrings.add("winters");//1

        List<String> listOfStrings = new ArrayList<String>();
        listOfStrings.add("eamonn");
        listOfStrings.add("winters");

        //set has no order and only holds unique objects
        Set<String> setOfStrings = new HashSet<String>();
        setOfStrings.addAll(arrayOfStrings);
        System.out.println("Size of set after adding array"+setOfStrings.size());
        setOfStrings.addAll(listOfStrings);
        System.out.println("Size of set after adding list"+setOfStrings.size());

        Map<String,Integer> ageMap = new HashMap<String, Integer>();
        ageMap.put("eamonn",33);
        ageMap.put("winters",18);

        System.out.println("The age of eamonn is"+ageMap.get("eamonn"));



    }
}
