2023년 01월 3일 화요일

---

- Github : Remote Repository(원격저장소)
- `git init` : folder를 local repository로 만듬.
- `git remote` : local repository에 remote repository를 __등록, 조회, 삭제__ 할 수 있는 명령어.
    1. `$ git remote add name adress` : 등록
    2. `$ git remote -v` : 조회
    3. `$ git remote rm name or remove name` : 삭제

- file upload x, commit upload
- `git push` : local repository의 commit을 remote repository에 upload하는 명령어
    - `$ git push repository name branch name`
    - `-u` option을 사용하면, 두번째 commit부터는 `repository name branch name` 생략가능.

- vscode 자격 증명

![](https://cafeptthumb-phinf.pstatic.net/MjAyMjEyMDFfMjAg/MDAxNjY5ODkwMDQ1NzY0.T2k4Pl-2ryNg01Ij9bZ1iVq_LMjp3CfdIimWcQyNB6kg.eTP010EfS5OXkOllgwhbMcoQ7TMVOUrKcHz43H2yKeIg.PNG/image.png?type=w1600)

- git push 완료 후

```git
$ git push origin master
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 8 threads
Compressing objects: 100% (5/5), done.
Writing objects: 100% (5/5), 15.76 KiB | 7.88 MiB/s, done.
Total 5 (delta 0), reused 0 (delta 0), pack-reused 0
To https://github.com/chlwo796/chlwo796.git
 * [new branch]      master -> master
```

### *remote repository에 파일을 드래그해서 업로드하지 않는다.

>local repository에서 변경이 먼저 일어나고, 그 변경 사항(commit)을 remote repository에 반영하는 형태여야 한다. 드래그 해서 file을 upload하면 remote repository에 변경이 먼저 일어나는 형태가 되기 때문에 지양해야 한다.



