// ui-common.js

(function(global, $){

'use strict';


	$(function($) {

		// sticky fixed
		if (document.querySelector('.sticky-scroll')) {
		
			var $window = $(window),
				$stickyscroll = $('.sticky-scroll'),
				stickyOffset = $stickyscroll.offset().top;

			$window.on('scroll', function() {
			    var sticky = $stickyscroll,
			        scroll = $window.scrollTop();
			    
			    if (scroll >= stickyOffset) {
			        sticky.addClass('fixed');
			        $documente.addClass('stickyfixed');
			    } else {
			        sticky.removeClass('fixed');
			        $documente.removeClass('stickyfixed');
			    }
			});
		};

		/* 수정:1209 */
		// sub tab sticky fixed
		if (document.querySelector('.sub-tab')) {
			var $window = $(window),
				$stickyscroll = $('.sticky-scroll'),
				stickyOffset = $stickyscroll.offset().top;

			$window.on('scroll', function() {
			    var sticky = $stickyscroll,
			        scroll = $window.scrollTop();
			    
			    if (scroll >= stickyOffset) {
			        $documente.addClass('fixedSubTab');
			    } else {
			        $documente.removeClass('fixedSubTab');
			    }
			});
		}

		/* 수정:1123 */
		// sub tab slide sticky fixed
		if (document.querySelector('.sub-tab-slide')) {
		
			var $window = $(window),
				$stickyscroll = $('.sticky-scroll'),
				stickyOffset = $stickyscroll.offset().top;
				$('.content').css('height','969px');
				/* 추가:1126 */
				$('.null-empaty').css('top','60%');
				/* //추가:1126 */

			$window.on('scroll', function() {
			    var sticky = $stickyscroll,
			        scroll = $window.scrollTop();
			    
			    if (scroll >= stickyOffset) {
			        $documente.addClass('fixedSubSlide');
			    } else {
			        $documente.removeClass('fixedSubSlide');
			    }
			});
		};

		// img wrap sticky fixed
		if (document.querySelector('.myvenu-adcard1')) {
		
			var $window = $(window),
				$stickyscroll = $('.sticky-scroll'),
				stickyOffset = $stickyscroll.offset().top,
				$imgWrap = $('.myvenu-adcard1').find('.img-wrap'),
				$siblingsBox = $('.myvenu-adcard1').find('ul');
				$('.content').css('height','969px');

			$window.on('scroll', function() {
			    var sticky = $stickyscroll,
			        scroll = $window.scrollTop();
			    
			    if (scroll >= stickyOffset) {
			        sticky.addClass('fixed');
			        $documente.addClass('fixedImg');
			        $siblingsBox.css('padding-top', $imgWrap[0].offsetHeight+17);
			    } else {
			        sticky.removeClass('fixed');
			        $documente.removeClass('fixedImg');
			        $siblingsBox.css('padding-top', '');
			    }
			});
		};
		/* //수정:1123 */

		// btn toggle
		var $btn_toggle = $('.btn-toggle'),
			$cont_toggle = $('.cont-toggle');
			
		$btn_toggle.on('click', function(e) {
			e.preventDefault();
			$(this).toggleClass('on');
			$cont_toggle.toggleClass('hide');
		});

		/* 수정:1123 */
		// nav tap slide
		var navTapSlide = function () {
			var idx;
			$('.nav-tab .swiper-wrapper a').each(function(i){
				if ($(this).hasClass("on")) {
					idx = i;
				}
			});
			var swiper_subTab = new Swiper('.nav-tab .swiper-container ', {
				slidesPerView: 3,
				spaceBetween: 0,
				initialSlide : idx,
				slidesPerGroup: 3,
				centeredSlides: false,
				paginationClickable: true,
				grabCursor: true,
				loop : false,
				navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev',
				},
				breakpoints: {
					320: {
					slidesPerView: 2,
					spaceBetween: 10,
					slidesPerGroup: 2,
					}
				}
			});
		};
		navTapSlide();

		// sub tap slide
		var subTapSlide = function () {
			var idx;
			$('.sub-tab-slide .swiper-wrapper a').each(function(i){
				if ($(this).hasClass("on")) {
					idx = i;
				}
			});
			var swiper_subTab = new Swiper('.sub-tab-slide .swiper-container ', {
				slidesPerView: 'auto',
				initialSlide : idx,
				slidesPerGroup: 1,
				centeredSlides: true,
				paginationClickable: true,
				grabCursor: true,
				loop : false,
				navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev',
				}
			});
		};
		subTapSlide();
		/* //수정:1123 */

		// gallery slide 
		var gallerySlide = function () {
			var gallery_slide = new Swiper('.gslide', {
				pagination: {
				el: '.swiper-pagination',
				clickable: true,
				},
			});
		};
		gallerySlide();

		// sub menu
		var $documente = $(document.documentElement),
			$btnmenu = $('.btn-menu'),
			$btnmenuclose = $('.btn-menu-close'),
			$dimmedaside = $('.dimmed-aside'),
			
			navopened = false;

		$btnmenu.click(togglenav);
		$btnmenuclose.click(closenav);

		function togglenav(e) {
			if (!navopened) {
				$documente.addClass('submenu');
				navopened = true;
			} else {
				closenav();
			}
			e.preventDefault();
		}

		function closenav(e) {
			$documente.removeClass('submenu');
			navopened = false;
		}

		$dimmedaside.on({'click': closenav});

		$('.has-child').on('click',function(event){
			event.preventDefault();
			$('.has-child + ul').slideUp('400');
			/* 수정:1126 */
			$(this).parent().siblings().removeClass('on');
			/* //수정:1126 */
			$(this).parent().toggleClass('on');
			if($(this).next('ul').is(":hidden") == true) {
				$(this).next('ul').slideDown('400');
			}
		});


		// btn more
		var $btn_more = $('.btn-detail-more'),
			$bg_opacity = $('.bg-opacity');
			
		$btn_more.on('click', function(e) {
			e.preventDefault();
			$(this).parent().parent().parent().toggleClass('on');
		});
		
		$bg_opacity.on('click', function(e) {
			$(this).parent().removeClass('on');
		});


		// btn lang
		var $btn_lang = $('.btn-lang'),
			$btn_lang_close = $('.btn-lang-close');
			
		$btn_lang.on('click', function(e) {
			e.preventDefault();
			$(this).parent().toggleClass('on');
		});

		$btn_lang_close.on('click', function(e) {
			e.preventDefault();
			$(this).parent().parent().parent().removeClass('on');
		});

		// accordion
		(function accordion () {
			
			$('.langlist').children('li').first().children('a').addClass('active')
				.next().addClass('is-open').show();
				
			$('.langlist').on('click', '.subject-link', function(e) {
			e.preventDefault();
				
			  if (!$(this).hasClass('active')) {

				$('.langlist .is-open').removeClass('is-open').hide();
				$(this).next().toggleClass('is-open').toggle();			  
				
				$('.langlist').find('.active').removeClass('active');			
				$(this).addClass('active');			
				
			 } else {
				$('.langlist .is-open').removeClass('is-open').hide();
				$(this).removeClass('active');
			  }
		   });
		})();

		/* 수정:1216 */
		// map view
	    var $html = $('html'),
	    	$tabcontainer = $('.tab-container'),
			$tabmenus = $('.tab-menu li a'),
			$tabcont = $('.tab-cont'),
			$imgcont = $('.img-cont'),
			$mapsubmenus = $tabcont.find('li a'),
			$imgsub = $('.img-sub-cont li'),
			$view = $('.map-view'),
			$maplinks = $('.map .map-link'),
			$maparea = $('.map-area');

		$maplinks.on('click',function(){
			$view.addClass('on')
			$tabcontainer.css('margin-top', $maparea[0].offsetHeight);
		});
		
		var changeCont = function(index) {
			if ( index >=0 && index <= $tabmenus.length) {
				$($tabcont).siblings().removeClass('active');
				$($tabcont[index]).addClass('active');
			}
		};

		var changeImg = function(index) {
			if ( index >=0 && index <= $tabmenus.length) {
				$($imgcont).siblings().removeClass('active');
				$($imgcont[index]).addClass('active');
			}
		}; 

		var changeMenu = function(index) {
			if ( index >=0 && index <= $tabmenus.length) {
				$($tabmenus[index]).parent().siblings().removeClass('active');
				$($tabmenus[index]).parent().addClass('active');
			}
		};

		var clickMenu = function(link, index) {
			link.addEventListener('click',function(e){
				e.preventDefault();
				$(this).parent().siblings().removeClass('active');
				$(this).parent().addClass('active');
				changeCont(index);
				changeImg(index);
			});
		};

		for (var $tabmenu, i=0, l=$tabmenus.length;i<l;i++){
			$tabmenu = $tabmenus[i];
			clickMenu($tabmenu, i);				
		}

		var clickMaplink = function(link, index) {
			link.addEventListener('click',function(e){
				e.preventDefault();
				changeCont(index);
				changeImg(index);
				changeMenu(index);
			});
		};

		for (var $maplink, i=0, l=$maplinks.length;i<l;i++){
			$maplink = $maplinks[i];
			clickMaplink($maplink, i);
		}

		var changeSubImg = function(index) {
			if ( index >=0 && index <= $mapsubmenus.length) {
				$($imgsub).siblings().removeClass('active');
				$($imgsub[index]).addClass('active');
			}
		};		

		var clickSubMenu = function(link, index) {
			link.addEventListener('click',function(e){
				e.preventDefault();
				$(this).parent().parent().siblings().children().removeClass('active');
				$(this).parent().siblings().removeClass('active');
				$(this).parent().addClass('active');
				changeSubImg(index);
			});
		};

		for (var $mapsubmenu, i=0, l=$mapsubmenus.length;i<l;i++){
			$mapsubmenu = $mapsubmenus[i];
			clickSubMenu($mapsubmenu, i);				
		}

		// facode toggle
		var $btnmore = $('.btn-fa-more'),
		    $contmore = $('.cont-fa-more');

		$btnmore.on('click', function(e) {
			e.preventDefault();
			$(this).parent().parent().siblings().removeClass('open');
			$(this).parent().parent().next().toggleClass('open');
		});
		/* 수정:1216 */
	    
	});

})(this, this.jQuery);



