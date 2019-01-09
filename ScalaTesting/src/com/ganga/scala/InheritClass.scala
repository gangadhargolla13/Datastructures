package com.ganga.scala

class Point(val xy : Int,val yx : Int){
  var x : Int = xy;
  var y : Int = yx;
  
  def move(dx : Int, dy : Int){
    x = x + dx;
    y = y + dy;
    println("value of x is "+x)
    println("value of y is "+y)
  }
}

class Point1(override val xy:Int,override val yx:Int,val zz:Int) extends Point(xy,yx){
  var z : Int = zz;
  
  def move(dx:Int,dy:Int,dz:Int){
    x = x + dx;
    y = y + dy;
    z = z + dz;
    println("value of x is "+x);
    println("value of y is "+y);
    println("value of z is "+z)
  }
}
object InheritClass {
  def main(args : Array[String]){
    val po = new Point1(10,20,10);
    po.move(12, 34)
    //po.move(5, 6, 7);
  }
  
}