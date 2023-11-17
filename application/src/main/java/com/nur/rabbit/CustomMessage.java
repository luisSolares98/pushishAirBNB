package com.nur.rabbit;


import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomMessage {

    private UUID id;

    private String message;

}