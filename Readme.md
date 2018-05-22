To Run Application:
please ensure gradle is setup on test machine.

import/clone project from github https://github.com/dibbydon/crawler.git into eclips
on command window:
navigate to crawler directory
  run gradle build //build the project
  run gradle run // to run the project

or 

to run compiled application:
on command window:
run gradle fatJar
navigate to crawler/build/libs
run java -jar micrawler.jar

