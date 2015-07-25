<link rel="stylesheet/less" type="text/css" href="${ctx}/static/css/main.less">
<script src="http://cdn.bootcss.com/less.js/1.3.3/less.min.js" type="text/javascript"></script>
<link rel="shortcut icon" href="favicon.ico">
<script type="text/javascript">
  (function () {
  	//作者不希望用ie访问该站点
    if (/Microsoft/.test(navigator.appName)) { return }

    window.onload = function () {
      var headers = document.querySelectorAll('#docs h2, #guide h1');
      var menu = document.getElementById('menu');
      var init = menu.offsetTop;
      var docked;

      /*for (var i = 0; i < headers.length; i++) {
        headers[i].id = '-' + headers[i].innerHTML.toLowerCase().replace(/ /g, '-');
      }*/

      window.onscroll = function () {
        if (!docked && (menu.offsetTop - scrollTop() < 0)) {
          menu.style.top = 0;
          menu.style.position = 'fixed';
          menu.className = 'docked';
          docked = true;
        } else if (docked && scrollTop() <= init) {
          menu.style.position = 'absolute';
          menu.style.top = init + 'px';
          menu.className = menu.className.replace('docked', '');
          docked = false;
        }
      };

	menuList("java", "java_list") ;
	menuList("linux", "linux_list") ;
	menuList("database", "database_list") ;
	menuList("pattern", "pattern_list") ;
    };

    function scrollTop() {
      return document.body.scrollTop || document.documentElement.scrollTop;
    }
    
  })();
  
function menuList(itemid, itemlist) {
  		var link     = document.getElementById(itemid),
            dropdown = document.getElementById(itemlist);

        link.onmouseover = function () {
          link.className = 'dark-red';
          dropdown.style.display = 'block';
        };
        link.onmouseout = function (e) {
          if (e.relatedTarget === dropdown) { return }
          link.className = link.className.replace('dark-red', '');
          hide ();
        };
        dropdown.onmouseout = function (e) {
          var t = e.relatedTarget;

          if (e.target == link) { return }

          while (t !== document.body) {
            if (t == dropdown) { return }
            else               { t = t.parentNode }
          } 
          link.className = link.className.replace('dark-red', '');
          hide ();
        };

        function hide() { dropdown.style.display = 'none' }
  }
  
</script>