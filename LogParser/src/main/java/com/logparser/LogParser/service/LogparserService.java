package com.logparser.LogParser.service;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class LogparserService {

    public  void PopulateRetreievedData(String path) throws IOException {
        ArrayList lstArray;
        lstArray = new ArrayList();
        lstArray.add("[api-gateway");
        lstArray.add("ffd3082fe09d");
        FileReader fr = null;
        try {
            //fr = new FileReader("C:\\RAQA-Deploy\\logfile.txt.rtf");
            fr = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader (fr);
        //PopulateRetreievedData prd = new PopulateRetreievedData();
        int count = 0;
        int count1=0;
        Iterator it = lstArray.iterator();
        HashMap map = new HashMap();
        while(it.hasNext()) {
            String str = (String) it.next();
            String line = br.readLine();
            while (line != null) {
                String []parts = line.split(" ");
               // String []parts = line.split("");
                List temp= Arrays.asList(parts);
                if(temp.contains(str) && temp.contains("[error]")) {
                    count++;
                    System.out.println("Error :"+temp);
                }
               /* for( String w : parts)
                {
                    if(w.contains(str) && w.contains("error"))
                        count++;
                }*/
                line = br.readLine();
            }
            System.out.println(str +" : "+count);

        }

    }
}
