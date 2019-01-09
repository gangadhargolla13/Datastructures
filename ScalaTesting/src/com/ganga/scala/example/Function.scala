package com.ganga.scala.example

class Function {

  def test(xy:Int) = {
    var a =10;
     a;
  }
  
  def defultValue(a:Int = 10,b:Int =9) = {
    val c = a+b;
    c;
  }
  
  def multiplyBy2(a:Int):Int={
    a*2;
  }
  def funExample(a:Int,f:Int=>AnyVal):Unit={
    println(f(a))
  }
  def add(a:Int,b:Int,c:Int) = {
    def add2(x:Int,y:Int) = {
      x+y
    }
    add2(a,add2(b,c))
  }
}

object Function{
  def main(arg:Array[String]){
    val dd = new Function();
    println(dd.add(10, 67, 98))
    dd.funExample(25, dd.multiplyBy2);
    var result1 = (a:Int,b:Int) =>a+b;
    println(result1(10,29))
   /*println(dd. test(10));
   println(dd.defultValue());
   println(dd.defultValue(20, 10));
   println(dd.defultValue(b= 89, a=1))*/
    add(1,2,3,4,56,7)
  }
  
  def add(a:Int*) = {
    var sum = 0
    for(b <- a){
      sum +=b;
    }
    println(sum)
  }
}