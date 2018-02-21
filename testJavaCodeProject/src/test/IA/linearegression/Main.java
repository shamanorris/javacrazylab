package test.IA.linearegression;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		double[] thetaVector = new double[] {1.004579, 2.826822};
		//double[] thetaVector = new double[] {1.0, 1.0};
		double alpha = 0.3;
		List<Double[]> featureVector = new ArrayList<>();
		List<Double> labels = new ArrayList<>();
		for(int i = 0; i < 100; i++){
			double sqr = i * 2;
			featureVector.add(new Double[]{1.0, sqr});
			labels.add(sqr);
		}
//		Double[] houseFeature1 = new Double[]{1.0, 2.0};
//		Double[] houseFeature2 = new Double[]{1.0, 3.0};
//		Double[] houseFeature3 = new Double[]{1.0, 4.0};
//		Double[] houseFeature4 = new Double[]{1.0, 5.0};
//		Double[] houseFeature5 = new Double[]{1.0, 6.0};
//		Double[] houseFeature6 = new Double[]{1.0, 7.0};
//		Double[] houseFeature7 = new Double[]{1.0, 8.0};
//		Double[] houseFeature8 = new Double[]{1.0, 9.0};
//		featureVector.add(houseFeature1);
//		featureVector.add(houseFeature2);
//		featureVector.add(houseFeature3);
//		featureVector.add(houseFeature4);
//		featureVector.add(houseFeature5);
//		featureVector.add(houseFeature6);
//		featureVector.add(houseFeature7);
//		featureVector.add(houseFeature8);
//		labels.add(4.0);
//		labels.add(9.0);
//		labels.add(16.0);
//		labels.add(25.0);
//		labels.add(36.0);
//		labels.add(49.0);
//		labels.add(64.0);
//		labels.add(81.0);

		LinearRegressionFunction h = new LinearRegressionFunction(thetaVector);
		for(int i = 0; i < 100000; i++){
			h = LinearRegressionFunction.train(h, featureVector, labels, alpha);
		}
		System.out.println(h.apply(new Double[]{1.0, 10.0 }));
	}

}
