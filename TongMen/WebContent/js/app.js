var app =angular.module('demo', ['ionic','demo.service'])

    .config(['$stateProvider', '$urlRouterProvider','$ionicConfigProvider', function($stateProvider, $urlRouterProvider,$ionicConfigProvider) {

        $stateProvider
            .state('root', {
                url : '/root',
                templateUrl : 'root.html',
                controller : 'RootPageController'
            })

            .state('login', {
                url : '/login',
                templateUrl : 'login.html',
                controller : 'LoginController'
            })
			.state('lunbo', {
                url : '/lunbo',
                templateUrl : 'lunbo.html',
                controller : 'RootPageController'
            })

            .state('fst', {
                url : '/fst',
                templateUrl : 'fst-abstract.html',
                abstract : true,
                controller : 'FstController'
            })
            .state('fst.home', {
                url: '/home',
                views: {
                    'fst': {
                        templateUrl: 'fst-home.html',
                        controller : 'FstHomePageController'
                    }
                }
            })
            .state('fst.first', {
                url: '/first',
                views: {
                    'fst': {
                        templateUrl: 'fst-first.html',
                        controller : 'FstFirstPageController'
                    }
                }
            })
            .state('fst.second', {
                url: '/second',
                views: {
                    'fst': {
                        templateUrl: 'fst-second.html',
                        controller : 'FstSecondPageController'
                    }
                }
            })

            .state('homepage', {
                url : '/homepage',
                templateUrl : 'snd-abstract.html',
                abstract : true,
                controller : 'SndController'
            })
            .state('homepage.home', {
                url: '/home',
                views: {
                    'homepage': {
                        templateUrl: 'snd-home.html',
                        controller : 'SndHomePageController'
                    }
                }
            })
            .state('homepage.chat', {
                url: '/chat',
                views: {
                    'homepage': {
                        templateUrl: 'snd-chat.html',
                        controller : 'SndChatPageController'
                    }
                }
            })
            .state('homepage.chat-single', {
              url: '/chat-single',
              views: {
                'homepage': {
                  templateUrl: 'snd-chat-single.html',
                  controller : 'SndChatSinglePageController'
                }
              }
            })
            .state('homepage.drink', {
                url: '/drink',
                views: {
                    'homepage': {
                        templateUrl: 'snd-drink.html',
                        controller : 'SndDrinkPageController'
                    }
                }
            })
            .state('snd.policy', {
                url: '/policy',
                views: {
                    'snd': {
                        templateUrl: 'snd-policy.html',
                        controller : 'SndPolicyPageController'
                    }
                }
            })

        $urlRouterProvider.otherwise('/root');
		$ionicConfigProvider.tabs.position('bottom');
    }])

    .controller('RootPageController', function($scope, $ionicSideMenuDelegate) {
    })

    .controller('NavController', function($scope, $ionicSideMenuDelegate) {
      $scope.toggleLeft = function() {
        $ionicSideMenuDelegate.toggleLeft();
      };
    })
    .controller('FstController', function($scope, $ionicSideMenuDelegate) {
    })
    .controller('FstHomePageController', function($scope, $ionicSideMenuDelegate) {
$scope.content_data;





    })
    .controller('FstFirstPageController', function($scope, $ionicSideMenuDelegate,$ionicHistory) {
		$scope.myGoBack = $ionicHistory.backView();
	
 
		
		
    })
    .controller('FstSecondPageController', function($scope, $ionicSideMenuDelegate) {
    })

    .controller('SndController', function($scope, $ionicSideMenuDelegate) {
    })
    .controller('SndHomePageController', function($scope, $ionicSideMenuDelegate) {
		
		$scope.items=[{"img":"avatar1.png"},{"img":"avatar1.png"}];
    })
    .controller('SndChatPageController', function($scope, $ionicSideMenuDelegate) {
    })
    .controller('SndChatSinglePageController', function($scope, $ionicSideMenuDelegate) {
    })
    .controller('SndDrinkPageController', function($scope, $ionicSideMenuDelegate) {
    })
    .controller('SndPolicyPageController', function($scope, $ionicSideMenuDelegate) {
    })

    .controller('LoginController', function($scope,login_register) {
        $scope.username="";
        $scope.password="";
        $scope.login=function(username,password)
        {

             console.log(username); 
            login_register.do_login(username,password)
             .success(function(data, status, headers) { 
                    // the success function wraps the response in data 
                    // so we need to call data.data to fetch the raw data 

          if(data.data=="true")
          {
            location.href="www.baidu.com";

          }
          else
          {


          }
        }) 



        }



    })


