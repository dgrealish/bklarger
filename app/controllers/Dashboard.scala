package controllers

import play.api.mvc.{Action, Controller}

import scala.concurrent.ExecutionContext
/**
 * Created by grealish on 13.08.14.
 */
object Dashboard extends Controller {

  def backlog(warehouse: String) = Action {
    ExecutionContext.Implicits.global
    val backlog = scala.concurrent.future {
      models.Order.backlog(warehouse)
    }

    Async {
      backlog.map(value => Ok(value))
    }
  }

}
