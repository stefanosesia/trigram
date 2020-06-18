# Trigram text generator
This code aims to solve: Coding Kata http://codekata.com/kata/kata14-tom-swift-under-the-milkwood/

## Overview
This program is able to read .txt input text and generate random, custom- length, text.

The program was developed using Java 14.0.1 and Junit 4.5

## Quick Start Guide
The program comes pre-loaded with some .txt inputs in the "Library" folder, feel free to change, remove or add more books (https://www.gutenberg.org/ is a great source)

The project supports Maven, you can run mvn clean install to set-up yoour environment. Intellij should pick it up autoomatically.

Compile the project and run UserInterface.main() , you will be prompted to choose the right input as well as choose a maximum length of the output.

The generated test will be saved in the "output" folder

For a step-by-step installation guide follow https://github.com/stefanosesia/trigram/wiki/Step-by-step-setup-instructions-(Windows---Intellij)

**NOTE:** *the program also generates an activity log and saves it to the "log" folder*

**NOTE:** *make sure the "library" and "output" folder have the right read/write permissions, should there be a problem with that, the program should prompt you.*

**NOTE:** *The program currently does not have the ability to backtrack, hence the output might be smaller than the requested, different runs will yield different results. A feature branch has been created for this scope but has not yet been tested or apporved for master*

## Program Structure

The program is divided in varius modules and classes to keep the code as neat as possible, here is a description of what every class does

### Resources package
*This package contains "utility" clases and constants, boilerplate and trivial code re-used in the program for basic operations*

**Constants.java**
*This class contains Constants used to initialize defaults, specify default directories and set parameter's intervals*

Changing one variable here will automatically update the behaviour of the program, as per user's specification.

**CustomLogger**
*This class logs (with timestamps) all the activity performed by a given user in a specified logfile*

This can be useful in production environment to set up monitoring or to debug specific issues

**IO**
*This class contains methods to create a more pleasant Input/Output user experience, formatting outputs and standardizing the UI*


### UserInterface
*This is the main class, it only contains the sequence of operations to be performed*

**Main()**
*This method is responsible for the code flow alone, asks for user input and displays progress indicators and eventual errors to the end-user*

### FileManager
*This is in charge of folder operations*

**readFolder()**
*Returns a list of available files in a given folder*

### Ingestor
*This methods focuses on reading / writing from/to files*

**hasAccess**
*Return True if the file exists and can be accessed*

**writeToFile**
*Writes a given string to a specified file*

**readFile**
*Reads the text from a file, line by line, retuns a list of strings*

### TrigramMapGenerator
*Given a list of lines in a files, it generates a trigram*

**generateTrigramMap**
*Generates a trigram from a List<String>, all text is lowercase, keys are lowercase and with no punctuation, some punctuation is allowed in the values *

### TextGenerator
*Given a trigram, it generates a text to the user's specification*

**generateText**
*Given a trigram, it chooses a random couple of words to start building the text, then chooses a random value from the trigram.
The subsequent two words, stripped of their characters are used to find a next match. 
The result is a List of strings, which is then concatenated adding spaces and carriage returns*

**joinText**
*Is used to concatenate the generated text*



