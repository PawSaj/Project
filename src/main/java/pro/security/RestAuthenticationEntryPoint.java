package pro.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)
            throws IOException, ServletException {
        logger.debug("ENTER commence(): httpServletRequest={}, httpServletResponse={}, e={}", httpServletRequest, httpServletResponse, e);
        logger.debug("requestUri: {}", httpServletRequest);
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}