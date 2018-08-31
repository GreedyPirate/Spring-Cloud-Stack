package com.ttyc.sleuth.feign.consumer.sleuth;

import brave.Span;
import brave.Tracer;
import brave.propagation.ExtraFieldPropagation;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "zipkinFilter", urlPatterns = "/")
public class BaggageInfo extends OncePerRequestFilter {
    private final Tracer tracer;

    public BaggageInfo(Tracer tracer) {
        this.tracer = tracer;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Span initialSpan = this.tracer.nextSpan().name("span").start();
        initialSpan.tag("tagss", ExtraFieldPropagation.get(initialSpan.context(), "foo"));
        ExtraFieldPropagation.set(initialSpan.context(), "foo", "bar");
        ExtraFieldPropagation.set(initialSpan.context(),"UPPER_CASE", "someValue");
    }
}
