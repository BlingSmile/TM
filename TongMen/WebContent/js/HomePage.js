var homepage = angular.module("HomePage", ["ionic"]);
 
homepage.config(function ($stateProvider, $urlRouterProvider) {
 
     $urlRouterProvider.when("", "/homepage");
 
     $stateProvider
        .state("homepage", {
            url: "/homepage",
            templateUrl: "HomePage.html"
        })
        .state("theme", {
            url: "theme",
            templateUrl: "Theme.html",
            controller : "ThemeCtrl"
        })
        .state("homepage.HotTheme", {
            url: "/homepage/HotTheme",
            templateUrl: "ThemeList.html"
        })
        .state("homepage.HotCircle", {
            url: "/homepage/HotCircle",
            templateUrl: "CircleList.html"
        })
         .state("homepage.HotUser", {
            url: "/homepage/HotUser",
            templateUrl: "UserList.html"
        })
        .state('create', {
            url : '/create',            
            templateUrl :'login.html' , 
            
        });
     
});

homepage.controller('NavController', function($scope, $ionicSideMenuDelegate) {
      $scope.toggleLeft = function() {
        $ionicSideMenuDelegate.toggleLeft();
      };
})

var theme={
	useravrurl:'img/avatar.png',
	tname:'主题名',
	content:'我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟我是内容哟',
	time:'2015-05-15',
	praice:'32'
	};
	
homepage.controller("ThemeListCtrl",function($scope){
	$scope.themes = [theme,theme,theme,theme,theme,theme,theme,theme,theme,theme,theme,theme,theme];
	$scope.items = [];
	for(var i=0;i<50;i++) 
		$scope.items.push(["item",i+1].join(""));
	
})

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
homepage.controller("ThemeCtrl",function($scope){
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

homepage.controller("CircleCtrl",function($scope){

	$scope.circles = [circle,circle,circle,circle,circle,circle,circle];
	
})

homepage.controller("UserCtrl",function($scope){
	$scope.users = [user,user,user,user,user,user,user,user,user,user,user,user,user];
	
})