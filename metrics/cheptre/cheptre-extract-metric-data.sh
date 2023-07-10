#! /bin/bash
echo "Transformation Aspect, Value" > cheptre-metrics.csv
grep -E "% Setup| % Model Traversal| % Helper| % Expression Outsourcing| % Tracing| % Incrementality| % Transformation" ../../solutions/cheptre/src/main/resources/Class2Relational.cep | sed -e 's/^[[:space:]]*% //' | sed -e 's/\([0-9]\)/, \1/' | sed 's/Expression Outsourcing/Helper/g' >> cheptre-metrics.csv
