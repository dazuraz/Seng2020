/**
 * Group 05
 * Elizabeth Sternhell, Theodora Tse, Wen Di Lim, Yoo Jin Jung
 * seng2020
 * Purchase.scala
 * 24/09/2012
 */
package eventBclasses

import java.util.Date
import java.text.SimpleDateFormat
import Library._
import org.squeryl._
import adapters.H2Adapter
import PrimitiveTypeMode._

class Purchase (override val date: Date,
		override val employeeID: Long,
	    val ChangeGiven: Float,
		val BasketPrice: Float,
		val LoyaltyPointsEarned: Int,
		val MoneyReceived: Float,
		val CustomerID: Long,
		val TotalTax: Float,
		val PriceType: String,
		val PaymentType: String) extends Transaction (date, employeeID)	{  
  
		var hasSold : Boolean = false;
		
		/**
		 * cart joins the basket with its respective transaction
		 * Have no clue how to separate out transactions + baskets just yet
		 * Will have to try later
		 * cart will return a list of ids that are associated with it
		 */
		def cart : List[Long] = {
		    val cart = join(basket, purchaseHistory.leftOuter)((s, r) =>
		      select(s, r)
		      on(s.id === r.map(_.id))
		    )
		    var value : List[Long] = List()

		    for (sr <- cart) {
		      value ::= sr._1.productID
		      if (this.hasSold == false) {
		        update(products)(p =>
		        where (p.id === sr._1.productID)
		        set (p.shelfProducts := p.shelfProducts.~ - sr._1.unitsBought))
		      }
		      
		    }
		    this.hasSold = true
		    return value
		}
		
		
		
		
	    def totalPrice() : Float = {
		    var price : Float = 0
		    for (item : BasketItem <- basket) {
			  price += item.POSPrice
			}
		    return price
	  }

}