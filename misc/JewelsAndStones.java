import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        int jewelsCount=0;
        for(int i=0;i<jewels.length();i++){
            int count=1;
            if(map.containsKey(jewels.charAt(i))){
                count = map.get(jewels.charAt(i))+1;
            }
            map.put(jewels.charAt(i),count);
        }
        for(int i=0;i<stones.length();i++){
            if(map.containsKey(stones.charAt(i))){
                jewelsCount += 1;
            }
        }
        return jewelsCount;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));

    }
}
