package com.jpa.datajpatutorial.domain;

import com.jpa.datajpatutorial.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    /*
     * 참고 : 엔티티의 식별자는 id를 사용하고 PK컬렴명은 member_id 를 사용한다.
     * 테이블은 타입이 없으므로 구분이 어렵다.
     * 관례상 테이블명 + id라고 많이 사용한다.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
    /*
     * ㅇㅣ론적으로 Getter Sertter는 모두 제공하지 않고 꼭 필요한 별도의 메서드를 제공하는게 가장 이상적이다.
     * 실무에서는 엔티티의 데이터는 조회할 일이 너무 많다. Getter의 경우 모두 열어두는것이 편리하다.
     * Setter는 호출하면 데이터가 변한다. 가까운 미래에 엔티티가 도대체 왜 변경하는지 추적하기 점점힘들어진다.
     * 그래서 엔티티를 변경할때는 Setter 대신 변경지점이 명확하도록 변경을 위한 비즈니스 메서드를 별도로 제공해야한다.
     * */

    //==연관관계 메서드==//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
