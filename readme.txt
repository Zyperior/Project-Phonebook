   ____             ____              __  
  / __ \__  _______/ __ )____  ____  / /__
 / / / / / / / ___/ __  / __ \/ __ \/ //_/
/ /_/ / /_/ / /  / /_/ / /_/ / /_/ / ,<   
\____/\__,_/_/  /_____/\____/\____/_/|_|  
                                          

Our phonebook is a user friendly program for storing your contacts phonenumbers.
The Gui is lightweight and blazing fast with minimal clutter. 
The program stores and loads categories separately. 
As you might for example want to separate your personal life from work.

We wrote the software with the intent to allow future updates in terms of added functionality.

How does it work?
When you open the program you will be presented with a graphical user interface with an empty table.
There will be 4 text inputs, Last name,first name,location and phone number.
There is also an drop box where you select what category to work in.
Step 1. Select a category. (home is default)

Constraints for inputs are the following: first name & last name & location = min 2chars, max 20chars. Swedish locale no digits allowed. 
Phone number = min 2 digits, max 20 digits. dash is allowed.

Step 2. Enter data for your contact you must fill all fields. (dont worry about capitalization the software will autoformat it for you)

Step 3. add a couple more contacts

Step 4. Start typing a  first name but stop halfway trough and you will see how the table dynamicly updates. This works in all fields and is your means of searching.

step 5. Select a contact from the table and press Remove contact to remove your contact.

Some general information. The software will create a maximum of 3 files on your computer. They will be created in the directory from you RUN the software.
The software will only load a file once you selected the category. 
Imagine if the category was instead users with their separate logins, wouldnt it make sense to only load that specific users data to prevent potential leaks?
While it might not make much sense in protecting categories our mindset was to create a solid framework that would be utilized further in the future.

Build instructions:

1. Maven from bash.
Clone the project from github
Extract the folder(if you cloned it via a .zip)
Open bash.
Locate the folder.
Type: mvn package (if you previously built it i recommend using mvn clean package)
The jar file will be located in the target folder. (Project-Phonebook-1.0-SNAPSHOT.jar)
If you cant double click the jar file to open it, use bash or cmd with the command: java -jar filename.jar

2. Jenkins maven.
Make a new freestyle job.
Locate the version control section.
Paste our repo in the git field https://github.com/Zyperior/Project-Phonebook
Under build select invoke top-level maven targets.
In the goal field type a desired function package,compile,test etc.
It's recommended to add clean before your command if you previously built it.
Dont add the pom files location as its already located in the project root and will be found by jenkins. Leave the field empty.
Save your job and run it.
Locate the job in your computers jenkins-workspace and open the target folder where you will find the .jar (Project-Phonebook-1.0-SNAPSHOT.jar)
If you cant double click the jar file to open it, use bash or cmd with the command: java -jar filename.jar

Where is my workspace?
For windows users:
Your default jenkins workspace is usually: C:\Program Files (x86)\Jenkins\workspace\
Thats where your jobs are saved locally and where you can find the job and then its target folder containing the .jar
We assume linux users already configured their workspace to something specific of atleast knows where it is :)




