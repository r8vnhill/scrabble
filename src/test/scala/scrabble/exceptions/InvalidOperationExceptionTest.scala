
package cl.uchile.dcc
package scrabble.exceptions

import munit.FunSuite

class InvalidOperationExceptionTest extends FunSuite {
  private val message = "This is a test message"
  private var exception: InvalidOperationException = _

  override def beforeEach(context: BeforeEach): Unit = {
    exception = new InvalidOperationException(message)
  }

  test("An [[InvalidOperationException]] can be created with a message") {
    assertEquals(exception.getMessage, message)
  }
}
