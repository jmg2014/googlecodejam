package qualification2015.a

import java.io.{BufferedReader, FileInputStream, InputStreamReader, PrintWriter}
/*
https://code.google.com/codejam/contest/6224486/dashboard#s=p0
 */
object StandingOvation {


  def main(args: Array[String]): Unit = {

    val out = new PrintWriter("src/main/scala/qualification2015/a/A-large-practice.out")
    val in = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/scala/qualification2015/a/A-large-practice.in")))

    val numTests = Integer.parseInt(in.readLine())

    (1 to numTests).foreach(i => out.println("Case #" + i.toString + ": " + solve(in)))

    in.close()
    out.close()

  }

  def solve(in: BufferedReader): Int = {

    val List(shyest, attendees) = in.readLine().split(' ').toList.map(_.toString)

    solve2(attendees, 0, 0, 0)
  }


  def calculation(position: Integer, count: Int, extra: Int): Int = {
    if (count + extra >= position) {
      0
    }
    else {
      position - (count + extra)
    }
  }

  def solve2(attendees: String, position: Int, count: Int, extra: Int): Int = {

    attendees.length match {
      case 1 => extra + calculation(position, count, extra)
      case _ => solve2(attendees.slice(1, attendees.length), position + 1, count + attendees.charAt(0).asDigit, extra + calculation(position, count, extra))
    }


  }

}
