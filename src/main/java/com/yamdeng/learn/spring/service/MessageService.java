package com.yamdeng.learn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yamdeng.learn.spring.dto.request.MessageRequestDTO;
import com.yamdeng.learn.spring.dto.response.MessageDTO;
import com.yamdeng.learn.spring.mapper.MessageMapper;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public List<MessageDTO> select(MessageRequestDTO MessageRequestDTO) {
        return messageMapper.select(MessageRequestDTO);
    }

    public int getTotalCount(MessageRequestDTO MessageRequestDTO) {
        return messageMapper.getTotalCount(MessageRequestDTO);
    }

    public MessageDTO getMessageById(Long id) {
        return messageMapper.getMessageById(id);
    }

    public int insertMessage(MessageDTO MessageDTO) {
        return messageMapper.insertMessage(MessageDTO);
    }

    public void updateMessage(MessageDTO MessageDTO) {
        messageMapper.updateMessage(MessageDTO);
    }

    public void deleteMessageById(long id) {
        messageMapper.deleteMessageById(id);
    }

}
