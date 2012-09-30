/**
 * Group 05
 * Elizabeth Sternhell, Theodora Tse, Wen Di Lim, Yoo Jin Jung
 * seng2020
 * Product.scala
 * 3:34:58 PM
 */

package eventBclasses

class Product (
		var seasonalFloats: Float,
		val discount: Float,
		val discountThreshold: Float,
		val unitSize: Int,
		val unitPrice: Int,
		val totalProducts: Int,
		val warehouseProducts: Int,
		val backroomProducts: Int,
		val shelfProducts: Int,
		val discontinued: Boolean,
		val productType: String) extends BaseEntity {

}