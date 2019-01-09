package com.ganga.scala

import java.io.PrintWriter
import java.io.File
import scala.io.Source

object IOoperations {

  def main(args : Array[String]){
    // Writing data into files
    /*val writer = new PrintWriter(new File("Demo.txt"))
    writer.write("I am back from today");
    writer.write("so sorry")
    writer.close()*/
    //Reading data from console
    /*println("Please enter your input :")
    val value = Console.readLine
    println(value)*/
    
    //Reading data from files
    println("Following is the content read: ")
    Source.fromFile("Demo.txt").foreach(print)
  }
}