package ma.emsi.evaluationFournisseur.security;


//import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
//import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.session.SessionRegistry;
//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
/////
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.security.config.Customizer ;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//
//@KeycloakConfiguration
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
//public class KeycloakSecurityConfig   {
////
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
////        auth.authenticationProvider(keycloakAuthenticationProvider);
////    }
////
////    @Bean
////    @Override
////    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
////        return new RegisterSessionAuthenticationStrategy(sessionRegistry());
////    }
////
////    @Bean
////    public SessionRegistry sessionRegistry() {
////        return new SessionRegistryImpl();
////    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
////        http.csrf(crsf->crsf.disable());
////        http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()));
////        http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.disable());
////        http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
//////        http.authorizeRequests()
//////                .antMatchers("/h2-console/**", "/swagger-ui/**", "/v3/**", "/public/**", "/actuator.**").permitAll()
//////                .anyRequest().authenticated();
////
////        http.authorizeRequests(authz->authz.requestMatchers("/h2-console/**", "/swagger-ui/**", "/v3/**", "/public/**", "/actuator.**").permitAll().anyRequest().authenticated()) ;
////    }
////
////    @Override
////    public void init(WebSecurity builder) throws Exception {
////
////    }
////
////    @Override
////    public void configure(WebSecurity builder) throws Exception {
////
////    }
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("*");
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedHeader("*");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//@Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    //  http.csrf(crsf->crsf.disable());
//   //   http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.disable()) ;
//      // http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()));
////    http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.disable());
////    http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
////    http.authorizeRequests(authz->authz.requestMatchers("/h2-console/**", "/swagger-ui/**", "/v3/**", "/public/**", "/actuator.**").permitAll().anyRequest().authenticated()) ;
//
//    http.cors(Customizer.withDefaults())
//            .authorizeHttpRequests(authz->authz.anyRequest().authenticated());
//
//    return http.build();
//
//}
//
//}
