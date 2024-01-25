package com.example.airdns.domain.reservation.entity;


import com.example.airdns.domain.reservation.dto.ReservationRequestDto;
import com.example.airdns.domain.room.entity.Rooms;
import com.example.airdns.domain.user.entity.Users;
import com.example.airdns.global.common.entity.CommonEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@Builder
@Getter
@AllArgsConstructor
@SQLDelete(sql = "UPDATE reservation SET is_deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime checkIn;

    @Column
    private LocalDateTime checkOut;

    @Column
    @Builder.Default
    private Boolean isDeleted = false;

    @Column
    private LocalDateTime deletedAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rooms_id")
    private Rooms rooms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    public void updateReservationTime(ReservationRequestDto.UpdateReservationDto requestDto) {
        this.checkIn = requestDto.getCheckInTime();
        this.checkOut = requestDto.getCheckOutTime();
    }

    public void delete() {
        this.isDeleted = true;
        this.deletedAt = LocalDateTime.now();
    }
}
