package oktenweb.configs;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

public class RequestProcessingJWTFilter extends GenericFilterBean{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("doFilter from RequestProcessingJWTFilter works");
        Authentication authentication = null;
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        if(authorizationHeader!=null){
            String user = Jwts.parser()
                    .setSigningKey("yes".getBytes())
                    .parseClaimsJws(authorizationHeader.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();
            System.out.println(user+" !!!!!-!!!");
            authentication = new UsernamePasswordAuthenticationToken
                    (user, null, Collections.<GrantedAuthority>emptyList());
        }
        //if header does not exist - authentication is null:
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        chain.doFilter(request, response);

    }
}
