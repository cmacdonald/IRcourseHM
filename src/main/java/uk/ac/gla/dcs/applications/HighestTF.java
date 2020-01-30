package uk.ac.gla.dcs.applications;

import org.terrier.applications.CLITool;
import org.terrier.structures.Index;
import org.terrier.terms.PorterStemmer;

/**
 * This is a template class for the first lab, for identifying the document with the highest term
 * frequency for a given term. To run this class:
 *  - ensure that you have run the "mvn install" command for this project
 *  - add terrier.mvn.coords=uk.ac.gla.dcs:ircourse:1.0-SNAPSHOT to the terrier.properties file
 *  - run bin/terrier highest-tf
 */
public class HighestTF extends CLITool {

    @Override
    public int run(String[] args) throws Exception {

        if (args.length != 1) {
            System.err.println("Usage: " + this.commandname() + " term");
            System.err.println(this.helpsummary());
            return -1;
        }
        String term = args[0];
        term = new PorterStemmer().stem(term);
        

        Index index = Index.createIndex();

        String docno = "TODO";
        // TODO: tell us the docno of the document that
        // has the highest term frequency for the specified term
        // You may refer to a useful part of the Terrier documentation
        // https://github.com/terrier-org/terrier-core/blob/5.x/doc/extend_retrieval.md#using-terrier-indices-in-your-own-code

        System.out.println(docno);
        
        //leave this is as.
        return 0;
    }

    @Override
    public String commandname() {
        return "highest-tf";
    }

    @Override
    public String sourcepackage() {
        return "IRcourseHM";
    }

	@Override
	public String helpsummary() {
		return "identifies the document with highest tf for given term";
	}
    
}