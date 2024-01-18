package com.example.airdns.domain.like.service;

import com.example.airdns.domain.like.dto.LikesResponseDto;
import com.example.airdns.domain.user.entity.Users;

import java.util.List;

public interface LikesService {

    LikesResponseDto.CreateLikeResponseDto addLike(Long roomsId, Users user);
    LikesResponseDto.DeleteLikeResponseDto cancelLike(Long roomsId, Users user);
    LikesResponseDto.ReadLikeResponseDto getRoomLike(Long roomsId, Users user);
}
