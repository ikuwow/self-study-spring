package com.ikuwow.selfstudyspring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RepositoryPointcut {

    @Pointcut("execution(* com.ikuwow.selfstudyspring.repository..MemoRepository+.save(..))")
    public void save() {}

    @Pointcut("execution(* com.ikuwow.selfstudyspring.repository..MemoRepository+.findByAuthor(..)) && args(author)")
    public void findByAuthor(String author) {}

}
