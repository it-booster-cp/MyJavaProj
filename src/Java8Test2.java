import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class Java8Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Collection<String> arrayList = new ArrayList<>();
		
		arrayList.add("aaaa");
		arrayList.add("bbbb");
		arrayList.add("cccc");
		arrayList.add("dddd");
		
		
		StringBuffer stringBuffer = new StringBuffer();
		
		final int[] i = {0};
		arrayList.forEach(path -> {
		i[0]++;
		
		//stringBuffer.append(path);
		if(arrayList.size() > i[0]){
			//stringBuffer.append(" & ");
		}
		});
		
		//System.out.println(stringBuffer.toString());
		
		
		AtomicInteger index = new AtomicInteger(0);
		arrayList.stream().forEach(path ->{
			index.getAndIncrement();
			stringBuffer.append(path);
			if(index.get() < arrayList.size()) stringBuffer.append(" & ");
		});
		
		System.out.println(stringBuffer.toString());

	}

}
