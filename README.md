This is a sample Eclipse (and Maven) project for creating a new weighting model in Terrier, and later a proximity feature (for Exercise 2).

In your coursework, following the coursework specification, you will be expected to edit/make new version of `src/main/java/uk/ac/gla/dcs/models/MyWeightingModel.java` (Exercise 1) and `src/main/java/uk/ac/gla/dcs/dsms/SampleProxFeatureDSM.java` (Exercise 2). You should also edit the corresponding unit tests in `src/test/java` to ensure your implementations work as you expect.

You can edit/compile/and test your source in Eclipse, Netbeans or from the command line. You will need to use the command line to deploy your new models within Terrier.

## Compiling and Testing from the Command Line

From the command line, in this directory, type:
	
	mvn package

This will create a jar file at `target/ircourse-1.0-SNAPSHOT.jar`

 Right clicking the ircourse project, selecting Run As..Junit Test 

Unit tests are provided for both weighting model and proximity feature DSM. Unit tests are run automatically using `mvn package`. You can skip unit testing using `mvn -DskipTests package`.

## Compiling and Testing using Netbeans

To import the project into Netbeans, you simply use the File...Open Project functionality.

You can run the unit tests by selecting Test from the project's right-click context menu.

You can obtain a jar file at `target/ircourse-1.0-SNAPSHOT.jar`, by selecting Build from the right-click context menu.

## Compiling and Testing using Eclipse

To import the project into Eclipse, use the File...Import Project..Existing Maven Projects.

You can run the unit tests by selecting Run As...Junit Test from the project's right-click context menu.

You can obtain a jar file at `target/ircourse-1.0-SNAPSHOT.jar`, by selecting Run As...Maven Build and entering `package` as the goal. 

## Usage in Terrier

You can use classes from your project in Terrier by manually adding the generate Jar file to Terrier's classpath. To do this, firstly switch (e.g. `cd`) back to the terrier-core directory, and then alter the CLASSPATH environment variable to point to the generated jar file, before running `trec_terrier.sh`. On a Linux machine with a bash shell, this will look like:

	CLASSPATH=/path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar bin/trec_terrier.sh -r
	
For instance, to use your new weighting model, specify the name of the class to the trec.model property:

	CLASSPATH=/path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar bin/trec_terrier.sh -r -Dtrec.model=uk.ac.gla.dcs.models.MyWeightingModel

A few students may have tcsh as their default unix shell. In this case, the same command would look like:

    setenv CLASSPATH /path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar 
    bin/trec_terrier.sh -r -Dtrec.model=uk.ac.gla.dcs.models.MyWeightingModel
    
Or similarly on Windows:

    SET CLASSPATH="H:\path\to\myproject\target\ircourse-1.0-SNAPSHOT.jar"
    bin\trec_terrier.bat -r Dtrec.model=uk.ac.gla.dcs.models.MyWeightingModel
