


			/* 用于进行非空验证的方法*/
				function isNull(ipt) {
					$(ipt).next(".validate_1").remove();
					if (ipt.value=="") {
						$(ipt).after("<span class='validate_1'><img src='/neusoftsms/imgs/Warning_16px_1186332_easyicon.net.ico'>"+ipt.title+"不能为空</span>");
						$(ipt).next(".validate_1").css({
							left:$(ipt).offset().left-7,
							top:$(ipt).offset().top-2
						}).fadeIn(300);
						$(ipt).next().click(function(){
							$(this).fadeOut(200,function(){
								$(ipt).focus();
							});
							
						});
						return true;
					}
						return false;
				}
//				return ok;
//			});
			
			