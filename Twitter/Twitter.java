package Twitter;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Twitter {
    Map<Integer,List<Integer>> followersRecord;
    List<List<Integer>> tweetsRecord;
    public Twitter(){
        tweetsRecord=new LinkedList<>();
        followersRecord=new LinkedHashMap<>();
    }
    public void postTweet(int userId, int tweetId) {
        tweetsRecord.add(List.of(userId,tweetId));
    }
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feeds=new LinkedList<>();
        if(followersRecord.containsKey(userId)){
            List<Integer> followers=followersRecord.get(userId);
            feeds=tweetsRecord.stream().filter(list->followers.contains(list.get(0)) || list.get(0)==userId).map(list->list.get(1)).collect(Collectors.toList());
        }
        else
            feeds=tweetsRecord.stream().filter(list->list.get(0)==userId).map(list->list.get(1)).collect(Collectors.toList());
        Collections.reverse(feeds);
        feeds=feeds.stream().limit(10).collect(Collectors.toList());
        return feeds;
    }
    public void follow(int followerId, int followeeId) {
        if(!followersRecord.containsKey(followerId))
            followersRecord.put(followerId, List.of(followeeId));
        else{
            List<Integer> fetchFollowers=followersRecord.get(followerId);
            List<Integer> followers=new LinkedList<>();
            for(int i=0;i<fetchFollowers.size();i++)
                followers.add(fetchFollowers.get(i));
            followers.add(followeeId);
        }
    }
    public void unfollow(int followerId, int followeeId) {
        if(followersRecord.containsKey(followerId)){
            List<Integer> fetchFollowers=followersRecord.get(followerId);
            List<Integer> followers=new LinkedList<>();
            for(int i=0;i<fetchFollowers.size();i++)
                followers.add(fetchFollowers.get(i));
            followers.remove((Object) followeeId);
            if(followers.size()==0)
                followersRecord.remove(followerId);
            else
                followersRecord.replace(followerId, followers);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<List<Integer>> input,output;
        List<String> labels;
        try{
            System.out.println("Enter length of the list : ");
            input=new LinkedList<>();
            output=new LinkedList<>();
            labels=new LinkedList<>();
            int length=sc.nextInt();
            labels.add("Twitter");
            input.add(List.of());
            for(int i=1;i<length;i++){
                System.out.println("Enter label name : ");
                String label=sc.next();
                labels.add(label);
                if(label.equals("getNewsFeed")){
                    System.out.println("Enter account ID : ");
                    input.add(List.of(sc.nextInt()));
                }
                else if(label.equals("follow") || label.equals("unfollow")){
                    System.out.println("Enter follower and followee account ID to follow/unfollow : ");
                    input.add(List.of(sc.nextInt(),sc.nextInt()));
                }
                else if(label.equals("postTweet")){
                    System.out.println("Enter account ID and Tweet ID : ");
                    input.add(List.of(sc.nextInt(),sc.nextInt()));
                }
            }
            System.out.println(labels+" "+input);
            Twitter object=new Twitter();
            output.add(null);
            for(int i=1;i<labels.size();i++){
                if(labels.get(i).equals("postTweet")){
                    object.postTweet(input.get(i).get(0), input.get(i).get(1));
                    output.add(null);
                }
                else if(labels.get(i).equals("getNewsFeed"))
                    output.add(object.getNewsFeed(input.get(i).get(0)));
                else if(labels.get(i).equals("follow") || labels.get(i).equals("unfollow")){
                    if(labels.get(i).equals("follow"))
                        object.follow(input.get(i).get(0), input.get(i).get(1));
                    else
                        object.unfollow(input.get(i).get(0), input.get(i).get(1));
                    output.add(null);
                }
            }
            System.out.println(output);
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

