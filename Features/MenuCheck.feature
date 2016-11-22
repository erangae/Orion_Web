Feature: Menus availability

	Scenario: Verify availability of all the menus
		When I go to the homepage
		Then I should see 'Solutions for' menu
		And I should see 'Products' menu
		And I should see 'Knowledge Hub' menu
		And I should see 'Support' menu
		And I should see 'About Us'
		
	Scenario Outline: Navigate to all the sub menus
		When I go to the homepage
		When I go to menu <menuno> <menu>
		And I click sub menu <submenuno> <submenu>
		Then I should see page title <submenu>
		And I should see page header <menu> <menuno> <submenu>
		Examples: Page details
		| menuno | menu 		 | submenuno | submenu			    |
		| 5	     | Solutions for | 3		 | Healthcare Providers |
		| 5	     | Solutions for | 4		 | Payers |
		| 5	     | Solutions for | 3		 | Public Health & HIEs |
		| 5	     | Solutions for | 3		 | Pharmaceutical Manufacturers |
		| 5	     | Solutions for | 3		 | Pharmaceutical Retailers |
		| 5	     | Solutions for | 3		 | Medical Device Manufacturers |
		| 5	     | Solutions for | 3		 | Application Developers |
		| 5	     | Solutions for | 3		 | Interoperability |
		| 5	     | Solutions for | 2		 | Population Health Management |
		| 5	     | Solutions for | 2		 | Precision Medicine |