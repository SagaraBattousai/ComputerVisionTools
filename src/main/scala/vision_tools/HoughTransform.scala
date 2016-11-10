package vision_tools

/**
  * Created by Gengar on 10/11/2016.
  */
class HoughTransform(points:List[Point]) {

  val lines:List[MCLine] = {
    for {
      point <- points
      line = new MCLine(point)
    } yield line
  }

  def intersections():Map[Point, List[Double]] = {
    var m = Map[Point, List[Double]]()
      for(
        point <- points;
        line = new MCLine(point);
        inter = line.intersect(lines)
      )
    {
      m += (point -> inter)
    }
    m
    }



}
