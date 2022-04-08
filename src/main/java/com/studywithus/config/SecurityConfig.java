package com.studywithus.config;

import com.studywithus.config.jwt.JwtAuthenticationEntryPoint;
import com.studywithus.config.jwt.JwtAuthenticationFilter;
import com.studywithus.config.jwt.JwtAuthorizationFilter;
import com.studywithus.domain.repository.jwt.JwtMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CorsFilter corsFilter;
    private final JwtMemberRepository jwtMemberRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(new MyFilter3(), SecurityContextPersistenceFilter.class);//SecurityContextPersistenceFilter가 처음이다 가장 빨리 실행시키기
        http.csrf().disable(); //위조된 요청으로 부터 보호한다. rest 서버에서는 토큰을 사용하기 때문에 굳이 설정할 필요가 없다고 한다.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//세션 사용 안함
                .and()
                .addFilter(corsFilter) //모든 요청은 해당 필터를 탄다 // crossOrigin 요청이 와도 다 탄다 //@CrossOrigin(인증 없을ㄴ때), 인증이 있을 때는 시큐리티 필터에 등록해줘야 한다.
                .formLogin().disable() //jwt니까 필요없음
                .httpBasic().disable() //http 로그인 방식 안씀 //기본 헤더에 id pw 담는 방식//안쓴다 //우리는 베리어 방식을 쓸 것이기 때문에 다 disable
                .addFilter(new JwtAuthenticationFilter(authenticationManager())) // 로그인 필터를 달아준다//AuthenticationManger를 넘겨줘야 함
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtMemberRepository)) //권한 체크 필터?
                .authorizeRequests()
                .antMatchers("/member/**").access("hasRole('ROLE_USER')")
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .usernameParameter("email")
                .anyRequest().permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new JwtAuthenticationEntryPoint());

    }
}









