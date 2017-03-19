package qualification2016.a

import java.io.{BufferedReader, FileInputStream, InputStreamReader, PrintWriter}

/*
https://code.google.com/codejam/contest/6254486/dashboard#s=p0
 */
object CountingSheep {

  def main(args: Array[String]): Unit = {

    val out = new PrintWriter("src/main/scala/qualification2016/a/A-large-practice.out")
    val in = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/scala/qualification2016/a/A-large-practice.in")))

    val numTests = Integer.parseInt(in.readLine())

    (1 to numTests).foreach(i => out.println("Case #" + i.toString + ": " + solve(in)))

    in.close()
    out.close()


    def solve(in: BufferedReader): String = {


      //keep track of the numbers that has been seen
      val seen = Array(false, false, false, false, false, false, false, false, false, false)


      val number = in.readLine().toInt


      if (number ==0) return "INSOMNIA"

      var next:Int=1
      var candidate=0

      while (!checkNumSeen(seen)){

        candidate=number*next
        solveOne(candidate,seen)
        next=next+1

      }

      candidate.toString
    }

    def solveOne(number: Int, seen: Array[Boolean]):Unit = {

      var candidate = number

      while (candidate > 0) {
        seen(candidate%10) = true
        candidate = candidate / 10
      }

    }

    def checkNumSeen(seen:Array[Boolean]):Boolean={

      var count:Int=0

      for(i <- seen.indices){
        if (seen(i)) count=count+1
      }

      count==10
    }
  }
}
