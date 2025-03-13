import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<Integer> treeSet=new TreeSet<>();
		for(int i=50;i>0;i-=2) { // i=i-2
			treeSet.add(i);
		}
		for(int j : treeSet) {
			System.out.println(j);
		}
		System.out.println(treeSet.first());
		System.out.println(treeSet.last());
		System.out.println(treeSet.lower(26));
		System.out.println(treeSet.higher(26));
		
		NavigableSet<Integer> descendingSet=treeSet.descendingSet();
		for(int k : descendingSet) {
			System.out.println(k);
		}
		
		TreeSet<Integer> treeSet2 = new TreeSet<>();
		treeSet2.add(20);
		treeSet2.add(10);
		treeSet2.add(30);
		treeSet2.add(50);
		treeSet2.add(40);

		for(int l : treeSet2) {
		    System.out.println(l);
		}

	}

}
