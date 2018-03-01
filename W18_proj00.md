# W18_proj00

Manuel Partidag Gomez and Ty Gooch

## Brief Description
Java application that calculates travel time between 2 destinations on the UCSB campus. Supports walking, biking, and flying.

## User Stories
* As a user, I can click on checkboxes next to buildings so that I can select these buildings to calculate travel time between them

* As a user without a bike, I can see how long it will take me to walk between classes so that I can be on time to class.

* As a user with a bike, I can see how long it will take me to bike between classes so that I can set aside time to park my bike without being late for class.

* As a user with or without a plane, I can see how long it would take to fly between buildings so that I can have fun.

## Does It Run?
This project compiles with no issues however the functionality is limited to certain cases. You can only calculate the travel time between certain buildings. Some buildings are not supported even though they are selectable.

## Future Feature User Stories
* As a user, I can zoom in on the map so that I can read the building name more clearly.

* As a user with a skateboard, I can calculate the skating time between buildings so that I can plan ahead.

* As a user, I can input my class schedule so that I can optimize my route for each day.

* As a user, I can view the route that is used to calculate the travel time so that I know I am taking the correct route.

## Quality of README.md
As it stands, the README includes the necessary instructions to run the project. However, the description of the project included is outdated and doesn't take into account the flying time feature. To make it easier for the next generation of students, the README should include instructions on how to use the application in addition to the included build instructions. Currently it is not very clear how to use the core functionality of the application by only viewing the README.

## State of build.xml
The current state of the build file is adequate for production however it lacks documentation. Most targets do not include a description. Furthermore, there is a disconnect between the project name included in the run target and the name of the repo (UCSBWalk vs CalculateWalkingTime).

## Current Issues
There are enough current issues to earn 1000 points over the course of this quarter. The descriptions of what needs to be fixed/implemented are clear.

## Additional Issues
#### Broken Functionality
Travel times cannot be calcualated between certain buildings. To replicate this error, select Rob Gym and Campbell Hall and click to calculate walking, biking, or flying time. If you look at the logs in the terminal, you will see that an exception is thrown.

#### Inaccurate Functionality
Travel times between buildings are not accurate. To replicate this, select Girvetz and Davidson Library and calculate the walk time. The application says it takes 4 minutes to walk between these buildings however our experiences on campus suggest otherwise.

## Code Assessment
The code is not well organized and lacks documentation.

Classes are separated based on whether or not they are related to the GUI or business logic. We like this separation however we wish they were separated into separate direcectories rather than separate files. It makes it hard to make improvements when logic is lumped together.

Furthermore, within these 2 separate files, there is inconsistent and unnecessary whitespace. There is no apparent spacing between code blocks.

On top of that, there is dead code that is commented out but still included. It looks like the previous team was using print statements to debug their code but forgot to delete said print statements. Initally it was confusing to us why this was even included because we were concerned it may be crucial to uncomment this code to get broken features functionial.

## Test Coverage
Unsurprisingly, given the broken functionality of this project, there are no unit tests included. Future developers should include unit tests to ensure that fututre commits do not degrade functionality.