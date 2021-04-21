package learning
import java.io.{File, FileInputStream, PrintWriter}

import com.sun.xml.internal.ws.developer.Serialization

import scala.io.Source

/**
  * 第九章 文件和正则表达式
  */
object Learn06_zhengze extends  App {
  //1、读取行
  val source = Source.fromFile("E:\\test.txt", "utf-8")
  val lineIterator = source.getLines()
  for (line <- lineIterator) println(line)
  //也可以将这些行放到数组或者数组缓冲
  val line2 = source.getLines().toArray
  //把整个文件读取成一个字符串
  val content = source.mkString
  println(content)

  //2、读取字符
  for (char <- source) print(char)

  //3、读取词法单元和数字
  val tokens = source.mkString.split("\\S+")
  print(tokens.mkString)

  //4、从url和其他源读取
  //  val source2 = Source.fromFile("http://horstamn","utf-8")
  //  println(source.mkString)
  val source3 = Source.fromString("Hello World")
  println(source3.mkString)
  val source4 = Source.stdin

  //5、读取二进制文件
  val file = new File("E:\\serverlist.bin")
  val in = new FileInputStream(file)
  val bytes = new Array[Byte](file.length.toInt)
  in.read(bytes)
  in.close()

  //6、写入文本文件
  val out = new PrintWriter("test2.txt")
  for (i <- 1 to 100) out.print(i + " ")
  out.close()

  //7、遍历目录
  def subdirs(dir: File): Iterator[File] = {
    val childern = dir.listFiles.filter(_.isDirectory)
    childern.toIterator ++ childern.toIterator.flatMap(subdirs _)
    //for (d <- subdirs(dir)) print(d)
  }

  //8、序列化
  //如果接受缺省的的id，可以省略@SerialVersionUID注解
  @SerialVersionUID(42L) class Person extends Serializable

  //9、进程控制
  //用sacla写脚本
  import sys.process._

//  "ls -al .." !
  //10、正则表达式
  val numPatter = "[0-9]+".r
  //如正则表达式包含斜杆或者，最好使用原始字符串语法"""..."""
  val wsnumPatter = """\s + [0-9] + \s""".r
  //10、正则表达式组
  val numitemPatter = "([0-9] + [a-z] + )".r




}