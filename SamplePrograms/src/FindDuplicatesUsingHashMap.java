import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesUsingHashMap {
	public static void main(String[] args) {
		int[] array= {4334,534,21,67,21};
		
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		for (Integer i : array) {
			if (map.get(i)==null) {
				map.put(i, 1);
			}
			else {
				map.put(i, map.get(i)+1);
			}
		}
		
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			System.out.println(m.getKey()+"-> "+m.getValue());
		}
	}
}
