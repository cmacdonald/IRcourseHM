package uk.ac.gla.dcs.models;

import org.terrier.matching.models.WeightingModel;
import org.terrier.structures.postings.Posting;

/** You should use this sample class to implement a Simple TF*IDF weighting model for Exercise 1
  * of the exercise. You can tell Terrier to use your weighting model by specifying the 
  * -w commandline option, or the property trec.model=uk.ac.gla.dcs.models.MyWeightingModel.
  * NB: There is a corresponding unit test that you should also complete to test your model.
  * @author TODO
  */
public class MyWeightingModel extends WeightingModel
{
	private static final long serialVersionUID = 1L;

	public String getInfo() { return this.getClass().getSimpleName(); }
	
	boolean init = false;
	
	//init() will NOT be needed in your Simple TF*IDF implementation but 
	//will be needed for your vector space model implementation
	
	void init() {
		//you may complete any initialisation code here.
		//you may assume access to 
		//averageDocumentLength (numberOfTokens /numberOfDocuments )
   		//keyFrequency (The frequency of the term in the query)
   		//documentFrequency (The document frequency of the term in the collection)
   		//termFrequency (The frequency of the term in the collection)
   		//numberOfDocuments (The number of documents in the collection)
		//numberOfTokens (the total length of all documents in the collection)

		//rq.getIndex() (the underlying Index)

		//rq.getMatchingQuery Terms() (the MatchingQueryTerms object, 
		//which is the system's low level representation of the query)
		
		//Terrier will only have one index loaded at the once time, so
		//to share variables between weighting model instances, use static variables
		init = true;
	}

	@Override
	public double score(Posting p) {
		if (! init)
			init();

		double tf = p.getFrequency();
		double docLength = p.getDocumentLength();
		//you should implement this method to return a score for a term occurring tf times in a document of docLength tokens.

		//you may assume access to the following member variables of the superclass:
		//averageDocumentLength (numberOfTokens /numberOfDocuments )
   		//keyFrequency (The frequency of the term in the query)
   		//documentFrequency (The document frequency of the term in the collection)
   		//termFrequency (The frequency of the term in the collection)
   		//numberOfDocuments (The number of documents in the collection)
		//numberOfTokens (the total length of all documents in the collection)
		//as well as any member variables you create   


		return 0d;
	}

	@Override
	public double score(double tf, double docLength) {
		throw new UnsupportedOperationException("other method is in use");
	}

}
