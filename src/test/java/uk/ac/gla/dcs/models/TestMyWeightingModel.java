package uk.ac.gla.dcs.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.terrier.indexing.IndexTestUtils;
import org.terrier.matching.MatchingQueryTerms;
import org.terrier.matching.matchops.SingleTermOp;
import org.terrier.matching.models.WeightingModel;
import org.terrier.querying.ManagerFactory;
import org.terrier.querying.Request;
import org.terrier.querying.SearchRequest;
import org.terrier.querying.parser.Query.QTPBuilder;
import org.terrier.structures.Index;
import org.terrier.structures.postings.BasicPostingImpl;
import org.terrier.tests.ApplicationSetupBasedTest;
import org.terrier.utility.ApplicationSetup;

public class TestMyWeightingModel extends ApplicationSetupBasedTest {
	@Test @SuppressWarnings("serial")
	public void testModel() throws Exception {
		// no stemming or stopwords
		ApplicationSetup.setProperty("termpipelines", "");
		// make an index with a two sample documents
		Index index = IndexTestUtils.makeIndex(new String[] { "doc1", "doc2", "doc3" },
				new String[] { "The quick brown fox jumps over the lazy dog",
						"Exploring the zoo, we saw every kangaroo jump and quite a few carried babies.",
						"Sneaky white tiger creeps up on a visitor at a zoo before launching a lightning attack" });

		WeightingModel wm = new MyWeightingModel();
		wm.setCollectionStatistics(index.getCollectionStatistics());
		// double check: our index has two documents
		assertEquals(3, index.getCollectionStatistics().getNumberOfDocuments());

		//build up a mocked query of one term, "jumps"
		SearchRequest srq = ManagerFactory.from(index.getIndexRef()).newSearchRequestFromQuery("jumps");
		((Request)srq).setMatchingQueryTerms(new MatchingQueryTerms());
		((Request)srq).getMatchingQueryTerms().add(QTPBuilder.of(new SingleTermOp("jumps")).setWeight(1d).build());

		// what score would your weighting model give to the term 'jumps',
		// if it occurred once in a document with total length 5?
		wm.setEntryStatistics(index.getLexicon().getLexiconEntry("jumps"));
		wm.setKeyFrequency(1.0d);
		wm.prepare();
		wm.setRequest((Request)srq);
		double score = wm.score(new BasicPostingImpl(1, 1) {
			public int getDocumentLength() { return 5; }
		});
		System.out.println(score);
		//TODO: make your assertion about what the score should be
		//assertEquals(XXX, score, 0.0d);
	}
}
