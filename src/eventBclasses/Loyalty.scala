/**
 * Group 05
 * Elizabeth Sternhell, Theodora Tse, Wen Di Lim, Yoo Jin Jung
 * seng2020
 * Loyalty.scala
 * 3:32:47 PM
 */

package eventBclasses

class Loyalty(
		var firstName: String,
		var lastName: String,
		var email: Option[String],
		var loyaltyPoints: Int,
		var privileges: String) extends BaseEntity {

}

//import privilegeType._
//
//class Loyalty(
//		val firstName: String,
//		val lastName: String,
//		val email: Option[String],
//		val loyaltyPoints: Int,
//		val privileges: privilegeType) extends BaseEntity {
//
//}