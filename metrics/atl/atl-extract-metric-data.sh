#! /bin/bash
echo "Transformation Aspect, Value" > atl-metrics.csv
grep -E "\-\- Setup|\-\- Model Traversal|\-\- Helper|\-\- Expression Outsourcing|\-\- Tracing|\-\- Incrementality|\-\- Transformation" ../../solutions/atl/src/main/resources/Class2Relational.atl | sed -e 's/^[[:space:]]*--//' | sed -e 's/\([0-9]\)/, \1/' | sed 's/Expression Outsourcing/Helper/g' >> atl-metrics.csv
