package GUI;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class Util {
	
	public static void shuffleArray(int[] array) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : array) {
			list.add(i);
		}

		Collections.shuffle(list);

		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
	}

}
