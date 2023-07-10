#! /bin/bash
echo "Transformation Aspect, Value" > csharp-metrics.csv
grep -E "// Setup| // Model Traversal| // Helper| // Expression Outsourcing| // Tracing| // Incrementality| // Transformation| // Model Navigation| // Change Propagation" ../../solutions/csharp/CSharpClassToRelational.cs | sed -e 's/^[[:space:]]*\/\/\?//' | sed -e 's/\([0-9]\)/, \1/' | sed 's/Expression Outsourcing/Helper/g' >> csharp-metrics.csv
