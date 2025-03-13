import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		//key, value 모두 String
		Map<String,String> colors = new HashMap<String,String>();
		colors.put("red", "#ff0000");
		colors.put("green", "#00ff00");
		colors.put("blue", "#0000ff");
		System.out.println(colors.get("red"));
		System.out.println(colors.get("green"));
		System.out.println(colors.get("blue"));
		
		Set<String> keySet = colors.keySet();
		for(String s : keySet) {
//			System.out.println(s);
			System.out.println(colors.get(s));
		}
	}

}
