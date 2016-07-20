package com.leetcode.solved;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
	Map<Integer,String> mapIntVal;
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        init();
        String[] array = {"", "Thousand","Million","Billion"};
    
        int i = 0;
        String result = "";
        while(num > 0){
            if(num%1000 != 0) result = compute(num%1000).trim() + " " + array[i] + " " + result;
            num /= 1000;
            i++;
        }
        
        return result.trim();
        
    }
    private String compute(int num){
        if(num == 0) return "";
        if(num <= 20) return mapIntVal.get(num);
        if(num < 100) return mapIntVal.get(num - num%10) + " "+ compute(num%10);
        return mapIntVal.get(num/100) + " Hundred " + compute(num%100); 
    }
    private void init(){
        this.mapIntVal = new HashMap<>();
        mapIntVal.put(0,"");
        mapIntVal.put(1,"One");
        mapIntVal.put(2,"Two");
        mapIntVal.put(3,"Three");
        mapIntVal.put(4,"Four");
        mapIntVal.put(5,"Five");
        mapIntVal.put(6,"Six");
        mapIntVal.put(7,"Seven");
        mapIntVal.put(8,"Eight");
        mapIntVal.put(9,"Nine");
        mapIntVal.put(10,"Ten");
        mapIntVal.put(11,"Eleven");
        mapIntVal.put(12,"Twelve");
        mapIntVal.put(13,"Thirteen");
        mapIntVal.put(14,"Fourteen");
        mapIntVal.put(15,"Fifteen");
        mapIntVal.put(16,"Sixteen");
        mapIntVal.put(17,"Seventeen");
        mapIntVal.put(18,"Eighteen");
        mapIntVal.put(19,"Nineteen");
        mapIntVal.put(20,"Twenty");
        mapIntVal.put(30,"Thirty");
        mapIntVal.put(40,"Forty");
        mapIntVal.put(50,"Fifty");
        mapIntVal.put(60,"Sixty");
        mapIntVal.put(70,"Seventy");
        mapIntVal.put(80,"Eighty");
        mapIntVal.put(90,"Ninety");
    }

}
