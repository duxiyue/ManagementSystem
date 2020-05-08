package com.ManagementSystem.framework.common.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
public class MessageDto {

	/** メッセージID */
	public String id;

	/** メッセージレベル */
	public String level;

	/** メッセージ */
	public String message;

	/**
	 * コンストラクタ
	 */
	public MessageDto() {

	}

	/**
	 * コンストラクタ
	 * @param strId
	 * @param strLevel
	 * @param strMessage
	 */
	public MessageDto(String strId, String strLevel, String strMessage) {
		this.id = strId;
		this.level = strLevel;
		this.message = strMessage;
	}

}
