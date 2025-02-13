document.addEventListener("DOMContentLoaded", function () {
    function isMobile() {
        return window.matchMedia("(max-width: 768px)").matches;
    }
    console.log('1');

    document.querySelector('#nav .dropdown-btn').addEventListener('click', function () {
        let tg = this;
        if (!(tg.classList.contains('active'))) {
            tg.classList.add('active');
            document.querySelector('#nav .nav-dropdown').classList.add('on');
        } else {
            tg.classList.remove('active');
            document.querySelector('#nav .nav-dropdown').classList.remove('on');
        }
    });
});
