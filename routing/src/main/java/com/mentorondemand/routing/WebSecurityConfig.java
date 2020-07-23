/*
 * package com.mentorondemand.routing;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter;
 * 
 * 
 * //@Configuration //@EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Bean public AuthTokenFilter authenticationJwtTokenFilter() { return new
 * AuthTokenFilter(); }
 * 
 * @Override public void configure(AuthenticationManagerBuilder
 * authenticationManagerBuilder) throws Exception {
 * //authenticationManagerBuilder.userDetailsService(userDetailsService).
 * passwordEncoder(passwordEncoder()); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.cors().and().csrf().disable()
 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
 * and() .authorizeRequests().antMatchers("/api/auth/**").permitAll()
 * .anyRequest().permitAll();
 * //http.addFilterBefore(authenticationJwtTokenFilter(),
 * UsernamePasswordAuthenticationFilter.class);
 * 
 * }
 * 
 * }
 */