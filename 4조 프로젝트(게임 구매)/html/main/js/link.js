document.addEventListener("DOMContentLoaded", function () {
    fetch("../header/header.html") // header.html 파일 가져오기
      .then(response => response.text())
      .then(data => {
        document.getElementById("headerContainer").innerHTML = data;

            let link = document.createElement("link");
            link.rel = "stylesheet";
            link.href = "../header/css/header.css";
            document.head.appendChild(link);

      })
      .catch(error => console.error("헤더 로딩 실패:", error));

      fetch("../footer/footer.html") // footer.html 파일 가져오기
      .then(response => response.text())
      .then(data => {
        document.getElementById("footerContainer").innerHTML = data;

            let link = document.createElement("link");
            link.rel = "stylesheet";
            link.href = "../footer/css/footer.css";
            document.head.appendChild(link);

      })
      .catch(error => console.error("footer 로딩 실패:", error));
  });  
