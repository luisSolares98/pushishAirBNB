package com.nur.rabbit;

import lombok.*;
@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Response {

	private Pattern pattern;

	private CustomMessage data;

}
