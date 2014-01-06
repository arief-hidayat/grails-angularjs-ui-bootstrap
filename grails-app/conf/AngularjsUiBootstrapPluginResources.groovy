
import grails.util.Environment
import  org.codehaus.groovy.grails.commons.ApplicationHolder

def getJsFile(String name) {
    (Environment.current in [Environment.DEVELOPMENT, Environment.TEST]) ? "${name}.js" : "${name}.min.js"
}

def applicationContext = ApplicationHolder.application.mainContext
def jqueryPlugin = applicationContext.pluginManager.getGrailsPlugin('jquery')
def angularResourcePlugin = applicationContext.pluginManager.getGrailsPlugin('angularjs-resources')
//
def config = ApplicationHolder.application.config
def aubConfig = config?.grails?.resources?.angularjs?.bootstrap


modules = {
	if(!angularResourcePlugin) {
        'angular' {
                if (jqueryPlugin) {
                        dependsOn 'jquery'
                }
                resource ( aubConfig?.angularResource ?: [
                        url:[plugin: 'angular-ui-bootstrap', dir:'js/angular', file:"angular.min.js"],
                        exclude:'minify', disposition: 'head',
                        linkOverride: "http://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"]  )
        }
	}
    'bootstrap-css' {
        resource ( aubConfig?.bootstrapCssResource ?: [
                url: [plugin: 'angular-ui-bootstrap', dir:'css', file:'bootstrap.min.css'] ,
                linkOverride: 'http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css']  )

    }
    'angular-bootstrap' {
        dependsOn(['angular', 'bootstrap-css'])
        resource ( aubConfig?.angularBootstrapResource ?: [
                url:[plugin: 'angular-ui-bootstrap', dir:'js/angular', file:'ui-bootstrap-tpls-0.9.0.min.js'],
                exclude:'minify', disposition : "head",
                linkOverride: "http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.9.0.min.js"]  )
    }
}