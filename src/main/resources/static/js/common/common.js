/***********************************************************************
fancybox定義
***********************************************************************/
var fancyboxBasicOption = {
		type: 'iframe',              // 種別（image, ajax, iframe, swf, inline）
		margin: 0,                   // ビューポートとFancyBoxラッパーの間の余白
		padding: 0,                  // FancyBoxラッパーとコンテンツの間の余白
		//hideOnOverlayClick: false,   // オーバーレイクリックで、FancyBoxを閉じない
		//showCloseButton: true,       // 閉じるボタン表示
		scrolling: 'auto',           // スクロールバー表示
		//overlayColor: '#000000',     // オーバーレイの色
		transitionIn: 'none'         // 遷移種別（elastic, fade, none）
};

/***********************************************************************
fancyboxOpen
***********************************************************************/
function openFancybox(inIframe, url, width, height, onStart, onComplete, onClosed) {
	
	var fancyboxOption = {};
	$.extend(true, fancyboxOption, fancyboxBasicOption);
	$.extend(true, fancyboxOption, {
		href: url,
		width: width,
		height: height
	});

	if (onStart) {
		$.extend(true, fancyboxOption, {
			onStart: onStart
		});
	}
	if (onComplete) {
		$.extend(true, fancyboxOption, {
			onComplete: onComplete
		});
	}
	if (onClosed) {
		$.extend(true, fancyboxOption, {
			onClosed: onClosed
		});
	}
	if (inIframe) {
		parent.$.fancybox(fancyboxOption);
	} else {
		$.fancybox(fancyboxOption);
	}
}

