2023년 1월 2일 월요일

---

## GUI vs CLI

1. GUI와 CLI의 정의
   - GUI(Graphic User Interface) : Graphic을 통해 User와 Computer가 상호작용하는 방식
   - CLI(Command Line Interface) : Terminal을 통해 User와 Computer가 상호작용하는 방식

---

#### \* Interface

>Interface란 원래 서로 다른 개체끼리 맞닿아 있는 면을 뜻한다. 여기에서는 __User와 Computer가 서로 소통하는 접점__ 이라고 이해하도록 하자.

---

2. CLI를 사용하는 이유
   - __new__ 라는 이름으로 새 Folder를 생성해보자.
        1. GUI (4단계): __마우스 우클릭 -> 새로 만들기 -> 폴더 -> new 작성__
        2. CLI (1단계): __mkdir new__
    - CLI는 GUI보다 더 많은 세부적인 기능을 사용할 수 있고, 단계가 적어 성능면에서 더 우월하다.
  
3. Git Bash를 사용하는 이유
    - Windows에는 CLI환경인 __Powershell, 명령 프롬프트__ 가 이미 존재한다. 하지만 왜 Git Bash 라는 것을 사용할까?
        1. 명령어의 통일
            - Unix 계열 운영체제의 명령어와 Windows 명령어의 차이가 존재한다.
            - 따라서 __Git Bash__ 라고 하는 일종의 번역기를 통해 Windows에서도 UNIX 계열 운영체제의 터미널 명령어를 사용하기 위함.
        2. UNIX 계열 운영체제의 명령어를 더 많이 쓴다.
            - 개발자 입장에서는 Windows보다는 UNIX 계열 운영체제 기반의 프로그램이 훨씬 많다.
            - 그만큼 개발 시장에서는 UNIX 계열 운영체제가 더 많이 사용되기 때문에, __Git Bash__ 를 통해서 UNIX 계열 운영체제의 터미널 명령어를 한다.

## 경로

1. Root, Home Directory
   1. Root Directory(__/__)
        - 모든 File와 Folder를 담고 있는 최상위 Folder
        - windows의 경우 보통은 __C Drive__ 를 의미한다.
    2. Home Directory(__~__)
        - __Tilde(틸드)__ 라고도 부르며, 현재 로그인 된 User의 Home Folder를 의미한다.
        - Windows의 경우 __c:/사용자(users)/현재 사용자 계정__ 을 의미한다.
        - Mac의 경우 __/Users/현재 사용자 계정__ 을 의미한다.

2. 절대 경로와 상대 경로
   1. 절대 경로 : Root Directory부터 목적 지점까지 거치는 모든 경로를 전부 작성한 것
        - 윈도우 바탕 화면의 절대경로 : __C:/Users/chlwo/OneDrive__
    2. 상대 경로 : 현재 작업하고 있는 Directory를 기준으로 계산된 상대적 위치를 작성한 것.
        - 현재 작업하고 있는 Directory가 __C:/Users__ 라고 한다면 윈도우 바탕화면으로의 상대경로는 __chlwo/OneDrive__ 가 된다.
        - 간결해서 좋지만, 현재 작업하고 있는 Directory가 변경되면 상대경로도 변경된다.
        - __./__ : 현재 작업하고 있는 Folder를 의미
        - __../__ : 현재 작업하고 있는 Folder의 상위 Folder를 의미

