class AngularjsUiBootstrapGrailsPlugin {
    // the plugin version
    def version = "0.9.0-M1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Grails Angular Ui Bootstrap Plugin" // Headline display name of the plugin
    def author = "Arief Hidayat"
    def authorEmail = "mr.arief.hidayat@gmail.com"
    def description = '''\
Angular UI Bootstrap JS resources plugin.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/grails-angular-ui-bootstrap"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
    def developers = [ [ name: "Arief Hidayat", email: "mr.arief.hidayat@gmail.com" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "github", url: "https://github.com/arief-hidayat/grails-angular-ui-bootstrap/issues/" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/arief-hidayat/grails-angular-ui-bootstrap/" ]


    //def dependsOn = ['angularjs-resources':'1.0.8 > *']
    def loadAfter = ['jquery','angularjs-resources']

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { ctx ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
