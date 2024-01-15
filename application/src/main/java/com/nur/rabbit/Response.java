package com.nur.rabbit;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Response {

	private Pattern pattern;

	private CustomMessage data;

}
