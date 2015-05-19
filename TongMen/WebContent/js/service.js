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
    		url:'   ',
    		params:{'name':username,"password":password}




    	})





    };
    var register=function(username,password,phone){
      return $http({
        method:'post',
        url:'',
        params:{'name':username,'password':password,'phone':phone}


      })






    }




    
    return { 
      events: function(username) { return doRequest(username, 'events'); }, 
      do_login:function(username,password){ return login(username,password);},
      do_register:function(username,password,phone){return register(username,password,phone)};
     
    }; 
  }]); 