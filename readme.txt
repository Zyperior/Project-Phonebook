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
clone the project from github
extract the folder
open bash
locate the folder
type: mvn package
The jar file will be located in the target folder

Want to use our project with jenkins?
Make a new freestyle job
paste our repo in the git field https://github.com/Zyperior/Project-Phonebook
Under build select invoke top-level maven targets
Type a desired function package,compile,test etc
It's recommended to add clean before your command if you previously built it
Dont add the pom files location as its already located in root and will be found by jenkins. Leave the field empty.


