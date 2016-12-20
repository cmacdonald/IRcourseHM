This is a sample Eclipse (and Maven) project for creating a new weighting model and proximity feature in Terrier.

## Compilation

From the command line:
	
	mvn package

This will create a jar file in `target/`

## Testing

Unit tests are provided for both weighting model and proximity feature DSM.

## Usage in Terrier

You can use your new weighting model with Terrier by manually adding it to Terrier's classpath:

	CLASSPATH=/path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar bin/trec_terrier.sh -r

