package learning

import java.io.IOException


/**
  * @author wanggc
  * @date 2019/10/06 星期日 15:33
  * scala学习
  * 第一章 基础
  * 第二章 控制结构和函数
  */
object Learn01_function extends App {
  val ages = Seq(42,61,29,64)
  println(s"The oldest person is ${ages.max}")

  /**
    * 条件表达式
    */
  //if else
  var x: Int = 10
  val s = if (x > 0) 1 else -1
  println("s=" + s)

  //混合类型，int 和 String 公共超类是 Any
  val s1 = if (x > 0) "person" else -1
  println("s1=" + s1)

  //返回(),Unit类，表示无用值得占位符
  val s2 = if (x < 0) 1
  println("s2=" + s2)

  //输入和输出

  //循环
  //while
  var r = 1
  while (x > 1) {
    // r = r + x
    r = x * x
    x -= 1
    println("r=" + r)
  }

  //for
  var k = 1
  for (i <- 1 to 10)
    k = k + i // 1+1+2+...10 = 56
  println("k=" + k)

  var sum = 0
  for (ch <- "Hello") sum +=ch
  println("sum = " + sum)

  //高级for循环何for推导式
  for (i <- 1 to 3;j <- 1 to 3) print((10 * i + j) + " ")
  println()

  for (i <- 1 to 3) yield i % 3

  //函数
  //函数名称，参数，函数体
  def abs(x : Double) = if (x >= 0) x else -x
  val num = abs(-3)
  println(s"This num abs is: $num ")

  //函数体多个表达式，{}
  def fac(n : Int) = {
    var r = 1
    for (i <- 1 to n) r = r * i
    r
  }
  val fac_demo = fac(2)
  println(s"fac_demo is : $fac_demo")

  //递归函数必须指定返回类型
  def fac2(n : Int) : Int = if (n <= 0) 1 else fac2(n - 1)
  val fac2_demo = fac2(3)
  println(s"fac2_demo is : $fac2_demo")

  //默认参数和带名参数
  def decorate(str : String, left : String = "[", right : String = "]") = left + str + right
  val decorate_demo = decorate("Hello")
  println(s"decorate_demo is : $decorate_demo")

  //变长参数
  def sum(args : Int*) = {
    var result = 0
    for (arg <- args) result += arg
    result
  }
  val sum_demo = sum(1,3,5,9)
  val sum_demo2 = sum(1 to 5:_*)
  println(s"sum_demo is : $sum")

  //过程：不返回值的函数叫过程procedure,他的返回值就是unit
  def box(s:String): Unit ={
    var border = "-" * s.length + "--\n"
    println(border + "|" + s + "|\n" + border)
  }
  val box_demo = box("Hello")
  println(s"$box_demo")

  //懒值，初始化延迟，知道首次对他取值
  //减少开销
  lazy val word = scala.io.Source.fromFile("test.txt").mkString //只有用到test.txt文件时才会读取

  //异常
  try{

  } catch {
    case ex: IOException => ex.printStackTrace()
  } finally {

  }



}

