package com.yamdeng.learn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamdeng.learn.spring.constant.ApiConstant;
import com.yamdeng.learn.spring.dto.CommonResponseDTO;
import com.yamdeng.learn.spring.dto.request.MessageRequestDTO;
import com.yamdeng.learn.spring.dto.response.MessageDTO;
import com.yamdeng.learn.spring.service.MessageService;

@RequestMapping(ApiConstant.MESSAGE_API_PREFIX)
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("")
    public CommonResponseDTO<List<MessageDTO>> select(MessageRequestDTO messageRequestDTO) {
        List<MessageDTO> list = messageService.select(messageRequestDTO);
        int totalCount = messageService.getTotalCount(messageRequestDTO);
        return CommonResponseDTO.<List<MessageDTO>>builder()
                            .data(list)
                            .totalCount(totalCount)
                            .build();
    }

    @GetMapping("{id}")
    public CommonResponseDTO<MessageDTO> getDetail(@PathVariable("id") Long id) {
        return CommonResponseDTO.<MessageDTO>builder()
                            .data(messageService.getMessageById(id))
                            .build();
    }

    @PostMapping("")
    public CommonResponseDTO<MessageDTO> create(@RequestBody MessageDTO messageDTO) {
        messageService.insertMessage(messageDTO);
        MessageDTO createdEntity = messageService.getMessageById(messageDTO.getId());
        return CommonResponseDTO.<MessageDTO>builder().data(createdEntity).build();
    }

    @PutMapping("{id}")
    public CommonResponseDTO<MessageDTO> update(@PathVariable("id") Long id, @RequestBody MessageDTO messageDTO) {
        messageDTO.setId(id);
        messageService.updateMessage(messageDTO);
        MessageDTO updatedEntity = messageService.getMessageById(id);
        return CommonResponseDTO.<MessageDTO>builder().data(updatedEntity).build();
    }

    @DeleteMapping("{id}")
    public CommonResponseDTO<?> delete(@PathVariable Long id) {
        messageService.deleteMessageById(id);
        return CommonResponseDTO.getDefaultResponse();
    }

}
