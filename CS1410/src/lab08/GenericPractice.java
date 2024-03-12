package lab08;

import java.util.ArrayList;

public class GenericPractice {

	public static void main(String[] args) {
		Pair<String, String> stringPair = new Pair<String, String>("Hi", "there");
		System.out.println(stringPair);

		ArrayList<String> stringList = new ArrayList<String>();
		stringList.add("CS");
		stringList.add("1410");
		System.out.println(stringList);
		System.out.println(stringList.indexOf("1410"));
		
		ArrayList<Pair<String, String>> pairList = new ArrayList<Pair<String, String>>();
		pairList.add(new Pair<String, String>("CS", "1410"));
		pairList.add(new Pair<String, String>("CS", "1410"));
		System.out.println(pairList);
		
		pairList.remove(stringPair);
		pairList.remove(new Pair<String, String>("CS", "1410"));
		System.out.println(pairList);
	}
}
