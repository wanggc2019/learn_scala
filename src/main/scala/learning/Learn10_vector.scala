package learning

/**
  * 第 17 章 类型参数
  */
class Learn10_vector {

}
//泛型类
class Pair[F,S](val frist:F,val second:S){

}
//类型变量界定
class Pair2[T <: Comparable[T]](val frist:T,val second:T){
  def smaller = if (frist.compareTo(second) < 0) frist else second
}

//视图界定
class Pair3[T <% Comparable[T]](val frist:T,val second:T){
  def smaller = if (frist.compareTo(second) < 0) frist else second
}
//上下文界定
class Pair4[T: Ordering](val frist:T,val second:T){
  def smaller(implicit ord:Ordering[T]): Unit ={
    if (ord.compare(frist,second) < 0) frist else second
  }
}

object Test2 extends App{
  val p = new Pair(42,"wgc")
  //泛型函数
  def getMiddle[T](a:Array[T]) = a{a.length / 2}

  getMiddle(Array("wgc",20,"Hello"))

  //类型变量界定
  val p2 = new Pair2("wgc","Hello")
  println(p2.smaller)
  //视图界定
  val p3 = new Pair3(2,4)
  println(p3.smaller)

  val p4 = new Pair4("wgc","Hello")
  println(p4.smaller)




}