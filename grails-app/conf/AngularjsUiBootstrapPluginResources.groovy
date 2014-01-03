
import grails.util.Environment

def getJsFile(String name) {
    (Environment.current in [Environment.DEVELOPMENT, Environment.TEST]) ? "${name}.js" : "${name}.min.js"
}

modules = {
    'bootstrap-css' {
        resource url:[plugin: 'angular-ui-bootstrap', dir:'css', file:'bootstrap.min.css'] ,
                linkOverride: 'http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css'
    }
    'angular-bootstrap' {
        dependsOn(['angular', 'bootstrap-css'])
        resource url:[plugin: 'angular-ui-bootstrap', dir:'js/angular', file:getJsFile('ui-bootstrap-tpls-0.9.0')], disposition : "head"
    }
}