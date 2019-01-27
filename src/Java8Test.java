import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class Java8Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] test = {"scsd","scsdc"};
		
		
		Collection<String> arrayList = new ArrayList<>();
		arrayList.add("aaaa");
		arrayList.add("bbbb");
		
		Optional<String> findFirst = arrayList.stream().findFirst();
		System.out.println(findFirst.get());
		
		Optional<String> findFirst2 = arrayList.stream().findFirst();
		System.out.println(findFirst2.get());
		
		
		
		
		
	}

}
