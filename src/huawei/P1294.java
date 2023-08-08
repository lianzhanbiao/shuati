package huawei;

import java.util.*;

public class P1294 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        int m = in.nextInt();
        List<Integer> list = new ArrayList<>();
        while(in.hasNextInt())  list.add(in.nextInt());
        int s = list.size();
        Collections.sort(list);
        boolean flag = true;
        if(list.get(0) - r > 0 || list.get(s-1)+r < n) flag = false;
        int count = 0;
        int [][] arr = new int [s][2];
        for(int i = 0; i < s; i++){
            arr[i][0] = list.get(i) - r;
            arr[i][1] = list.get(i) + r;
        }
        int a = 0;
        for(int i = 0; i < s; i++){
            if(i != s-1 && arr[i][0] <= a && arr[i+1][0] > a){
                count++;
                a = arr[i][1];
                if(a >= n) break;
            }
            if(i == s-1){
                if(arr[i][0]<=a && arr[i][1]>=n)
                    count++;
                else flag = false;
            }
        }
        if(!flag) System.out.println("-1");
        else System.out.println(count * m);

    }
}
