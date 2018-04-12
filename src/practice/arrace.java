package practice;

import java.util.ArrayList;
import java.util.Random;

public class arrace {
	public static void main(String[] args) {
		arrace race = new arrace();
		race.runner();
	}

	int total1 = 0;
	int total2 = 0;
	boolean done = false;
	boolean a1 = true;
	Random rand = new Random();
	ArrayList<Integer> one = new ArrayList<Integer>();
	ArrayList<Integer> two = new ArrayList<Integer>();

	void runner() {

		while (!done) {
			if (a1) {
				int random1 = rand.nextInt(100);
				total1 = total1 + rand.nextInt(100);
				one.add(random1);
				if (total1 > 1000) {
					done = true;
				}
			} else {
				int random2 = rand.nextInt(100);
				total2 = total2 + rand.nextInt(100);
				two.add(random2);
				if (total2 > 1000) {
					done = true;
				}
			}
			a1 = !a1;
		}
		if (total1 > 1000) {
			System.out.println("Array 1 won!");
			for (int i = 0; i < one.size(); i++) {
				System.out.println(one.get(i));
			}
			System.out.println(total1);
		} 
		if (total2 > 1000) {
			System.out.println("Array 2 won!");
			for (int j = 0; j < two.size(); j++) {
				System.out.println(two.get(j));
			}
			System.out.println(total2);
		}
	}
}
