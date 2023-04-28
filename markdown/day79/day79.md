2023년 4월 24일 월요일

## day 79

### 1. spring boot

**스프링 시큐리티**

- 스프링 시큐리티는 스프링 기반 애플리케이션의 인증과 권한을 담당하는 스프링의 하위 프레임워크

  - 인증(Authenticate)은 로그인을 의미
  - 권한(Authorize)은 인증된 사용자가 어떤 것을 할 수 있는지를 의미

- CSRF(cross site request forgery) : 웹 사이트 취약점 공격을 방지를 위해 사용하는 기술이며, 스프링 시큐리티가 CSRF 토큰 값을 세션을 통해 발행하고 웹 페이지에서는 폼 전송시에 해당 토큰을 함께 전송하여 실제 웹 페이지에서 작성된 데이터가 전달되는지를 검증하는 기술

- 스프링시큐리티 설치를 위해 build.gradle 수정
  - `implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'` 추가

```java
package com.mysite.sbb;

(... 생략 ...)
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
(... 생략 ...)

@Configuration  // 스프링의 환경설정 파일임을 의미하는 애너테이션
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers(
                new AntPathRequestMatcher("/**")).permitAll()
            .and()
                .csrf().ignoringRequestMatchers(
                        new AntPathRequestMatcher("/h2-console/**"))
            .and()
                .headers()
                .addHeaderWriter(new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
            ;
        return http.build();
    }
}
```

---

### 2. memo

- [db 설계 | uml 화살표 설명](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=kmk1030&logNo=221235714879)
  ![](https://mblogthumb-phinf.pstatic.net/MjAxODAzMjNfMTkx/MDAxNTIxNzkzMTY2OTIx.rJS2eiI7Epxp0m7o-fcm-TH86JpD8RJNqeMvcd66diEg.J40dBr6vrbZQ_Yv5nHSxdUMVZzd7Aj91J0qXMYic1z0g.PNG.kmk1030/image.png?type=w800)

- 데이터베이스 5월 10일 시험
