/*
 * "Scrabble" (c) by R8V.
 * "Scrabble" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc
package scrabble.exceptions

/** Class representing an invalid operation exception.
 *
 * This class extends the base Exception class and is used to signify that an operation
 * was attempted which is not valid for the given context.
 *
 * @constructor creates a new ``InvalidOperationException`` with a specific error message.
 * @param message the specific error message for this exception.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class InvalidOperationException(message: String) extends Exception(message)
