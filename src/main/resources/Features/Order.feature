Feature: Order

	Scenario: Order Product
		When User go to web product demoqa
		And Click product
		And Choose color
		And Choose size
		And Choose qty
		And add to cart
		And checkout cart
		And enter first name
		And enter last name
		And enter company
		And enter country
		And enter address1
		And enter address2
		And enter city
		And enter province
		And enter postcode
		And enter phone
		And enter comments
		And enter email
		And click tnc
		And click place order
		Then checkout success
