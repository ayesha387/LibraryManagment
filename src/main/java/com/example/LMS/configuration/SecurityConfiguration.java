package com.example.LMS.configuration;

//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration //extends WebSecurityConfigurerAdapter
{

    /*
    @Autowired
    CustomUserDetailService userDetailService;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity.csrf().disable();

        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests()
                .antMatchers("/info/**").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/user/signUp").permitAll()
                .antMatchers("/user/test").permitAll()
                .antMatchers("/api/**").hasAnyAuthority("Employee","Admin")
                .antMatchers("/admin/**").hasAuthority("Admin")
                .anyRequest().authenticated()
                .and().exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

     */

        // Basic Authentication
        /*
        httpSecurity.authorizeRequests()
                .antMatchers("/info/**").permitAll()
                .and().authorizeRequests()
                .antMatchers("/api/**").hasAnyAuthority("Employee","Admin")
                .antMatchers("/admin/**").hasAuthority("Admin")
                .and()
                .formLogin()
                .permitAll();

        */

    //}
/*
    @Override
    public void configure(AuthenticationManagerBuilder aMgrBuilder) throws Exception
    {
        //aMgrBuilder.inMemoryAuthentication().withUser("admin").password("pwd_").roles("ADMIN");
        //aMgrBuilder.inMemoryAuthentication().withUser("faraz").password("_pwd").roles("USER");

        aMgrBuilder.userDetailsService(this.userDetailService).passwordEncoder(passwordEncoder());
    }


    @Bean
    BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }



    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws  Exception
    {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationEventPublisher authenticationEventPublisher(ApplicationEventPublisher applicationEventPublisher)
    {
        return new DefaultAuthenticationEventPublisher(applicationEventPublisher);
    }

 */

        /*
    @Bean
    public static NoOpPasswordEncoder passwordEncoder()
    {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
*/

    /*

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new MessageDigestPasswordEncoder("MD5");
    }
*/

}
