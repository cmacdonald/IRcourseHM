This is a sample Eclipse (and Maven) project for creating a new weighting model and proximity feature in Terrier.

In your coursework, following the coursework specification, you will be expected to edit/make new version of `src/main/java/uk/ac/gla/dcs/models/MyWeightingModel.java` and `src/main/java/uk/ac/gla/dcs/dsms/SampleProxFeatureDSM.java`

## Compilation

From the command line:
	
	mvn package

This will create a jar file in `target/`

## Testing

Unit tests are provided for both weighting model and proximity feature DSM.

## Usage in Terrier

You can use classes in your project by manually adding it to Terrier's classpath:

	CLASSPATH=/path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar bin/trec_terrier.sh -r

For instance, to use your new weighting model, specify the name of the class to the trec.model property:

	CLASSPATH=/path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar bin/trec_terrier.sh -r -Dtrec.model=uk.ac.gla.dcs.models.MyWeightingModel
