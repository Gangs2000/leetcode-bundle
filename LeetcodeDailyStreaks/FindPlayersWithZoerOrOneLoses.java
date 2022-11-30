package LeetcodeDailyStreaks;

import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindPlayersWithZoerOrOneLoses {
    List<List<Integer>> output;    
    Map<Integer, Integer> winnerMap,loserMap;    
    public FindPlayersWithZoerOrOneLoses(){
        winnerMap=new TreeMap<>();
        loserMap=new TreeMap<>();
        output=new LinkedList<>();
    }
    public List<List<Integer>> findWinners(int[][] matches) {
        for(int i=0;i<matches.length;i++){
            this.validateWinners(matches[i][0]);
            this.validateLosers(matches[i][1]);                                                            
        }              
        output.add(winnerMap.keySet().stream().collect(Collectors.toList()));
        output.add(loserMap.keySet().stream().filter(key->(loserMap.get(key)==1)).collect(Collectors.toList()));
        return output;        
    }
    public void validateWinners(int winner){        
        if(loserMap.size()==0)
            winnerMap.put(winner, 1);
        else if(!loserMap.containsKey(winner) && !winnerMap.containsKey(winner))
            winnerMap.put(winner, 1);          
    }
    public void validateLosers(int loser){        
        if(winnerMap.containsKey(loser))
            winnerMap.remove(loser);    
        if(loserMap.containsKey(loser))
            loserMap.put(loser, loserMap.get(loser)+1);                                
        else
            loserMap.put(loser, 1);                                  
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] matches;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of rows : ");
            int rows=sc.nextInt();
            matches=new int[rows][2];
            for(int i=0;i<rows;i++){
                for(int j=0;j<2;j++){
                    matches[i][j]=sc.nextInt();
                }
            }
            System.out.println(new FindPlayersWithZoerOrOneLoses().findWinners(matches));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

