/**
 * Group 05
 * Elizabeth Sternhell, Theodora Tse, Wen Di Lim, Yoo Jin Jung
 * seng2020
 * Library.scala
 * 24/09/2012
 */

package eventBclasses

import org.squeryl._
import adapters.H2Adapter
import PrimitiveTypeMode._

object Library  extends Schema {
	val loyalty = table[Loyalty]
	on(loyalty)(customer => declare (
			customer.id is (autoIncremented),
			customer.email is (unique)
	))

	val products = table[Product]
	
	val purchaseHistory = table[Purchase]
	
	on (purchaseHistory) (receipt => declare(
		receipt.id is (autoIncremented)
	
	))
	
	val basket = table[eventBclasses.BasketItem]
	
	on(basket)(item => declare (
			item.id is (autoIncremented)
	))
	
	on(products)(item => declare (
			item.id is (autoIncremented)
	))
}
