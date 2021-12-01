package controllers

import models.MyWeb.MyIndex

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def uno() = Action { implicit request: Request[AnyContent] =>
    MyIndex.update_rgb_list()
    Ok(views.html.uno())
  }

  def due() = Action { implicit request: Request[AnyContent] =>
    MyIndex.update_rgb_list()
    Ok(views.html.due())
  }

  def scelto_uno() = Action { implicit request: Request[AnyContent] =>
    MyIndex.scelto_uno()
    MyIndex.update_rgb_list()
    Ok(views.html.uno())
  }

  def scelto_due() = Action { implicit request: Request[AnyContent] =>
    MyIndex.scelto_due()
    MyIndex.update_rgb_list()
    Ok(views.html.due())
  }
}
