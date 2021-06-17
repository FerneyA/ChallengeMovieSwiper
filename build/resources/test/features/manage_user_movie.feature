Feature: Manage movies preferences
  As a user logged into the Movie Swiper app
  I want to be able to manage movies preferences
  To be able to add them to my favorites section or watchlist

  Background: User is Logged In
    Given user with username: 'farroyave' and password: 'faqsau' is logged into the movieSwiper app

  Scenario: Select movie randomly and add it to watchlist
    When user randomly selects a movie from the top rated list and saves it to watchlist
    Then the random movie should be added to watchlist in the library section

  Scenario: Add movie to favorites section using filter of movie name and year
    When user selects the movie: 'Mulan' of the year: '1998' and add it to favorites
    Then the movie: 'Mulan' should be added to favorites in the library section

#  Scenario: Add movie to favorites section using swipe animation
#    When user selects a random movie with swipe animation in the explore section
#    Then the random movie should be added to watchlist in the library section