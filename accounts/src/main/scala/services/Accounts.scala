package services

import java.util.logging.Logger

import main.scala.models.User
import services.Database

import scala.collection.mutable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
class Accounts extends Database{

  val database = new Database
  def addUser(firstName: String, lastName: String,mobileNo: Long, userName: String, password:String, confirmPassword: String):Future[Boolean]={
    Future{
      if(password == confirmPassword){
        database.user += (mobileNo -> User(firstName,lastName,mobileNo,userName,password))
        true
      }

      else{
        false
      }
    }
  }
/*
  def authenticate(userName:String, password:String): Future[Long]={
    Future{
      val result= database.user.filter(_._2.userName == userName && _._2.password == password)

    }
  }*/

}
