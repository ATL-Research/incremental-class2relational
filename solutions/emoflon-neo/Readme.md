# Steps required to inspect the eMoflon::Neo solution for the ClassToRelational case
- Install a vm hypervisor which is able to run OVA images, e.g. Oracle VM virtual box: https://www.virtualbox.org/wiki/Downloads
- Download the OVA image of eMoflon::Neo to be run in a virtual machine: https://emoflon.org/download/#pre-built-virtual-machine-neo-vm
- Log in to the virtual machine. User: vagrant, Password: vagrant
- Connect to the Neo4j database by opening the Neo4j Browser (following the provided desktop link). 
- Start the eMoflon::Neo Eclipse by following the provided desktop link.
- Establish the database connection between eMoflon::Neo and Neo4j: In eMoflon::Neo, open the Neo4J preferences (Window -> Preferences -> eMoflon::Neo -> Neo4J Preferences). The following configuration data might be suitable:
  * Connection URI: bolt://localhost:7687
  * User: neo4j
  * Password: test
- Open the Neo4j Browser and connect to the database using the same configuration data
- In your eMoflon::Neo Eclipse workspace, import the example projects via -> Import -> Team -> Team-Project, using this URL to access the relevant project set file: https://github.com/eMoflon/emoflon-neo/raw/master/projectSetRuntime.psf
- Open the folder ClassToRelational/src to inspect the solution:
  * Metamodels can be found in metamodels
  * All models are located in folders models.correctnessXX. Files named classXX.msl contain the models to be transformed, files named contain the models to be transformed *including* the respective changes. New elements are annotated with ._cr_ : true (nodes) or ~_cr_ : true (edges), deleted elements with ._de_ : true (nodes) or ~_de_ : true (edges), respectively.
  * The triple graph grammar is stored in the file ClassToRelational.msl
  * The transformations can be run by right-clicking on the file ClassToRelational_FWD_OPT_Run_App.java and selecting Run as -> Java application 
	