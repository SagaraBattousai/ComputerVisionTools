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

    println(lines)

    println(l.intersect(lines))

    println(l.intersect(ll))

    println(h.intersections())





  }

}
