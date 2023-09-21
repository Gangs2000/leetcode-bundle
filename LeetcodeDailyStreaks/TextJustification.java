package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TextJustification {
    int index=0, currentStringLength=0;
    List<String> resultList, tempList;     
    public TextJustification(){
        resultList=new LinkedList<>();
        tempList=new LinkedList<>();        
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        while(index<words.length){
            if(currentStringLength+words[index].length()<=maxWidth){
                currentStringLength+=words[index].length();
                tempList.add(words[index]);     
                index++;                                                          
            }            
            else {
                justifyTheStrings(tempList, currentStringLength, maxWidth);                            
                tempList.clear(); currentStringLength=0;
            }                
        }        
        justifyLastLine(tempList, currentStringLength, maxWidth);
        return resultList;
    }
    public void justifyLastLine(List<String> tempList, int currentStringLength, int maxWidth){
        int requiredSpace=maxWidth-currentStringLength;
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<tempList.size();i++){
            stringBuilder.append(tempList.get(i));
            stringBuilder.append(" ");
            requiredSpace--;
        }
        char[] spaces=new char[requiredSpace];
        Arrays.fill(spaces,' ');
        stringBuilder.append(String.valueOf(spaces));
        resultList.add(stringBuilder.toString());
    }
    public void justifyTheStrings(List<String> tempList, int currentStringLength, int maxWidth){        
        int requiredSpace=tempList.size()-1, reminingSpace=maxWidth-currentStringLength;
        if(requiredSpace>reminingSpace){
            currentStringLength-=tempList.get(tempList.size()-1).length();
            tempList.remove(tempList.size()-1);
            index--;
            justifyTheStrings(tempList, currentStringLength, maxWidth);
        }
        else{
            char[] spaces;
            StringBuilder stringBuilder=new StringBuilder();
            //Checking if space can be evenly seggregated..
            if(tempList.size()==1){
                stringBuilder.append(tempList.get(0));
                spaces=new char[reminingSpace];
                Arrays.fill(spaces, ' ');
                stringBuilder.append(String.valueOf(spaces));
            }
            else if(reminingSpace%requiredSpace==0){
                int spaceCount=reminingSpace/requiredSpace;                
                for(int i=0;i<tempList.size()-1;i++){
                    //Adding characters
                    stringBuilder.append(tempList.get(i));                                     
                    //Adding spaces
                    spaces=new char[spaceCount];
                    Arrays.fill(spaces, ' ');
                    stringBuilder.append(String.valueOf(spaces));
                }
                //Adding final text to the stringBuilder
                stringBuilder.append(tempList.get(tempList.size()-1));
            }
            else{                
                int spaceCount=2;//reminingSpace-requiredSpace;
                for(int i=0;i<tempList.size()-1;i++){                   
                    if(reminingSpace>=spaceCount){ 
                        //Adding characters
                        stringBuilder.append(tempList.get(i));
                        //Adding spaces
                        spaces=new char[spaceCount];
                        Arrays.fill(spaces, ' ');
                        stringBuilder.append(String.valueOf(spaces));
                        reminingSpace-=spaceCount;                    
                    }
                    else{
                        stringBuilder.append(tempList.get(i));
                        spaces=new char[reminingSpace];
                        Arrays.fill(spaces, ' ');
                        stringBuilder.append(String.valueOf(spaces));                        
                    }
                }
                //Adding final text to the stringBuilder
                stringBuilder.append(tempList.get(tempList.size()-1));
            }
            resultList.add(stringBuilder.toString());
        }
    }
    public static void main(String[] args){
        Scanner sc;
        String[] words;
        try{            
            sc=new Scanner(System.in);
            System.out.println("Enter length of words array : ");
            int length=sc.nextInt();
            words=new String[length];
            for(int i=0;i<length;i++)
                words[i]=sc.useDelimiter("\n").next();
            System.out.println("Enter MaxWidth value : ");
            int maxWidth=sc.nextInt();
            System.out.println(new TextJustification().fullJustify(words, maxWidth));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.getMessage();
        }
    }
}
