/**
 * Group 05
 * Elizabeth Sternhell, Theodora Tse, Wen Di Lim, Yoo Jin Jung
 * seng2020
 * salesController.scala
 * 28/09/2012
 */

import eventBclasses.BasketItem
import eventBclasses.Library._
import org.squeryl._
import adapters.H2Adapter
import PrimitiveTypeMode._

object salesController {
  
	def cancelItem (scannedArray: List[Int]) {
		for (i<-0 until scannedArray.size) {
			val basketItem = basket.where(basketItem => basketItem.productID === scannedArray(i)).single
			
			if (basketItem.unitsBought > 1) {
				update(basket)(b =>
				  where (b.productID === basketItem.productID)
				  set (b.unitsBought := b.unitsBought.~ - 1)
				)
			} else {
				basket.deleteWhere(b => b.productID === basketItem.productID)
			}
			
		}
	}
  
	/**
	 * This method allows a customer to order items
	 * It doesn't actually subtract anything from the database
	 * But it does check if the customer's entry is valid, so ultimately
	 * when it is stored in the database as a receipt it is valid
	 * 
	 * @param scannedArray This is the list of IDs that has been scanned in individually
	 */
    def sellProducts(scannedArray: List[Int]) {
    
    	var productList = scannedArray.filter(s => productExists(s))
    
	    for (i<-0 until productList.size){
	    	val product = products.where(product => product.id === productList(i)).single
			if (inReceipt(productList(i))) {
			    var newUnits : Int = 0
			    var newPrice : Float = 0
			    for (b : BasketItem <- basket) {
					if (b.productID == productList(i)) {
						if ((b.unitsBought+1) <= product.shelfProducts) {
					    	newUnits = b.unitsBought + 1
					    } else {
					    	newUnits = product.shelfProducts
					    }
					    newPrice = product.unitPrice * newUnits
					    
					}
			    }
			    update(basket)(b =>  where(b.productID === productList(i))
				set(b.unitsBought := newUnits,
				b.POSPrice := newPrice)
			    )
			} else {
			    val item = new BasketItem(productList(i), 1, product.unitPrice)
			    basket.insert (item)
			}
	    }
    } 

    /**
     * This method checks that the product exists in the product tables
     */
    def inReceipt (productID : Long) : Boolean = {
	    var seen = false
		    for (item : BasketItem <- basket.where(item => item.productID === productID)) {
			    seen = true
		    }
	    return seen
    }

    /**
     * This method checks that the product exists within the array of the array of basketItems
     */
    def productExists (productID : Long) : Boolean = {
	    var exists = false 
	    for (product : eventBclasses.Product <- products.where(product => product.id === productID)) {
	    	if (product.shelfProducts > 0) {
	    		exists = true
	    	}
	    }
	    return exists
    }

    /**
     * This method calculates the total price of every item in the basket to create a transaction
     */
    //  def totalPrice(basket: Array[BasketItem]) : Float = {
    //    var price : Float = 0
    //    for (item : BasketItem <- basket) {
    //	  price += item.POSPrice
    //	}
    //    return price
    //  }

}