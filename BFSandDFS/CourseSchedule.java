import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CourseSchedule {
    Map<Integer, List<Integer>> adjMap;
    boolean[] visited, cycleDetection;
    public CourseSchedule(){
        adjMap=new HashMap<>();
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        findAdjElements(prerequisites);
        visited=new boolean[numCourses];
        cycleDetection=new boolean[numCourses];
        Arrays.fill(visited, false);
        Arrays.fill(cycleDetection, false);
        for(Map.Entry<Integer, List<Integer>> entry : adjMap.entrySet()){
            int key=(int) entry.getKey();
            if(!visited[key] && isCycleFormedByGraph(key, adjMap, visited, cycleDetection))               
                return false; 
        }
        return true;
    }
    public boolean isCycleFormedByGraph(int node, Map<Integer, List<Integer>> adjMap, boolean[] visited, boolean[] cycleDetection){
        visited[node]=true;
        cycleDetection[node]=true;
        if(adjMap.containsKey(node)){
            for(int child : adjMap.get(node)){
                if(!visited[child] && isCycleFormedByGraph(child, adjMap, visited, cycleDetection))
                    return true;
                else if(cycleDetection[child])
                    return true;
            }
        }
        cycleDetection[node]=false;
        return false;
    }
    public void findAdjElements(int[][] preRequisites){
        for(int i=0;i<preRequisites.length;i++){
            adjMap.putIfAbsent(preRequisites[i][1], new LinkedList<>());
            List<Integer> list=adjMap.get(preRequisites[i][1]);
            list.add(preRequisites[i][0]);
            adjMap.put(preRequisites[i][1], list);
        }
    }
    public static void main(String[] args){        
        Scanner sc;
        int[][] preRequisites;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter numCourses : ");
            int numCourses=sc.nextInt();
            System.out.println("Enter length of pre-requisties array : ");
            int length=sc.nextInt();
            preRequisites=new int[length][2];
            for(int i=0;i<length;i++){
                preRequisites[i][0]=sc.nextInt();
                preRequisites[i][1]=sc.nextInt();
            }
            System.out.println(new CourseSchedule().canFinish(numCourses, preRequisites));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
