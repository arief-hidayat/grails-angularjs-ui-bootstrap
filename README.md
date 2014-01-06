grails-angularjs-ui-bootstrap
=============================

Grails resources plugin for http://angular-ui.github.io/bootstrap/

### How to Use

In BuildConfig.groovy
```
        runtime ":angularjs-ui-bootstrap:0.9.0-M1"
```

That's it!

Of course you need to create your own page and javascript that uses the angular-bootstrap.

Let's take an example from angular-bootstrap homepage (http://angular-ui.github.io/bootstrap/).
Create resource module that depends on "angular-bootstrap" in ApplicationResources.groovy 

```
modules = {
    application {
        dependsOn "angular-bootstrap"
        resource url:'js/example.js', disposition: "head"
    }
}
```

Create example.js under WEB-INF/js folder
```
angular.module('plunker', ['ui.bootstrap']);
function AccordionDemoCtrl($scope) {
  $scope.oneAtATime = true;

  $scope.groups = [
    {
      title: "Dynamic Group Header - 1",
      content: "Dynamic Group Body - 1"
    },
    {
      title: "Dynamic Group Header - 2",
      content: "Dynamic Group Body - 2"
    }
  ];

  $scope.items = ['Item 1', 'Item 2', 'Item 3'];

  $scope.addItem = function() {
    var newItemNo = $scope.items.length + 1;
    $scope.items.push('Item ' + newItemNo);
  };
}
```

Replace grails-app/views/index.gsp content with the following.
```
	<!doctype html>
	<html>
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
Note that: The difference is only on the head, the rest are just normal webpage with angularjs.
This plugin comes with default layout "angularBody". If you don't define ng-app (e.g. 'plunker') in the body, it will use default value ('myApp').


### Override Resources Definition

Optionally can define one of the following in Config.groovy
```
grails.resources.angularjs.bootstrap.angularResource = [
    url:[plugin: 'angular-ui-bootstrap', dir:'js/angular', file:"angular.min.js"],
    exclude:'minify', disposition: 'head', linkOverride: "http://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"]
grails.resources.angularjs.bootstrap.bootstrapCssResource = [
    url: [plugin: 'angular-ui-bootstrap', dir:'css', file:'bootstrap.min.css'] ,
    linkOverride: 'http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css']
grails.resources.angularjs.bootstrap.angularBootstrapResource = [
    url:[plugin: 'angular-ui-bootstrap', dir:'js/angular', file:'ui-bootstrap-tpls-0.9.0.min.js'],
    exclude:'minify', disposition : "head", linkOverride: "http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.9.0.min.js"]
```

This will be useful if you need to use bootstrap css or angular/angular-bootstrap javascript that is different from the one packaged in the plugin.

Note that if you use this plugin together with angularjs-resources plugin, this plugin will use 'angular' resource defined in angularjs-resources plugin. So, your 'grails.resources.angularjs.bootstrap.angularResource' configuration will be omitted.