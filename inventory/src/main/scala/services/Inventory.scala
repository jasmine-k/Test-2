package services

import models.{Inventory, Item}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
class InventoryServices extends InventoryDatabase{

  def searchItem(itemCategory: String): Future[List[Item]] = {
    Future {
      val itemsRequired: List[Item] = listOfItem.filter(_.category == itemCategory)

      if (itemsRequired.isEmpty) {
        throw new NoSuchElementException
      }
      else {
        itemsRequired
      }
    }
  }


  def sortItems(priceSelection: Option[String], rateOrPrice: Option[String]): Future[List[Item]] = {
    Future {
      rateOrPrice match {
        case Some("rate") =>
          priceSelection match {
            case Some("low") =>listOfItem.sortBy(_.rating)
            case Some("high") => listOfItem.sortBy(_.rating).reverse
            case None => listOfItem.sortBy(_.rating).reverse
          }

        case Some("price") =>
          priceSelection match {
            case Some("low") => listOfItem.sortBy(_.price)
            case Some("high") =>listOfItem.sortBy(_.price).reverse
            case None => listOfItem.sortBy(_.price).reverse
          }
        case None =>
          priceSelection match {
            case Some("low") => listOfItem.sortBy(_.price)
            case Some("high") =>listOfItem.sortBy(_.price).reverse
            case None => listOfItem.sortBy(_.price).reverse
          }
      }
    }
  }

}
