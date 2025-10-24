import java.util.Scanner;

public class lostnum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        if (n >= 2 && n <= (2*Math.pow(10, 5))){
            int[] nums = new int[n];
        int[] contains = new int[n-1];
        for (int i=1; i<=n; i++){
            nums[i-1] = i;


        }
        for (int i=0; i<n-1; i++){
            int num = scn.nextInt();
            for (int j=0; j<n; j++){
                if (num == nums[j]){
                    contains[i] = num;
                  
                }
            }
            
            
        }
        for (int i=1; i<=n; i++){
            int flag = 0;
            for (int j=0; j<n-1; j++){
                if (i == contains[j]){
                    flag = 1;
                }
                
                
            }
            if (flag == 0){
                System.out.println(i);
                break;
            }
        }

        }
        

        
        
    }
}

    
