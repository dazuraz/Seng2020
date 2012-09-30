/**
 * Group 05
 * Elizabeth Sternhell, Theodora Tse, Wen Di Lim, Yoo Jin Jung
 * seng2020
 * Refund.scala
 * 24/09/2012
 */
package eventBclasses

import java.util.Date
import java.text.SimpleDateFormat

class Refund (override val date: Date,
		override val employeeID: Long, 
		val moneyReturned: Float,
		val previousReceiptID: Float,
		val refundCondition: String) extends Transaction (date, employeeID) {

}