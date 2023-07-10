package dev.vorstu.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="userInfo")
public class UserInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String fio;

    private String phoneNumber;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group groupId;

    @Enumerated(EnumType.STRING)
    private Role role;
}
