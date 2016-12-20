This is a sample Eclipse (and Maven) project for creating a new weighting model and proximity feature in Terrier.

In your coursework, following the coursework specification, you will be expected to edit/make new version of `src/main/java/uk/ac/gla/dcs/models/MyWeightingModel.java` and `src/main/java/uk/ac/gla/dcs/dsms/SampleProxFeatureDSM.java`. You should also edit the corresponding unit tests to ensure your implementations work as expected.

## Compilation

From the command line, in this directory, type:
	
	mvn package

This will create a jar file at `target/ircourse-1.0-SNAPSHOT.jar`

## Testing

Unit tests are provided for both weighting model and proximity feature DSM. Unit tests are run automatically using `mvn package`. You can skip unit testing usign `mvn -DskipTests package`.

## Usage in Terrier

You can use classes from your project in Terrier by manually adding the generate Jar file to Terrier's classpath. To do this, firstly switch (e.g. `cd`) back to the terrier-core directory, and then alter the CLASSPATH environment variable, before running `trec_terrier.sh`:

	CLASSPATH=/path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar bin/trec_terrier.sh -r
	
For instance, to use your new weighting model, specify the name of the class to the trec.model property:

	CLASSPATH=/path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar bin/trec_terrier.sh -r -Dtrec.model=uk.ac.gla.dcs.models.MyWeightingModel
