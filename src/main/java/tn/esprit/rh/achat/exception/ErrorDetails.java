package tn.esprit.rh.achat.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    private String status;
    private int httpStatus;
    private String message;
    private Date timestamp;
}
