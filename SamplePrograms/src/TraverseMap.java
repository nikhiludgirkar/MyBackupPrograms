import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TraverseMap {
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("nikhil", "udgirkar");
		
//		Set<?> set=map.entrySet();
//		Iterator<?> i=set.iterator();
		
		for (Map.Entry<String, String> entry : map.entrySet())
			System.out.println(entry.getKey());
		
/*		while (i.hasNext()) {
			Map.Entry me=(Map.Entry)i.next();
			System.out.println(me.getKey());
			System.out.println(me.getValue());
		}
*/	}
}
