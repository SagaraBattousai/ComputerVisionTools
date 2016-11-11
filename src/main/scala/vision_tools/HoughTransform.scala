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
  /*
    def intersections():List[Point] = {
      var m = List[Point]()
      for(
        point <- points;
        line = new MCLine(point);
        inter = line.intersect(lines)
      )yield inter
      }
    }
    */

  def intersections():List[List[Point]] = {
    for (
      point <- points;
      line = new MCLine(point);
      inter = line.intersect(lines)
    ) yield inter
  }

}
