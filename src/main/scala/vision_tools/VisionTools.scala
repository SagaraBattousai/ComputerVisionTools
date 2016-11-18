package vision_tools

/**
  * Created by Gengar on 10/11/2016.
  */
object VisionTools {

  def main(args: Array[String]): Unit = {

    val points = List(new Point(0.0,5.5),
                      new Point(1.0,6.0),
                      new Point(3.5,7.0),
                      new Point(2.5,6.5),
                      new Point(4.5,7.5),
                      new Point(6.0,8.0),
                      new Point(7.5,8.5),
                      new Point(9.0,9.0),
                      new Point(11.9, 9.5),
                      new Point(14.3,10)
                     )


    val k = Array.ofDim[Double](5,5)

    k(0) = Array(0.0,0.0,0.0,0.0,0.0)
    k(1) = Array(0.0,0.1,0.1,0.1,0.0)
    k(2) = Array(0.0,0.1,1.0,0.1,0.0)
    k(3) = Array(0.0,0.1,0.1,0.1,0.0)
    k(4) = Array(0.0,0.0,0.0,0.0,0.0)

    val rel = new Relaxation(k)




  }

}
