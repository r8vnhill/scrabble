
package cl.uchile.dcc
package scrabble.types

import munit.FunSuite

class XStringTest extends FunSuite {
  val string1 = "1"
  val string2 = "2"
  val int = 1
  val double = 1.0

  var xString1: XString = _
  var xString2: XString = _
  var integer: Integer = _
  var real: Real = _

  override def beforeEach(context: BeforeEach): Unit = {
    xString1 = new XString(string1)
    xString2 = new XString(string2)
    integer = new Integer(int)
    real = new Real(double)
  }

  test("Two [[XString]] with the same value are equal") {
    assertEquals(xString1, xString1)
  }

  test("Two [[XString]] with different values are not equal") {
    assertNotEquals(xString1, xString2)
  }

  test("The hash code of two [[XString]] with the same value is the same") {
    assertEquals(xString1.##, xString1.##)
  }

  test("The hash code of two [[XString]] with different values is not the same") {
    assertNotEquals(xString1.##, xString2.##)
  }

  test("An [[XString]] can be converted to a [[String]]") {
    assertEquals(xString1.toString, string1)
  }

  test("An [[XString]] can be added to another [[XString]]") {
    assertEquals(xString1.add(xString2), new XString(string1 + string2))
  }

  test("An [[Integer]] can be added to an [[XString]]") {
    assertEquals(xString1.add(integer), new XString(string1 + int))
  }

  test("A [[Real]] can be added to an [[XString]]") {
    assertEquals(xString1.add(real), new XString(string1 + double))
  }
}