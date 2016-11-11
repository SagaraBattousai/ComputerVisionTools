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


}
