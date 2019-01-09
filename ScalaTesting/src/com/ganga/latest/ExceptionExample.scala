package com.ganga.latest

import java.io.FileNotFoundException
import java.io.IOException

object ExceptionExample {

  def main(args:Array[String]){
    
  }
  
  def testing(a:Array[Int]){
    try
    {
      var sum:Int=0
      for(x <- 0 to a.length-1)
      {
        println("Values are ")
      }
    }
    catch
    {
      case ex:FileNotFoundException => {
        println("Missing file exception")
      }
      case ex:IOException => {
        println("IO Exception")
      }
    }
  }
}