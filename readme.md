# Incremental MTL vs. GPLs: Class into Relational Database Schema Transformation Case

Model transformation languages (MTLs) are domain specific languages tailored to express model-to-model transformation programs. 
They typically offer hihger-level syntactic constructs, such as rules, and specific features, such as automatic traceability support, than general-purpose languages (GPLs). 
Moreover, some MTLS allow for multiple execution modes, such as incremental or bidirectional, based on a single specification. Many MTLs have been proposed over the past decades but GPLs are still widely used to write model transformations in practice. 
Previous work has identified some reasons for this, in the context of batch execution mode. 
Our hypothesis is that the situation is different for other execution modes. 

Therefore, this transformation tool contest calls for incremental solutions implemented using various **MTLs and GPLs**, with the purpose of building a data set consisting of **labeled solutions** specified in diverse languages.
The overall objective is to leverage this data set to better undertand whether GPLs are up to incremental tasks or whether MTLs are significantly more appropriate.

## Contents of this repository

- case description:  submitted TTC proposal
- labeling:  examples of how to provide labels to a MTL (ATOL) and GPL (Java) solution
- metamodels: source and target metamodel as well as the Change metamodel used for incremental updates of the input model
- models: the source models
- solutions: implementations of ATOL (incremental variant of ATL), and Java solutions
- utils: 
    - the SolutionDriver which executes the transformation, 
    - the Comparator which evaluates the outcome of batch and incremental transformations
    - ecore2class: utility Ecore2Class transformation which can turn any Ecore model into an instance of the expected source model
  

## Using Github maven repository

We provide two maven packages, the fuzzer / model comparator and the solution driver with metamodels, they are hosted on Github. They are published publicly but Github requires users to authenticate to access their maven repository.

For a Gradle example you can read the repository declaration from [ATOL build.gradle file](solutions/atol/transformation/build.gradle). To generate your credentials you can read Github documentation [for maven](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-to-github-packages) or [Gradle](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry#authenticating-to-github-packages).

## Checking the solutions

Register the Github authentication information properly, as explained in the previous section (e.g., via the `GITHUB_ACTOR` and `GITHUB_TOKEN` environment variables, or in ~/.gradle/gradle.properties).
From the `utils/` sub-directory, launch `check_solution.sh`.
For instance:
```
	$ cd utils
	$ ./check_solution.sh
```

## Requirements

- ATL:
    - java 11+
- ATOL:
    - build: java 17 & <21 
        - fails to build with java 21 because xtend compiler is not compatible yet
    - run: java 17+
- bxtend:
    - java 17+
- cheptre:
    - java 17+
    - docker
        - user must be able to start/stop containers
- csharp, csharp_cp, nmf:
    - dotnet 7
- java:
    - java 14+
- Refinery:
    - java 21+
- yamtl-java:
    - java 17+