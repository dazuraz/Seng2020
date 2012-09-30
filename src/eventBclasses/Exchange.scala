/**
 * Group 05
 * Elizabeth Sternhell, Theodora Tse, Wen Di Lim, Yoo Jin Jung
 * seng2020
 * Exchange.scala
 * 24/09/2012
 */

package eventBclasses

import java.util.Date
import java.text.SimpleDateFormat

class Exchange (override val date: Date,
		override val employeeID: Long, 
		val oldTransactionID: Long) extends Transaction (date, employeeID) {

}