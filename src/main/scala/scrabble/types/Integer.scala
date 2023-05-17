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

/** Class representing an integer value.
 *
 * This class extends the [[Value]] trait and provides methods for adding this Integer to
 * other [[Value]] types.
 * It overrides the [[add]] method from [[Value]] trait and provides specific implementation
 * for adding
 * [[Integer]] to different types of [[Value]].
 * In the case of adding an [[Integer]] to a [[XString]], it throws an
 * [[InvalidOperationException]] as the operation is not supported.
 *
 * @param value the value this instance represents.
 * @constructor create a new Integer with a given value.
 * @example
 * {{{
 * val int1 = new Integer(3)
 * val int2 = new Integer(5)
 * val result = int1.add(int2) // result is a new Integer with value 8
 * }}}
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 */
class Integer(override val value: Int) extends Value with Equals {

  /** Add this Integer to another Value using double dispatch.
   *
   * Double dispatch is a technique that allows us to invoke a method based on the runtime
   * type of two objects.
   * In this case, it invokes the [[addToInt]] method on the other Value (the second
   * dispatch), which will call the method based on the runtime type of that Value.
   * This allows us to have different behavior depending on what type of Value we are
   * adding to this Integer.
   *
   * @param that the other Value to add.
   * @return the result of the addition as a Value.
   * @throws InvalidOperationException when the addition operation is not valid.
   */
  override def add(that: Value): Value = {
    that.addToInt(this)
  }

  /// Documentation inherited from [[Value]]
  override def addToInt(that: Integer): Integer = {
    new Integer(this.value + that.value)
  }

  /// Documentation inherited from [[Value]]
  override def addToReal(that: Real): Real = {
    new Real(this.value + that.value)
  }

  /// Documentation inherited from [[Value]]
  override def addToString(that: XString): XString = {
    new XString(this.value.toString + that.value)
  }

  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Integer]
  }

  /// Documentation inherited from [[Any]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Integer]
      this.value == other.value
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode(): Int = {
    Objects.hash(classOf[Integer], this.value)
  }

  /// Documentation inherited from [[Any]]
  override def toString: String = {
    this.value.toString
  }
}


