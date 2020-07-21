package co.kr.unli.server.domain

import javax.persistence.*

@Entity
class Accounts(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(length = 255)
    val di: String,

    @Column(length = 255)
    val name: String,

    @Column(length = 255)
    val mobile: String
)