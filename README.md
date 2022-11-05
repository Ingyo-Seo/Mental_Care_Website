# 정신 건강 증진 웹 사이트

## 프로젝트 기간
2022/7/4 ~ 현재

## 사용 기술
<img src="https://img.shields.io/badge/JAVA-007396?style=flat-square&logo=java&logoColor=white"/> <img src="https://img.shields.io/badge/Spring Tool Suite-6DB33F?style=flat-square&logo=Spring&logoColor=white"/> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=Spring Boot&logoColor=white"/> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/>

## 내용
공개SW 개발자대회 참가 및 개인 학습용으로 진행했던 개인 프로젝트입니다. 게시판 기능과 약 먹은 시간 타임라인을 확인할 수 있는 웹사이트입니다.

## 파일 요약
- /src/main/java/com/health/board 폴더 : 게시글 관련 데이터 코드 폴더
  - BoardController.java : Controller
  - BoardCreateContent.java : DTO
  - BoardEntity.java : Entity
  - BoardRepository.java : DAO
  - BoardService.java : Service
- /src/main/java/com/health/care 폴더 : 약복용 관련 데이터 코드 폴더
  - CareController.java : Controller
  - CareEntity.java : Entity
  - CareRepository.java : DAO
  - CareService.java : Service
- /src/main/java/com/health/comment 폴더 : 댓글 관련 데이터 코드 폴더
  - CommentController.java : Controller
  - CommentCreateContent.java : DTO
  - CommentEntity.java : Entity
  - CommentRepository.java : DAO
  - CommentService.java : Service
- /src/main/java/com/health/user 폴더 : 사용자 관련 데이터 코드 폴더
  - UserController.java : Controller
  - UserCreateAccount.java : DTO
  - UserEntity.java : Entity
  - UserRepository.java : DAO
  - UserRole.java : 사용자 권한을 정의하는 코드
  - UserSecurityService.java : 로그인 처리를 할 때의 코드
  - UserService.java : Service
- DataNotFoundException.java : 예외 처리 코드
- HealthApplication.java : 프로젝트 생성시 기본 생성되는 코드
- MainController.java : 메인 Controller
- SecurityConfig.java : 스프링 기반 애플리케이션의 인증과 권한을 담당하는 스프링의 하위 프레임워크 코드

MVC - Model View Controller 패턴

Client <-[DTO]-> Controller <-[DTO]-> Service <-[DTO]-> Repository(DAO) <-[Entity(Domain)]-> DB

- Client : 사용자
- DTO : Data Transfer Object, 데이터를 이동하기 위한 객체, Entity를 그대로 사용하면 데이터 변질 위험, 역할 분리
- Controller : 요청과 응답을 관리하는 계층
- Service : 모듈화와 보안을 위해서 Controller가 바로 DAO를 사용해서 DB에 접근하지 않기 위해서 사용
- DAO : Data Access Object, 실제 DB에 접근하는 객체
- Entity : 테이블과 1대1 매핑되는 객체

## 프로젝트 결과 

### 메인
> ![image](https://user-images.githubusercontent.com/64400731/199389082-61c356a0-87b2-4328-b2eb-859b106997d0.png)

### 게시판
> ![image](https://user-images.githubusercontent.com/64400731/199389387-15b281b3-b5ad-4011-a502-7cb86a47c9b8.png)

### 약먹기 기록
> ![image](https://user-images.githubusercontent.com/64400731/199389636-04388ba8-53d3-4f7d-b204-37bb86a88a77.png)

### 회원가입
> ![image](https://user-images.githubusercontent.com/64400731/199389926-5d9602a1-658e-41d6-a2e3-36315a68aac6.png)

### 로그인
> ![image](https://user-images.githubusercontent.com/64400731/199389780-7058ee68-a9cd-4019-9f0e-9d9703d79355.png)
