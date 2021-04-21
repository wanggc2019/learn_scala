package learning

/**
  * 第四章 映射和元组
  * 映射是键值对偶的集合 ----scala中称为元组，n个对象的聚集
  */
object Learn03_map extends  App{

  //1、构造映射
  val scores = Map("Alices" -> 10,"Bob" -> 3,"Wgc" -> 20)  //不可变的Map[String,Int]
  val scores2 = scala.collection.mutable.Map("Alices" -> 10,"Bob" -> 3,"Wgc" -> 20) //可变得映射
  val scores3 = new scala.collection.mutable.HashMap[String,Int] //空映射
  //scala：映射是对偶得集合，对偶是2个值构成得组，这2个值并不一定是同类型得
  // ->操做符来建对偶
  // （）来建对偶
  val  scores4 = Map(("Alices",20),("Bob",30),("Wgc",40))

  //2、获取映射得值
  val bobScores = scores("Bob")
  println("bobScores : " + bobScores)

  //检查映射中是否含有某个键
  val wgcScores = if (scores.contains("Wgc")) scores("Wgc") else 0
  println("wgcScores : " + wgcScores)
  //便捷写法
  val alicesScores = scores.getOrElse("Alices",0)
  println("alicesScores : " + alicesScores)
  val alicesScores2 = scores.getOrElse("Smitsh",0)
  println("alicesScores2" + alicesScores2)

  //3、更新映射得值，可变得映射
//  scores("Bob") = 50 //报错，不可变
  val bobScores_source = scores2.getOrElse("Bob",0)
  println("bobScores_source : " + bobScores_source)
  //修改
  scores2("Bob") = 80
  val bobScores_des = scores2.getOrElse("Bob",0)
  println("bobScores_des : " + bobScores_des)
  // +=添加多个关系
  scores2 += ("Bob" -> 100,"Morch" -> 45) //修改Bob，添加Morch
  val bobScores2 = scores2.getOrElse("Bob",0)
  val morch = scores2.getOrElse("Morch",0)
  println("bobScores2 : " + bobScores2)
  println("Morch : " + morch)

  //移除使用-+
  scores2 -= "Morch"
  val morch2 = scores2.getOrElse("Morch",0)

  //不能更新一个不可变元组，但是可以组成一个新元组
  val newScores = scores + ("Bbq" -> 90,"Jim" -> 60)
  //从不可变映射中移除某个键
  val moveSocres = scores - "Morch"

  //4、迭代映射
  for (key <- scores.keySet)
    print(key + " ")
  println()
  for (values <- scores.values)
    print(values + " ")
  println()
  //反转映射，键值顺序倒过来
  for ((keys,values) <- scores) yield (values,keys)

  //5、已排序得映射
  //树形映射
  val scores5 = scala.collection.immutable.SortedMap("Alices" -> 10,"Bob" -> 3,"Wgc" -> 20)
  println("scores5 : " + scores5)

  //6、java互转

  //7、元组
  //映射是键值对偶得集合，对偶是元组得最简单得形态，元组是不同类型得值的集合
  val tuple = (10, 3.14, "Hello")
  //访问组元
  //元组的组元从1开始
  println("tuple._1 : " + tuple._1)
  println("tuple._2 : " + tuple._2)
  println("tuple._3 : " + tuple._3)
  //模式匹配
  println("Hello World".partition(_.isUpper))

  //8、拉链操做,2个数据的咬合
  val husband = Array("牛郎","李亚鹏","张杰");
  val wife = Array("织女","王菲","谢娜");
  val both = husband.zip(wife)
  println("husband : " + husband.mkString(","))
  println("wife : " + wife.mkString(","))
  for (i <- both) print(i)
  println()
  for ((h,w) <- both) Console.print(h ,w)
  println()
  //toMap将对偶转换成映射
  val both2 = husband.zip(wife).toMap
  println("both2 : " + both2)


}
