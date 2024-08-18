import java.util.Scanner;
public class gas {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stations:");
        int no_station = sc.nextInt();
        int gas[] = new int[no_station];
        int cost[] = new int[no_station];
        System.out.println("Enter the gas station values:");
        for(int i = 0 ; i<no_station; i++)
        gas[i]= sc.nextInt();
        System.out.println("Enter the cost values:");
        for(int i = 0 ; i<no_station; i++)
        cost[i]= sc.nextInt();
        int net = 0, flag = 0,count=0;
        for (int st=0;count<no_station && st<no_station;){
            net = net + gas[st] - cost[st];
            if(net<=0){
                System.out.println(" cannot start at "+ st);
                st++;
                net=0;
                if(flag >= 1)
                {
                    count++;
                }
                System.out.println(" count "+ count);
                flag=flag-1;
            }
            else{
            flag++;
            count++;
            System.out.println(" fuel remaining at "+ st+ " is "+net);
            System.out.println(" count "+ count);
            st++;
        }
        if(flag >= 1 && st >= no_station) {
            st=0;
        } 
    }
        if(flag <= 0){
            System.out.println("Not possible to start at any station ");
        }
        else{
            System.out.println("successfully travelled. The remaining cost is "+ net);
        }

sc.close();
}}
