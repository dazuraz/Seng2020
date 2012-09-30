//import org.squeryl.PrimitiveTypeMode._
//import org.squeryl.Schema
//import org.squeryl.annotations.Column
//import java.util.Date
//import java.sql.Timestamp
//
//
//class Loyalty (var LoyaltyID: Long, 
//	var firstName: String, 
//	var lastName: String,
//	var email: Option[String],
//	var LoyaltyBegin: Date,
//	var LoyaltyPoints: Int,
//	var LoyaltyUsed: Int) {
//    def this() = this(0,"","",Some(""), new Date("2012 January 12"), 0, 0)		
//
//	    //def removeAccount();
//
//	    //def changeDetails();
//
//	    def incLoyaltyPoints(price: Int){
//	LoyaltyPoints += price/10
//    }
//
//    def decLoyaltyPoints(points: Int) {
//	LoyaltyPoints -= points
//    }
//}
//
//class Employees (var EmploymentType: String,
//	val EmploymentBegin: Date,
//	var EmploymentEnd: Date) extends Loyalty {
//    def this() = this ("", new Date("2012 January 12"), new Date("2012 January 12"))
//}
//
//class Admin (val AdminBegin: Date,
//	var AdminEnd: Date) extends Employees {
//    def this() = this (new Date("2012 January 12"), new Date("2012 January 12"))
//
//	    def getSpecialAccount(managerCode: String) {
//	class Privileges (var managerCode: String, var storeStatus: Boolean) {
//	    def changeManagerCode(newStr: String) {
//		managerCode = newStr
//	    } 
//
//	    def openCloseStore () {
//		if (storeStatus == false)
//		    storeStatus = true
//		    else storeStatus = false
//	    }
//	}
//	val special:Privileges = new Privileges(new String, false)
//	special
//    }
//}
//
//class stockShiftHist (var SupplierOrder: String, ShelfHist: String, BackroomHist: String, WarehouseHist: String) {
//    def this() = this("", "", "", "")
//
//	    def changeOrders (Orders: String) {
//	SupplierOrder = Orders
//    }
//}
//// fields can be mutable or immutable 
//
//class Product2 (var ProductID: Long,
//	var SeasonalFloats: Float,
//	var Discount: Float,
//	var UnitSize: Int,
//	var TotalProducts: Int,
//	var WarehouseProducts: Int,
//	var BackroomProducts: Int,
//	var ShelfProducts: Int,
//	var Discountinued: Boolean,
//	var Type: String) {
//    def this() = this(0, 0, 0, 0, 0, 0, 0, 0, false, "")
//}
//
//class Storage (var Type: String,  
//	var Category: String,
//	var Capacity: Int,
//	var CurrentSize: Int) {
//    def this() = this ("", "", 0, 0)
//}
//
//class Transaction (var BasketProducts: Option[Product2],
//	var TotalPrice: Float,
//	var ReceiptID: Long,
//	var Date: Date,
//	var EmployeeID: Long){
//    def this() = this (Some(new Product2()), 0, 0, new Date("2012 January 12"), 0)
//}
//
//class Purchase (var ChangeGiven: Float,
//	var BasketPrice: Float,
//	var LoyaltyPointsEarned: Int,
//	var MoneyReceived: Float,
//	var CustomerID: Long,
//	var TotalTax: Float,
//	var PriceType: String,
//	var PaymentType: String) extends Transaction {
//    def this() = this (0, 0, 0, 0, 0, 0, "", "")
//}
//
//class Losses (var ReasonForLoss: String,
//	var ProductName: String,
//	var ProductID: Int,
//	var ProductPrice: Float) extends Transaction {
//    def this() = this ("", "", 0, 0)
//	    println (this.ProductPrice)
//}
//
//class Exchange (var OldTransactionID: Long) extends Transaction {
//    def this() = this (0)
//}
//
//class Refund (var MoneyReturned: Float,
//	var PreviousReceiptID: Float,
//	var RefundCondition: String) extends Transaction {
//    def this() = this(0, 0, "")
//}
//
//object Random {
//    def main (args: Array[String]) {
//	println ("cake")
//	var loss:Losses = new Losses
//	loss.ProductID = 3;
//	Library.products.insert(new Product2());
//	Library.products.insert(new Product2(2, 0, 0, 0, 0, 0, 0, 0, false, "str"));
//	//var borrowals = table[Transaction]
//	for (product : Product2 <- Library.products)
//	  println(product.ProductID)
//    }
//}
//
//object Library extends Schema {
//    //When the table name doesn't match the class name, it is specified here :
//    var authors = table[Loyalty]
//	    var products = table[Product2]
//		    var borrowals = table[Transaction]	
//}