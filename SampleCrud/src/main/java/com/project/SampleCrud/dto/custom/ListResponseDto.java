package com.project.SampleCrud.dto.custom;

import com.project.SampleCrud.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListResponseDto {

    private Integer count;
    private List<User> users;

}
