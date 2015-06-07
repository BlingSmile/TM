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
        params:{"Tid":Tid}

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
	        params:{"user":"personal"}
	      })

	    };
	    
	    var getSchoolInformation= function(){
		      return $http({
		        method:'post',
		        url:'CollelabelAction',
		        params:{"form":"query","user":"personal"}
		      })

		    };
		var getUserInformation= function(Uid){
			      return $http({

			        method:'post',
			        url:'GetUsernuminfoAction',
			        params:{"form":"query","Uid":Uid,"user":"other"}
			      })

			    };
			    
	    var getUserSchoolInformation= function(Uid){
				      return $http({
				        method:'post',
				        url:'CollelabelAction',
				        params:{"form":"query","Uid":Uid,"user":"other"}
				      })

				    };
 
		    var getUnreadmessageNum= function(){
			      return $http({
			        method:'post',
			        url:'MessageAction',
			        params:{"form":"GetUnreadmessageNum"}
			      })

			    };
			    
	    return { 
	    do_getInformation:function(){return getInformation();},
	    do_getSchoolInformation:function(){return getSchoolInformation();},
	    do_getgetUserInformation:function(Uid){return getUserInformation(Uid);},
	    do_getUserSchoolInformation:function(Uid){return getUserSchoolInformation(Uid);},
	    do_getUnreadmessageNum:function(){return getUnreadmessageNum();}
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
	  

	  }])
 
//创建资料
 .factory('createResource', ['$http', function($http) { 
	  
	    var createResource= function(title,content,link){
	      return $http({

	        method:'post',
	        url:'UploadResourceAction',
	        params:{"title":title,"content":content,"link":link}
	      })

	    };


	    return { 
	    do_createResource:function(title,content,link){return createResource(title,content,link);}
	    }
	  
	  }])
	  
//创建圈子
 .factory('createCircle', ['$http', function($http) { 
	  
	    var createCircle= function(name,content,subject,area,school,college,major,scolearea,scoleschool,scolecollege,scolemajor){
	      return $http({

	        method:'post',
	        url:'CreateCircleAction',
	        params:{"Cname":name,"Cdesc":content,"subject":subject,"area":area,"school":school,"college":college,"major":major,"Tarea":scolearea,"Tschool":scoleschool,"Tcollege":scolecollege,"Tmajor":scolemajor}
	      })

	    };


	    return { 
	    do_createCircle:function(name,content,subject,area,school,college,major,scolearea,scoleschool,scolecollege,scolemajor){return createCircle(name,content,subject,area,school,college,major,scolearea,scoleschool,scolecollege,scolemajor);}
	    }
	  
	  }])
	  
	  
	  //个人发布的主题和资料
  .factory('myThemeResource', ['$http', function($http) { 
  
    var getTheme= function(){
      return $http({
        method:'post',
        url:'GetpubAction',
        params:{"form":"GetPubTheme"}
      })

    };
    var getResource= function(){
      return $http({
        method:'post',
        url:'GetpubAction',
        params:{"form":"GetPubRec"}
      })

    };
   

    
    return { 
    do_getTheme:function(){return getTheme();}
    ,
    do_getResource:function(){return getResource();}
    }
  
  }])
  
  
  //编辑个人信息
 .factory('editUserInformation', ['$http', function($http) { 
	  
	    var getUserInformation= function(){
	      return $http({
	        method:'post',
	        url:'CollelabelAction',
	        params:{"form":"query"}
	      })
	    };
	    
	    var setUserInformation= function(user){
	    	user.form="update";
		      return $http({
		        method:'post',
		        url:'CollelabelAction',
		        params:user
		      })
		 };
		    

	    return { 
	    do_getUserInformation:function(){return getUserInformation();},
	    do_setUserInformation:function(user){return setUserInformation(user);}
	    }
	  
	  }])
	  
	  
	  //圈子详细-资料
 .factory('CircleDetailResources', ['$http', function($http) { 
	  
	    var getResourceList= function(){
	      return $http({
	        method:'post',
	        url:'GetResourcelistAction',
	      })
	    };
	    
		    

	    return { 
	    do_getResourceList:function(){return getResourceList();}
	    }
	  
	  }])
	  
	 //点赞
 .factory('PraiseService', ['$http', function($http) { 
	  	
	 	var getpraisefunc= function(Tid){
	      return $http({
	        method:'post',
	        url:'GetpraiseAction',
	        params:{"Tid":Tid,"form":"GetPraisestatu"}
	      })
	    };
	    
	    var addpraisefunc= function(Tid){
	      return $http({
	        method:'post',
	        url:'GetpraiseAction',
	        params:{"Tid":Tid,"form":"AddThemepraise"}
	      })
	    };
	    
	    var deletepraisefunc= function(Tid){
		      return $http({
		        method:'post',
		        url:'GetpraiseAction',
		        params:{"Tid":Tid,"form":"DeleteThemepraise"}
		      })
		    };
	    
		    

	    return { 
	    do_addpraisefunc:function(Tid){return addpraisefunc(Tid);},
	    do_getpraisefunc:function(Tid){return getpraisefunc(Tid);},
	    do_deletepraisefunc:function(Tid){return deletepraisefunc(Tid);}
	    }
	  
	  }])
	  
	  
	   //收藏
 .factory('CollectService', ['$http', function($http) { 
	  	
	 	var getCollectFunc= function(Tid,type){
	      return $http({
	        method:'post',
	        url:'SaveAction',
	        params:{"Tid":Tid,"form":"GetSaveStatu","type":type}
	      })
	    };
	    
	    var addCollectFunc= function(Tid,type){
	      return $http({
	        method:'post',
	        url:'SaveAction',
	        params:{"Tid":Tid,"form":"AddSave","type":type}
	      })
	    };
	    
	    var deleteCollectFunc= function(Tid,type){
		      return $http({
		        method:'post',
		        url:'SaveAction',
		        params:{"Tid":Tid,"form":"DeleteSave","type":type}
		      })
		    };
	    
		    

	    return { 
	    do_getCollectFunc:function(Tid,type){return getCollectFunc(Tid,type);},
	    do_addCollectFunc:function(Tid,type){return addCollectFunc(Tid,type);},
	    do_deleteCollectFunc:function(Tid,type){return deleteCollectFunc(Tid,type);}
	    }
	  
	  }])
	  
	   //主题回复
 .factory('AddThemeReply', ['$http', function($http) { 
	  
	    var addThemeReply= function(Tid,content){
	      return $http({
	        method:'post',
	        url:'AddReplyAction',
	        params:{"Tid":Tid,"content":content}
	      })
	    };
	    
		    

	    return { 
	    do_addThemeReply:function(Tid,content){return addThemeReply(Tid,content);}
	    }
	  
	  }])
	  
	  //私信
	  .factory('MessageService', ['$http', function($http) { 
	  
	    var getMessageList= function(){
	      return $http({
	        method:'post',
	        url:'MessageAction',
	        params:{"form":"GetAllMessage"}
	      })
	    };
	    
	    var getUserMessageList= function(ToId){
		      return $http({
		        method:'post',
		        url:'MessageAction',
		        params:{"form":"GetPrivateMessage","ToId":ToId}
		      })
		    };
	    
	    var sendMessage= function(ToId,content){
		      return $http({
		        method:'post',
		        url:'MessageAction',
		        params:{"form":"SendMessage","ToId":ToId,"content":content}
		      })
		    };
	    return { 
	    	do_getMessages:function(){return getMessageList();},
	    	do_getUserMessageList:function(ToId){return getUserMessageList(ToId);},
	    	do_sendMessage:function(ToId,content){return sendMessage(ToId,content);}
	    }
	  
	  }])
	  
	  //关注、取消关注
	  .factory('FocusService', ['$http', function($http) { 
	  
	    var addFocusFunc= function(Uid){
	      return $http({
	        method:'post',
	        url:'UserFocusAction',
	        params:{"form":"AddFucos","Fid":Uid}
	      })
	    };
	    
	    var deleteFocusFunc= function(Uid){
		      return $http({
		        method:'post',
		        url:'UserFocusAction',
		        params:{"form":"DeleteFucos","Fid":Uid}
		      })
		    };
		var getFocusFunc= function(Uid){
		return $http({
			method:'post',
			url:'UserFocusAction',
			params:{"form":"FucosState","Fid":Uid}
			})
		};
	    return { 
	    	do_addFocusFunc:function(Uid){return addFocusFunc(Uid);},
	    	do_deleteFocusFunc:function(Uid){return deleteFocusFunc(Uid);},
	    	do_getFocusFunc:function(Uid){return getFocusFunc(Uid);}
	    }
	  
	  }])
	  