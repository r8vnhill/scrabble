
package cl.uchile.dcc
package filereader

import java.io.{FileNotFoundException, IOException}
import scala.io.{BufferedSource, Source}
import scala.io.StdIn.readLine

/** Main application object that reads and prints lines from a user-specified file.
 *
 * This object extends App and prompts the user to enter a filename. It then attempts to
 * open, read, and print the lines from the provided file.
 * It employs exception handling to gracefully deal with scenarios where the file may
 * not exist or cannot be opened.
 *
 * The type [[Option]] is used to handle the [[BufferedSource]].
 * The Option type in Scala is used when a value may be present or not, representing a
 * kind of wrapper around a value.
 * [[Some]] is a case of Option that signifies the presence of a value, and [[None]]
 * signifies its absence.
 *
 * The program uses a try-catch-finally block to handle potential
 * [[FileNotFoundException]], [[IOException]], and [[SecurityException]] that can occur
 * during file operations.
 * FileNotFoundException is thrown when the file does not exist or cannot be opened for
 * some reason.
 * IOException is more general and can be thrown for various input-output failures,
 * including issues with file permissions, network access errors, and more.
 * SecurityException is thrown when the security manager denies an operation, such as
 * reading from a file.
 *
 * @example
 * {{{
 * // Assuming that "example.txt" exists and contains the following lines:
 * // Hello, World!
 * // This is a file.
 * // When the user enters "example.txt", the output would be:
 * // Hello, World!
 * // This is a file.
 * }}}
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @version 1.0.0
 * @since 1.0.0
 */
object Main extends App {
  // Prompt the user to enter the filename
  print("Enter the name of the file to read: ")
  private val filename = readLine()

  // An Option is used to hold the BufferedSource, allowing it to start as None before
  // the file is opened.
  var file: Option[BufferedSource] = None
  try {
    // Attempt to open the file with the provided filename
    file = Some(Source.fromFile(filename))

    // If the file is successfully opened, read and print each line
    for (line <- file.get.getLines()) {
      println(line)
    }
  } catch {
    // If the file cannot be found or opened, a FileNotFoundException will be thrown
    case e: FileNotFoundException =>
      // The catch block handles the exception by printing a message and the stack trace
      println("Couldn't find that file.")
      e.printStackTrace()
    case e: IOException =>
      println("Error reading file.")
      e.printStackTrace()
    case e: SecurityException =>
      println("Insufficient permissions to read file.")
      e.printStackTrace()
  } finally {
    // The finally block is always executed, whether an exception was thrown or not
    // It is used here to ensure that the file is closed if it was opened
    if (file.isDefined) {
      file.get.close()
    }
  }
}

