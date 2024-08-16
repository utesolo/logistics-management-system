// script.js
$(document).ready(function () {
    $('.undo').click(function (e) {
        e.preventDefault();
        const $this = $(this);

        // 如果点击的是顶级菜单项，则加载内容
        if (!$this.parent().hasClass('subnav')) {
            const target = $this.attr('href');
            console.log(target);
            loadContent(target);
        }
    })
    // 当点击某个菜单项时触发
    $('.nav-link').click(function (e) {
        e.preventDefault(); // 阻止默认行为
        const $this = $(this);
        const subnavId = $this.closest('.nav-item').find('.subnav').attr('id');
        toggleSubnav(subnavId);
    });

    function toggleSubnav(subnavId) {
        const $subnav = $('#' + subnavId);
        if ($subnav.hasClass('show')) {
            $subnav.slideUp(300, function () {
                $subnav.removeClass('show');
                $subnav.prev('.nav-link').find('.arrow').removeClass('rotate');
            });
        } else {
            $subnav.slideDown(300, function () {
                $subnav.addClass('show');
                $subnav.prev('.nav-link').find('.arrow').addClass('rotate');
            });
        }
    }

    function loadContent(target) {
        $('#content').load(target + '.html', function () {
            console.log('内容已加载');
        });
    }
});