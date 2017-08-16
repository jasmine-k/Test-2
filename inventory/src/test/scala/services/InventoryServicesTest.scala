package services

import models.{Item, Vendor}
import org.scalatest.AsyncFunSuite

class InventoryServicesTest extends AsyncFunSuite with InventoryDatabase{

  val inventory = new InventoryServices
  test("searchItem"){
    inventory.searchItem("cat1").map(result => assert(result === List(item1)))

  }

  test("sort item high to low by price"){
    inventory.sortItems(Some("high"),Some("price")).map(result => assert(result === List(item1,item2)))
  }

  test("sort item low to high by price"){
    inventory.sortItems(Some("high"),Some("price")).map(result => assert(result === List(item2,item1)))
  }

  test("sort item high to low by rating"){
    inventory.sortItems(Some("high"),Some("price")).map(result => assert(result === List(item2,item1)))
  }
  test("sort item low to high by rating"){
    inventory.sortItems(Some("high"),Some("price")).map(result => assert(result === List(item1,item2)))
  }

}