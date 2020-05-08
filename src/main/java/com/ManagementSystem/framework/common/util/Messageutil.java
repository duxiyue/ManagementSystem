package com.ManagementSystem.framework.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.web.servlet.ModelAndView;

import com.ManagementSystem.framework.common.dto.MessageDto;

/**
 * メッセージクラス
 * @author wangfalin
 */
public final class Messageutil {

	/** リソースバンドル */
	private static ResourceBundle resBund = ResourceBundle.getBundle("messages_ja", Locale.JAPANESE);

	/**
	 * コンストラクタ
	 */
	private Messageutil() {
	}

	/**
	 * ModelAndViewメッセージを追加する。
	 * @param model
	 * @param msgId
	 * @param params
	 */
	public static void addMessage(final ModelAndView model, final String msgId, final String... params ) {
		List<MessageDto> msgList = getAndPutMsgList(model.getModel(), msgId, params);
		model.addObject("msgList", msgList);
	}

	/**
	 * Mapからメッセージリストを取得し、メッセージを追加する。
	 * @param model
	 * @param msgId
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected static List<MessageDto> getAndPutMsgList(final Map<String, Object> model, final String msgId, final String... params) {
		List<MessageDto> msgList = null;

		Object temp = model.get("msgList");
		if (ObjectCommonUtil.isEmpty(temp)) {
			msgList = new ArrayList<>();
		} else if(temp instanceof List) {
			msgList = (List<MessageDto>)model.get("msgList");
		}
		msgList = Messageutil.addMessages(msgList, msgId, params);
		return msgList;
	}

	/**
	 * 新規メッセージを既存のメッセージリストに追加する。
	 * @param msgList
	 * @param msgId
	 * @param params
	 * @return
	 */
	protected static List<MessageDto> addMessages(List<MessageDto> msgList, String msgId, String... params) {

		// メッセージリストがない場合には、新規に作成する
		List<MessageDto> lclList = (msgList == null || msgList.size() == 0 ? new ArrayList<MessageDto>() : msgList);

		// メッセージIDがない場合は、リストをそのまま返す
		if (!StringCommonUtil.isEmpty(msgId)) {
			return lclList;
		}

		// メッセージIDが、リソースバンドルに存在しない場合、リストをそのまま返す
		if (!resBund.containsKey(msgId)) {
			return lclList;
		}

		lclList.add(createMessageDto(msgId, params));

		return lclList;
	}

	/**
	 * メッセージIDから｛@link MessageDto｝を生成する。
	 * @param msgId
	 * @param params
	 * @return
	 */
	protected static MessageDto createMessageDto(String msgId, String... params) {

		return new MessageDto(msgId, getMsgLevel(msgId), getMessage(msgId, params));
	}

	/**
	 * メッセージIDからメッセージ文言を取得する。
	 * @param msgId
	 * @param params
	 * @return
	 */
	public static String getMessage(String msgId, String... params) {
		return formatMsg(resBund.getString(msgId), params);
	}

	/**
	 * メッセージの先頭文字により、メッセージレベルを取得する。
	 * @param msgId
	 * @return
	 */
	private static String getMsgLevel(String msgId) {

		if (!StringCommonUtil.isEmpty(msgId)) {
			return "";
		}

		return msgId.split("\\.")[0];
	}

	/**
	 * メッセージフォーマット
	 * @param msg
	 * @param params
	 * @return
	 */
	protected static String formatMsg(String msg, String... params) {

		for (int i= 0; i < params.length; i++) {
			String reg = "{" + i + "}";
			msg = msg.replace(reg,  params[i]);
		}

		return msg;
	}
}
