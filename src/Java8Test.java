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
		
		String[] files = new String[]{"f_00001","f_000002","sgsgs"};
		
		boolean matches = "f_000001".matches("^f_.*$");
		System.out.println("MATCHES: "+matches);
		//test
		
		StringBuffer stringBuffer = new StringBuffer();
		arrayList.forEach(ar->stringBuffer.append(ar+ " & "));
		
		System.out.println(stringBuffer.toString());
		
		
		
		
		
	}

}
