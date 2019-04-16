// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/adinema/Dev/CT_Java/ct/conf/routes
// @DATE:Mon Mar 11 19:55:42 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def userstories(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "userstories")
    }
  
    // @LINE:6
    def story(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "story/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:8
    def migratestories(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "migratestories")
    }
  
  }

  // @LINE:11
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
