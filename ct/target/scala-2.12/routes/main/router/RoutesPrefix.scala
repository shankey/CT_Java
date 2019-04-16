// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/adinema/Dev/CT_Java/ct/conf/routes
// @DATE:Mon Mar 11 19:55:42 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
