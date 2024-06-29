package com.yamdeng.learn.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yamdeng.learn.spring.dto.request.MessageRequestDTO;
import com.yamdeng.learn.spring.dto.response.MessageDTO;

@Mapper
public interface MessageMapper {

    List<MessageDTO> select(MessageRequestDTO messageRequestDTO);

    int getTotalCount(MessageRequestDTO messageRequestDTO);

    MessageDTO getMessageById(long id);

    int insertMessage(MessageDTO messageDTO);

    void updateMessage(MessageDTO messageDTO);

    void deleteMessageById(long id);

}
