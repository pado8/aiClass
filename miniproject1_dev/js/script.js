document.addEventListener('DOMContentLoaded', function () {
  // 헤더의 관련사이트 드롭다운 메뉴 기능
  document.querySelector('#header .dropdown_btn').addEventListener('click', function () {
    let tg = this;
    if (!(tg.classList.contains('active'))) {
      tg.classList.add('active');
      document.querySelector('#header .nav_dropdown').classList.add('on');
    } else {
      tg.classList.remove('active');
      document.querySelector('#header .nav_dropdown').classList.remove('on');
    }
  });

  // 스크롤 시 헤더에 클래스 추가
  const header = document.querySelector("#header");
  window.addEventListener("scroll", function () {
    if (window.scrollY > 0) {
      header.classList.add("scrolled");
    } else {
      header.classList.remove("scrolled");
    }
  });

  // 헤더 관련 사이트 클릭시 나타나는 드롭다운 기능
  const button = document.getElementById("drop_btn");
  const dropdown = document.getElementById("drop_menu");

  function updateDropdownPosition() {
    const rect = button.getBoundingClientRect();

    dropdown.style.top = `${rect.bottom + 40}px`; // 버튼 바로 아래에 위치
    dropdown.style.left = `${rect.left + rect.width / 2}px`; // 버튼 중앙 정렬
    dropdown.style.transform = "translateX(-50%)"; // 정확한 중앙 정렬
  }

  button.addEventListener("click", function () {
    if (dropdown.style.display === "block") {
      dropdown.style.display = "none";
      window.removeEventListener("scroll", updateDropdownPosition); // 위치 업데이트 중지
      window.removeEventListener("resize", updateDropdownPosition); // 창 크기 변경 시 업데이트 중지
    } else {
      dropdown.style.display = "block";
      updateDropdownPosition(); // 위치 업데이트
      window.addEventListener("scroll", updateDropdownPosition); // 스크롤 시 위치 업데이트
      window.addEventListener("resize", updateDropdownPosition); // 창 크기 변경 시 업데이트
    }
  });
});