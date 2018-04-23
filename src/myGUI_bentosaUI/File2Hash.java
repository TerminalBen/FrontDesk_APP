package myGUI_bentosaUI;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bentolima
 */
public class File2Hash {
    
    public static HashMap file2hash() throws  IOException {
    

    BufferedReader br = new BufferedReader(new FileReader("/Users/bentolima/NetBeansProjects/GUI_bentosa/test/nomes.txt"));
    String line =  null;
    HashMap<String,String> map = new HashMap<String, String>();

    while((line=br.readLine())!=null){
        String str[] = line.split("\n");
        System.out.println (str);
        
        for(int i=0;i<str.length;i++){
            String arr[] = str[i].split(",");
            map.put(arr[0], arr[1]);
        }
    }
    System.out.println(map);
    return map;
 }
}
