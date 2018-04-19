package practice;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashMap;

public class AnimalHipster {

	public AbstractCollection<String> findAnimalHipsters(HashMap<String, ArrayList<String>> network,
			HashMap<String, String> favoriteAnimals) {
		ArrayList<String> hipsters = new ArrayList<String>();
		for (String s : network.keySet()) {
			if (network.get(s).isEmpty()) {
				hipsters.add(s);
			}
			for (String f : network.get(s)) {
				if (favoriteAnimals.get(f).equals(s)) {

				} else {
					if (hipsters.contains(s)) {

					} else {
						hipsters.add(s);
					}
				}
			}
		}
		return hipsters;
	}

}
