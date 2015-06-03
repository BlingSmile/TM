//全局变量
var answers={};


var app =angular.module('demo', ['ionic','demo.service','expanderModule'])

    .config(['$stateProvider', '$urlRouterProvider','$ionicConfigProvider', function($stateProvider, $urlRouterProvider,$ionicConfigProvider) {

        $stateProvider
         .state('homepage', {
                url : '/homepage',
                templateUrl : 'HomePage.html',
                abstract : true,
               
            })
         
         //主题详细
        .state("theme", {
            url: "/theme/:Tid",
            templateUrl: "Theme.html",
            controller : "ThemeCtrl"
        })
        
       
        //主页主题推送
        .state("homepage.HotTheme", {
            url: "/HotTheme",
            views:{
                'theme':{        
           				 templateUrl: "ThemeList.html",
           				 controller: 'circleThemeLists'
                }
            }
        })
        
        //主页圈子推送
        .state("homepage.HotCircle", {
             url: "/HotCircle",
            views:{
                'theme':{
		            templateUrl: "CircleList.html",
		             controller: 'CircleCtrl'
                }
            }
        })
        
        //主页用户推送
         .state("homepage.HotUser", {
            url: "/HotUser",
            views:{
                'theme':{
            		templateUrl: "UserList.html",
            		controller : 'hotUserCtrl'
                	}
            }
        })
        
        //主页-我关注的圈子
         .state("homepage.homeGroup",{
            url:"/Circle",
            views:{
                'group':{
                    templateUrl:'CircleList.html',
                    controller : 'MyCircleCtrl'
                }
            }

         })
         
         //主页-我关注的人
          .state("homepage.myFocusFriend",{
            url:"/myfoucsfriend",
            views:{

                'friend':{
                    templateUrl:'UserList.html',
                   controller : 'myFocusFriendController'
                }
            }

         })
         
       //主页-关注我的人
         .state("homepage.FocusMeFriend",{
           url:"/focusmefriend",
           views:{

               'friend':{
                   templateUrl:'UserList.html',
                  controller : 'FocusMeFriendController'
               }
           }

        })
        
          //圈子详细
          .state("circledetail", {
            url: "/circledetail",
            templateUrl: "CircleDetail.html",
            abstract : true,

        })
        
        //圈子详细-主题
         .state("circledetail.theme",{
            url:"/Theme/:Cid",
            views:{
                'theme':{
                    templateUrl:'ThemeList.html',
                    controller : 'circleThemeList'
                }
            }

         })
         
         //圈子详细-用户
          .state("circledetail.user",{
            url:"/Users",
            views:{
                'user':{
                    templateUrl:'UserList.html',
                    controller :'circleUserCtrl'
                }
            }

         })
         
         //圈子详细-资源
          .state("circledetail.resource",{
            url:"/Resource",
            views:{
                'resource':{
                    templateUrl:'ResourceList.html',
                    controller :'circleResourceCtrl'
                }
            }

         })
         
			//登陆
            .state('login', {
                url : '/login',
              
                templateUrl : 'login.html',
                controller : 'LoginController'
           
            })
            
            //注册
            .state('register', {
                url : '/register',
              
                templateUrl : 'register.html',
                controller : 'registerController'
           
            })

				//创建圈子
              .state('createCircle', {
                url : '/createCircle',                
                templateUrl : 'creategroup.html' , 
                controller : 'createCircleCtrl'
            })
            
            	//创建主题
              .state('createTheme', {
                url : '/createTheme',                
                templateUrl : 'creatTheme.html' , 
                controller : 'creatThemeCtrl'
            })
            
            //创建资料
              .state('createResource', {
                url : '/createResource',                
                templateUrl : 'creatResource.html' , 
                controller : 'creatResourceCtrl'
            })
            
            //收藏
              .state('Collection', {
                url : '/Collection',                
                templateUrl : 'Collection.html' , 
                controller : 'CollectionCtrl',
                 abstract : true,
            })
            
            //收藏-主题
	         .state("Collection.theme",{
	            url:"/Theme",
	            views:{
	                'theme':{
	                    templateUrl:'ThemeList.html',
	                    controller :'CollectionThemeCtrl'
	                }
	            }
	
	         })
	         
	          //收藏-资源
	         .state("Collection.resource",{
	            url:"/Resource",
	            views:{
	                'resource':{
	                    templateUrl:'ResourceList.html',
	                    controller : 'CollectionResourceCtrl'
	                }
	            }
	         })
	         
	         //个人信息
              .state('person_information', {
                url : '/person',                 
                templateUrl : 'person_information.html' , 
                controller : 'person_ctrl'
            })
            
             //个人发布的主题及资料
          .state("myThemeResource", {
            url: "/myThemeResource",
            templateUrl: "myThemeResource.html",
            abstract : true,

        })
        
        //个人发布的-主题
         .state("myThemeResource.theme",{
            url:"/Theme",
            views:{
                'mytheme':{
                    templateUrl:'ThemeList.html',
                    controller : 'myThemeCtrl'
                }
            }

         })
         
         
         //个人发布的-资源
          .state("myThemeResource.resource",{
            url:"/Resource",
            views:{
                'myresource':{
                    templateUrl:'ResourceList.html',
                    controller :'myResourceCtrl'
                }
            }

         })
         
         //编辑个人资料
          .state("editUserInformation",{
            url:"/edituserinformation",
            templateUrl:'EditUserInformation.html',
            controller :'editUserInformationCtrl'
         })


          //私信
              .state('message', {
                url : '/message',                 
                templateUrl : 'MessageList.html' , 
                controller : 'messagectrl'
            })
          
        //主题详细
        .state("userinformation", {
            url: "/user/:Uid",
            templateUrl: "UserInformation.html",
            controller : "UserInformationCtrl"
        })
            
        //$urlRouterProvider.otherwise('/homepage');
		$ionicConfigProvider.tabs.position('bottom');
    }])

.controller('NavController', function($scope, $ionicSideMenuDelegate) {
      $scope.toggleLeft = function() {
        $ionicSideMenuDelegate.toggleLeft()
      };
})




//主页-圈子推送
.controller("CircleCtrl",function($scope,$ionicSideMenuDelegate,$ionicHistory,CirclePromote){

	CirclePromote.do_CirclePromote().success(function(data, status, headers){			
		$scope.circles = data;
		
	});
    
})


//我关注好友
    .controller('myFocusFriendController', function($scope, $ionicSideMenuDelegate,$ionicHistory,userInformation) {
     
		userInformation.do_getMyAteention().success(function(data, status, headers){
			$scope.users= data;
		});	
    })

    //关注我好友
    .controller('FocusMeFriendController', function($scope, $ionicSideMenuDelegate,$ionicHistory,userInformation) {
	
		userInformation.do_getAteentionMe().success(function(data, status, headers){
		    $scope.users=data;
		})
		
    })



//登陆
    .controller('LoginController', function($scope,login_register) {
        $scope.username="";
        $scope.password="";
        $scope.login=function(username,password)
        {
             
            login_register.do_login(username,password)
             .success(function(data, status, headers) { 
            	 alert(data[0]);
          if(data[0].result=="登陆成功")
          {
            location.href="index.html#/homepage/HotTheme";
          }
          else
          {
          }
        }) 
        }
    })

//注册
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
                         if(data.result=="注册成功")
                         {
                            location.href="index.html#/homepage/HotTheme";
                          }
                          else
                          {
                          }
                        }) 
            }
        }
    })

    

    //创建圈子
.controller('createCircleCtrl', function($scope, $ionicSideMenuDelegate,$ionicHistory,createCircle) {
	
	 $scope.submitForm=function (circle)
	    {
		 //alert(theme.themename);
		 createCircle.do_createCircle(circle.name,circle.content,circle.subject,circle.area,circle.school,circle.college,circle.major,circle.scolearea,circle.scoleschool,circle.scolecollege,circle.scolemajor).success(function(data, status, headers){
			 if(data[0].result == "创建成功"){
				 history.back();
			 }
		 })
	    }
	 
	 $scope.back=function ()
    {
            history.back();
    }

})

	//个人信息
   .controller('person_ctrl',function($scope,$ionicSideMenuDelegate,$ionicHistory,PeopleInformation){
	   var grades=["大一","大二","大三","大四","研一","研二","研三"];   
 PeopleInformation.do_getInformation().success(function(data, status, headers){
		
		$scope.focusNum = data.focusNum;
		$scope.pubthemeNum = data.pubthemeNum;
		$scope.pubrecNum = data.pubrecNum;
		$scope.befocusNum = data.befocusNum;
		$scope.praiNum = data.praiNum;

	});
 PeopleInformation.do_getSchoolInformation().success(function(data, status, headers){
		
		$scope.school = data[0].school;
		$scope.college = data[0].college;
		$scope.major = data[0].major;
		$scope.grade = grades[data[0].grade];

	});
 
 PeopleInformation.do_getUnreadmessageNum().success(function(data, status, headers){
		$scope.unreadnum = data.UnreadMessNum;
	});
 
})


//主页-主题推送
.controller('circleThemeLists', function($scope, $ionicSideMenuDelegate,$ionicHistory,ThemePromote) {
 	
 		ThemePromote.do_ThemePromote().success(function(data, status, headers){		
			$scope.themes = data;			
		});
})

//主题详细
.controller("ThemeCtrl",function($scope,$state,$stateParams,$ionicPopup,ThemeInformation,PraiseService,AddThemeReply,CollectService){
		$scope.Tid =$stateParams.Tid;
		ThemeInformation.do_getTheme($scope.Tid).success(function(data, status, headers){
	
			$scope.theme = data[0];
			
			$scope.comments = data[1].ReplyNum;
	
		});
		
		ThemeInformation.do_getAnswer($scope.Tid).success(function(data, status, headers){
			answers=data;
			$scope.answers = answers;
	
		});
		PraiseService.do_getpraisefunc($scope.Tid).success(function(data, status, headers){
			if(data.result == 1001){
				$scope.praisestate="取消赞";
				$scope.praise = true;
			}else{
				$scope.praisestate="赞";
				$scope.praise = false;
			}
	
		});
		CollectService.do_getCollectFunc($scope.Tid,1).success(function(data, status, headers){
			if(data.result == 1001){
				$scope.collectstate="取消收藏";
				$scope.collect = true;
			}else{
				$scope.collectstate="收藏";
				$scope.collect = false;
			}	
		});
		
		$scope.praisefunc=function()
		{
			if($scope.praise){
				$scope.praisestate="赞";
				PraiseService.do_deletepraisefunc($scope.Tid).success(function(data, status, headers){
					
				})
			}else{
				$scope.praisestate="取消赞";
				PraiseService.do_addpraisefunc($scope.Tid).success(function(data, status, headers){
					
				})
			}
			$scope.praise = !$scope.praise;

		}
	
	$scope.collectfunc=function()
	{
		if($scope.collect){
			$scope.collectstate="收藏";
			CollectService.do_deleteCollectFunc($scope.Tid,1).success(function(data, status, headers){
				
			})
		}else{
			$scope.collectstate="取消收藏";
			CollectService.do_addCollectFunc($scope.Tid,1).success(function(data, status, headers){
				
			})
		}
		$scope.collect = !$scope.collect;
	}

     $scope.back=function ()
    {
            history.back();
    }
     
     $scope.showPopup = function() {
    	  $scope.data = {}
    	  // An elaborate, custom popup
    	  var myPopup = $ionicPopup.show({
    	    template: '<textarea  placeholder="回复内容" maxLength="240" rows="6" cols="20"   ng-model="data.reply" style="height:30%"></textarea>',
    	    title: '快速回复',
    	    scope: $scope,
    	    buttons: [
    	      { text: '取消' },
    	      {
    	        text: '<b>发表</b>',
    	        type: 'button-positive',
    	        onTap: function(e) {
    	        	alert($scope.data.reply);
    	          if (!$scope.data.reply) {
    	            //don't allow the user to close unless he enters wifi password
    	            e.preventDefault();
    	          } else {
    	        	AddThemeReply.do_addThemeReply($scope.Tid,$scope.data.reply).success(function(data, status, headers){
    	        		if(data.result == "回复成功")
    	        		{
    	        			ThemeInformation.do_getAnswer($scope.Tid).success(function(data, status, headers){
    	        				$scope.answers = data;
    	        		
    	        			});
    	        		}else{
    	        			alert("服务器繁忙");
    	        		}
    	        	})
    	          }
    	        }
    	      },
    	    ]
    	  });
     }
    
})


//圈子详细-主题
.controller('circleThemeList', function($scope,$stateParams,$ionicSideMenuDelegate,$ionicHistory,ThemeListInformation) {
	$scope.Cid = $stateParams.Cid;
	ThemeListInformation.do_getThemeList($scope.Cid).success(function(data, status, headers){
		$scope.themes = data;
	});
})

//圈子详细-用户
.controller('circleUserCtrl', function($scope, $ionicSideMenuDelegate,$ionicHistory,$ionicPopup,ThemeListInformation,MessageService) {
	var user = {
	Uid:1,
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

	$scope.users = [user,user,user,user,user,user,user,user,user,user,user,user,user];
	
	$scope.showPopup = function(Uid) {
   	  $scope.data = {}

    	var ToId=$scope.users[index].Uid
   	  // An elaborate, custom popup
   	  var myPopup = $ionicPopup.show({
   	    template: '<textarea  placeholder="留言内容" maxLength="240" rows="6" cols="20"   ng-model="data.reply" style="height:30%"></textarea>',
   	    title: '快速留言',
   	    scope: $scope,
   	    buttons: [
   	      { text: '取消' },
   	      {
   	        text: '<b>发送</b>',
   	        type: 'button-positive',
   	        onTap: function(e) {
   	          if (!$scope.data.reply) {
   	            //don't allow the user to close unless he enters wifi password
   	            e.preventDefault();
   	          } else {
   	        	MessageService.do_sendMessage(ToId,$scope.data.reply).success(function(data, status, headers){
   	        		if(data.result == 1001)
   	        		{
   	        			alert("留言成功");
   	        		}else{
   	        			alert("服务器繁忙");
   	        		}
   	        	})
   	          }
   	        }
   	      },
   	    ]
   	  });
    }
})

//主页用户推送
.controller('hotUserCtrl', function($scope, $ionicSideMenuDelegate,$ionicHistory,UserPromote) {

	UserPromote.do_UserPromote().success(function(data, status, headers){
		
		$scope.users = data;

	});
})

//主页-我关注的圈子
.controller("MyCircleCtrl",function($scope, $ionicSideMenuDelegate,$ionicHistory,getFocusCircle){
	getFocusCircle.do_getFocusCircleList().success(function(data, status, headers){
	
		$scope.circles = data;

	});
})


//圈子详细-用户
.controller('circleResourceCtrl', function($scope, $ionicSideMenuDelegate,$ionicHistory,CircleDetailResources) {
	CircleDetailResources.do_getResourceList().success(function(data, status, headers){
		
		$scope.resources = data;

	});
	
})


//创建主题
.controller('creatThemeCtrl', function($scope, $ionicSideMenuDelegate,$ionicHistory,createTheme) {
	 
	 $scope.submitForm=function (theme)
	    {
		 //alert(theme.themename);
		 createTheme.do_createTheme(theme.themename,theme.themecontent);
	    }
	 
	 $scope.back=function ()
    {
            history.back();
    }

})

//创建资料
.controller('creatResourceCtrl', function($scope, $ionicSideMenuDelegate,$ionicHistory,createResource) {
	
	 $scope.submitForm=function (resource)
	    {
		 //alert(theme.themename);
		 createResource.do_createResource(resource.name,resource.content,resource.link).success(function(data, status, headers){
			 if(data[0].result == "上传成功"){
				 history.back();
			 }
		 })
	    }
	 
	 $scope.back=function ()
    {
            history.back();
    }

})

//收藏
.controller('CollectionCtrl', function($scope, $ionicSideMenuDelegate,$ionicHistory) {

	 $scope.back=function ()
    {
            history.back();
    }

})

//收藏主题
.controller('CollectionThemeCtrl', function($scope, $ionicSideMenuDelegate,$ionicHistory,getCollectionTheme) {

	getCollectionTheme.do_getCollectionThemeList().success(function(data, status, headers){
		
		$scope.themes = data;

	});
	
	 $scope.back=function ()
    {
            history.back();
    }

})


//收藏资料
.controller('CollectionResourceCtrl', function($scope, $ionicSideMenuDelegate,$ionicHistory,getCollectionResource) {

	getCollectionResource.do_getCollectionResourceList().success(function(data, status, headers){
		
		$scope.resources = data;

	});
	
	 $scope.back=function ()
    {
            history.back();
    }

})

//个人发布-主题
.controller('myThemeCtrl', function($scope,$stateParams,$ionicSideMenuDelegate,$ionicHistory,myThemeResource) {
	myThemeResource.do_getTheme().success(function(data, status, headers){
		$scope.themes = data;
	});

})

//个人发布-主题
.controller('myResourceCtrl', function($scope,$stateParams,$ionicSideMenuDelegate,$ionicHistory,myThemeResource) {
	myThemeResource.do_getResource().success(function(data, status, headers){
		$scope.resources = data;
	});

})

//编辑个人资料
.controller('editUserInformationCtrl', function($scope,$state,$ionicSideMenuDelegate,$ionicHistory,editUserInformation) {
	editUserInformation.do_getUserInformation().success(function(data, status, headers){
		$scope.user = data[0];
	});
	
	 $scope.submitForm=function (user)
	    {
		 //alert(user.grade);
		 editUserInformation.do_setUserInformation(user).success(function(data, status, headers){
			 if(data.result == "修改成功"){
				 $state.go("person_information");
			 }
		 })
	    }
})


//私信
.controller('messagectrl', function($scope,$state,$ionicSideMenuDelegate,$ionicHistory,MessageService) {
	
//	$scope.doRefresh=function(){
//		MessageService.do_getMessages().then(function(data){
//			$scope.messages = data;
//		});
//	}
	MessageService.do_getMessages().success(function(data, status, headers){
		$scope.messages = data;
	});

	 $scope.back=function ()
	    {
	            history.back();
	    }
})


//私信
.controller('UserInformationCtrl', function($scope,$state,$stateParams,$ionicSideMenuDelegate,$ionicHistory,FocusService) {
	$scope.Uid =$stateParams.Uid;
	
	$scope.focusstate=true;
	$scope.focus="关注"
		
	$scope.setFocus=function(){
		if($scope.focusstate){
			$scope.focus="关注";
			FocusService.do_deleteFocusFunc($scope.Uid).success(function(data, status, headers){
				$scope.focusstate=true;
			})
		}else{
			$scope.focus="取消关注";
			FocusService.do_addFocusFunc($scope.Uid).success(function(data, status, headers){
				$scope.focusstate=false;
			})
		}
		$scope.focusstate = !$scope.focusstate;
	}
	 $scope.back=function ()
	    {
	            history.back();
	    }
})