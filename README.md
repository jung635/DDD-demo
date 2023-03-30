기술
0. DDD 기반 아키텍처 적용
1. Exception : @ControllerAdvice를 통하여 Exception을 관리하고, CommonResponse.java, ErrorCode로 커스텀한 응답 표출
2. Logging : @Slf4j를 이용한 로깅
3. JPA : 기본 조회 및 저장
4. MariaDB : 로컬 MariaDB 연동
5. Security
   - CSRF 방지
   - 설정파일 암호화(jasypt)
   - 패스워드 암호화 (Spring security)
   - SQL injection 방어
6. Authentication
   -  OAuth2.0 적용
   -  JWT 기반 인증
7. 통신
   - Kafka
   - gRPC
   - HTTP

Functions
1. User 등록
2. User list 조회

Table
- id : ID
- userId : 유저 아이디
- name : 이름 
- pw : 패스워드