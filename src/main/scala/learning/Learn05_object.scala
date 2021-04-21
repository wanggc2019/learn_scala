package learning

import learning.Account.lastNumber

/**
  * 第六章 对象
  */
object Learn05_object {

  //1、单例对象
  //scala无静态对象
  private var lastNumber = 0
  def newUniqueNumber() = {
    lastNumber += 1
    lastNumber
  }
}

//2、伴生对象
class Account{
  val id = Account.newUniqueNumber() //调用半生对象的方法
  private var balance = 0.0
  def deposit (amount : Double) {
    balance += amount
  }
}
//类和他的伴生对象可以互访私有特性
object Account{
  private var lastNumber = 0
  private def newUniqueNumber() = {lastNumber += 1; lastNumber}
  val account = new Account
  account.deposit(1.2)
}

//3、扩展类或者特质的对象
abstract class UndoableAction(val description:String){
  def undo():Unit
  def redo():Unit

}

object DoNothingAction extends UndoableAction("Do Nothing"){
  override def undo(){}
  override def redo(){}
}

//4、枚举
// scala没有枚举类型，不过标准库给出了一个Enumeration助手类，用于产出枚举
object TrafficLightColor extends Enumeration{
  type TrafficLightColor = Value
  val Red, Yellow, Green = Value
  def doWhat(color: TrafficLightColor) = {
    if (color == Red) "stop"
    else if (color == Yellow) "hurry up"
    else "go"
  }
}

object Demo {
  def main(args: Array[String]): Unit = {
    Learn05_object.newUniqueNumber()

    val action = Map("open"-> DoNothingAction,"save"-> DoNothingAction)
    println(action.mkString(","))

    //输出所有枚举值的集
    for (c <- TrafficLightColor.values) println(c.id + ": " + c)
    //可以通过枚举的id和名称来定位查找
    println("TrafficLightColor(0): " + TrafficLightColor(0))
    println("TrafficLightColor.withName(\"Red\"): " + TrafficLightColor.withName("Red"))

  }
}
