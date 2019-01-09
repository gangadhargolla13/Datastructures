package com.ganga.scala

import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

object ExceptionTest {

  def main(args : Array[String]){
    try{
      var f = new FileReader("input.txt");
    }catch{
      case ex: FileNotFoundException => {
        println("missing file exception")
      }
      case ex : IOException => {
        println("File not found exception")
      }
    }
    finally{
      println("successfully existed")
    }
  }
}