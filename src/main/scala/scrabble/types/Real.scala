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

/** Class representing a real number value (as Double).
 *
 * This class extends the [[Value]] trait and provides methods for adding this Real to
 * other [[Value]] types.
 * It overrides the `add` method from [[Value]] trait and provides specific implementation
 * for adding [[Real]] to different types of [[Value]]. In the case of adding a [[Real]]
 * to a [[XString]], it throws an [[InvalidOperationException]] as the operation is not
 * supported.
 *
 * @constructor Create a new instance with a double value.
 * @param value the double value this instance represents.
 * @example
 * {{{
 * val real1 = new Real(3.5)
 * val real2 = new Real(5.5)
 * val result = real1.add(real2) // result is a new Real with value 9.0
 * }}}
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @version 1.0
 * @since 1.0
 */
class Real(override val value: Double) extends Value with Equals {

  /** Add this Real to another Value using double dispatch.
   *
   * Double dispatch is a technique that allows us to invoke a method based on the runtime
   * type of two objects.
   * In this case, it invokes the [[addToReal]] method on the other Value (the second
   * dispatch), which will call the method based on the runtime type of that Value.
   * This allows us to have different behavior depending on what type of Value we are
   * adding to this Real.
   *
   * @param that the other Value to add.
   * @return the result of the addition as a Value.
   * @throws InvalidOperationException when the addition operation is not valid.
   */
  override def add(that: Value): Value = {
    that.addToReal(this)
  }

  /// Documentation inherited from [[Value]]
  override def addToInt(that: Integer): Real = {
    new Real(this.value + that.value)
  }

  /// Documentation inherited from [[Value]]
  override def addToReal(that: Real): Real = {
    new Real(this.value + that.value)
  }

  /// Documentation inherited from [[Value]]
  override def addToString(that: XString): XString = {
    new XString(that.value + this.value.toString)
  }

  /// Documentation inherited from [[Any]]
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Real]
  }

  /// Documentation inherited from [[Any]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Real]
      this.value == other.value
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode(): Int = {
    Objects.hash(classOf[Real], this.value)
  }

  /// Documentation inherited from [[Any]]
  override def toString: String = {
    this.value.toString
  }
}
