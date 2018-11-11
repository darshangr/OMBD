#OMDbApp

This app is intended to make a call to OMDb API and search for a movie based on user entered title name,
if succesfull app shows the matching response in a Recycler view, if not displays error message.

The app has 2 bottom tab and user is defaulted to home tab where user can search and the 2nd tab is favorite tab which shows favorites
that the user has choosen earlier.

This app follows MVVM pattern and makes use latest architechtural components like Room, etc. Open source libraries like Retrofit, OkHttp and Picasso are also used.



## TODO

1. Update DB for favorites and show the same in favorites tab.
2. Additional Unit and instumentation testing.
3. Code cleanup, externalize Strings and add comments on important methods and classes.