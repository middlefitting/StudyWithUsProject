프로그램 실행 방법
1. node.js 설치
   - https://nodejs.org/en/
2. h2 데이터베이스 설치 
   - https://www.h2database.com/html/main.html
   - h2 데이터베이스 압축해제 후 bin 폴더에서 gitbash 실행
   - ./h2.bat 입력
   - 출력된 창에서 JDBC URL: 칸에 
   jdbc:h2:~/studywithus
   - 입력으로 데이터베이스 생성
   - 이후 jdbc:h2:tcp://localhost/~/studywithus 를 입력해서 접속
3. Gradle -> build -> build 클릭해서 빌드 후 application 파일 실행
4. 프로젝트 포트 8081