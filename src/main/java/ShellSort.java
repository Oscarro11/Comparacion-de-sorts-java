public class ShellSort{
    public static void ShellSort (int[] estructura){
       int n = estructura.Length;
       for (int gap = n/2; gap > 0; gap /= 2){
        for (int i = gap; i < n; i += 1){
            int temp = estructura[i];
            int j = i;
            while ( j >= gap && estructura[j - gap] > temp){
                estructura[j] = estructura[j - gap];
                j -= gap;
            }
            estructura[j] = temp;
            
        }
       } 
    }
}