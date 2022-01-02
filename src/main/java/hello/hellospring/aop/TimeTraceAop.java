package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component  // 정형화된 평범한 코드들은 컴포넌트 스캔으로 등록
public class TimeTraceAop {

    // 공통 관심사항 AOP 걸 메소드 타게팅
    @Around("execution(* hello.hellospring..*(..))")  // hello.hellospring 패키지 하위에 다 적용해
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish  = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
