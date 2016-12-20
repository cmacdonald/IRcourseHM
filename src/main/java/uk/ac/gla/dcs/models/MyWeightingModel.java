package uk.ac.gla.dcs.models;

import org.terrier.matching.models.WeightingModel;

/** Instantiate this class for your weighting model. You can tell Terrier to use this class
  * by specifying trec.model=uk.ac.gla.dcs.models.MyWeightingModel
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
   		//termFrequency (The term frequency in the collection)
   		//numberOfDocuments (The number of documents in the collection)
   		//numberOfTokens (the total length of all documents in the collection)

		return 0d;
	}

	public double score(double tf, double docLength, double n_t, double F_t, double _keyFrequency) {
		throw new UnsupportedOperationException();
	}
}
