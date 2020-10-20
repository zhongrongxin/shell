
package me.zrxjava.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import me.zrxjava.common.exception.BadRequestException;
import me.zrxjava.common.exception.EntityExistException;
import me.zrxjava.common.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Objects;

import static org.springframework.http.HttpStatus.NOT_FOUND;


/**
 * 全局异常处理
 * @author zhongrongxin
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler{

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiError> handleException(Throwable e){
        // 打印堆栈信息
        log.error("Throwable ->",e);
        return buildResponseEntity(ApiError.error(e.getMessage()));
    }

    /**
     * 处理运行时异常
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ApiError> runtimeException(RuntimeException e) {
        // 打印堆栈信息
        log.error("RuntimeException ->",e);
        return buildResponseEntity(ApiError.error(e.getMessage()));
    }


    /**
     * 处理自定义异常
     */
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<ApiError> badRequestException(BadRequestException e) {
        // 打印堆栈信息
        log.error("BadRequestException ->",e);
        return buildResponseEntity(ApiError.error(e.getStatus(),e.getMessage()));
	}

    /**
     * 处理 EntityExist
     */
    @ExceptionHandler(value = EntityExistException.class)
    public ResponseEntity<ApiError> entityExistException(EntityExistException e) {
        // 打印堆栈信息
        log.error("EntityExistException ->",e);
        return buildResponseEntity(ApiError.error(e.getMessage()));
    }

    /**
     * 处理 EntityNotFound
     */
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ApiError> entityNotFoundException(EntityNotFoundException e) {
        // 打印堆栈信息
        log.error("EntityNotFoundException ->",e);
        return buildResponseEntity(ApiError.error(NOT_FOUND.value(),e.getMessage()));
    }

    /**
     * 处理所有接口数据验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        // 打印堆栈信息
        log.error("MethodArgumentNotValidException ->",e);
        String[] str = Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getCodes())[1].split("\\.");
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        String msg = "不能为空";
        if(msg.equals(message)){
            message = str[1] + ":" + message;
        }
        return buildResponseEntity(ApiError.error(message));
    }

    /**
     * 统一返回
     */
    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, HttpStatus.valueOf(apiError.getStatus()));
    }
}