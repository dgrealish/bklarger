package controllers

import play.api._
import play.api.mvc._
import models.PickList
import templates.Html
import java.util.Date
import scala.concurrent.{ExecutionContext, future}

/**
 * Created by grealish on 12.08.14.
 */

object PickLists extends Controller {

  def sendAsync(warehouse: String) = Action {
    import ExecutionContext.Implicits.global
    future {
      val pickList = PickList.find(warehouse)
      send(views.html.pickLists(warehouse, pickList, new Date))
    }
    Redirect(route.PickLists.index())
  }

  def preview(warehouse: String) = Action {
    val pickList = PickLists.find(warehouse)
    val timestamp = new java.util.Date
    Ok(views.html.pickList(warehouse, pickList, timestamp))
  }

  def index = Action {
    Ok(views.html.index())
  }

  private def send(html: Html): Unit = {
    Logger.info(html.body)
    // we send the pick list here
  }
}
