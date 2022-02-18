import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BingWatching {
    public static float findMinimumDays(List<Float> durations) {
        // Write your code here
        Collections.sort(durations);
        // float currSum = 0;
        int day = 0;
        // int i =0, k=0;
        // float maxSum = 0;
        // while (i<durations.size()) {
        //     currSum += durations.get(i);

        //     if(currSum <= 3.00){

        //         maxSum = Math.max(maxSum, currSum);
        //     }
        //     while(currSum + durations.get(i)>3.00 ){
        //         currSum =0;
        //         day+=1;
        //     }
        //     i++;
        // }
       
        for(int i=0;i<durations.size();i++){
            float prevSum = durations.get(i);
            float currSum = 0;

            for(int j=1;j<durations.size();j++){
                currSum = durations.get(i)+durations.get(j);
                if(currSum<3.00){
                    prevSum = Math.max(prevSum, currSum);

                    day+=1;
                    break;
                    
                }
            }
        }
        return day;
    }

    public static void main(String[] args) {
        List<Float> lf = new ArrayList<>();
        // lf.add(1.01f);
        // lf.add(1.91f);
        // lf.add(1.32f);
        // lf.add(1.4f);
        lf.add(1.01f);
        lf.add(1.01f);
        lf.add(1.01f);
        lf.add(1.4f);
        lf.add(2.4f);
        
        System.out.println(findMinimumDays(lf));
    }
}
