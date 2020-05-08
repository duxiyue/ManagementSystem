package com.ManagementSystem.framework.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ManagementSystem.framework.security.dto.TopMenuListDto;
import com.ManagementSystem.web.entity.MenuEntity;
import com.ManagementSystem.web.mapper.MenuMapper;
import com.ManagementSystem.web.util.CommonCode;
/**
 * メニューサービスクラス
 */
@Service
@Transactional
public class TopMenuService {

	/** メニューMapper */
    @Autowired
    private MenuMapper menuMapper;

    /**
     * トップ画面初期処理サービス
     * @return userEntity
     */
    public List<TopMenuListDto> topMenuInit(Integer userAuth) {

    	List<TopMenuListDto> topMenuList = new ArrayList<TopMenuListDto>();
    	TopMenuListDto topMenuListDto = new TopMenuListDto();
    	// 一級メニュー
    	List<MenuEntity> menuList1 = new ArrayList<MenuEntity>();
    	// 二級メニュー
    	List<MenuEntity> menuList2 = new ArrayList<MenuEntity>();

    	Integer tempAuth = null;
    	if (userAuth != CommonCode.AUTH_CODE) {
    		tempAuth = userAuth;
    	}
    	// 一級メニューを取得する
    	menuList1 = menuMapper.getMenuList(1, tempAuth, null);

    	for (MenuEntity entity : menuList1) {

    		// 二級メニューを取得する
    		menuList2 = menuMapper.getMenuList(2, tempAuth, entity.menuId);

    		if (menuList2 != null && menuList2.size() > 0) {
    			entity.menuId = "#";
    		}

    		// メニュー設定
    		topMenuListDto.setMenuEntity(entity);
    		topMenuListDto.setMenuList(menuList2);
    		topMenuList.add(topMenuListDto);
    		topMenuListDto = new TopMenuListDto();
    	}
    	return topMenuList;
    }
}