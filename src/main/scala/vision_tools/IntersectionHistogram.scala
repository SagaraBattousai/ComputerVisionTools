package vision_tools

/**
  * Created by Gengar on 10/11/2016.
  */
class IntersectionHistogram(xRange:Int, yRange:Int) {

  val histogram = Array.ofDim[Int](yRange,xRange)

  val corner = '+'
  val horizontal = '-'
  val vertical = '|'



  def updateHistogram(points:List[Point]):Unit = {
    val floorPoints = points.map(_.floor(10,1))
      var i = 1
      for ( p <- floorPoints) {
        println(i + ": " + p)
        histogram(p._2)(p._1) += 1
        i += 1
      }

  }

  override def toString: String = {
    var s = ""
    for(data <- histogram.reverse) {
      s += " K = " + data.mkString(", ") + ":  \n"
    }
    s
  }



}
