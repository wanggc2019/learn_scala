package learning

/**
  * 第十章 特质
  * 类似java的接口
  */

trait Logger{
  def log(msg: String) //抽象方法，不用加abstract,t特质中未被实现得方法默认就是抽象得
}

//字类给与实现
class ConsoleLogger extends Logger{
  //override可以不写
  def log(msg: String): Unit = {
    print(msg)
  }
}

//需要多个特质用with
class ConsoleLogger2 extends Logger with Specializable{
  def log(msg: String): Unit = {
    println(msg)
  }
}

trait Logged{
  def log(msg:String) {}
}

//叠加再一起得特质
trait TimeStampLogger extends Logged{
  abstract override def log(msg: String): Unit = super.log(new java.util.Date() + msg) //日志添加时间戳
}

trait ShortLogger extends Logged{
  val maxLength = 15
  override def log(msg: String): Unit = super.log(
    if (msg.length <= maxLength) msg else msg.substring(0,maxLength - 3) + "...") //截断过于冗长得日志
}

//自身类型
//this: 类型 => 只能被混入指定类型的子类
trait LoggedException extends Logged{
  this: Exception =>
  def log() {log(getMessage)}
}



