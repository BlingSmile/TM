 angular.module('demo.service',[])

  .factory('login_register', ['$http', function($http) { 
  
    var doRequest = function(username, path) { 
      return $http({ 
        method: 'JSONP', 
        url: 'https://api.github.com/users/' + username + '/' + path + '?callback=JSON_CALLBACK' 
      }); 
    } ;
    var login= function(username,password){
    	var params={};
    	params.name = username;
    	params.password =password;
    	return $http({
    		method:'post',
    		url:'LoginAction?name=123&password=ss',
    		
    	})
    }
    return { 
      events: function(username) { return doRequest(username, 'events'); }, 
      do_login:function(username,password){ return login(username,password);}
    }; 
  }]); 