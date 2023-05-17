
package cl.uchile.dcc
package scrabble.types

import scrabble.exceptions.InvalidOperationException

import munit.FunSuite

class RealTest extends FunSuite {
  val double1 = 1.0
  val double2 = 2.0
  val int = 1
  val string = "1"

  var real1: Real = _
  var real2: Real = _
  var integer: Integer = _
  var xString: XString = _

  override def beforeEach(context: BeforeEach): Unit = {
    real1 = new Real(double1)
    real2 = new Real(double2)
    integer = new Integer(int)
    xString = new XString(string)
  }

  test("Two [[Real]] with the same value are equal") {
    assertEquals(real1, real1)
  }

  test("Two [[Real]] with different values are not equal") {
    assertNotEquals(real1, real2)
  }

  test("The hash code of two [[Real]] with the same value is the same") {
    assertEquals(real1.##, real1.##)
  }

  test("The hash code of two [[Real]] with different values is not the same") {
    assertNotEquals(real1.##, real2.##)
  }

  test("A [[Real]] can be converted to a [[String]]") {
    assertEquals(real1.toString, double1.toString)
  }

  test("A [[Real]] can be added to another [[Real]]") {
    assertEquals(real1.add(real2), new Real(double1 + double2))
  }

  test("An [[Integer]] can be added to a [[Real]]") {
    assertEquals(real1.add(integer), new Real(double1 + int))
  }

  test("Adding an [[XString]] to a [[Real]] throws an InvalidOperationException") {
    interceptMessage[InvalidOperationException]("XString should be leftmost in the add operation") {
      real1.add(xString)
    }
  }
}
