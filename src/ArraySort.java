import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ArraySort implements Comparator<ProduktXXX>{
	 
    @Override
    public int compare(ProduktXXX e1, ProduktXXX e2) {
        if(e1.getProdukt() == e2.getProdukt()){
            return 1;
        } else {
            return -1;
        }
    }

}

