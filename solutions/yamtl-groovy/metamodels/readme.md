# Changes to Original Variant of ATL Zoo

For examining the incremental transformation, we applied some changes to the metamodels of the [original Class2Relation](https://www.eclipse.org/atl/atlTransformations/#Class2Relational) transformation from the ATL Zoo.

## Changes to the source model

  - remove the inheritance relationships and the abstract-property of classes
  - remove the separate definition of primitive types
    -> use the default EDataTypes instead
  
## Changes to the target model

## Changes to the Change metamodel

  - add changes that allow for adding and deleting elements from the root: AddToRoot, DeleteFromRoot
  - add apply method to all elementary changes
  - make basic elementary changes (AttributeChange, AssociationChange, ...) abstract     
