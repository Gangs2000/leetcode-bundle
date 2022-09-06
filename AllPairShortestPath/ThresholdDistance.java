import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
class ThresholdDistance
{
    int weightTable[][],maxThreshold;
    ThresholdDistance(int nodes,int maxThreshold)
    {
        this.maxThreshold=maxThreshold;   
        weightTable=new int[nodes][nodes];
        for(int i=0;i<nodes;i++)
        {
            for(int j=0;j<nodes;j++)
            {
                if(i==j)
                    weightTable[i][j]=0;                         //Initializing diagonal values as 0's
            }
        }
    }
    private void markWeights(int edges[][],int nodes,int threshold)
    {
        for(int i=0;i<weightTable.length-1;i++)                   //Stroing weight of each path in WeightTable
        {
            for(int j=(i+1);j<weightTable[i].length;j++)
            {
                if(i!=j)                                          //Ignoring diagonal values, as they have been already initialized
                {
                    boolean flag=true;
                    for(int k=0;k<edges.length;k++)
                    {
                        if(edges[k][0]==i && edges[k][1]==j)      //Checking if path exists or not
                        {
                            flag=false;
                            weightTable[i][j]=edges[k][2];        //Store weight if path is found
                            weightTable[j][i]=edges[k][2];
                            break;
                        }             
                    }
                    if(flag)
                    {
                        weightTable[i][j]=maxThreshold;          //Store max threshold value if path not found
                        weightTable[j][i]=maxThreshold;
                    }
                }
            }
        }
        //Calling method to find all pair shorest path
        floydWarshell(nodes,threshold);
    }
    private void floydWarshell(int nodes,int threshold)                                    //Floyd Warshell Algorithm
    {
        for(int pivot=0;pivot<nodes;pivot++)                                               //Iteration for each pivot value
        {
            for(int i=0;i<weightTable.length-1;i++)                                        //Weight Table row
            {
                for(int j=(i+1);j<weightTable[i].length;j++)                               //Weight Table column
                {
                    if(!(i==pivot || j==pivot))                                            //If row or column not matches pivot values then it executes upcoming statements
                    {
                        if((weightTable[i][pivot]+weightTable[pivot][j])<weightTable[i][j]) 
                        {
                            weightTable[i][j]=weightTable[i][pivot]+weightTable[pivot][j];      //If sum of nodes is smaller then current value, then replace it 
                            weightTable[j][i]=weightTable[i][pivot]+weightTable[pivot][j];
                        }
                    }
                }
            }
        }
        //Calling method to find out Threshold values
        minumumThreshold(threshold);
    }
    private void minumumThreshold(int threshold)
    {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<weightTable.length;i++)
        {
            for(int j=0;j<weightTable[i].length;j++)
            {
                if(weightTable[i][j]>0 && weightTable[i][j]<=threshold) 
                    count++;
            }   
            hm.put(i,count);                                                //Storing all nodes threshold values in HashMap
            count=0;
        }
        int cityWithGreatestNumber=0,cities=hm.get(0);
        for(Map.Entry<Integer,Integer> entry:hm.entrySet())
        {
            if((int) entry.getKey()>=cityWithGreatestNumber && (int) entry.getValue()<=cities)       
            {                                                              //Saving highest key with minimum cities
                cityWithGreatestNumber=(int) entry.getKey();
                cities=(int) entry.getValue();
            }
        }
        System.out.println("City With the Smallest Number of Neighbors at a Threshold Distance "+cityWithGreatestNumber);
    }
    public static void main(String[] args)
    {
        Scanner sc;
        int row=0,nodes=0,threshold=0,maxValue=0,edges[][];
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter number of nodes : ");
            nodes=sc.nextInt();
            if(!(nodes>=2 && nodes<=100))
                throw new Exception("Nodes value must be in the range between 2 and 100..");
            System.out.println("Enter number of rows : ");
            row=sc.nextInt();
            edges=new int[row][3];
            for(int i=0;i<row;i++)
            {
                for(int j=0;j<edges[i].length;j++)
                {
                    if(j==0 || j==1)
                    {
                        int value=sc.nextInt();
                        if(value>=0 && value<nodes)
                            edges[i][j]=value;
                        else
                            throw new Exception("Value must be in the range between "+0+" "+(nodes-1));
                    }
                    else
                    {
                        int weight=sc.nextInt();
                        maxValue+=weight;
                        edges[i][j]=weight;
                    }
                }
            }
            System.out.println("Enter threshold value to find minumum distance : ");
            threshold=sc.nextInt();
            new ThresholdDistance(nodes,maxValue).markWeights(edges,nodes,threshold);
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}