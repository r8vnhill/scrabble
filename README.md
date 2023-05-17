# Double Dispatch and Exceptions in Scala

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

## Scrabble

Scrabble is a Scala project that implements a simple type system akin to those found in 
programming languages or calculators. 
It is not related to the board game of the same name.

### Description

Scrabble uses a type hierarchy to represent different kinds of values, including 
`Integer`, `Real`, and `XString` which represent integers, floating point numbers, and 
strings respectively. 
These classes extend from the `Value` trait.

The `add` method is implemented in each class using a technique called "double 
dispatch". 
This allows each class to handle different types of addition operations. 
The `Integer` and `Real` classes handle numerical addition, while the `XString` class 
handles string concatenation.

The project includes a custom exception, `InvalidOperationException`, which is thrown 
when an unsupported operation is attempted, such as adding a string to a number from the
right.

### Example

```scala
val intVal = new Integer(5)
val realVal = new Real(2.5)
val strVal = new XString("Hello")

val result1 = intVal.add(realVal) // Returns a Real(7.5)
val result2 = strVal.add(intVal)  // Returns an XString("Hello5")
val result3 = intVal.add(strVal)  // Throws an InvalidOperationException
```

This showcases how the add method uses double dispatch to correctly perform addition 
operations between different types of values.

### Building

To build the project, you need to have sbt installed. 
Then, you can compile the project with:

```bash
sbt compile
```

### Testing

Unit tests are included in the project. 
To run the tests, use:

```bash
sbt test
```

## Scala File Reader

Scala File Reader is a simple Scala application that reads and prints lines from a 
user-specified file.

### Description

The application prompts the user to enter a filename, then it attempts to open, read, 
and print the lines from the provided file. 
It employs robust exception handling to gracefully deal with scenarios where the file 
may not exist, cannot be opened, or if an error occurs during the reading process.

An `Option` type is used to handle the `BufferedSource`, allowing it to start as `None` 
before the file is opened and then wrapping the `BufferedSource` in a `Some` once the 
file is successfully opened.

### Example

Here is an example interaction with the application:

```bash
Enter the name of the file to read: example.txt
Hello, World!
This is a file.
```
In this example, "example.txt" is the name of the file the user wants to read. 
The application opens the file, reads the lines, and prints them to the console.

### Building and Running

To build and run the application, you need to have sbt installed.

Compile the application with:

```bash
sbt compile
```

Run the application with:

```bash
sbt run
```

### Handling Exceptions

The application includes robust exception handling for ``FileNotFoundException``, 
``IOException``, and ``SecurityException``. 
These exceptions handle scenarios like the file not being found, an error occurring 
while reading the file, and not having the necessary permissions to read the file, 
respectively.
