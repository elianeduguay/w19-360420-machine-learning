
import javax.xml.crypto.Data;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;



public class kNNMain{

	public static void main(String... args) throws FileNotFoundException{

		// TASK 1: Use command line arguments to point DataSet.readDataSet method to
		// the desired file. Choose a given DataPoint, and print its features and label

		String file = args[0];






		//TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
		int runsOfTheModel = 1000;
		double [] accuracy = new double [runsOfTheModel];
		for (int m = 0; m < runsOfTheModel; m++)
		{

			List<DataPoint> data = DataSet.readDataSet(file);
			//DataSet.printDataSet(data);
			List<DataPoint> datatest = DataSet.getTestSet(data, 3/10.);
			List<DataPoint> datatrain = DataSet.getTrainingSet(data, 7/10.);
			//DataSet.printLabelFrequencies(data);

			// TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)


			// TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
			// and returns the Euclidean distance between those two points (as a double)



			// TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
			// and make a print a predicted target label


			int k = 1;
			KNNClassifier classifier = new KNNClassifier(k);
			for(int i = 0; i < datatrain.size(); i++)
			{
				DataPoint [] neighbors = classifier.getNearestNeighbors(datatrain, datatrain.get(i));
				for (int j = 0; j < neighbors.length; j++) {
					String pred = classifier.predict(Arrays.asList(neighbors), neighbors[j]);
					//System.out.println(pred);
				}
			}





			// TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
			// point based on nearest neighbors in training set. Calculate accuracy of model.

			double nbGoodPreds = 0;
			for (int i = 0; i < datatest.size(); i++) {
				DataPoint [] neighbors = classifier.getNearestNeighbors(datatrain, datatest.get(i));
				for (int j = 0; j < neighbors.length; j++) {
					String pred = classifier.predict(Arrays.asList(neighbors), neighbors[j]);
					if (pred.equals(datatest.get(i).getLabel())) {
						nbGoodPreds++;
					}
/*
					System.out.println("======================");
					System.out.println(pred);
					System.out.println(datatest.get(i).getLabel());
					System.out.println(pred.equals(datatest.get(i).getLabel()));*/
				}
			}
			accuracy[m] = Math.round(nbGoodPreds / datatest.size() * 10000)/100.;
			System.out.println("Accuracy: " + accuracy[m] + "%");
		}
		double mean = mean(accuracy);
		System.out.println("The mean is: " + mean);
		System.out.println("The standard deviation is: " + std(accuracy, mean));

	}

	public static double mean(double[] values) {
		double total = 0;
		for (int i = 0; i < values.length; i++) {
			total += values[i];
		}
		return total / values.length;
	}

	public static double std(double[] values, double mean) {
		double series = 0;
		for (int i = 0; i < values.length; i++) {
			series += Math.pow(values[i] - mean, 2);
		}
		return Math.sqrt((1./values.length) * series);
	}

}
