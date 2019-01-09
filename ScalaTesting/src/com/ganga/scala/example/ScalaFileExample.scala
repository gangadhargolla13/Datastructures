package com.ganga.scala.example

import java.io.File
import java.io.PrintWriter
import scala.io.Source

object ScalaFileExample {

  def main(arg :Array[String]){
    println("function is being called");
    val fileObject = new File("Demo.txt" )
    val printWriter = new PrintWriter(fileObject)
    printWriter.write("Hello, This is scala file")
    printWriter.close()
    println("---")
    readingFile();
  }
  
  def readingFile(){
    var fileName = "Demo.txt";
    var fileSource = Source.fromFile(fileName);
    for(line <- fileSource.getLines)
      println(line)
      fileSource.close;
  }
}
