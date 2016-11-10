package vision_tools

/**
  * Created by Gengar on 10/11/2016.
  */
class MCLine(line:String) {

  def this(point:Point) {
    this(""+ point.y + "+" + (-1 * point.x) + "m")
  }

  val xy:(Double,Double) = {
    val s = line.split('+')
    (s(1).split('m')(0).toDouble, s(0).toDouble)

  }
  def y:Double = xy._2

  def x:Double = xy._1

  def $(m:Double):Double = y + (x * m)

  def intersect(other:MCLine):Double = {
    val y = this.y - other.y
    val x = other.x - this.x
    return y/x

  }

  def intersect(lines:List[MCLine]):List[Double] = {
    for {
      line <- lines.filter(_ != this)
      intersections = intersect(line)
    } yield intersections

  }

  override def toString: String = line

  override def equals(obj: scala.Any): Boolean = this.toString == obj.toString




}
