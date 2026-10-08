1. How long did your first build take, roughly? And the second?
    30 ish mins

2. In dark mode, what changed color on its own?
    The app background changed to a dark gery/black and the letters turned white.

3. What is one thing on your screen right now that you don't understand yet?
    I don't really understand the gradlew part or what its doing.

--- Lab 6 : Task 5 ---
Week 5, Friday. Change one Modifier on your Column — the padding number, or swap .fillMaxWidth() for
.fillMaxSize(). Write down what you changed and what happened to the screen. One or two sentences.

    I changed padding from 24 to 50 and i saw it doubled the distance from all the edge by about 2.
    It give the content on the home page a bigger boarder of white space before the egde of the phone.


--- Lab 7 : Task 6 ---
Week 6, Wednesday.
1. Paste the Logcat lines from your broken counter.
Excluded

2. In your own words: why did count change but the screen didn't?
The counter changed because we were clicking the button but were not giving it anything to add so 
it only counted up one without adding anything new.

3. What does remember do? What would happen without it?
Remembers keeps the same box every time the function is run, without it every time it would return with default

--- Lab 8 : Task 1 ---
Putting task one before empty doesn't change anything sense we have grayed out the button when its empty.

--- Lab 8 : Task 2 ---
Because there will be no event that's purely numbers.

--- Lab 8 : Task 3 ---
1. I Left empty                   ->  Button is grayed out                                  -> Yes
2. I added 18 spaces              ->  It did not recognize them and the button stayed gray  -> Yes
3. I added 40 characters          ->  It did not let me add more                            -> Yes
4. I added one character          ->  It sent the too short error                           -> Yes
5. I added Hello then tried hello ->  It recognized that it was already in there            -> Yes
6. I put 123456789                ->  It sent the error "cant only be numbers"              -> Yes
7. I put 123456789W               ->  It added it as a meeting name                         -> Yes
8. I put New York Trip            ->  It added it as a meeting name                         -> Yes 


--- Lab 9 : Task 3 ---
1. After rotating, which screen were you on? 
    I am still on the all meetings screen.

2. Were your two new items still there? 
    No the 2 items i added were lost/ not remembered.

3. Look at how currentScreen and trails(Meetings) are each created in CampusAppScreen. Explain the difference in one or
two sentences
    CurrentScreen is created with rememberSaveable while Meetings is created with only remember. rememberSavable
    allows configuration change like the screen rotation while remember does not.


