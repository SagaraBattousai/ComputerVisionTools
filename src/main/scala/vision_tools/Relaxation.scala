package vision_tools

/**
  * Created by jam414 on 18/11/16.
  */
class Relaxation(img:Array[Array[Double]]) {

  val notImg = img.map(x => x.map(y => 1 - y))

  def q(r1:Int,r2:Int, aj:Double):Double = (r1*aj) + (r2*(1-aj))

  def adjacent(ai:(Int,Int), max:Int):List[(Int,Int)] = {
    val a = ai._1
    val b = ai._2
    val am = a -1
    val bm = b -1
    val ap = a + 1
    val bp = b + 1

    val k = List((am, bm),(a,bm),(ap,bm),(am, b),(ap,b),(am,bp),(a,bp),(ap,bp));

    k.filter(x => (x._1 >= 0 && x._1 < max) && (x._2 >= 0 && x._2 < max))

  }

  def Q(ai:(Int,Int), r1:Int, r2:Int):Double = {

    var sum = 0.0
    for((x,y) <- adjacent(ai,5)){
      sum += q(r1,r2, img(x)(y))
    }
    sum
  }

  def Q(ai:(Int,Int), r1:Int, r2:Int, img:Array[Array[Double]]):Double = {

    var sum = 0.0
    for((x,y) <- adjacent(ai,5)){
      sum += q(r1,r2, img(x)(y))
    }
    sum
  }

  def ps1(ai:(Int,Int)):Double = {

    val ps = img(ai._1)(ai._2)
    val psk = 1 - ps
    val Qs = Q(ai, 2, 1)
    val Qsk = Q(ai, 1, 1, notImg)

    (ps * Qs)/((ps * Qs) + (psk * Qsk))
  }

  def next():Array[Array[Double]] = {
    for(i <- 0 until img.length){
      for(j<- 0 until img.length){
        img(i)(j) = ps1((i,j))
      }
    }
    img
  }

  def next(img:Array[Array[Double]]):Array[Array[Double]] = {
    for(i <- 0 until img.length){
      for(j<- 0 until img.length){
        img(i)(j) = ps1((i,j))
      }
    }
    img
  }

    next();next()
    img.foreach(x => println(x.mkString(",")))
}
