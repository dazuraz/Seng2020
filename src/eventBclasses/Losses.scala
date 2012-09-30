/**
 * Group 05
 * Elizabeth Sternhell, Theodora Tse, Wen Di Lim, Yoo Jin Jung
 * seng2020
 * Losses.scala
 * 24/09/2012
 */
package eventBclasses

import java.util.Date
import java.text.SimpleDateFormat

class Losses (override val date: Date,
		override val employeeID: Long, 
		val reasonForLoss: String,
		val productName: String,
		val productID: Int,
		val productPrice: Float) extends Transaction (date, employeeID) {

}