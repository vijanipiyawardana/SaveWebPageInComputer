package savewebpage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SaveWebpage {

    public static void main(String[] args) {
        File dir = new File("/home/vijani/Desktop/");
        String str = "data.html";
        URL url;
        InputStream inputStream = null;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        String line;
        ArrayList<String> list = new ArrayList<String>();
        String[] splitStr; 
        try {
            url = new URL("https://www.tutorialspoint.com/artificial_intelligence/artificial_intelligence_natural_language_processing.htm");
            inputStream = url.openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedWriter = new BufferedWriter(new FileWriter(new File(dir, str)));
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                
                splitStr = line.split(" ");
                for(int i=0; i<splitStr.length; i++){
                    list.add(splitStr[i]);
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
               // sentence.concat(line);
            }
            
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : list) {
            if (wordCount.containsKey(word)) {
                // Map already contains the word key. Just increment it's count by 1
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                // Map doesn't have mapping for word. Add one with count = 1
                wordCount.put(word, 1);
            }
        }
        for (Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("Count of : " + "\"" +  entry.getKey() + "\""
                    + " in sentence = " + entry.getValue());
        }
    }

}
