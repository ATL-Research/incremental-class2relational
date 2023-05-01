# Incremental MTL vs. GPLs: Class into Relational Database Schema Transformation Case

Model transformation languages (MTLs) are domain specific languages tailored to express model-to-model transformation programs. 
They typically offer hihger-level syntactic constructs, such as rules, and specific features, such as automatic traceability support, than general-purpose languages (GPLs). 
Moreover, some MTLS allow for multiple execution modes, such as incremental or bidirectional, based on a single specification. Many MTLs have been proposed over the past decades but GPLs are still widely used to write model transformations in practice. 
Previous work has identified some reasons for this, in the context of batch execution mode. 
Our hypothesis is that the situation is different for other execution modes. 

Therefore, this transformation tool contest calls for incremental solutions implemented using various **MTLs and GPLs**, with the purpose of building a data set consisting of **labeled solutions** specified in diverse languages.
The overall objective is to leverage this data set to better undertand whether GPLs are up to incremental tasks or whether MTLs are significantly more appropriate.

## Contents of this repository

## Using Github maven repository

We provide two maven packages, the fuzzer / model comparator and the solution driver with metamodels, they are hosted on Github. They are published publicly but Github requires users to authenticate to access their maven repository.

For a Gradle example you can read the repository declaration from [ATOL build.gradle file](solutions/atol/transformation/build.gradle). To generate your credentials you can read Github documentation [for maven](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry#authenticating-to-github-packages) or [Gradle](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry#authenticating-to-github-packages).

