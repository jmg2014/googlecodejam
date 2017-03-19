package qualification2016.b

import java.io.{BufferedReader, FileInputStream, InputStreamReader, PrintWriter}

/*
https://code.google.com/codejam/contest/6254486/dashboard#s=p1
 */
object RevengePancakes {

  def main(args: Array[String]): Unit = {


    val out = new PrintWriter("src/main/scala/qualification2016/b/B-large-practice.out")
    val in = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/scala/qualification2016/b/B-large-practice.in")))

    val numTests = Integer.parseInt(in.readLine())


    (1 to numTests).foreach(i => out.println("Case #" + i.toString + ": " + solve(in)))

    in.close()
    out.close()


    def solve(in: BufferedReader): String = {


      var pancakes: String = in.readLine()

      var flipCount: Int = 0

      var position: Int = pancakes.length - 1

      while (position >= 0) {

        if (pancakes(position) == '-') {
          pancakes = flip(pancakes, position)
          flipCount = flipCount + 1
        }

        position = position - 1

      }

      flipCount.toString
    }

    def flip(pancakes: String, position: Int): String = {

      var aux = pancakes.slice(0, position + 1).map(_ match { case '+' => '-' case '-' => '+' })

      var result = aux + pancakes.substring(position+1,pancakes.length)

      result

    }


  }
}
