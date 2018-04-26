package practice;

import java.util.ArrayList;

public class OncogeneDetector {
	boolean ans;
	int healthy;
	double hp;
	int cancer;
	double cp;
	public boolean isOncogene(ArrayList<String> healthySequences, ArrayList<String> cancerSequences, String string) {
		for (int i = 0; i < healthySequences.size(); i++) {
			if (healthySequences.get(i).contains(string)) {
				healthy += 1;
			}
		}
		for (int i = 0; i < cancerSequences.size(); i++) {
			if (cancerSequences.get(i).contains(string)) {
				cancer += 1;
			}
		}
		hp = (double) healthy / (double) healthySequences.size();
		cp = (double) cancer / (double) cancerSequences.size();
		if (cp > hp) {
			ans = true;
			
		} else if (hp > cp) {
			ans = false;
		}

		return ans;
	}
}
