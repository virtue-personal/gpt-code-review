package com.virtue.elaprac.service;

import com.virtue.elaprac.dto.MenuDTO;
import com.virtue.elaprac.entity.Menu;
import com.virtue.elaprac.repository.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuService {

    private final MenuRepository menuRepository;

    private final ModelMapper mapper;

    @Autowired
    public MenuService(MenuRepository menuRepository, ModelMapper mapper) {
        this.menuRepository = menuRepository;
        this.mapper = mapper;
    }

    public MenuDTO findMenuByMenuCode(int menuCode) {
        Menu selectedMenu =
                menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        return mapper.map(selectedMenu, MenuDTO.class);
    }
}
