
import org.squeryl._
import adapters.H2Adapter
import PrimitiveTypeMode._
import java.util.Date
import java.text.SimpleDateFormat
import eventBclasses.Library
import scala.dbc.statement.Transaction

object Main {
  def main(args: Array[String]) {
    Class.forName("org.h2.Driver");
    SessionFactory.concreteFactory = Some(()=>
      Session.create(
        java.sql.DriverManager.getConnection("jdbc:h2:~/example", "sa", ""),
        new H2Adapter)
    )

    inTransaction {
      import Library._
      import eventBclasses._
      import salesController._

      drop
      create
      printDdl
      val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
      val may2009 = dateFormat.parse("2009-05-01")
      val jan2009 = dateFormat.parse("2009-01-01")      

      loyalty.insert(new Loyalty ("JRR", "Tolkien", None, 0, "User"))
      loyalty.insert(new Loyalty ("Jane", "Monroe", Some("jane@positive.com.au"), 0, "Employee"))
      loyalty.insert(new Loyalty ("Blake", "Lively", Some("blake@lively.com.au"), 0, "User"))
      loyalty.insert(new Loyalty ("Julia", "Gillard", Some("julia@parliament.com.au"), 0, "Admin"))
      loyalty.insert(new Loyalty ("Russell", "Cooper", None, 0, "Employee"))
      loyalty.insert(new Loyalty ("Ryan", "Reynolds", Some("ryan@reynolds.com.au"), 0, "User"))
      loyalty.insert(new Loyalty ("Bob", "Stewart", Some("bob@stewart.com.au"), 0, "Employee"))	
      loyalty.insert(new Loyalty ("Tyler", "Johnson", None, 0, "User"))
      loyalty.insert(new Loyalty ("Fred", "Smith", Some("fred@smith.com.au"), 0, "Admin"))
      loyalty.insert(new Loyalty ("Josh", "White", Some("josh@white.com.au"), 0, "Employee"))
     
      products.insert(new Product(5, 2, 0, 0, 3, 3, 3, 3, 3, false, "The Lord of the Rings"))
      products.insert(new Product(5, 2, 0, 0, 3, 3, 3, 3, 3, false, "The Lord of the Rings"))
      products.insert(new Product(5, 2, 0, 0, 3, 3, 3, 3, 3, false, "The Lord of the Rings"))
      products.insert(new Product(5, 2, 0, 0, 3, 3, 3, 3, 3, false, "Rainbows"))
      products.insert(new Product(5, 2, 0, 0, 3, 3, 3, 3, 3, false, "Sunshine"))
      products.insert(new Product(5, 2, 0, 0, 3, 3, 3, 3, 3, false, "Lollipops"))
      
      for (product : Product <- products) {
        println(product.productType + " id: " + product.id);
      }
      
      for (user : Loyalty <- loyalty.where(user => user.privileges === "Admin") ) {
        println(user.firstName + " email: " + user.email.getOrElse() + " id: " + user.id + " privileges: " + user.privileges);
      }
      
      val user = loyalty.where(user => user.privileges === "Admin")    
      loyalty.update(user.map(u => {u.loyaltyPoints += 2; u}))
      
      for (user : Loyalty <- loyalty.where(user => user.privileges === "Admin") ) {
        println(user.firstName + " points: " + user.loyaltyPoints + " privileges: " + user.privileges);
      }
      
      println(productExists(1))
      println(productExists(2))
      println(productExists(2))
      println(productExists(3))
      println(productExists(18))
      println(productExists(4))

      sellProducts(List(1, 1, 2, 3, 18, 4))
      sellProducts(List(1, 1, 2, 3, 18))
      
      cancelItem (List(1, 4))
      
      purchaseHistory.insert(new Purchase (may2009, loyalty.first.id, 0,0,0,0,0,0, "hello world", "scala"))
      
      for (receipt: Purchase <- purchaseHistory) {
        receipt.cart
        println (receipt.totalPrice)
      }
      for (product : Product <- products) {
        println("id: " + product.id + " shelfNo: " + product.shelfProducts);
      }
      
      for (receipt: Purchase <- purchaseHistory) {
        receipt.cart
        println (receipt.totalPrice)
      }
      
      for (product : Product <- products) {
        println("id: " + product.id + " shelfNo: " + product.shelfProducts);
      }
      
    }
  }
}

class stockShiftHist (val SupplierOrder: String, 
		val ShelfHist: String, 
		val BackroomHist: String, 
		val WarehouseHist: String)	