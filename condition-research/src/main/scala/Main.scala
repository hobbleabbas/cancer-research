import scala.io.StdIn

@main def hello: Unit = 
  println("Welcome to the cancer research shell. Enter a condition UMLS")
  println(msg + "enter a condition below: ")
  val testVal = StdIn.readLine()
  println(s"Accepted input, $testVal")

def msg = "I was compiled by Scala 3. :)."