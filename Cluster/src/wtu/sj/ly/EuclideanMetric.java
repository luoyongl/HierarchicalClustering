package wtu.sj.ly;

import java.util.List;

public class EuclideanMetric {	
	public static double sim_distance(List<Double> vector1, List<Double>vector2) {
		double distance = 0;
		if (vector1.size() == vector2.size()) {
			for (int i = 0; i < vector1.size(); i++) {
				double temp = Math.pow((vector1.get(i) - vector2.get(i)), 2);
				distance += temp;
			}
			distance = Math.sqrt(distance);
		}
		return distance;
	}
}
