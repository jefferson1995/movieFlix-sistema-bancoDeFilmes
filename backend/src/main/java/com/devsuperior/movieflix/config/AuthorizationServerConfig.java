package com.devsuperior.movieflix.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.devsuperior.movieflix.JwtTokenEnhancer;

@Configuration
@EnableAuthorizationServer //representa o Auth. server    //Checklist do OAuth 2.0
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	//variável de ambiente
	@Value("${security.oauth2.client.client-id}")
	private String clientId;
	
	@Value("${security.oauth2.client.client-secret}")
	private String clientSecret;
	
	@Value("${jwt.duration}")
	private Integer jwtDuration;
	
	//OS QUATROS BEANS NECESSÁRIOS 
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	@Autowired //websecurityconfig
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenEnhancer tokenEnhancer; //Para adicionar informações no token ex. nome e id do usuário

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	
	/*
	 * //Define como será a autenticação  -> app credentials 
	 */
	
	@Override 
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory() 
		.withClient(clientId) 
		.secret(passwordEncoder.encode(clientSecret)) 
		.scopes("read", "write") 
		.authorizedGrantTypes("password") 
		.accessTokenValiditySeconds(jwtDuration); //validade
	}

	
	/*
	 * Informa quem vai autorizar  
	 * qual vai ser o formato do token
	 */
	
	@Override 
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		//Para adicionar o id e nome do usuário no token
		TokenEnhancerChain chain = new TokenEnhancerChain();
		chain.setTokenEnhancers(Arrays.asList(accessTokenConverter, tokenEnhancer));
		
		endpoints.authenticationManager(authenticationManager)  //Processa a autenticação -> configurado na classe websecuityconfig
		.tokenStore(tokenStore)     //Objeto responsável para processar o token 
		.accessTokenConverter(accessTokenConverter) //registra a chave -> definida na classe appConfig
		.tokenEnhancer(chain); //para adicionar o chain id e nome usuário
	}
}
