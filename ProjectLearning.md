## MAVEN이 아니라 GRADLE을 사용하는 이유
1.   maven은 xml로 정의하기 때문에 설정 내용이 길어지고  **가독성이**  떨어진다
2.    빌드와 테스트 실행 결과 gradle이 더  **빠르다**  (캐시를 사용하기 때문에 테스트 반복시 차이가 더 커진다)



# 코드 내용 상세  
## H2 DB
H2는 메모리에서 실행 되기 때문에 직접 접근하려면 웹 콘솔을 사용해야한다. properties에 추가.
```java
spring.h2.console.enabled=true
```
