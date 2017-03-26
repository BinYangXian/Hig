package com.cdsxt.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AA {
	/** 
     * 统计各个单词出现的次数 
     * @param text 
     */  
    public static void findEnglishNum(String text){  
        //找出所有的单词  
        String[] array = {".", " ", "?", "!"};  
        for (int i = 0; i < array.length; i++) {  
            text = text.replace(array[i],",");  
        }  
        String[] textArray = text.split(",");  
          
        //遍历 记录  
        Map<String, Integer> map = new HashMap<String, Integer>();  
        for (int i = 0; i < textArray.length; i++) {  
            String key = textArray[i];  
            //转为小写  
            String key_l = key.toLowerCase();  
            if(!"".equals(key_l)){  
                Integer num = map.get(key_l);  
                if(num == null || num == 0){  
                    map.put(key_l, 1);  
                }else if(num > 0){  
                    map.put(key_l, num+1);  
                }  
            }  
        }  
        //输出到控制台  
        System.out.println("各个单词出现的频率为：");  
        Iterator<String> iter = map.keySet().iterator();  
        while(iter.hasNext()){  
            String key = iter.next();  
            Integer num = map.get(key);  
            System.out.println(key + "\n\t\t" + num + "次\n-------------------");  
        }  
    }
}
