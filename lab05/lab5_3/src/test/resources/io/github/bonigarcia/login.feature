Feature: Booking a flight

  Scenario: Choosing a flight
      When I navigate to "https://blazedemo.com/"
      Then the header is 'BlazeDemo'

      When I choose departure 'Paris'
      Then departure is 'Paris'

      When I choose destination 'Rome'
      Then destination is 'Rome'

      When I find flights
      Then the page title is 'BlazeDemo - reserve'

      When I choose any flight, such as 1
      Then the page title becomes 'BlazeDemo Purchase'

      When I purchase flights
      Then the title is 'BlazeDemo Confirmation'