grails-angularjs-ui-bootstrap
=============================

grails plugin for angular ui bootstrap

dependency: grails angularjs resources plugin.

Currently, this plugin depends on version 1.2.6 which has not been released.
I made pull request to fix an issue (https://github.com/smartiniOnGitHub/grails-angularjs-resources/pull/14).

Meanwhile, you can grab the plugin from (https://github.com/arief-hidayat/grails-angularjs-resources/tree/fix-js-map) and do "grails refresh-dependencies" + "grails maven-install".


In BuildConfig.groovy
```
        runtime ":angularjs-ui-bootstrap:0.9.0-SNAPSHOT"
```

In ApplicationResources.groovy add dependency to "angular-bootstrap"
```
modules = {
    application {
        dependsOn "angular-bootstrap"
        resource url:'js/example.js', disposition: "head"
    }
}
```

Example.js and the following page is taken from angular-bootstrap homepage.
```
	<!doctype html>
	<html ng-app="plunker">
	<head>
	    <meta name="layout" content="angularBody"/>
	    <r:require module="application" />
	</head>
	<body ng-app="plunker">
	<div ng-controller="AccordionDemoCtrl">
	    <label class="checkbox">
	        <input type="checkbox" ng-model="oneAtATime">
	        Open only one at a time
	    </label>
	    <accordion close-others="oneAtATime">
	        <accordion-group heading="Static Header, initially expanded" is-open="true">
	            This content is straight in the template.
	        </accordion-group>
	        <accordion-group heading="{{group.title}}" ng-repeat="group in groups">
	            {{group.content}}
	        </accordion-group>
	        <accordion-group heading="Dynamic Body Content">
	            <p>The body of the accordion group grows to fit the contents</p>
	            <button class="btn btn-default btn-sm" ng-click="addItem()">Add Item</button>
	            <div ng-repeat="item in items">{{item}}</div>
	        </accordion-group>
	        <accordion-group is-open="isopen">
	            <accordion-heading>
	                I can have markup, too! <i class="pull-right glyphicon" ng-class="{'glyphicon-chevron-down': isopen, 'glyphicon-chevron-right': !isopen}"></i>
	            </accordion-heading>
	            This is just some content to illustrate fancy headings.
	        </accordion-group>
	    </accordion>
	</div>
	</body>
	</html>
```