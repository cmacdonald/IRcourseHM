package uk.ac.gla.dcs.dsms;

import static org.junit.Assert.*;
import org.junit.Test;

import org.terrier.tests.ApplicationSetupBasedTest;
import org.terrier.indexing.IndexTestUtils;
import org.terrier.utility.ApplicationSetup;
import org.terrier.structures.Index;
import org.terrier.structures.postings.IterablePosting;

import uk.ac.gla.dcs.dsms.SampleProxFeatureDSM;

public class TestSampleProxFeatureDSM extends ApplicationSetupBasedTest
{
	@Test public void testOneDocTwoTerms() throws Exception {

		//make an index with a single sample document
		ApplicationSetup.setProperty("termpipelines", "");
		Index index = IndexTestUtils.makeIndexBlocks(
				new String[]{"doc1"}, 
				new String[]{"The quick brown fox jumps over the lazy dog"});

		//get posting iterators for two terms
		IterablePosting[] ips = new IterablePosting[2];
		ips[0] = index.getInvertedIndex().getPostings(index.getLexicon().getLexiconEntry("fox"));
		ips[1] = index.getInvertedIndex().getPostings(index.getLexicon().getLexiconEntry("jumps"));
		ips[0].next();
		ips[1].next();
		assertEquals(0, ips[0].getId());
		assertEquals(0, ips[1].getId());

		SampleProxFeatureDSM sample = new SampleProxFeatureDSM();
		double score = sample.calculateDependence(
            ips, //posting lists
            new boolean[]{true,true},  //is this posting list on the correct document?
            new double[]{1d,1d}, false//doesnt matter
		);
		//TODO: check your score is correct
	}
}
