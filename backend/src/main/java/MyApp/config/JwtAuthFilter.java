package MyApp.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// A Http filter to intercept the incoming requests and validate the JWT
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private  final UserAuthProvider userAuthProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Example of a valid header:
        //Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...

        if(header != null){
            String [] authElements = header.split(" ");
            if(authElements.length ==2 && "Bearer".equals(authElements[0])){
                try{
                    if("GET".equals(request.getMethod())){
                        SecurityContextHolder.getContext().setAuthentication(userAuthProvider.validateToken(authElements[1]));
                    } else {
                        SecurityContextHolder.getContext().setAuthentication(userAuthProvider.validateTokenStrongly(authElements[1]));
                    }
                }catch (RuntimeException e){
                    SecurityContextHolder.clearContext();
                    throw e;
                }
            }
        }
        // This line is crucial, It tells Spring Security to continue processing the
        // next filter in the chain (and eventually reach the controller).
        filterChain.doFilter(request, response);
    }
}
