package models

import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by grealish on 12.08.14.
 *
 * */

case class Product(ean: Long,  description: String)

// preparation request to build a picklist
case class Preparation(orderNumber: Long, product: Product, quantity: Int, location: String)

// pick list data access object stud.. for test data

object PickList {

  def find(warehouse: String) : List[Preparation] = {
    val p = Product(5010255079763L, "Large paper clips 1000 pack")
    List(
      Preparation(3141592, p, 200, "Aisle 42 bin 7"),
      Preparation(6535897, p, 500, "Aisle 42 bin 7"),
      Preparation(93, p, 100, "Aisle 42 bin 7")
    )
  }
}

object Warehouse {
  def find() = {
    List("W123", "W456")
  }
}
object Order {

    def backlog(warehouse: String): String = {
      Thread.sleep(5000L)
      new SimpleDateFormat("mmms").format(new Date())
    }
}

// old case class
case class StockItem(
  id: Long,
  productId: Long,
  warehouseId: Long,
  quantity: Long)

