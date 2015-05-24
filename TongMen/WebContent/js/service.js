 angular.module('demo.service',[])

  .factory('login_register', ['$http', function($http) { 
  
    var doRequest = function(username, path) { 
      return $http({ 
        method: 'JSONP', 
        url: 'https://api.github.com/users/' + username + '/' + path + '?callback=JSON_CALLBACK' 
      }); 
    } ;
    var login= function(username,password){
      return $http({

        method:'post',
        url:'LoginAction',
        params:{'name':username,"password":password}




      })

    };
    var register=function(username,password,phone){
      return $http({
        method:'post',
        url:'RegisterAction',
        params:{'name':username,'password':password,'phone':phone}


      })

    }

    
    return { 
      events: function(username) { return doRequest(username, 'events'); }, 
      do_login:function(username,password){ return login(username,password);},
      do_register:function(username,password,phone){return register(username,password,phone)}
     
    }; 
  }])




   //关注的用户
  .factory('userInformation', ['$http', function($http) { 
  
    var getMyAteention= function(){
      return $http({

        method:'post',
        url:'UserFocusAction',
        params:{"form":"GetFucosList"}




      })

    };
    var getAteentionMe= function(){
      return $http({

        method:'post',
        url:'UserFocusAction',
        params:{"form":"GetWhofucos"}
      })

    };
   

    
    return { 
    do_getMyAteention:function(){return getMyAteention();}
    ,
    do_getAteentionMe:function(){return getAteentionMe();}
    }
  
  }])
  
  //主题列表
  .factory('ThemeListInformation', ['$http', function($http) { 
  
    var getThemeList= function(Cid){
      return $http({

        method:'post',
        url:'GetThemeAction',
        params:{"CircleId":Cid}

      })

    };
   
    
    return { 
    do_getThemeList:function(Cid){return getThemeList(Cid);}
    }
  
  }])
  
  //主题详细
  .factory('ThemeInformation', ['$http', function($http) { 
  
    var getTheme= function(Tid){
      return $http({

        method:'post',
        url:'ThemeinfoAction',
        params:{"ThemeId":Tid}

      })

    };
    
    var getAnswer= function(Tid){
      return $http({

        method:'post',
        url:'GetThemRyAction',
        params:{"ThemeId":Tid}

      })

    };
   
    
    return { 
    do_getTheme:function(Tid){return getTheme(Tid);},
    do_getAnswer:function(Tid){return getAnswer(Tid);}
    }
  
  }])
 
  //用户资料
 .factory('PeopleInformation', ['$http', function($http) { 
	  
	    var getInformation= function(){
	      return $http({

	        method:'post',
	        url:'GetUsernuminfoAction',
	      })

	    };
	    
	    var getSchoolInformation= function(){
		      return $http({
		        method:'post',
		        url:'CollelabelAction',
		        params:{"form":"query"}
		      })

		    };
 
	    return { 
	    do_getInformation:function(){return getInformation();},
	    do_getSchoolInformation:function(){return getSchoolInformation();}
	    }
	  
	  }]) 
 //收藏主题
 .factory('getCollectionTheme', ['$http', function($http) { 
	  
	    var getCollectionThemeList= function(){
	      return $http({

	        method:'post',
	        url:'GetSavelistAction',
	        params:{"form":"ThemeList"}
	      })

	    };


	    return { 
	    do_getCollectionThemeList:function(){return getCollectionThemeList();}
	    }
	  
	  }])
 
 //收藏资料
 .factory('getCollectionResource', ['$http', function($http) { 
	  
	    var getCollectionResourceList= function(){
	      return $http({

	        method:'post',
	        url:'GetSavelistAction',
	        params:{"form":"RescList"}
	      })

	    };


	    return { 
	    do_getCollectionResourceList:function(){return getCollectionResourceList();}
	    }
	  
	  }])
 
//收藏资料
 .factory('getFocusCircle', ['$http', function($http) { 
	  
	    var getFocusCircleList= function(){
	      return $http({

	        method:'post',
	        url:'UserFocusAction',
	        params:{"form":"GetFocusciecle"}
	      })

	    };


	    return { 
	    do_getFocusCircleList:function(){return getFocusCircleList();}
	    }
	  
	  }])
 
//创建主题
 .factory('createTheme', ['$http', function($http) { 
	  
	    var createTheme= function(title,content){
	      return $http({

	        method:'post',
	        url:'CreatethemeAction',
	        params:{"title":title,"content":content}
	      })

	    };


	    return { 
	    do_createTheme:function(title,content){return createTheme(title,content);}
	    }
	  
	  }])
 
 
//主题推送
 .factory('ThemePromote', ['$http', function($http) { 
	  
	    var ThemePromote= function(){
	      return $http({

	        method:'post',
	        url:'PromoteThemeAction',
	      })

	    };


	    return { 
	    do_ThemePromote:function(){return ThemePromote();}
	    }
	  
	  }])
	  
	  //圈子推送
 .factory('CirclePromote', ['$http', function($http) { 
	  
	    var CirclePromote= function(){
	      return $http({

	        method:'post',
	        url:'PromoteCircleAction',
	      })

	    };


	    return { 
	    do_CirclePromote:function(){return CirclePromote();}
	    }
	  
	  }]) 
 
 //圈子推送
 .factory('UserPromote', ['$http', function($http) { 
	  
	    var UserPromote= function(){
	      return $http({

	        method:'post',
	        url:'PromoteUserAction',
	      })

	    };


	    return { 
	    do_UserPromote:function(){return UserPromote();}
	    }
	  

	  }]); 