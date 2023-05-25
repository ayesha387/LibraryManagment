package com.example.LMS.security.jwt;

import com.project.carworkshop.exception.CarWorkShopException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        // 1. get token
        String requestToken  = request.getHeader("Authorization");

        System.out.println(requestToken);

        String userName = null;
        String token = null;

        // 2 WorkShopToken 54645645
        if(!Strings.isBlank(requestToken) && requestToken.startsWith("WorkShopToken"))
        {
            token = requestToken.substring(14);
            try
            {
                userName = this.jwtTokenHelper.getUsernameFromToken(token);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Unable to fetch token");
            }
            catch (ExpiredJwtException e)
            {
                System.out.println("token has been expired");
            }
            catch (MalformedJwtException e)
            {
                System.out.println("Invalid JWT");
            }
            catch(CarWorkShopException e)
            {

            }
            catch(Exception ex)
            {

            }

            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null)
            {

                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

                if (jwtTokenHelper.validateToken(token, userDetails))
                {

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
                else
                {
                    System.out.println("Invalid Jwt Token");
                }
            }
            else
            {
                System.out.println("Username or context is null");
            }
        }
        else
        {
            System.out.println("JWT token does not exist");
        }
        filterChain.doFilter(request,response);
    }
}
