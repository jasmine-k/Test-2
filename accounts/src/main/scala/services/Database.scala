package services

import main.scala.models.User

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Map}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait Database {

  private val TOKEN = 9999L
  private val INVALIDTOKEN = -1
  val user: mutable.Map[Long, User] = Map(
    9898989810L -> User("jas", "kaur", 9898989810L, "jas", "jasmine"),
    9898989811L -> User("jas", "kaur", 9898989811L, "jas", "jasmine"),
    9898989812L -> User("jas", "kaur", 9898989812L, "jas", "jasmine")
  )

  def token(valid: Boolean): Long = {
    if (valid) {
      TOKEN
    }
    else {
      INVALIDTOKEN

    }
  }
}
