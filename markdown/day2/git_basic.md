2023년 1월 2일 월요일

---

## 0. Git install

1. [Git download](https://git-scm.com/download/win)
2. [Install](https://cafe.naver.com/thisiscoding/2153)
   - Git 설치 후 윈도우 탐색기를 연다.(윈도우키 + e)
   - __c:/사용자(Users)/현재 사용자 계정__ 로 이동
   - Folder 내 빈 공간에서 마우스 우클릭 후 __Git Bash Here__ 를 클릭.
   - Git Bash 창에 HOME Folder를 의미하는 __~__ 표시만 있다면 정상.(__~__ 표시가 없거나, 뒤에 글자가 추가적으로 나타난다면 잘못된 경로일 수 있음.)
   - git은 폴더 안에 파일이 바뀌는 것, 파일의 내용이 바뀌는 것을 관리해주는 도구
  
3. a.java 파일 20줄 50줄
4. git은 관리하는 폴더를 지정하면 그곳에 있는 것을 관리한다.

---

## 1. 초기설정

> 최초 한 번만 설정한다. 매번 git을 사용할 때마다 설정할 필요 x


1. 누가 커밋 기록을 남겼는지 확인할 수 있도록 이름과 이메일을 설정, 작성자를 수정하고 싶을 때에는 이름, 메일주소만 다르게 하여 동일하게 입력

```git
$ git config --global user.name "이름"
$ git config --global user.email "메일주소"
```

2. 작성자가 올바르게 설정되었는지 확인

```git
$ git config --global --list
```

## 2. git 기본 명령어

### (0) 로컬 저장소
![로컬저장소](https://cafeptthumb-phinf.pstatic.net/MjAyMjEyMDFfMjY2/MDAxNjY5ODg5MzQ0NzY1.dGlimdwxyORrLAdgFQnPOTvhzKPb3UIv6kI13-TV4NUg.IVxtQ2MCOH8AS6WKc17p3zKCBNuyOFJFLHpLynV0ZsEg.PNG/image.png?type=w1600)

- Working Directory(= working tree) : 사용자의 일반적인 작업이 일어나는 곳
- Staging Area(= index) : 커밋을 위한 파일 및 폴더가 추가되는 곳
- Respository : Staging Area에 있던 파일 및 폴더의 변경사항(커밋)을 저장하는 곳
- Git은 Working Directory -> Staging Area -> Repository의 과정으로 버전 관리를 수행한다.

### (1) git init

`$ git init`

- 현재 작업 중인 디렉토리를 Git으로 관리한다는 명령어
- `.git` 이라는 숨김 폴더를 생성하고, 터미널에는 (master)라고 표기된다.
- Mac OS의 경우 (master)가 표기되지 않는데, terminal 업그레이드를 통해 표기할 수 있다.
> 주의사항
 1. 이미 Git 저장소인 폴더 내에 또 다른 Git 저장소를 만들지 않는다. (중첩금지)
 2. 터미널에 (master)가 있으면, `git init` 입력금지
Home Directory에서 `git init` 금지. 터미널의 경로가 `~`인지 확인.

### (2) git status

`$ git status`

- Working Directory와 Staging Area에 있는 파일의 현재 상태를 알려주는 명령어
- 어떤 작업을 시행하기 전에 수시로 status를 확인하면 좋음.

__상태__

1. `Untracked` : Git이 관리하지 않는 File(한 번도 Staging Area에 올라간 적 없는 File)
2. `Traked` : Git이 관리하는 File
   1. `Unmodified`  : 최신 상태
   2. `Modified` : 수정되었지만 아직 Staging Area에는 반영하지 않은 상태
   3. `Staged` : Staging Area에 올라간 상태

![File의 Life Cycle](https://cafeptthumb-phinf.pstatic.net/MjAyMjEyMDFfMjEw/MDAxNjY5ODg5Mzg4NDg5.WG4NBdzDIyK0wYjioREZCj2Ox8g17y5Y6ROFeODUwdQg.g6nyhbeFzEophldndH2g7_LNxLDGw7ykZZ5sTS01m4gg.PNG/image.png?type=w1600)

### (3) git add

`$ git add`

\* 특정 파일 : `$ git add a.txt`

\* 특정 폴더 : `$ git add my_folder/`

\* 현재 Directory에 속한 파일/폴더 전부 : `$ git add .`

- Working Directory에 있는 File을 Staging  Area 로 올리는 명령어
- Git이 해당 File을 추적(관리)할 수 있도록 만든다.
- __Untracked, Modified -> Staged__ 로 상태를 변경한다.
- 예시
  
```git
$ touch a.txt b.txt

$ git status

On branch master

No commits yet

Untracked files: 
   (use "git add <file>...") to include in what will be committed)
      a. txt
      b. txt
nothing added to commit but untracked files present(use "git add" to track)
```
`$ git add a.txt`

```git
$ git status

On branch master

No commits yet

Changes to be committed:
   (use "git rm --cached <file>..." to unstage)
      new file:   a.txt

Untracked files:
   (use "git add <file>..." to include in what will be committed)
      b.txt
```

### (4) git commit

```git
$ git commit -m "first commit"
[master (root-commit) 2eb6c98] first commit
1. file changed, 1 insertion(+)
create mode 100644 a.txt
```
- Staging Area에 올라온 file의 변경 사항을 하나의 version(commit)으로 저장하는 명령어
- __Commit message__ 는 현재 변경 사항들을 잘 나타낼 수 있도록 __의미__ 작성하는 것이 중요.
- 각각의 commit은 __SHA-1__ 알고리즘에 의해 반환된 고유의 해시 값을 ID로 가진다
- __(root-commit)__ 은 해당 commit이 최초의 commit일 때만 표시된다. 이후 commit부터는 사라짐.

### (5) git log

```git
$ git log
commit 2eb6c98ee43adfcb73b42c97da6147db0c06c640 (HEAD -> master)
Author: chlwo796 <chlwo796@gmail.com>
Date:   Mon Jan 2 18:37:06 2023 +0900

    first commit
```
- commit의 내역(ID, 작성자, 시간, 메세지 등)을 조회할 수 있는 명령어
- Option
  - __--oneline__ : 한줄로 축약해서 보여줌.
  - __--graph__ : 브랜치와 머지 내역을 그래프로 보여줌.
  - __--all__ : 현재 브랜치를 포함한 모든 브랜치의 내역을 보여줌.
  - __--reverse__ : commit 내역의 순서를 반대로 보여줌.(최신이 가장 아래)
  - __-p__ : file의 변경 내용도 같이 보여줌.
  - __-2__ : 원하는 갯수 만큼의 내역을 보여줌(2 이외 임의의 숫자 가능)
  
### \* Option과 인자
   > Command를 사용하면서 - 혹은 --를 통해 Option을 사용하는 것을 배웠다. Option과 더불어서 인자라는 개념도 존재하는데 이는 무엇이 다를까?

   Option은 Command의 동작 방식을 지정하는 것이다. 따라서 생략가능하고 단순히 기존 기능보다 부가 적인 기능을 원할 때 사용한다. 예를들면 __git log --oneline__ 은 commit 내역을 한줄로 보고 싶을 때 사용한다. __oneline__ Option은 말그대로 부가적인 기능이므로, 생략해도 __git log__ 는 정상 작동한다.

   인자는 Command의 동작 대상을 지정하는 것이다. 따라서 생략이 불가능하다. 예를들면 __git add__  라고만 작성하면 어떤 File을 Staging Area에 올릴지 모르게 된다. 반드시 __git add a.txt__ 와 같이 git add 명령어가 동작할 대상을 지정해야 하는데 이때 __a.txt__ 와 같은 대상을 인자라고 한다.  
  
### (6) 한눈에 보는 Git Command

![git command](https://cafeptthumb-phinf.pstatic.net/MjAyMjEyMDFfMjU2/MDAxNjY5ODg5NDU4MDk2.55d4vqg7LCrqTFYgD15IGwjPy7DqycGJqZmmDMfBmiQg.uAlUXERKwzvQ5hp66r6ajTB95ilN_PgUY2Mi1OZQqZsg.PNG/image.png?type=w1600)

- git push : git hub로 넘어감
- exit : 나가기