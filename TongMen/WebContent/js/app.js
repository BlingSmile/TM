var app =angular.module('demo', ['ionic','demo.service','expanderModule'])

    .config(['$stateProvider', '$urlRouterProvider','$ionicConfigProvider', function($stateProvider, $urlRouterProvider,$ionicConfigProvider) {

        $stateProvider
         .state('homepage', {
                url : '/homepage',
                templateUrl : 'HomePage.html',
                abstract : true,
               
            })
         
        // .state("homepage", {
        //    abstract : true,
        //     url: "/homepage",
        //     templateUrl: "HomePage.html"
       
        // })
        .state("theme", {
            url: "theme",
            templateUrl: "Theme.html",
            controller : "ThemeCtrl"
        })
        .state("homepage.HotTheme", {
            url: "/HotTheme",
            views:{
                'theme':{
            
            templateUrl: "ThemeList.html"
        }
        }
        })
        .state("homepage.HotCircle", {
             url: "/HotCircle",
            views:{
                'theme':{
           
            templateUrl: "CircleList.html"
        }
        }
        })
         .state("homepage.HotUser", {
            url: "/HotUser",
            views:{
                'theme':{
            
            templateUrl: "UserList.html"
        }
        }
        })
         .state("homepage.homeGroup",{
            url:"/group",
            views:{

                'group':{

                    templateUrl:'homeGroup.html',
                    controller : 'SndChatPageController'
                }
            }

         })
          .state("homepage.homeFriend",{
            url:"/friend",
            views:{

                'friend':{

                    templateUrl:'homeFriend.html',
                   controller : 'homeFriendController'
                }
            }

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

            // .state('homepage', {
            //     url : '/homepage',
            //     templateUrl : 'snd-abstract.html',
            //     abstract : true,
            //     controller : 'SndController'
            // })
            // .state('homepage.home', {
            //     url: '/home',
            //     views: {
            //         'homepage': {
            //             templateUrl: 'snd-home.html',
            //             controller : 'SndHomePageController'
            //         }
            //     }
            // })

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

            // .state('homepage.download', {
            //     url: '/homepage/download',
            //     views: {
            //         'group': {
            //             templateUrl: 'snd-chat.html',
            //             controller : 'SndChatPageController'
            //         }
            //     }
            // })

            // .state('homepage.chat-single', {
            //   url: '/homepage/chat-single',
            //   views: {
            //     'friend': {
            //       templateUrl: 'snd-chat-single.html',
            //       controller : 'SndChatSinglePageController'
            //     }
            //   }
            // })
            // .state('homepage.friend', {
            //     url: '/homepage/friend/',
            //     views: {
            //         'homepage': {
            //             templateUrl: 'snd-drink.html',
            //             controller : 'homeFriendController'
            //         }
            //     }
            // })
            //  .state('homepage.friend.attentionMe', {
            //     url: '/attentionMe',
            //     views: {
            //         'friend': {
            //             templateUrl: 'attentionMe.html',
            //             controller : 'SndChatPageController'
            //         }
            //     }
            // })
            .state('snd.policy', {
                url: '/policy',
                views: {
                    'snd': {
                        templateUrl: 'snd-policy.html',
                        controller : 'SndPolicyPageController'
                    }
                }
            })

        $urlRouterProvider.otherwise('/homepage');
		$ionicConfigProvider.tabs.position('bottom');
    }])

.controller('NavController', function($scope, $ionicSideMenuDelegate) {
      $scope.toggleLeft = function() {
        $ionicSideMenuDelegate.toggleLeft()
      };
})

.controller("ThemeListCtrl",function($scope){

var theme={
    useravrurl:'img/avatar.png',
    tname:'主题名',
    content:'我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟',
    time:'2015-05-15',
    praice:'32'
    };
    
    $scope.themes = [theme,theme,theme,theme,theme,theme,theme,theme,theme,theme,theme,theme,theme];
    $scope.items = [];
    for(var i=0;i<50;i++) 
        $scope.items.push(["item",i+1].join(""));
    
})


.controller("ThemeCtrl",function($scope){
    $scope.theme = {
    useravrurl:'img/avatar.png',
    user:'习大大',
    tname:'我是传说中的主题名',
    content:'我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟',
    time:'2015-05-15 8:10:10',
    praice:'32',
    comments:'5'
    };
    $scope.answers = [answer,answer,answer,answer,answer];
     $scope.back=function ()
    {
            history.back();
    }
    
})

.controller("CircleCtrl",function($scope){

var answer={
    ans_user_url:'img/avatar.png',
    ans_username:'毛东东',
    ans_content:'我就是回答的呢么帅气我就是回答的呢么帅气我就是回答的呢么帅气我就是回答的呢么帅气我就是回答的呢么帅气',
    ans_time:'2015-05-16 9:10:10',
    ans_praice:'32'
};

var circle ={
    cir_name:'高等数学',
    cir_img:'img/avatar2.png',
    cir_des:'数学是研究现实世界数量关系和空间形式的学科.随着现代科学技术和数学科学的发展，“数量关系”和“空间形式”有了越来越丰富的内涵和更加广泛的外延.数学不仅是一种工具，而且是一种思维模式； 不仅是一种知识，而且是一种素养； 不仅是一门科学，而且是一种文化.数学教育在培养高素质科技人才中具有其独特的、不可替代的作用.对于高等学校工科类专业的本科生而言，高等数学课程是一门非常重要的基础课，它内容丰富，理论严谨，应用广泛，影响深远.不仅为学习后继课程和进一步扩大数学知识面奠定必要的基础，而且在培养学生抽象思维、逻辑推理能力，综合利用所学知识分析问题解决问题的能力，较强的自主学习的能力，创新意识和创新能力上都具有非常重要的作用.',
    cir_user:'小小彬'
}

var user = {
    user_name:'小小彬',
    user_img:'img/avatar2.png',
    user_des:'活泼可爱聪明善良惹人喜爱人见人爱花见花开机智善解人意的小小彬',
    user_city:'北京',
    user_school:'北京交通大学',
    user_grade:'研一',
    user_themenum:'5',
    user_ansnum:'12',
    user_focusnum:'2',
}
    $scope.circles = [circle,circle,circle,circle,circle,circle,circle];
    
})

.controller("UserCtrl",function($scope){
    $scope.users = [user,user,user,user,user,user,user,user,user,user,user,user,user];
    
})

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
    .controller('FstHomepageController', function($scope, $ionicSideMenuDelegate) {
$scope.content_data;





    })
    .controller('homeFriendController', function($scope, $ionicSideMenuDelegate,$ionicHistory,userInformation) {
		$scope.friends=[{"name":"nazhenhuiyi","desc":"aaasss","peoId":'123'}];
     
userInformation.do_getMyAteention().success(function(data, status, headers){


$scope.friends= data;



});
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
userInformation.do_getMyAteention().success(function(data, status, headers){
    $scope.friends=data;
})

        }
	$scope.getPeopelInf2=function()
    {
        if(!$scope.second)
           {
            $scope.first=!$scope.first;
            $scope.second=!$scope.second;
           }

userInformation.do_getAteentionMe().success(function(data, status, headers){
    $scope.friends=data;
})

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




