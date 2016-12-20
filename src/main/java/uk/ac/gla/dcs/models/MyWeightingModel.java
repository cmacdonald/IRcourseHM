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
		return 0d;
	}

	public double score(double tf, double docLength, double n_t, double F_t, double _keyFrequency) {
		throw new UnsupportedOperationException();
	}
}
