2023년 1월 2일 월요일

---

## Terminal Command
- __touch__
    - make file
    - 띄어쓰기로 구분하여 여러 File을 한꺼번에 생성 가능
    - 숨김 File을 만들기 위해서는 __.__ 을 File name 앞에 붙인다.

```git
$ touch text.xtx
```

- __mkdir__
    - make directory
    - 띄어쓰기로 구분하여 여러 Folder를 한꺼번에 생성가능
    - Folder name 사이에 공백을 넣고 싶으면 따옴표로 묶어서 입력

```git
$ mkdir folder

$ mkdir 'Hello world'
```

- __ls__
    - list segmants
    - 현재 작업 중인 Directory의 Folder/File 목록을 보여줌
    - __-a__ : all, 숨김 File까지 모두 보여줌
    - __-l__ : long, 용량, 수정날짜 등 File정보를 자세히 보여줌

```git
$ ls

$ ls -a

$ ls -a -l

$ ls -al
```

- __mv__
    - move 
    - Folder/File을 다른 Folder 내로 이동하거나 이름을 변경하는 명령어
    - 다른 Folder로 이동할 때는 작성한 Folder가 반드시 있어야 함. 없으면 이름이 바뀐다.

```git
$ mv text.txt foldername

$ mv text1.txt text2.txt
```

- __cd__
    - change directory
    - 현재 작업 중인 Directory를 변경하는 명령어
    - __cd ~__ : Home Directory로 이동(__cd__ 만 입력해도 동일)
    - __cd ..__ : 상위 Directory로 이동
    - __cd -__ : 하위 Directory로 이동

```git
$ cd foldername
  
$ cd C:/Users/chlwo/OneDrive

$ cd ../상위/하위
```

- __rm__
    - remove
    - Folder/File 지우는 명령어
    - GUI와 달리 휴지통으로 이동하지 않고 바로 __완전 삭제__ 한다.
    - __*(asterisk, wildcard)__ 를 사용해서 __rm *.txt__ 라고 입력하면 txt file 전체를 다 지운다.
    - __-r__ : recursive 옵션. Folder를 지울 때 사용

```git
$ rm text.txt

$ rm -r foldername
```

- __start, open__
    - Folder/File을 여는 명령어
    - __windows__ : start, __Mac__ : open

```git
$ start text.txt

$ open text.txt
```

- 유용한 단축기
    - __위 아래 방향키__ : 과거에 작성했던 명령어 조회
    - __tab__ : Folder/File 이름 자동완성
    - __ctrl + a__ : 커서가 맨 앞으로 이동
    - __ctrl + e__ : 커서가 맨 뒤로 이동
    - __ctrl + w__ : 커서가 앞 단어를 삭제
    - __ctrl + 1__ : 터미널 화면을 깨끗하게 청소
    - __ctrl + insert__ : 복사
    - __shift + insert__ : 붙여넣기
  
- code filename.extention = making file -> open

- del filename.extention = delete file

    - 실행중인 파일을 닫은 상태에서 지운다.

- rd fileneme = empty folder 지움

- ipconfig /all

- cls = clear screen