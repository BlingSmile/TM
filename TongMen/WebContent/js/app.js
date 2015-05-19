var app =angular.module('demo', ['ionic','demo.service','expanderModule'])

    .config(['$stateProvider', '$urlRouterProvider','$ionicConfigProvider', function($stateProvider, $urlRouterProvider,$ionicConfigProvider) {

        $stateProvider
            .state('root', {
                url : '/root',
                templateUrl : 'root.html',
                controller : 'RootPageController'
            })
          .state('group', {
                url : '/group',
                templateUrl : 'groupDetail.html',
                abstract : true,
                controller : 'groupController'
            })
          .state('group.question', {
                url: '/question/:groupId',
                views: {
                  'tab-dash': {
                   templateUrl:'groupQuestion.html',
                    controller:'groupQController'
                  }
                }})
            .state('group.resouce', {
                url: '/resouce/:groupId',
                views: {
                  'tab-dash': {
                   templateUrl:'resouce.html',
                    controller:'groupQController'
                  }
                }})
              .state('group.peopel', {
                url: '/peopel/:groupId',
                views: {
                  'tab-dash': {
                   templateUrl:'peopel.html',
                    controller:'groupQController'
                  }
                }})

            .state('login', {
                url : '/login',
              
                templateUrl : 'login.html',
                controller : 'LoginController'
           
            })
            .state('register', {
                url : '/register',
              
                templateUrl : 'register.html',
                controller : 'registerController'
           
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

             .state('content', {
                url : '/content',
                templateUrl : 'templates/content.html',
                abstract : true,
                controller : 'FstController'
            })
            //  .state('content.friend', {
            //     url: '/friend',
            //     views: {
            //         'mainContent': {
            //             templateUrl: 'friend.html',
            //             controller : 'FstHomePageController'
            //         }
            //     }
            // })
                .state('fst.group',{
                    url:'/group/:groupId',
                    views:{
                        'fst':{
templateUrl:'groupDetail.html',
controller:'groupController'


                        }
                         }
                     })






//                          .state('fst.groupQuestion',{
//                             url :'groupQuestion/:groupId'
//                             ,
//                             views:{
//                                 'fst1':{
// templateUrl:'groupQuestion.html',
// controller:'groupQController'



//                                 }


//                             }


//                          })




                
            .state('fst.home', {
                url: '/home',
                views: {
                    'fst': {
                        templateUrl: 'fst-home.html',
                        controller : 'FstHomePageController'
                    }
                }
            })
            .state('fst.friend', {
                url: '/friend/:friendID',
                views: {
                    'fst': {
                        templateUrl: 'friend.html',
                        controller : 'friendController'
                    }
                }
            })
            // .state('fst.first', {
            //     url: '/first',
            //     views: {
            //         'fst': {
            //             templateUrl: 'fst-first.html',
            //             controller : 'FstFirstPageController'
            //         }
            //     }
            // })
            // .state('fst.second', {
            //     url: '/second',
            //     views: {
            //         'fst': {
            //             templateUrl: 'fst-second.html',
            //             controller : 'FstSecondPageController'
            //         }
            //     }
            // })

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

              .state('create', {
                url : '/create',
             
                  
                templateUrl : 'templates/creategroup.html' , 
                controller : 'validateCtrl'
            })

              .state('person_information', {
                url : '/person',
             
                  
                templateUrl : 'templates/person_information.html' , 
                controller : 'person_ctrl'
            })

            .state('homepage.download', {
                url: '/download',
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
            .state('homepage.friend', {
                url: '/friend/',
                views: {
                    'homepage': {
                        templateUrl: 'snd-drink.html',
                        controller : 'homeFriendController'
                    }
                }
            })
             .state('homepage.friend.attentionMe', {
                url: '/attentionMe',
                views: {
                    'friend': {
                        templateUrl: 'attentionMe.html',
                        controller : 'SndChatPageController'
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
 $scope.goback=function()
 {
history.back();


 }


    })
    .controller('FstHomePageController', function($scope, $ionicSideMenuDelegate) {
$scope.content_data;





    })
    .controller('homeFriendController', function($scope, $ionicSideMenuDelegate,$ionicHistory) {
		$scope.friends=[{"name":"nazhenhuiyi","desc":"aaasss","peoId":'123'}];
        friend1=[{"name":"nazhenhuiyi1","desc":"aaasss","peoId":'123'},{"name":"nazhenhuiyi2","desc":"aaasss","peoId":'123'},{"name":"nazhenhuiyi3","desc":"aaasss","peoId":'123'}];
        $scope.menus=["我关注的人","关注我的人"];
        $scope.first=true;
        $scope.second=false;
        $scope.getPeopelInf1=function()
     
     {
      //   {console.log(this.id);
      //       if(this.id==1)
      //       {
      //       $scope.friends=friend1;
      //       // $scope.clearNav();
      //       this.className+=" navigator-on";
      //       console.log(this);

      //   }
      //   else(this.id==2)
      //   {
      //       // $scope.clearNav();
      // this.className+=" navigator-on";


      //   }
      if(!$scope.first)
    {
        $scope.first=!$scope.first;
        $scope.second=!$scope.second;
        $scope.friends=friend1;
        console.log($scope.friends);
    }

// document.getElementById('2').className+=" navigator-on";

        }
	$scope.getPeopelInf2=function()
    {
        if(!$scope.second)
           {
            $scope.first=!$scope.first;
            $scope.second=!$scope.second;
           }

    }
//  $scope.clearNav=function(obj)
//  {
//  var lis=obj.parentNode.getElementsByTagName('*');
//  for(var i=0;i<lis.length;i++)
//  {
// lis[i].className="navigator-item";


//  }


//  }
		
		
    })

    .controller('friendController', function($scope, $stateParams) {
  // $scope.friend = friend.get($stateParams.roomid);
  $scope.friendID=$stateParams.friendID;
  console.log($scope.friendID)
  $scope.friend={"name":"nazhenhuiyi"}
})
     .controller('groupController', function($scope, $stateParams,$state) {
  // $scope.friend = friend.get($stateParams.roomid);
  // $scope.friendID=$stateParams.friendID;
  // console.log($scope.friendID);
  // $scope.friend={"name":"nazhenhuiyi"};

  $scope.getInf1=function()
  {
console.log($stateParams.groupId);
$state.go('fst.groupQuestion',{groupId:88});


  }



})

    .controller('groupQController', function($scope, $stateParams,$state){
$scope.question=[{'title':'那阵回忆'},{'title':'那阵回忆'},{'title':'那阵回忆'}];




    })


    .controller('FstSecondPageController', function($scope, $ionicSideMenuDelegate) {
    })

    .controller('SndController', function($scope, $ionicSideMenuDelegate) {
    })
    .controller('SndHomePageController', function($scope, $ionicSideMenuDelegate) {
		
		$scope.items=[{"img":"avatar1.png"},{"img":"avatar1.png"}];
    })
    .controller('SndChatPageController', function($scope, $ionicSideMenuDelegate) {

// $scope.data=[{"title":'资源名字',"tag":'top',"download_url":"http://www.baidu.com","thumbsup":"120"},
// {"title":'资源名字1',"tag":'top',"download_url":"/#","thumbsup":"120"}];
$scope.group=[{'title':'北京交通大学','groupId':'123'}];



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


    .controller('registerController', function($scope,login_register) {
        $scope.username="";
        $scope.phone="";

        $scope.password1="";
        $scope.password2="";
        $scope.register=function(username,password1,password2,phone)
        {
        	
        	console.log( password1); 
            if(password1==password2&&password1!='')
            {
            
            
            login_register.do_register(username,password1,phone)
             .success(function(data, status, headers) { 
                    // the success function wraps the response in data 
                    // so we need to call data.data to fetch the raw data 
console.log(data);
                         if(data.data=="true")
                          {
                            location.href="www.baidu.com";

                          }
                          else
                          {


                          }
                        }) 


            }
        }



    })

    
   .controller('validateCtrl',function($scope,$http){
    
    $scope.submitForm = function(groupname,descroption,biaoqian){
            
console.log(groupname+descroption);

    }
    $scope.back=function ()
    {

history.back();

    }
})

   .controller('person_ctrl',function($scope){
    
 //$scope.person=$http.get('');
 $scope.person={"personname":"那阵回忆","num_other_attention":'4',"num_good":'5',"num_my_attention":'6'};
    $scope.back=function ()
    {

history.back();

    }
})




