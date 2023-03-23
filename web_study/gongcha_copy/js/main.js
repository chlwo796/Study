const left1 = document.querySelector(".left1");
const right1 = document.querySelector(".right1");
const left2 = document.querySelector(".left2");
const bottom1 = document.querySelector(".bottom1");
const bottom2 = document.querySelector(".bottom2");
const bottom3 = document.querySelector(".bottom3");
const bottom4 = document.querySelector(".bottom4");
left1.animate(
  {
    transform: ["translateX(-50px)", "translateX(0px)"],
  },
  {
    duration: 300,
    fill: "forwards",
    easing: "ease",
  }
);
left2.animate(
  {
    transform: ["translateX(-50px)", "translateX(0px)"],
  },
  {
    duration: 300,
    fill: "forwards",
    easing: "ease",
  }
);
right1.animate(
  {
    transform: ["translateX(50px)", "translateX(0px)"],
  },
  {
    duration: 300,
    fill: "forwards",
    easing: "ease",
  }
);
bottom1.animate(
  {
    transform: ["translateY(50px)", "translateX(0px)"],
  },
  {
    duration: 300,
    fill: "forwards",
    easing: "ease",
  }
);
bottom2.animate(
  {
    transform: ["translateY(50px)", "translateX(0px)"],
  },
  {
    duration: 300,
    fill: "forwards",
    easing: "ease",
  }
);
bottom3.animate(
  {
    transform: ["translateY(50px)", "translateX(0px)"],
  },
  {
    duration: 300,
    fill: "forwards",
    easing: "ease",
  }
);
bottom4.animate(
  {
    transform: ["translateY(50px)", "translateX(0px)"],
  },
  {
    duration: 300,
    fill: "forwards",
    easing: "ease",
  }
);
// 메뉴 바
// ul에 마우스를 올리면 ul li 에 add .on
let gnb = document.querySelectorAll(".header > ul > li");
let gnbElement = document.querySelector(".header");

for (let i = 0; i < gnb.length; i++) {
  gnb[i].addEventListener("mouseover", () => {
    gnbElement.classList.add("on");
  });
}

let headerElement = document.querySelector(".header");

headerElement.addEventListener("mouseout", (e) => {
  if (e.target.id == "gnb") {
    gnbElement.classList.remove("on");
  }
});
