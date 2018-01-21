# cs56-calculatewalkingtime

Calculates time by walking or by biking to get from building to building at UCSB

# Javadoc
* [on cgu08](http://cgu08.github.io/cs56-calculatewalkingtime/javadoc)
* [on ucsb-cs56-project](http://ucsb-cs56-projects.github.io/cs56-calculatewalkingtime/javadoc/index)

## Building and Running Project
To run:
```
ant compile
ant run
```
To build javadoc:
```
ant javadoc
```
To clean:
```
ant clean
```

## Features
There is a limited number of lists currently:
* Calculate Time with Distance
  * Walking
  * Biking
  * Flying by Plane (Boeing 747)
* Dropdown List for easier access
* Simple Checkboxes
* ClearAll button

## Screenshots

![Screenshot 1](images/screenshot.png?raw=true)

## Future Features
* Refractor GUI
* FULL Campus Map
* Google API Integrated
* GOLD Class Support
* MORE TO COME

## F17 final remarks
* Begin by looking into MapGui and how the code works.
* Then check the issues, the best point getter would be to implement Google API.
* Before you start with Google API, you will need to learn Maven.
  * [Maven Guide--by Prof. Conrad](https://ucsb-cs56-pconrad.github.io/topics/maven/)
  * [Maven Guide by Creators](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
  * [Google API (Java) GitHub Examples](https://github.com/google/google-api-java-client-samples)
  * [Google API Setup](https://developers.google.com/api-client-library/java/google-api-java-client/setup)
* If you do not want to implement this, there is a work in progress.
  * Autocomplete is partially done, [pull request 7](https://github.com/UCSB-CS56-Projects/cs56-calculatewalkingtime/issues/7). You can look at the different methods done, and implement them.
* If you also start working on test cases, you will have the first 500 points done before you know it!
