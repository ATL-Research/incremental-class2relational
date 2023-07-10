#! /bin/bash
echo "Transformation Aspect, Value" > nmf-metrics.csv
grep -E "// Setup| // Model Traversal| // Helper| // Expression Outsourcing| // Tracing| // Incrementality| // Transformation| // Model Navigation| // Change Propagation" ../../solutions/nmf/ClassToRelational.cs | sed -e 's/^[[:space:]]*\/\/\?//' | sed -e 's/\([0-9]\)/, \1/' | sed 's/Expression Outsourcing/Helper/g' >> nmf-metrics.csv

grep -E "// Setup| // Model Traversal| // Helper| // Expression Outsourcing| // Tracing| // Incrementality| // Transformation| // Model Navigation| // Change Propagation" ../../solutions/nmf/NMFSolution.cs | sed -e 's/^[[:space:]]*\/\/\?//' | sed -e 's/\([0-9]\)/, \1/' | sed 's/Expression Outsourcing/Helper/g' >> nmf-metrics.csv
