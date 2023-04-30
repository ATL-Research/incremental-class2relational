## 1) Change Values of Attributes
	
	1) change name of Person to Member
		expected transformation behavior:
			update Table name

	2) set the name of Family to null

		expected transformation behavior:
			update Table name

	3) change firstname to multi-valued (setting it true)

		expected transformation behavior:
			delete column of table Person + create table for firstnames

	4) change emailAdresses to single-valued (setting it false)
			expected transformation behavior:
				delete table for mailAdresses + create column
			

## 2) Dangling Objects

	1) add elements to root: Class
		expected transformation behavior
			add a new table to target model
			
	2) add elements to root: Attribute
	
	3) insert Class to root and delete it
		