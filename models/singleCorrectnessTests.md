# List of Atomic Changes for Completeness Check

## 1) Change Values of EAttributes
	
### Affecting the String-EAttribute name

1. change name of Person to Member  
*expected transformation behavior*  
	- update Table name +  
	(:question:) update all tables that use Table name (multi-valued attributes)?

2. set the name of Family to null  
*expected transformation behavior*  
	- update Table name  
	(:question:) update all tables that use Table name (multi-valued attributes) with default value?

3. change firstname to multi-valued (setting it true)  
*expected transformation behavior*  
	- delete column of table Person +  
	- create table for firstnames with foreign keys

4. change emailAdresses to single-valued (setting it to false)  
*expected transformation behavior*  
	- delete table for emailAdresses + create column in table
	
5. set type of firstname null  
*expected transformation behaviors*  
	1. remove column (null value behavior 2)  
	**OR**  
	2. set default type to column (null value behavior 3)

### Affecting EReferences

6. set type of closestFriend null
*expected transformation behaviors*
	1. remove column (null value behavior 2)  
	**OR**  
	2. set default type to column (null value behavior 3)

7. set owner of closestFriend null (removes the reference from source model)
*expected transformation behavior*
	1. remove column (null value behavior 2)  
	**OR**  
	2. :new:set default owner to column (null value behavior 3)  
	(:question:) type is no more relevant so remove type OR set type to Integer (foreign key) OR set type to Default ?
	
## 2) Create and Delete EObjects -- "Dangling" Objects

8. add elements to root: Class House  
*expected transformation behavior*  
	- add a new table House in target model

9. add attribute to class Person  
*expected transformation behavior*  
	- create new column in table Person

10. add elements to root: Attribute, single-valued, type:Person  
*expected transformation behaviors*  
	1. do not create the object  
	**OR**  
	2. ignore missing link and create dangling columns (added to resource)  
	**OR**  
	3. add attribute to first table  
	**OR**  
	4. create Column and dummy table and insert it in dummy table

11. add elements to root: Attribute, multi-valued, type:Person, owner:null
*expected transformation behaviors*  
	1. do not create the object (null value behavior 2)  
	**OR**  
	2. create a table with default name (null value behavior 3)

12. add elements to root: Attribute, multi-valued, without type
*expected transformation behaviors*  
	1. do not create the object (null value behavior 2)  
	**OR**  
	2. create a table with default name (null value behavior 3)
		
14. (:question:)correctness_couple: insert Class to root and delete it

## 3) Dangling References
13. delete Class Person  
*expected transformation behaviors*  
	1. remove table and all links to table Person (i.e. columns of type Person, tables for multi-valued attributes owned by Person)  
	**OR**  
	2. use a default type for columns referencing the table
