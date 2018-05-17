package practice;

import java.util.ArrayList;

public class LearningArrayLists {

	public static Object createArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		return list;
	}

	public static void addToArrayList(ArrayList testList, String string) {
		testList.add(string);
	}

	public static Object getNumberOfItems(ArrayList testList) {
		return testList.size();
	}

	public static String getItem(ArrayList testList, int i) {
		return testList.get(1) + "";
	}

	public static String iterateOver(ArrayList testList) {
		return testList.get(0) + "" + testList.get(1) + "" + testList.get(2);
	}

	public static int findItemOnList(ArrayList testList, String string) {
		int number;
		int i = 0;
		while (!testList.get(i).equals(string)) {
			i++;
		}
		return i;
	}

	public static void replaceItem(ArrayList testList, int i, String string) {
		testList.set(i, string);
	}

	public static void insertItem(ArrayList testList, int i, String string) {
		testList.add(i, string);
	}

	public static ArrayList<Integer> createTypedArrayList() {
		return new ArrayList<Integer>();
	}

	public static Object addAllInteger(ArrayList<Integer> testList) {
		return testList.get(0) + testList.get(1) + testList.get(2);
	}

	public static ArrayList<String> createStringTypedArrayList() {
		return new ArrayList<String>();
	}

	public static String addAllString(ArrayList<String> testList) {
		return testList.get(0) + "" + testList.get(1) + "" + testList.get(2);
	}

}
