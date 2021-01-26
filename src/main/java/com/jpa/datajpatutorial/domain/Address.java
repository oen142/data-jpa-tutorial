package com.jpa.datajpatutorial.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Address {

    private String city;
    private String street;
    private String zipcode;


    /*
     * 값타입은 Getter만 만들어야 한다.
     * 기본적으로 값이라는것은 변경되면 안된다.
     * 생성자에서만 제공을 해야한다.
     *
     * 생성할때 리플렉션 프록시를 써야하는데
     * 기본생성자가 없으면 못한다.
     * 대신에 public으로 하면 호출할수 있기 때문에 protected를 사용하면 좋다.
     * */

}
