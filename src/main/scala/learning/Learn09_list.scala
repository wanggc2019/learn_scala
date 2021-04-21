package learning

/**
  * 第 13 章 集合
  * scala的集合
  * Iterable
  * --Sep
  * --Set
  * --Map
  */

/**
  * 第 14章 模式匹配
  */
/*object Learn09_list extends App {
  //List不可变
  val list = List(4,2,3)
  println(list.head) //4
  println(list.tail) //List(2, 3)
  println(9::list) //List(9, 4, 2, 3)

  //集合
  //不重复元素
  val set = Set(1,2,3)

  /**
    * scala中switch的等效代码
    */
  var sign = 1
  var ch:Char = '+'
  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _  => sign = 0
  }
  //简化
  sign = ch match {
    case '+' => 1
    case '-' => -1
    case _ => 0
  }

  //守卫 任何boolean条件
  var digit = 1
  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _ if Character.isDigit(ch) => digit = Character.digit(ch,10)
    case _ => sign = 0
  }

  var obj =
  obj match {
    case x:Int => x
    case s:String => Integer.parseInt(s)
    case _ :BigInt => Int.MaxValue
    case _ => 0
  }

  //匹配数组列表和元组
  var arr = Array(1,2,3)
  arr match {
    case Array(0) => 0
    case Array(x,y) => x + " " + y
    case Array(0,_*) => "0 ..."
    case _ => "something else"
  }

  var lst = List(1,2,3)
  lst match {
    case 0::Nil => "0"
    case x::y::Nil => x + " " + y
    case 0::tail => "0..."
    case _ => "something else"
  }

  var tup = Tuple2(0,"wgc")
  tup match {
    case (0,_) => "0..."
    case (y,0) => y + " 0"
    case _ => "neither is 0"
  }
  //样例类
  
}*/


