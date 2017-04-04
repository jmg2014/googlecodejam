package qualification2015.a

import java.io.BufferedReader

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito._

class StandingOvationTest extends FunSuite with BeforeAndAfter with MockitoSugar {


  test("no more people needed") {

    val bufferedReader: BufferedReader = mock[BufferedReader]

    when(bufferedReader.readLine()).thenReturn("6 4069616")

    assert(0 == StandingOvation.solve(bufferedReader))

  }


  test("test all 1") {

    val bufferedReader: BufferedReader = mock[BufferedReader]

    when(bufferedReader.readLine()).thenReturn("4 11111")

    assert(0 == StandingOvation.solve(bufferedReader))

  }


  test("test gap in the middle") {

    val bufferedReader: BufferedReader = mock[BufferedReader]

    when(bufferedReader.readLine()).thenReturn("5 110011")

    assert(2 == StandingOvation.solve(bufferedReader))

  }
  test("test only one") {

    val bufferedReader: BufferedReader = mock[BufferedReader]

    when(bufferedReader.readLine()).thenReturn("0 1")

    assert(0 == StandingOvation.solve(bufferedReader))

  }

  test("only needed the first person ") {
    assert(1 == StandingOvation.solve2("0122111", 0, 0, 0))
  }

  test("six people needed") {
    assert(6 == StandingOvation.solve2("0000001", 0, 0, 0))
  }


}
