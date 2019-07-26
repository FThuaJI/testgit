			function ShopConfirm(str){
				var ShopConfirmLayer=document.getElementById(str);
				//var webBgLayer=document.getElementById("webBgLayer");
				// ShopConfirmLayer.innerHTML=str;
				ShopConfirmLayer.style.display="";//显示内容层，显示覆盖层

				ShopConfirmLayer.style.left=parseInt((document.documentElement.scrollWidth-ShopConfirmLayer.offsetWidth)/2)+document.documentElement.scrollLeft+"px";
				ShopConfirmLayer.style.top=Math.abs(parseInt((document.documentElement.clientHeight-ShopConfirmLayer.offsetHeight)/2))+document.documentElement.scrollTop+"px"; //为内容层设置位置

				//webBgLayer.style.display="";
				//webBgLayer.style.height=document.documentElement.scrollHeight+"px"; //为覆盖层设置高度
			}
			
			function CloseShopConfirm(ids){
				var ShopConfirmLayer=document.getElementById(ids);
				//var webBgLayer=document.getElementById("webBgLayer");
				ShopConfirmLayer.style.display="none";
				//webBgLayer.style.display="none";
			}
			
			function replyfirm(str){
				var replyfirmLayer=document.getElementById(str);
			
				replyfirmLayer.style.display="";//显示内容层，显示覆盖层

				replyfirmLayer.style.left=parseInt((document.documentElement.scrollWidth-replyfirmLayer.offsetWidth)/2)+document.documentElement.scrollLeft+"px";
				replyfirmLayer.style.top=Math.abs(parseInt((document.documentElement.clientHeight-replyfirmLayer.offsetHeight)/2))+document.documentElement.scrollTop+"px"; //为内容层设置位置

				
			}
			
			function Closereplyfirm(ids){
				var replyfirmLayer=document.getElementById(ids);
				
				replyfirmLayer.style.display="none";
				
			}