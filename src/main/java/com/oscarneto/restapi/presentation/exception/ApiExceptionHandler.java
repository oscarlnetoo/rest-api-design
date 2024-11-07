package com.oscarneto.restapi.presentation.exception;

import com.oscarneto.restapi.domain.exception.DuplicateUniqueKeyException;
import com.oscarneto.restapi.domain.exception.EntityNotFoundException;
import com.oscarneto.restapi.presentation.dto.response.ApiErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = LogManager.getLogger(ApiExceptionHandler.class);

    /**
     * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid validation.
     *
     * @param ex      the MethodArgumentNotValidException that is thrown when @Valid validation fails
     * @param headers HttpHeaders
     * @param statusCode  HttpStatus
     * @param request WebRequest
     * @return the ApiErrorResponse object
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        return handleValidationInternal(ex);
    }

    /**
     * Handle DataIntegrityViolationException, inspects the cause for different DB causes.
     *
     * @param ex the DataIntegrityViolationException
     * @return the ApiErrorResponse object
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
        logger.error("Database error", ex);

        return buildResponseEntity(new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex));
    }

    /**
     * Handles ConstraintViolationException. Thrown when @Validated fails.
     *
     * @param ex the ConstraintViolationException
     * @return the ApiErrorResponse object
     */
    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
                ApiErrorMessage.BAD_REQUEST,
                ApiErrorMessage.BAD_REQUEST.getMessage(),
                ex);

        apiError.addValidationErrors(ex.getConstraintViolations());

        return buildResponseEntity(apiError);
    }

    /**
     * Handles EntityNotFoundException. Created to encapsulate errors with more detail than jakarta.persistence.EntityNotFoundException.
     *
     * @param ex the EntityNotFoundException
     * @return the ApiErrorResponse object
     */
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.NOT_FOUND, ApiErrorMessage.NOT_FOUND, ex.getMessage(), ex);

        return buildResponseEntity(apiError);
    }

    /**
     * Handles any DuplicateUniqueKeyException.
     *
     * @param ex the DuplicateUniqueKeyException
     * @return the ApiErrorResponse object
     */
    @ExceptionHandler(DuplicateUniqueKeyException.class)
    protected ResponseEntity<Object> handleDuplicateUniqueKey(DuplicateUniqueKeyException ex) {
        ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.BAD_REQUEST, ApiErrorMessage.DUPLICATE_KEY, ex.getMessage(), ex);

        return buildResponseEntity(apiError);
    }

    /**
     * Handles any Exception.
     *
     * @param ex the Exception
     * @return the ApiErrorResponse object
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handler(Exception ex, WebRequest request) {
        logger.error("Unknown error occurred", ex);

        return handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handlerMethodArgumentTypeMismatchException(Exception ex, WebRequest request) {
        String field = ((MethodArgumentTypeMismatchException) ex).getName().toString();
        Object body = new ApiErrorResponse(HttpStatus.BAD_REQUEST, ApiErrorMessage.ARGUMENT_MISMATCH.getMessage(field), ex);
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * This method overrides default Spring method to handle exceptions and, if the body is null, creates a body with
     * our definition of ApiError.
     *
     * The INTERNAL_SERVER_ERROR makes sense since everything going through this method is not handled by our code. I
     * understand that in this case Spring is handling the exception and we leverage on Spring's code for a lot of
     * stuff, but in this case there's no other way.
     *
     * For example, it's necessary to handle JsonMappingException to make it (and its child exceptions) return another
     * type of exception.
     *
     * @param ex the exception
     * @param body response body
     * @param headers response headers
     * @param statusCode response http status code
     * @param request request that originate this whole mess
     * @return a {@link ResponseEntity} with the object to be returned to the client
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        if (body == null) {
            body = new ApiErrorResponse(HttpStatus.valueOf(statusCode.value()), ex);
        }

        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }

    private ResponseEntity<Object> handleValidationInternal(BindException ex) {
        ApiErrorResponse apiError = new ApiErrorResponse(HttpStatus.BAD_REQUEST,
                ApiErrorMessage.BAD_REQUEST,
                ApiErrorMessage.BAD_REQUEST.getMessage(),
                ex);

        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());

        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiErrorResponse apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
