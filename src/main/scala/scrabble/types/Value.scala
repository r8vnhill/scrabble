/*
 * "Scrabble" (c) by R8V.
 * "Scrabble" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <https://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc
package scrabble.types

import scrabble.exceptions.InvalidOperationException

/** Trait representing a generic value.
 *
 * This trait provides an abstraction for a value of any type.
 * It defines a contract for adding values of various types together.
 * Each concrete class implementing this trait should provide their own implementation of
 * the addition operation with various types of Value ([[Integer]], [[Real]],
 * [[XString]]).
 * Each addition operation can potentially throw an [[InvalidOperationException]].
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
trait Value {

  /** The value this instance represents. */
  val value: Any

  /** Add this Value to another Value.
   *
   * @param that the other Value to add.
   * @return the result of the addition as a Value.
   * @throws InvalidOperationException when the addition operation is not valid.
   */
  def add(that: Value): Value

  /** Add this Value to an Integer.
   *
   * @param that the Integer to add.
   * @return the result of the addition as a Value.
   * @throws InvalidOperationException when the addition operation is not valid.
   */
  def addToInt(that: Integer): Value

  /** Add this Value to a Real.
   *
   * @param that the Real to add.
   * @return the result of the addition as a Value.
   * @throws InvalidOperationException when the addition operation is not valid.
   */
  def addToReal(that: Real): Value

  /** Add this Value to an XString.
   *
   * @param that the XString to add.
   * @return the result of the addition as a Value.
   * @throws InvalidOperationException when the addition operation is not valid.
   */
  def addToString(that: XString): Value
}

