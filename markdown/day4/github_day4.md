2023년 1월 4일 수요일

---

## clone, pull

- 원격저장소 가져오기
  - `git clone` : remote repository의 commit을 모두 가져와서, local repository를 생성하는 명령어

    - 형태 : `git clone <원격저장소 주소>`
    - `git init`과 `git remote add`가 이미 수행되어있다. 
  
  - `git pull` : remote repository의 commit을 가져와서, local repository를 업데이트 하는 명령어
    - 내용이 완전 일치하면 `git pull`을 해도 변화가 일어나지 않는다. __동기화 개념__
    - 형태 : `git pull <저장소이름> <브랜치이름>`



- 순서 : `git pull` ` git add` `git commit` `git push`
- `git push`하기 전에 꼭 `git pull`을 하자. reject 방지