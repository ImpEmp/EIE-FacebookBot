import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;

public class hostile_detect {

public int is_subject(String text){

	//1 faceboot
	//2 twitter
    //3 is mentioned but not tagged
	String[] words = text.split("\\W+");
	for ( String ss : words) {
		if(ss =="aEnoughisEnough101") {
			return 1;
			}
		if(ss =="aeietweets") {
			return 2;
			}
		if(ss =="EIE") {
		return 3;
		}
	  }
	return 0;
}

public static String leetspeekremover(String input) {
 

    // remove leetspeak
    input = input.replaceAll("1","i");
    input = input.replaceAll("!","i");
    input = input.replaceAll("3","e");
    input = input.replaceAll("4","a");
    input = input.replaceAll("@","a");
    input = input.replaceAll("5","s");
    input = input.replaceAll("7","t");
    input = input.replaceAll("0","o");
    input = input.replaceAll("9","g");
return input;
    }



public static int countWord(String wordwew) throws FileNotFoundException {
    String path = ""; //ADD YOUR PATH HERE
    String fileName = "badwords_en_US.txt";
    String testWord = wordwew; //CHANGE THIS IF YOU WANT
    int tLen = testWord.length();
    int wordCntr = 0;
    String file = path + fileName;
    boolean check;

    try{
        FileInputStream fstream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;        
        //Read File Line By Line
        while((strLine = br.readLine()) != null){                
            //check to see whether testWord occurs at least once in the line of text
            check = strLine.toLowerCase().equals(testWord.toLowerCase());
            if(check){                    
                //get the line, and parse its words into a String array
                String[] lineWords = strLine.split("\\s+");                    
                for(String w : lineWords){
                    //first see if the word is as least as long as the testWord
                    if(w.length() >= tLen){
                        String word = w.substring(0,tLen).trim();                                                        
                        if(word.equalsIgnoreCase(testWord)){                                
                            wordCntr++;
                        }                            
                    }
                }                    
            }   
        }            
        System.out.println("total is: " + wordCntr);
    //Close the input stream
    br.close();
    } catch(Exception e){
        e.printStackTrace();
    }

return wordCntr;
}

public static String filterText(String input) throws FileNotFoundException {
	int y = 0;
	int zz= 0;
	Boolean bad = false;
	input = leetspeekremover(input);
	String[] words = input.split("\\W+");
	for ( String ss : words) {
		y = countWord(ss);
		
		if(y>0){
		System.out.println(ss);
		zz++;
		bad = true;
		
		}
	  }
	
    if(bad == true)
        return "blocked";
    
    return "good";
}
public static int hostile_detecor(String ss){
	//https://tone-analyzer-demo.mybluemix.net/
	ToneAnalyzer service = new ToneAnalyzer("2016-05-19");
	service.setUsernameAndPassword("14f012a4-89f6-440f-ae4b-f1a9c039ec41", "kDFVlplsmKVG");
	return 1;
	
}

public static String filterTextext(String input) throws FileNotFoundException {
	int y = 0;
	int zz= 0;
	Boolean bad = false;
	input = leetspeekremover(input);
	String[] words = input.split("\\W+");
	for ( String ss : words) {
		y = countWord(ss);
		y = hostile_detecor(ss);
		if(y>0){
			 if(bad == true)
			        return "blocked for use of "+ ss;
		System.out.println(ss);
		zz++;
		bad = true;
		
		}
	  }
	
   
    
    return "good";
}
public Boolean facebookban(String text){
	return null;
	
}
public Boolean generalban(String input) throws FileNotFoundException{
	if(filterText(input)=="good"){
    return false;
	}
	else{
	return true;
	}
}
}

