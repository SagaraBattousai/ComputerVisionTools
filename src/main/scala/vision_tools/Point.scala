package vision_tools

/**
  * Created by Gengar on 10/11/2016.
  */
class Point(_x:Double,_y: Double) {

  def x = _x

  def y = _y

  def floor(xScale:Int, yScale:Int):(Int, Int) = ((x * xScale).floor.toInt, (y * yScale).floor.toInt)

  def floor():(Int, Int) = floor(1,1)

  override def toString: String = "[" + x + ", " + y + "]"

  override def hashCode(): Int = {
    var hash = 23
    val hashscale = 31
    val intpoint = this.floor()
    hash = hash * hashscale + intpoint._1
    hash = hash * hashscale + intpoint._2
    hash
  }

  override def equals(obj: scala.Any): Boolean = {
    var equals = false
    if(obj.isInstanceOf[Point]) {
      val other = obj.asInstanceOf[Point]

      equals = (other.x == this.x) && (other.y == this.y);
    }
    equals
  }


}
