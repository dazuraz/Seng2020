/**
 * Group 05
 * Elizabeth Sternhell, Theodora Tse, Wen Di Lim, Yoo Jin Jung
 * seng2020
 * Transaction.scala
 * 24/09/2012
 */

package eventBclasses

import java.util.Date
import java.text.SimpleDateFormat
import Library._
import org.squeryl._
import adapters.H2Adapter
import PrimitiveTypeMode._

class Transaction (val date: Date,
		val employeeID: Long) extends BaseEntity {
  
}

	 
        
//            if (seen == true) {

//            } else {
//                basket.insert(basketProducts[i], 1, basketProducts[i])
//            }
//        }
//    }
//	}