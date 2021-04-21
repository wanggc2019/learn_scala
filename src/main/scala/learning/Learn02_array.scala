package learning

import scala.collection.mutable.ArrayBuffer

/**
  * 第三章 数组相关操做
  */

object Learn02_array extends App {
//1、定长数组
  val nums = new Array[Int](10) //10个整数的数组，所有元素初始化为0
  val str = new Array[String](10) //10个字符串的数组，所有元素初始化为null
  //指定初始值
  val str2 = Array("Hello","wgc","you","money") //不需要new
  //访问数组元素
  println(str2(0)) //Hello

  //2、变长数组
  val arrayBuffer = ArrayBuffer[Int]()
  arrayBuffer += 1
  println(arrayBuffer)
  arrayBuffer += (1,2,3,4)
  println(arrayBuffer)

  arrayBuffer ++= Array(7,8,9)
  println(arrayBuffer)
  println(arrayBuffer(2))

  //遍历数组
  for (i <- 0 until arrayBuffer.length) // 0--a.length-1
    println("arrayBuffer[" + i + "]: " + arrayBuffer(i))

  for (i <- 0 until (arrayBuffer.length,2))
    println("arrayBuffer[" + i + "]: " + arrayBuffer(i))

  //数组转化
  val a = Array(11,12,13,14,15)
  val result = for (elem <- a) yield 2 * elem
  println(result)

  for (elem <- a if elem % 2 == 0) yield 2 * elem
  //or
  a.filter(_ % 2 == 0).map(2 * _)
  a.filter(_ % 2 == 0) map(2 * _)

  //常用算法
  //最值
  val b = Array(3,6,1,4,9).max
  println(b)

  //求和
  val c = Array(3,6,1,4,9).sum
  println(c)

  //排序
  val d = Array(3,6,1,4,9)
  val dSortd = d.sorted
  for (i <- 0 until dSortd.length)
    print(dSortd(i) + " ")
  println()

  //输出数组内容
  println(d.mkString(","))
  println(dSortd.mkString(","))
  println(dSortd.mkString("<",",",">"))

  //多维数组
  val e = Array.ofDim(3,4) //3行4列

  val f = new Array[Array[Int]](10)
  for (i <- 0 until f.length)
    f(i) = new Array[Int](i + 1)

  //scala和java的互操作


}
