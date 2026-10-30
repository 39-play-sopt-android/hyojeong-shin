package org.sopt.play

data class Product(
    val image: Int,
    val shop: String,
    val name: String
)

val products=listOf(
    Product(
        image = R.drawable.product1,
        shop = "페트리코어",
        name = "[\uD83C\uDF42가을] 로코 스트링 야상 코튼 점퍼 (3color)"
    ),
    Product(
        image = R.drawable.product2,
        shop = "벨류엣",
        name = "[정채연,혜진PICK/직잭단독/스웨이드 출시] 마리백 - 4colors)"
    ),
    Product(
        image = R.drawable.product3,
        shop = "더핑크",
        name = "[\uD83C\uDFC6기간한정특가/핏보장/후드일체형\uD83E\uDD0E]" +
                "페우 오버핏 스웨이드 레이어드 후드 유틸리티 점퍼 (4color)\n"
    ),
    Product(
        image = R.drawable.product4,
        shop = "라온느",
        name = "[핑크안감/색감레전드] 토스트 울 자켓"
    ),
    Product(
        image = R.drawable.product5,
        shop = "슬로우앤드",
        name = "[\uD83C\uDF89안국감사제/무료배송] made. 포트 컬러웨이 딥브이넥 니트" +
                " - 5 color (예약주문: 11월 초 이후 순차출고예정)"
    ),
    Product(
        image = R.drawable.product6,
        shop = "케이클럽",
        name = "[MADE]캬라멜 데일리 코튼 블루종 점퍼 " +
                "(S-L/데일리룩/데이트룩/출근룩/가을블루종/가을자켓/가을아우터)"
    )
)