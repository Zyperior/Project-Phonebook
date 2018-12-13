+-- src
    +-- phonebook
        +-- base
        +-- gui
        +-- run
        +-- storage


Put your junit5(jupiter) tests in:
src/test/java/ Using our pkg structure
If we wanted to test the Contact class:
src/test/java/phonebook/base/ContactTest.java

Want to create a jar?
Clone the project from github.
Extract the folder.
Open bash.
Locate the folder.
Type: mvn package
The jar file will be located in the target folder.

Want to use our project with jenkins?
Make a new freestyle job.
paste our repo in the git field https://github.com/Zyperior/Project-Phonebook
Under build select invoke top-level maven targets.
Type a desired function package,compile,test etc.
It's recommended to add clean before your command if you previously built it.
Dont add the pom files location as its already located in root and will be found by jenkins. Leave the field empty.

Your default jenkins workspace is usually: C:\Program Files (x86)\Jenkins\workspace\
Thats where your jobs are saved locally and where you can find the target folder containing the .jar
If you cant double click the jar file to open it, use bash or cmd with the command: java -jar filename.jar


