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

    val l = new MCLine(points(9))
    val l2 = new MCLine(points(1))
    val ll = new MCLine(points(0))
    val lines:List[MCLine] = for{
                    point <- points
                    line = new MCLine(point)
                   }yield line

    val h = new HoughTransform(points)

    val intersect = h.intersections().flatten

    println(intersect)

    //intersect.foreach(p => println(p.toString + "\n"))

    println(intersect.map(_.floor(10,1)))

    val hist = new IntersectionHistogram(10, 10)

    hist.updateHistogram(intersect)
    println(hist)

    val k = Array.ofDim[Double](5,5)

    k(0) = Array(0.0,0.0,0.0,0.0,0.0)
    k(1) = Array(0.0,0.1,0.1,0.1,0.0)
    k(2) = Array(0.0,0.1,1.0,0.1,0.0)
    k(3) = Array(0.0,0.1,0.1,0.1,0.0)
    k(4) = Array(0.0,0.0,0.0,0.0,0.0)

    val rel = new Relaxation(k)



  }

}
