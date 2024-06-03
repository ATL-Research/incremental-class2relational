# Incremental-class2relational
This repository contains two solutions to the proposed transformation case:
1. A BXtendDSL solution for the TTC2023 case: Incremental MTL vs. GPLs: Class into Relational Database Schema Transformation Case (initially submitted to TTC 2023)
2. A BXtend (plain iterative, using our framework) solution, created after the Transformation Tool Contest, inspired by the discussions

## The case revealed a bug in our code generation engine

To make the solution run, please do the following, after Code has been generated from the BXtendDSL specification:

In the project "Class2RelationalNew" goto "src-gen" folder and to the "rules" package. Comment the following line in "Class2Table.xtend"

```clz.getAttr().forEach[corr.assertRuleId("SingleAttribute2Column", "SingleClassAttribute2Column", "MultiAttribute2Table")]```

Change line ```val _col = colFrom(_attSinCol, _attSinCol_2, _attMulTbl)``` 

to 

```val _col = colFrom(_attSinCol, _attSinCol_2, _attMulTbl, tbl)```

and finally, change line

```def protected abstract Type4col colFrom(List<relational_.Column> attSinCol, List<relational_.Column> attSinCol_2, List<relational_.Table> attMulTbl);``` 

to


```def protected abstract Type4col colFrom(List<relational_.Column> attSinCol, List<relational_.Column> attSinCol_2, List<relational_.Table> attMulTbl, relational_.Table parent);```
