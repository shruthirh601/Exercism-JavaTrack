import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Etl {
    Map<String,Integer> result = new HashMap<>();
    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        for(Map.Entry<Integer, List<String>> entry : old.entrySet()){
            int key = entry.getKey();
            List<String> value = entry.getValue();
            for(String s : value){
                result.put(s.toLowerCase(), key);
            }
        }
        return result;
    }
}
