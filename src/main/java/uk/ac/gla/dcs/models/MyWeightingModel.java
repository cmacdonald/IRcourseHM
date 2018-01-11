package uk.ac.gla.dcs.models;

import org.terrier.matching.models.WeightingModel;

/** You should use this sample class to implement a Simple TF*IDF weighting model for Exercise 1
  * of the exercise. You can tell Terrier to use your weighting model by specifying the 
  * property trec.model=uk.ac.gla.dcs.models.MyWeightingModel
  * NB: There is a corresponding unit test that you should also complete to test your model.
  * @author TODO
  */
public class MyWeightingModel extends WeightingModel
{
	public String getInfo() { return this.getClass().getSimpleName(); }
	
	public double score(double tf, double docLength) {
		//you should implement this method to return a score for a term occurring tf times in a document of docLength tokens.

		//you may assume access to the following member variables of the superclass:
		//averageDocumentLength (numberOfTokens /numberOfDocuments )
   		//keyFrequency (The frequency of the term in the query)
   		//documentFrequency (The document frequency of the term in the collection)
   		//termFrequency (The frequency of the term in the collection)
   		//numberOfDocuments (The number of documents in the collection)
   		//numberOfTokens (the total length of all documents in the collection)

		return 0d;
	}

	/** This method is not required, and you are not expected to implement it */
	public double score(double tf, double docLength, double n_t, double F_t, double _keyFrequency) {
		throw new UnsupportedOperationException();
	}
}
