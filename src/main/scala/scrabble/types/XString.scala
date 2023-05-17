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

import java.util.Objects

/** Class representing a String value.
 *
 * This class extends the [[Value]] trait and provides methods for adding this XString to
 * other [[Value]] types.
 * It overrides the `add` method from [[Value]] trait and provides specific implementation
 * for adding [[XString]] to different types of [[Value]].
 *
 * @constructor Create a new instance with a String value.
 * @param value the string value this instance represents.
 * @example
 * {{{
 * val str1 = new XString("Hello ")
 * val str2 = new XString("World!")
 * val result = str1.add(str2) // result is a new XString with value "Hello World!"
 * }}}
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class XString(override val value: String) extends Value with Equals {

  /** Add this XString to another Value using double dispatch.
   *
   * Double dispatch is a technique that allows us to invoke a method based on the runtime
   * type of two objects.
   * In this case, it invokes the [[addToString]] method on the other Value (the second
   * dispatch), which will call the method based on the runtime type of that Value.
   * This allows us to have different behavior depending on what type of Value we are
   * adding to this XString.
   *
   * @param that the other Value to add.
   * @return the result of the addition as a Value.
   * @throws InvalidOperationException when the addition operation is not valid.
   */
  override def add(that: Value): Value = {
    that.addToString(this)
  }

  /** Attempt to add this ``XString`` to an ``Integer``.
   *
   * This operation is not supported for the ``XString`` class, so it throws an
   * ``InvalidOperationException``.
   * The ``XString`` should always be on the left of the add operation to preserve the
   * string concatenation semantics.
   *
   * @param that the Integer to add.
   * @return Nothing
   * @throws InvalidOperationException when trying to add an XString to an Integer.
   */
  override def addToInt(that: Integer): Nothing = {
    throw new InvalidOperationException("XString should be leftmost in the add operation")
  }

  /** Attempt to add this ``XString`` to a ``Real``.
   *
   * This operation is not supported for the ``XString`` class, so it throws an
   * ``InvalidOperationException``.
   * The ``XString`` should always be on the left of the add operation to preserve the
   * string concatenation semantics.
   *
   * @param that the Real to add.
   * @return Nothing
   * @throws InvalidOperationException when trying to add an XString to a Real.
   */
  override def addToReal(that: Real): Nothing = {
    throw new InvalidOperationException("XString should be leftmost in the add operation")
  }

  /// Documentation inherited from [[Value]]
  override def addToString(that: XString): XString = {
    new XString(that.value + this.value)
  }

  /// Documentation inherited from [[Any]]
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[XString]
  }

  /// Documentation inherited from [[Any]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[XString]
      this.value == other.value
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode(): Int = {
    Objects.hash(classOf[XString], this.value)
  }

  /// Documentation inherited from [[Any]]
  override def toString: String = {
    this.value
  }
}