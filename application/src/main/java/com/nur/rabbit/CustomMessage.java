package com.nur.rabbit;

import java.util.UUID;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class CustomMessage {

	private UUID id;

	private String message;

}