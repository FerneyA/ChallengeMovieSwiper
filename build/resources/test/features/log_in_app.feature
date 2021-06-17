Feature: Log in user in movie swiper application
  As a user of the Movie Swiper application
  I want to be able to login in the app
  To be able to manage the movies

  Scenario: Log in user in movie swiper app
    When user enter username: 'farroyave' and password: 'faqsau'
    Then the library section should contain the message: 'You are logged in as farroyave'

  Scenario: Log in guest user in movie swiper app
    When user enters as guest
    Then the guest user should see the message: 'Only for authenticated users'

