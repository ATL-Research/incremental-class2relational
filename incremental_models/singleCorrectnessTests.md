# List of Atomic Changes for Completeness Check

## 1) Change Values of EAttributes
	
	- Affecting the String-EAttribute name
	
	1) change name of Person to Member
		expected transformation behavior:
			update Table name

	2) set the name of Family to null
		expected transformation behavior:
			update Table name

	
	- Affecting the Boolean-EAttribute multiValued
	
	3) change firstname to multi-valued (setting it true)

		expected transformation behavior:
			delete column of table Person + create table for firstnames

	4) change emailAdresses to single-valued (setting it false)
			expected transformation behavior:
				delete table for mailAdresses + create column
	
	5) set type of firstnames null
		expected transformation behavior:
			remove all column contents?
			or set default type?
			
	- Affecting EReferences 

	6) set type of closestFriend null
			expected transformation behavior
				change type of column to default type?
	7) set owner of closestFriend null (removes the reference from source model)
		expected transformation behavior
			delete the columns
	



## 2) Create and Delete EObjects -- "Dangling" Objects

	8) add elements to root: Class
		expected transformation behavior
			add a new table to target model
			
	9) add attribute to class
		expected transformation behavior
			create new Column
	
	10) add elements to root: Attribute, single-valued, type:Person
		expected transformation behavior
			create Column 
				- and dummy table or
				- insert it in first table 

	11) add elements to root: Attribute, multi-valued, type:Person
	
	12) add elements to root: Attribute, multi-valued, without type
	
		potential transformation result for 10-12
			(1) do not create the object
			(2) ignore missing link and create dangling columns (added to resource)
			(3) add attribute to first table
			
	correctness_couple: insert Class to root and delete it

## 3) Dangling References
	13) delete Class Person
		expected transformation behavior
			(1) remove table and all links to table Person (i.e. columns of type Person)
			(2) use a default type for columns referencing the table
