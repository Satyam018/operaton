/**
 * bootstrap script of the admin application
 */

(function(document, window, require) {

  require({
    baseUrl: '../../../',
    paths: {
      'ngDefine' : 'assets/vendor/requirejs-angular-define/ngDefine',
      'domReady' : 'assets/vendor/require/domReady',
      'jquery' : 'assets/vendor/jquery-1.7.2.min',
      'jquery-mousewheel' : 'assets/vendor/jquery.mousewheel',
      'jquery-overscroll' : 'assets/vendor/jquery.overscroll',
      'bootstrap' : 'assets/vendor/bootstrap/js/bootstrap',
      'bootstrap-slider' : 'assets/vendor/bootstrap-slider/bootstrap-slider',
      'angular' : 'assets/vendor/angular/angular',
      'angular-resource' : 'assets/vendor/angular/angular-resource',
      'angular-sanitize' : 'assets/vendor/angular/angular-sanitize'
    },
    shim: {
      'jquery-mousewheel' : { deps: [ 'jquery' ] },
      'jquery-overscroll' : { deps: [ 'jquery' ] },
      'bootstrap' : { deps: [ 'jquery' ] },
      'bootstrap-slider' : { deps: [ 'jquery' ] },
      'angular' : { deps: [ 'jquery' ], exports: 'angular' },
      'angular-resource': { deps: [ 'angular' ] },
      'angular-sanitize': { deps: [ 'angular' ] }
    },
    packages: [
      { name: 'admin', location: 'app/admin', main: 'admin' },
      { name: 'camunda-common', location: 'assets/vendor/camunda-common' },
      { name: 'bpmn', location : 'assets/vendor/cabpmn' },
      { name: 'dojo', location : 'assets/vendor/dojo/dojo' },
      { name: 'dojox', location : 'assets/vendor/dojo/dojox' }
    ]
  });

  var APP_NAME = 'admin';

  /**
   *
   * @param {string} name the application name
   *
   * @see http://stackoverflow.com/questions/15499997/how-to-use-angular-scenario-with-requirejs
   */
  function ensureScenarioCompatibility() {

    var html = document.getElementsByTagName('html')[0];

    html.setAttribute('ng-app', APP_NAME);
    html.dataset.ngApp = APP_NAME;

    if (top !== window) {
      window.parent.postMessage({ type: 'loadamd' }, '*');
    }
  }

  /**
   * Bootstrap the angular application
   */
  function bootstrapApp(angular) {
    angular.bootstrap(document, [ APP_NAME ]);

    // ensure compatibility with scenario runner
    ensureScenarioCompatibility();
  }

  require([ 'angular', 'angular-resource', 'angular-sanitize', 'ngDefine', 'bootstrap' ], function(angular) {
    require([ APP_NAME, 'domReady!' ], function() {
      bootstrapApp(angular);
    });
  });

})(document, window || this, require);