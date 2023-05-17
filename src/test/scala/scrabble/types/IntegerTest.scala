
package cl.uchile.dcc
package scrabble.types

import scrabble.exceptions.InvalidOperationException

import munit.FunSuite

class IntegerTest extends FunSuite {
  private val int1 = 1
  private val int2 = 2
  private val double = 1.0
  private val string = "1"

  var integer1: Integer = _
  var integer2: Integer = _
  var real: Real = _
  var xString: XString = _

  override def beforeEach(context: BeforeEach): Unit = {
    integer1 = new Integer(int1)
    integer2 = new Integer(int2)
    real = new Real(double)
    xString = new XString(string)
  }

  test("Two [[Integer]] with the same value are equal") {
    assertEquals(integer1, integer1)
  }

  test("Two [[Integer]] with different values are not equal") {
    assertNotEquals(integer1, integer2)
  }

  test("The hash code of two [[Integer]] with the same value is the same") {
    assertEquals(integer1.##, integer1.##)
  }

  test("The hash code of two [[Integer]] with different values is not the same") {
    assertNotEquals(integer1.##, integer2.##)
  }

  test("An [[Integer]] can be converted to a [[String]]") {
    assertEquals(integer1.toString, int1.toString)
  }

  test("An [[Integer]] can be added to another [[Integer]]") {
    assertEquals(integer1.add(integer2), new Integer(int1 + int2))
  }

  test("A [[Real]] can be added to an [[Integer]]") {
    assertEquals(integer1.add(real), new Real(int1 + double))
  }

  test("Adding an [[XString]] to an [[Integer]] throws an InvalidOperationException") {
    interceptMessage[InvalidOperationException]("XString should be leftmost in the add operation") {
      integer1.add(xString)
    }
  }
}