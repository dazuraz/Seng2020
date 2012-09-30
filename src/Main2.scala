//
//import org.squeryl.PrimitiveTypeMode._
//import org.squeryl._
//import dsl.ast._
//import java.sql.{Savepoint}
//import scala.Array$
//
//object Main {
//  def main(args: Array[String]): Unit = {
//    println("Hi!")
//    Random.main(args)
////    val f = new Product("Cake", 0, 0, 0, 0, 0, 0, 0, false)
////    POSItiveDB.products.insert(f);
////  	for(p : Product <- POSItiveDB.products)
////  		println(p.ProductName)
//  }
//}
//
//object POSItiveDB extends Schema {
//  def products = table[Product]
//}
//
//trait POSid {
//  val id: Long = 0
//}
//
//class Product(var ProductName: String,	
//    var SeasonalFloats: Float,
//	var Discount: Float,
//	var UnitSize: Int,
//	var TotalProducts: Int,
//	var WarehouseProducts: Int,
//	var BackroomProducts: Int,
//	var ShelfProducts: Int,
//	var Discountinued: Boolean) extends POSid {
//    lazy val prod = POSItiveDB.products
//}