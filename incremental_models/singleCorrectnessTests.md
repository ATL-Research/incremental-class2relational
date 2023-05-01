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
	
	10) add elements to root: Attribute
		expected transformation behavior
			create Column 
				- and dummy table or
				- insert it in first table 
	11+12) insert Class to root and delete it
		