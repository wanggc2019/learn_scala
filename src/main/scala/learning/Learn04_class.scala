package learning

import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer


/**
  * 第五章 类
  */
class Counter {
  private var value = 0 // 必须初始化值
  //方法是默认公有的
  def increment(): Unit = {
    value += 1
  }
  def current() = value
}

class Counter2{
  private var value = 0
  def increment() { value += 1}
  def isLess(other: Counter2) = value < other.value  //访问另一个对象得私有变量
}

class Person{
  //1、bean属性，自动生成4个方法
  @BeanProperty var name :String = _
  //name:String
  //name_=(newValue: String) : Unit
  //getName():String
  //setName(newValue:String) :Unit

}

/**
  * 构造器
  * 如果一个类没有显示定义构造器，那么将自动拥有一个取无参得主构造器
  */
class Person2 {
  private var name = ""
  private  var age = 0

  //辅助构造函数
  def this(name:String){
    //调用主构造器
    this()
    this.name = name
  }

  //另一个辅助构造器
  def this(name:String, age:Int) {
    //调用前一个构造器
    this(name)
    this.age = age
  }
}

/**
  * 嵌套类
  *
  */
class Network {
  class Member(val name:String){
    val contacts = new ArrayBuffer[Member]()
  }
  private val member = new ArrayBuffer[Member]()

  def join(name:String) = {
    val m = new Member(name)
    member += m
    m
  }
}

object myCounter {
  def main(args: Array[String]): Unit = {
    val myCounter = new Counter //构造对象调用方法
    myCounter.increment() //改值器 value = 1
    println(myCounter.current()) //取值器

    //主构造函器
    val person1 = new Person2()
    //第一个构造器
    val person2 = new Person2("wgc")
    //第二个构造器
    val person3 = new Person2("wgc",20)

    val chatter = new Network
    val myFace = new Network
    val fred = chatter.join("fred")
    val wilma = chatter.join("wilma")
    fred.contacts += wilma // ok
    val barary = myFace.join("barary")
//    fred.contacts += barary //不能将一个myFace.Member添加到chatter.Member


 }
}