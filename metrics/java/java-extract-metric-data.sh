#! /bin/bash
echo "Transformation Aspect, Value" > java-metrics.csv
grep "// Class" ../../labeling/java/inc_labeled/Class2RelationalIncremental.java | sed -e 's/^[[:space:]]*.*Class //' | sed -e 's/ [^0-9]* / /' | sed -e 's/ A2B / /' | sed -e 's/ A2BPre / /' | sed -e 's/ /,/' | tail -n +2 | sed 's/Traversal/Model Traversal/g' >> java-metrics.csv
