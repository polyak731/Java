package exceptionTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnsupportedOpExcept {

	public static void main(String args[]){
		List<String> list = Collections.unmodifiableList(new ArrayList<String>());
		list.add("Hello");
	}
}
