package com.sb.sbdemo.aspect;

import com.sb.sbdemo.exception.BusiException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ye on 2/8/18.
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = BusiException.class)
    public ModelAndView busiExceptionHandler( Exception e) {
        ModelAndView mav = new ModelAndView("500");
        mav.addObject("errorMsg", e.getMessage());
        return mav;
    }
}
