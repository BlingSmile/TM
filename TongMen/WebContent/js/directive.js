var expanderModule=angular.module('expanderModule', []);
expanderModule.directive('navul', function() {
	return {
		restrict : 'EA',
		replace : true,
		transclude : true,
		template : '<ul class="navigator"><li ng-repeat="item in menus" class="navigator-item " >{{item}}</li></ul>',
		link : function(scope, element, attrs) {
			scope.menus=["我关注的人","关注我的人"];
			console.log(element.children().find("li"));
			// var childs=element.children();
			// console.log(element[0].childNode());
			console.log(document.getElementsByTagName("ul")[0].childNodes);
			var childs=document.getElementsByTagName("li");
			console.log(childs[0].nextElementSibling);
			// var childs=element[0].children();
			console.log(childs);
			for(var i=0;i<childs.length;i++)
			{
				alert(1);
				console.log(childs[i]);
				childs[i].onclick=function(event)
				{
					scope.$apply(attrs.getInf);
					for(var i=0;i<childs.length;i++)
						{
							childs[i].className="navigator-item";
						}
					this.className+=" navigator-on";
					alert(1);



				}


			}





			// var b= angular.element(element.children()[0]);
			// 	b.bind("onmouseover",function(){

			// 		 var a=angular.element(this)

			// 		a.toggleClass("ss")
			// 	});
				// console.log(element.children()[0].className);
				// var first=element.children()[0];
				// first.onmouseover=function()
				// {
				// 	this.className+="aa";

				// }

		}
	}
})