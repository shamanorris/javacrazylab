package IA.linearegression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearRegressionFunction implements Function<Double[], Double>{

	private final double[] thetaVector;
	
	public LinearRegressionFunction(double[] thetaVector) {
		this.thetaVector = Arrays.copyOf(thetaVector, thetaVector.length);
	}

	public Double apply(Double[] featureVector) {
		
		assert featureVector[0] == 1.0;
		
		double prediction = 0;
		for (int j = 0; j < thetaVector.length; j++)
			prediction += thetaVector[j] * featureVector[j];
		
		return prediction;
	}
	
	public double[] getThetas(){
		return Arrays.copyOf(thetaVector, thetaVector.length);
	}
	
	public static double cost(Function<Double[], Double> targetFunction, 
							List<Double[]> dataset,
							List<Double> labels){
		int m = dataset.size();
	   double sumSquaredErrors = 0;
	   for (int i = 0; i < m; i++) {
	      Double[] featureVector = dataset.get(i);
	      double predicted = targetFunction.apply(featureVector);
	      double label = labels.get(i);
	      double gap = predicted - label;
	      sumSquaredErrors += Math.pow(gap, 2);
	   }
	   return (1.0 / (2 * m)) * sumSquaredErrors;
	}
	
	public static LinearRegressionFunction train(LinearRegressionFunction targetFunction, 
												List<Double[]> dataset,
												List<Double> labels,
												double alpha){
		int m = dataset.size();
		double[] thetaVector = targetFunction.getThetas();
		double[] newThetaVector = new double[thetaVector.length]; 
		
	  for (int j = 0; j < thetaVector.length; j++) {
	      double sumErrors = 0;
	      for (int i = 0; i < m; i++) {
	         Double[] featureVector = normalize(dataset).get(i);
	         double error = targetFunction.apply(featureVector) - labels.get(i);
	         if(error < 0.001) break;
	         sumErrors += error * featureVector[j];
	      }
	      double gradient = (1.0 / m) * sumErrors;
	      newThetaVector[j] = thetaVector[j] - alpha * gradient;
	   }
	
		return new LinearRegressionFunction(newThetaVector);
	}
	
	public static List<Double[]> normalize(List<Double[]> dataset){
		List<Double[]> newList = new ArrayList<Double[]>(dataset);
		double sum = 0, min = Double.MAX_VALUE, max = Double.MIN_VALUE;
		for(int i = 0; i < dataset.size(); i++){
			double v = dataset.get(i)[1];
			sum += v;
			min = Math.min(min, v);
			max = Math.max(max, v);
		}
		double avg = sum/dataset.size();
		for(int i = 0; i < dataset.size(); i++){
			newList.get(i)[1] = (dataset.get(i)[1]-avg)/(max - min);
		}
		return newList;
	}
}
