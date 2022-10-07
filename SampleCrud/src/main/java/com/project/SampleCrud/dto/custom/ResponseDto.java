package com.project.SampleCrud.dto.custom;

import com.project.SampleCrud.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {

    private String message;
    private User user;

}
