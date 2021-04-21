package learning

import java.util.concurrent.locks.Condition

/**
  * 第 12 章 高阶函数
  * scala里面  函数是 “头等公民”,scala无法直接操纵方法，只能操纵函数
  */

object Learn08_function extends App {
  //值函数
  import scala.math._
  val num = 3.14
  val fun = ceil _  //将fun设为ceil()函数

  fun(num) //4.0
  Array(2.13,4.56,8.91).map(fun) //map接受一个函数参数并应用到所有的数组元素

  //匿名函数
  (x:Double) => 3 * x
  Array(2.13,4.56,8.91).map( (x:Double) => 3 * x)
  Array(2.13,4.56,8.91).map{(x:Double) => 3 * x}  //也可以用{}将函数参数包括起来

  //带函数参数的函数
  def valueAtOneQuarter(f: (Double) => Double) = f(0.25)

  //参数类型推断
  valueAtOneQuarter(x => x * 3)
  valueAtOneQuarter(3 * _) //等价于上面的

  //一些有用的高阶函数
  //map
//  (1 to 9).map(3 * _).foreach(println _) // 1-9 都乘以3
//  (1 to 9).map("*" * _).foreach(println _) // 打印三角形

//  (1 to 9).filter(_ % 2 == 0).foreach(println _) //过略偶数

  //闭包
  def mulBy(factor:Double) = (x:Double) => factor * x
  val triple = mulBy(3) // 3 * x
  val half = mulBy(0.5) // 0.5 * x
//  println(triple(14) + "," + half(14)) //42.0  7.0

  //SAM转换 single abstrac method

  //柯里化
  //将原来接受2个参数的函数变成接受一个参数的过程
  def mul(x:Int, y:Int) = x * y
  //柯里化
  def mulAtOneTime(x:Int) = (y:Int) => x *y
//  println(mulAtOneTime(6)(7)) // 6 * y, 6 *7 = 42
  //简写
  def mulAtOneTime2(x:Int,y:Int) = x * y
//  println(mulAtOneTime2(6,7))

  val a = Array("Hello","World")
  val b = Array("Hello","Wgc")
//  println(a.corresponds(b) (_.equalsIgnoreCase(_)))

  //控制抽象
  def runInThread(block: () => Unit): Unit ={
    new Thread {
      override def run(): Unit = { block()}
    }.start()
  }
//  runInThread{() => println("Hi"); Thread.sleep(1000); println("Bye")}

  def until(condition: => Boolean) (block: => Unit): Unit ={
    if (!condition){
      block
      until(condition) (block)
    }
  }
  var x =10
  until(x == 0){
    x -= 1
    println(x)
  }

  //return
  def indexOf(str: String,ch: Char): Unit = {
    var i = 0
    until(i == str.length){
      if (str(i) == ch) return i
      i += 1
    }
    return -1
  }
  indexOf("Hello",'e')



}