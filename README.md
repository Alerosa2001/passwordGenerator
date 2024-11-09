Password Generator App
A simple, graphical password generator built using Java and Swing. This app allows users to generate random passwords based on user-defined criteria, such as password length and whether to include uppercase letters, lowercase letters, numbers, and special symbols.

Features
Password Length Input: Allows users to specify the desired length for the generated password.
Character Type Selection: Toggle options to include uppercase letters, lowercase letters, numbers, and special symbols.
Random Password Generation: Click the "Generate" button to produce a password based on the selected criteria.
User-Friendly GUI: Easy-to-use graphical interface for seamless user experience.
Application Workflow
Launch the App: The app is launched through the App class, which initializes and displays the GUI.
Enter Password Length: Users can enter the desired password length in a dedicated input field.
Select Character Types: Users can toggle checkboxes for including uppercase letters, lowercase letters, numbers, and special symbols.
Generate Password: Upon pressing the "Generate" button, the app creates a password based on the specified length and criteria.
Display Generated Password: The generated password is displayed in a text area for the user to copy.
Technologies Used
Java: The main programming language used to implement the application logic and GUI.
Swing: Java's built-in GUI toolkit to create the user interface.
Random Class: Used for generating random characters from the available character pools to form the password.
Installation
To run this application locally:

Ensure you have Java 8 or higher installed on your machine.
Clone this repository using the command:
bash
Copy code
git clone https://github.com/yourusername/password-generator.git
Navigate to the project directory:
bash
Copy code
cd password-generator
Compile and run the application:
bash
Copy code
javac App.java PasswordGenerator.java PasswordGeneratorGUI.java
java App
How It Works
App.java
Main Class: Launches the application by creating an instance of the PasswordGeneratorGUI class and setting it visible.
PasswordGenerator.java
Password Generation Logic: This class is responsible for the backend functionality of the app. It uses predefined character pools (lowercase, uppercase, numbers, and special symbols) to generate a random password based on user-selected options. It uses the Random class to randomly pick characters from the valid pools.

Character Pools:

LOWERCASE_CHARACTERS: Contains all lowercase alphabet letters.
UPPERCASE_CHARACTERS: Contains all uppercase alphabet letters.
NUMBERS: Contains numbers from 0-9.
SPECIAL_SYMBOLS: Contains special characters such as !@#$%^&*().
The generatePassword method uses these pools and builds the password character by character, based on the specified criteria.

PasswordGeneratorGUI.java
User Interface: This class handles the graphical user interface (GUI). It contains the layout and styling of the application, including:
Labels: For displaying information, such as "Password Length" and the title.
Text Areas: For user input (password length) and displaying the generated password.
Toggle Buttons: To select the inclusion of uppercase, lowercase, numbers, and symbols.
Generate Button: When clicked, it triggers the password generation logic from the PasswordGenerator class.
Colors and Styling: The interface uses a light color palette with a soft violet-gray theme.
Code Structure
lua
Copy code
/password-generator
    |-- App.java
    |-- PasswordGenerator.java
    |-- PasswordGeneratorGUI.java
    |-- README.md
License
This project is open-source and available under the MIT License.
