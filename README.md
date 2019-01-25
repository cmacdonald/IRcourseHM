This is a sample Eclipse (and Maven) project for creating a new weighting model in Terrier 5.0, and later a proximity feature (for Exercise 2).

In your coursework, following the coursework specification, you will be expected to edit/make new version of `src/main/java/uk/ac/gla/dcs/models/MyWeightingModel.java` (Exercise 1) and `src/main/java/uk/ac/gla/dcs/dsms/SampleProxFeatureDSM.java` (Exercise 2). You should also edit the corresponding unit tests in `src/test/java` to ensure your implementations work as you expect.

You can edit/compile/and test your source in Eclipse, Netbeans or from the command line. You will need to use the command line to deploy your new models within Terrier.

## Compiling and Testing from the Command Line

From the command line, in this directory, type:
	
	mvn install

This will create a jar file at `target/ircourse-1.0-SNAPSHOT.jar`, and will install it into your local Maven repository, so Terrier can find it.

Unit tests are provided for both weighting model and proximity feature DSM. Unit tests are run automatically using `mvn install`. You can skip unit testing using `mvn -DskipTests install`.

## Compiling and Testing using IntelliJ

To import the project into IntelliJ, you simply use the File...New...Project from Existing Sources functionality.


You can obtain a jar file at `target/ircourse-1.0-SNAPSHOT.jar`, by selecting Maven Projects...lifecycle...`package` on the right hand side of the IntelliJ window. To install that jar file to your local Maven repository, select the `install` from the lifecycle list. You can run the junit tests by selecting `test` from the lifecycle list.


## Compiling and Testing using Eclipse

To import the project into Eclipse, use the File...Import Project..Existing Maven Projects.

You can run the unit tests by selecting Run As...Junit Test from the project's right-click context menu.

You can obtain a jar file at `target/ircourse-1.0-SNAPSHOT.jar`, by selecting Run As...Maven Build and entering `package` as the goal. Similarly, you can install that to your local Maven repository by selecting Run As...Maven Build and entering `install` as the goal  

## Usage in Terrier

You can use classes from your project in Terrier, in one of two manners:

 1. Telling Terrier which Maven package to import.
 1. manually adding the generate Jar file to Terrier's classpath.

We now explain these two different methods below.

### Importing from the local Maven repository

Terrier can search Maven for packages and add these to the classpath automatically. Firstly switch (e.g. `cd`) back to the terrier-platform directory. You will need to specify the group, artifact and version of the package that we want to add to the classpath. There are set in your project's pom.xml file.

	bin/terrier -Dterrier.mvn.coords=uk.ac.gla.dcs:ircourse:1.0-SNAPSHOT

Terrier will tell you that some files have been added to the classpath. Classes defined in this jar files can now be used in the same manner as Terrier's other standard classes. For instance, to use your new weighting model, specify the name of the class using the `-w` commandline option

	bin/terrier batchretrieve -Dterrier.mvn.coords=uk.ac.gla.dcs:ircourse:1.0-SNAPSHOT -w uk.ac.gla.dcs.models.MyWeightingModel

If you change your MyWeightingModel, you will need to re-`install` your project.

### Setting the CLASSPATH manually

To manually add the generated Jar file to Terrier's classpath, firstly switch (e.g. `cd`) back to the terrier-platform directory, and then alter the CLASSPATH environment variable to point to the generated jar file, before running `bin/terrier`. On a Linux machine with a bash shell, this will look like:

	CLASSPATH=/path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar bin/terrier batchretrieve
	
For instance, to use your new weighting model, specify the name of the class using the `-w` commandline option

	CLASSPATH=/path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar bin/terrier batchretrieve -w uk.ac.gla.dcs.models.MyWeightingModel

A few students may have tcsh as their default unix shell. In this case, the same command would look like:

    setenv CLASSPATH /path/to/myproject/target/ircourse-1.0-SNAPSHOT.jar 
    bin/terrier br -w uk.ac.gla.dcs.models.MyWeightingModel
    
Or similarly on Windows:

    SET CLASSPATH="H:\path\to\myproject\target\ircourse-1.0-SNAPSHOT.jar"
    bin\terrier.bat br -Dtrec.model=uk.ac.gla.dcs.models.MyWeightingModel

where `br` is short for `batchretrieve` 
