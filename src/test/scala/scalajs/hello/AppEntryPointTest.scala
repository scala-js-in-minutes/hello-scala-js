package scalajs.hello

import org.scalatest._

import scala.scalajs._
import scala.scalajs.js.JavaScriptException

class AppEntryPointTest extends FunSuite {

  val expectedWelcomeMessage = "Hello scala.js developer! :D"

  test("Welcome message should great a developer") {
    assert(AppEntryPoint.welcomeMessage() === expectedWelcomeMessage)
  }

  test("Welcome message function is exposed to javascript") {
    assert(js.eval("app.welcomeMessage()") === expectedWelcomeMessage)
  }

  test("Ensure that 'eval' fails for an undefined function") {
    assertThrows[JavaScriptException] {
      js.eval("app.unknownFunction()")
    }
  }

  test("The application should successfully run and print a greeting message in the browser's console") {
    ConsoleLogsRecorder.start()
    AppEntryPoint.main(Array())
    assert(ConsoleLogsRecorder.stopAndGetLogs() === List(expectedWelcomeMessage))
  }
}